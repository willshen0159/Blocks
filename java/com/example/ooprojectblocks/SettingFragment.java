package com.example.ooprojectblocks;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class SettingFragment extends MyFragment {

    private ImageButton backButton;
    private Button bgmButton;
    private Button soundButton;
    private Button colorBlindButton;
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
        view = inflater.inflate(R.layout.setting, container, false);
        backButton = (ImageButton) view.findViewById(R.id.backButton);
        bgmButton = (Button) view.findViewById(R.id.bgmButton);
        soundButton = (Button) view.findViewById(R.id.soundButton);
        colorBlindButton = (Button) view.findViewById(R.id.colorBlindButton);
        refresh();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.pop();
            }
        });
        bgmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(externalManager.getData().bgm) {
                    externalManager.stopBgm();
                    externalManager.getData().bgm = false;
                }
                else {
                    externalManager.startBgm("main");
                    externalManager.getData().bgm = true;
                }
                refresh();
            }
        });
        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(externalManager.getData().sound)
                    externalManager.getData().sound = false;
                else
                    externalManager.getData().sound = true;
                refresh();
            }
        });
        colorBlindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(externalManager.getData().colorBlind)
                    externalManager.getData().colorBlind = false;
                else
                    externalManager.getData().colorBlind = true;
                refresh();
            }
        });
        return view;
    }

    public void refresh() {
        if(externalManager.getData().bgm)
            bgmButton.setText("ON");
        else
            bgmButton.setText("OFF");
        if(externalManager.getData().sound)
            soundButton.setText("ON");
        else
            soundButton.setText("OFF");
        if(externalManager.getData().colorBlind)
            colorBlindButton.setText("ON");
        else
            colorBlindButton.setText("OFF");
    }
}
