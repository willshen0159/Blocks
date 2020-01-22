package com.example.ooprojectblocks;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ooprojectblocks.DB.AccountManager;
import com.example.ooprojectblocks.DB.SQLiteAccountManager;

public class RegisterFragment extends MyFragment {

    private ImageButton backButton;
    private Button registerButton;
    private EditText id;
    private EditText password;
    private EditText email;
    private AccountManager manager;
    //private ExternalManager externalManager;
    private View view;

    /*public void onAttach(Context context) {
        super.onAttach(context);
        try {
            externalManager = (ExternalManager) context;
        } catch (ClassCastException castException) {
            // The activity does not implement the externalManager.
        }
    }*/

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.register, container, false);
        backButton = (ImageButton) view.findViewById(R.id.backButton);
        registerButton = (Button) view.findViewById(R.id.registerButton);
        id = (EditText) view.findViewById(R.id.id);
        password = (EditText) view.findViewById(R.id.password);
        email = (EditText) view.findViewById(R.id.email);
        manager = new SQLiteAccountManager();
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.openDB(getActivity());
                if(manager.isAccountExist(id.getText().toString())) {
                    Toast.makeText(getActivity(), "Account exists", Toast.LENGTH_LONG).show();
                }
                else if(!manager.addAccount(id.getText().toString(), password.getText().toString(), email.getText().toString())) {
                    Toast.makeText(getActivity(), "Register failed", Toast.LENGTH_LONG).show();
                }
                else {
                    externalManager.getData().id = id.getText().toString();
                    Toast.makeText(getActivity(), "Register success", Toast.LENGTH_LONG).show();
                   externalManager.backHome();
                }
                manager.closeDB();
                View temp = getActivity().getCurrentFocus();
                if (temp != null) {
                    InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(temp.getWindowToken(), 0);
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.pop();
            }
        });
        return view;
    }
}
