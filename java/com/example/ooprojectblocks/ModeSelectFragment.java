package com.example.ooprojectblocks;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class ModeSelectFragment extends MyFragment {
    private ImageButton backButton;
    private Button classicModeButton;
    private Button specialModeButton;
    private Button duelModeButton;
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
        view = inflater.inflate(R.layout.mode_select, container, false);
        backButton = (ImageButton) view.findViewById(R.id.backButton);
        classicModeButton = (Button) view.findViewById(R.id.classicModeButton);
        specialModeButton = (Button) view.findViewById(R.id.specialModeButton);
        duelModeButton = (Button) view.findViewById(R.id.duelModeButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.pop();
            }
        });
        classicModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.getData().mode = "classic";
                externalManager.replaceFragment("player1");
            }
        });
        specialModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.getData().mode = "special";
                externalManager.replaceFragment("player1");
            }
        });
        duelModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.getData().mode = "duel";
                externalManager.replaceFragment("player2");
            }
        });
        return view;
    }

}
