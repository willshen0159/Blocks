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

public class ChangePasswordFragment extends MyFragment {

    private ImageButton backButton;
    private Button changePasswordButton;
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
        view = inflater.inflate(R.layout.change_password, container, false);
        backButton = (ImageButton) view.findViewById(R.id.backButton);
        changePasswordButton = (Button) view.findViewById(R.id.changePasswordButton);
        id = (EditText) view.findViewById(R.id.id);
        password = (EditText) view.findViewById(R.id.password);
        email = (EditText) view.findViewById(R.id.email);
        manager = new SQLiteAccountManager();
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.openDB(getActivity());
                if(!manager.verifyEmail(id.getText().toString(), email.getText().toString())) {
                    Toast.makeText(getActivity(), "Change Failed", Toast.LENGTH_LONG).show();
                }
                else {
                    manager.setPassword(id.getText().toString(), password.getText().toString());
                    Toast.makeText(getActivity(), "Change success", Toast.LENGTH_LONG).show();
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
