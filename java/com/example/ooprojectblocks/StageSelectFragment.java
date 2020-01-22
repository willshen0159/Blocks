/*package com.example.ooprojectblocks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class StageSelectFragment extends Fragment {

    private ImageButton backButton;
    private Button stage1Button;
    private Button stage2Button;
    private Button stage3Button;
    private Button stage4Button;
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.stage_select, container, false);
        backButton = (ImageButton) view.findViewById(R.id.backButton);
        stage1Button = (Button) view.findViewById(R.id.stage1);
        stage2Button = (Button) view.findViewById(R.id.stage2);
        stage3Button = (Button) view.findViewById(R.id.stage3);
        stage4Button = (Button) view.findViewById(R.id.stage4);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).pop();
            }
        });
        stage1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setMode("stage1");
                ((MainActivity)getActivity()).replacePlayer1Select();
            }
        });
        stage2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setMode("stage2");
                ((MainActivity)getActivity()).replacePlayer1Select();
            }
        });
        stage3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setMode("stage3");
                ((MainActivity)getActivity()).replacePlayer1Select();
            }
        });
        stage4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setMode("stage4");
                ((MainActivity)getActivity()).replacePlayer1Select();
            }
        });
        return view;
    }
}*/
