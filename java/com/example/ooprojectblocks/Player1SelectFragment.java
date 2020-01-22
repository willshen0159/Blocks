package com.example.ooprojectblocks;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Player1SelectFragment extends MyFragment {

    private ImageButton backButton;
    private ImageButton left;
    private ImageButton right;
    private ImageView player1;
    private Button startButton;
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
        view = inflater.inflate(R.layout.player1_select, container, false);
        backButton = (ImageButton) view.findViewById(R.id.backButton);
        left = (ImageButton) view.findViewById(R.id.left);
        right = (ImageButton) view.findViewById(R.id.right);
        player1 = (ImageView) view.findViewById(R.id.player1);
        startButton = (Button) view.findViewById(R.id.start);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.pop();
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(externalManager.getData().player1.equals("square"))
                    externalManager.getData().player1 = "circle";
                else if(externalManager.getData().player1.equals("circle"))
                    externalManager.getData().player1 = "triangle";
                else if(externalManager.getData().player1.equals("triangle"))
                    externalManager.getData().player1 = "square";
                refresh();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(externalManager.getData().player1.equals("square"))
                    externalManager.getData().player1 = "triangle";
                else if(externalManager.getData().player1.equals("triangle"))
                    externalManager.getData().player1 = "circle";
                else if(externalManager.getData().player1.equals("circle"))
                    externalManager.getData().player1 = "square";
                refresh();
            }
        });
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.replaceFragment("game");
            }
        });
        refresh();
        return view;
    }

    public void refresh() {
        if(externalManager.getData().player1.equals("square"))
            player1.setImageResource(R.drawable.whiteblock);
        else if(externalManager.getData().player1.equals("circle"))
            player1.setImageResource(R.drawable.whitecircle);
        else if(externalManager.getData().player1.equals("triangle"))
            player1.setImageResource(R.drawable.whitetriangle);
    }
}
