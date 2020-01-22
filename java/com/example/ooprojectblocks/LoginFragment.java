package com.example.ooprojectblocks;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ooprojectblocks.DB.AccountManager;
import com.example.ooprojectblocks.DB.SQLiteAccountManager;

public class LoginFragment extends MyFragment {

    private ImageButton backButton;
    private Button loginButton;
    private Button registerButton;
    private Button changePasswordButton;
    private EditText id;
    private EditText password;
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
        view = inflater.inflate(R.layout.login, container, false);
        loginButton = (Button) view.findViewById(R.id.loginButton);
        backButton = (ImageButton) view.findViewById(R.id.backButton);
        registerButton = (Button) view.findViewById(R.id.registerButton);
        registerButton.setPaintFlags(registerButton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        changePasswordButton = (Button) view.findViewById(R.id.changePasswordButton);
        changePasswordButton.setPaintFlags(changePasswordButton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        id = (EditText) view.findViewById(R.id.id);
        password = (EditText) view.findViewById(R.id.password);
        manager = new SQLiteAccountManager();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.pop();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.openDB(getActivity());
                if(!manager.isAccountExist(id.getText().toString())) {
                    Toast.makeText(getActivity(), "Account doesn't exist", Toast.LENGTH_LONG).show();
                }
                else if(!manager.verify(id.getText().toString(), password.getText().toString())) {
                    Toast.makeText(getActivity(), "Wrong password", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getActivity(), "Welcome " + id.getText(), Toast.LENGTH_LONG).show();
                    externalManager.getData().id = id.getText().toString();
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
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.replaceFragment("register");
            }
        });
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.replaceFragment("changePassword");
            }
        });
        return view;
    }
}
