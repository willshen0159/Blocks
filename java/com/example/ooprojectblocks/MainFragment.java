package com.example.ooprojectblocks;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MainFragment extends MyFragment {

    private Button playButton;
    private Button billboardButton;
    private Button settingButton;
    private Button loginButton;
    private Button logoutButton;
    private TextView hello;
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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(externalManager.getData().bgm)
            externalManager.startBgm("main");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main, container, false);
        playButton = (Button) view.findViewById(R.id.playButton);
        billboardButton = (Button) view.findViewById(R.id.billboardButton);
        settingButton = (Button) view.findViewById(R.id.settingButton);
        loginButton = (Button) view.findViewById(R.id.loginButton);
        logoutButton = (Button) view.findViewById(R.id.logoutButton);
        hello = (TextView) view.findViewById(R.id.hello);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.replaceFragment("mode");
            }
        });
        billboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.replaceFragment("billboard");
            }
        });
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.replaceFragment("setting");
            }
        });
        refresh();
        return view;
    }

    public void refresh() {
        if(externalManager.getData().id == null) {
            hello.setText("Hi, guest!");
            loginButton.setAlpha((float)1.0);
            logoutButton.setAlpha((float)0.0);
            logoutButton.setOnClickListener(null);
            loginButton.bringToFront();
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    externalManager.replaceFragment("login");
                }
            });
        }
        else {
            hello.setText("Hi, " + externalManager.getData().id + "!");
            logoutButton.setAlpha((float)1.0);
            loginButton.setAlpha((float)0.0);
            loginButton.setOnClickListener(null);
            logoutButton.bringToFront();
            logoutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    externalManager.getData().id = null;
                    refresh();
                }
            });
        }
    }
}
