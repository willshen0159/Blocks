package com.example.ooprojectblocks;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.ooprojectblocks.DB.AccountManager;
import com.example.ooprojectblocks.DB.SQLiteAccountManager;
import com.example.ooprojectblocks.Game.ClassicGameMech;
import com.example.ooprojectblocks.Game.DuelGameMech;
import com.example.ooprojectblocks.Game.GameMech;
import com.example.ooprojectblocks.Game.Object;
import com.example.ooprojectblocks.Game.SpecialGameMech;

public class GameFragment extends MyFragment {


    private View view;
    private GameMech game;
    private int score;

    private String state;

    private ImageButton pauseButton;
    private ImageButton resumeButton;
    private ImageButton homeButton;
    private ImageButton restartButton;

    private Handler handler;
    private AccountManager manager;
    //private ExternalManager externalManager;

    /*public void onAttach(Context context) {
        super.onAttach(context);
        try {
            externalManager = (ExternalManager) context;
        } catch (ClassCastException castException) {
            // The activity does not implement the externalManager.
        }
    }*/

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(externalManager.getData().mode.equals("duel")) {
            view = inflater.inflate(R.layout.duel_game, container, false);
            this.game = new DuelGameMech(externalManager.getData().player1,
                    externalManager.getData().player2, externalManager.getData().bgm, externalManager.getData().sound,
                    externalManager.getData().colorBlind, (ConstraintLayout) view.findViewById(R.id.duel_game_layout), getActivity());
            if(externalManager.getData().bgm)
                externalManager.startBgm("duel");
        }
        else if(externalManager.getData().mode.equals("classic")){
            view = inflater.inflate(R.layout.game, container, false);
            this.game = new ClassicGameMech(externalManager.getData().player1,
                    externalManager.getData().player2, externalManager.getData().bgm, externalManager.getData().sound,
                    externalManager.getData().colorBlind, (ConstraintLayout) view.findViewById(R.id.game_layout), getActivity());
            if(externalManager.getData().bgm)
                externalManager.startBgm("classic");
        }
        else if(externalManager.getData().mode.equals("special")) {
            view = inflater.inflate(R.layout.game, container, false);
            this.game = new SpecialGameMech(externalManager.getData().player1,
                    externalManager.getData().player2, externalManager.getData().bgm, externalManager.getData().sound,
                    externalManager.getData().colorBlind, (ConstraintLayout) view.findViewById(R.id.game_layout), getActivity());
            if(externalManager.getData().bgm)
                externalManager.startBgm("special");
        }
        pauseButton = (ImageButton) view.findViewById(R.id.pauseButton);
        resumeButton = (ImageButton) view.findViewById(R.id.resumeButton);
        homeButton = (ImageButton) view.findViewById(R.id.homeButton);
        restartButton = (ImageButton) view.findViewById(R.id.restartButton);
        manager = new SQLiteAccountManager();
        handler = new Handler();
        run();
        return view;
    }

    public void run() {
        state = "run";
        pauseButton.setAlpha((float)0.4);
        resumeButton.setAlpha((float)0.0);
        restartButton.setAlpha((float)0.0);
        homeButton.setAlpha((float)0.0);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = "pause";
            }
        });
        resumeButton.setOnClickListener(null);
        restartButton.setOnClickListener(null);
        homeButton.setOnClickListener(null);
        Runnable runnable = new Runnable() {
            public void run() {
                if(state.equals("run")) {
                    if(game.run() == 1)
                        handler.postDelayed(this, 10);
                    else
                        end();
                }
                else if(state.equals("pause"))
                    pause();
            }
        };
        handler.postDelayed(runnable, 0);
    }

    public void pause() {
        game.pause();
        pauseButton.setAlpha((float)0.0);
        resumeButton.setAlpha((float)1.0);
        resumeButton.bringToFront();
        homeButton.setAlpha((float)1.0);
        homeButton.bringToFront();
        pauseButton.setOnClickListener(null);
        resumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run();
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHome();
            }
        });
    }

    public void end() {
        pauseButton.setOnClickListener(null);
        homeButton.setAlpha((float)1.0);
        homeButton.bringToFront();
        restartButton.setAlpha((float)1.0);
        restartButton.bringToFront();
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHome();
            }
        });
    }

    public void backHome() {
        score = game.getScore();
        if(externalManager.getData().mode.equals("classic")) {
            if (externalManager.getData().id != null) {
                manager.openDB(getActivity());
                int temp = manager.getTopScore(externalManager.getData().id);
                if(temp < score)
                    manager.setTopScore(externalManager.getData().id, score);
                manager.closeDB();
            }
        }
        externalManager.backHome();
    }

    public void restart() {
        score = game.getScore();
        if(externalManager.getData().mode.equals("classic")) {
            if (externalManager.getData().id != null) {
                manager.openDB(getActivity());
                int temp = manager.getTopScore(externalManager.getData().id);
                if(temp < score)
                    manager.setTopScore(externalManager.getData().id, score);
                manager.closeDB();
            }
        }
        externalManager.replaceFragment("restart");
    }
}
