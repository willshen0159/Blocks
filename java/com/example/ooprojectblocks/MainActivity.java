package com.example.ooprojectblocks;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements ExternalManager {

    private Data data;
    private MediaPlayer mediaPlayer;
    private MyFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new Data();
        mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
    }

    public void replaceFragment(String next) {
        if(next.equals("mode")) {
            MyFragment modeSelectFragment = new ModeSelectFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, modeSelectFragment).addToBackStack(null).commit();
        }
        else if(next.equals("billboard")) {
            MyFragment billboardFragment  = new BillboardFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, billboardFragment).addToBackStack(null).commit();
        }
        else if(next.equals("setting")) {
            MyFragment settingFragment = new SettingFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, settingFragment).addToBackStack(null).commit();
        }
        else if(next.equals("login")) {
            MyFragment loginFragment = new LoginFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, loginFragment).addToBackStack(null).commit();
        }
        else if(next.equals("register")) {
            MyFragment registerFragment = new RegisterFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, registerFragment).addToBackStack(null).commit();
        }
        else if(next.equals("changePassword")) {
            MyFragment changePasswordFragment = new ChangePasswordFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, changePasswordFragment).addToBackStack(null).commit();
        }
        else if(next.equals("player1")) {
            MyFragment player1SelectFragment = new Player1SelectFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, player1SelectFragment).addToBackStack(null).commit();
        }
        else if(next.equals("player2")) {
            MyFragment player2SelectFragment = new Player2SelectFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, player2SelectFragment).addToBackStack(null).commit();
        }
        else if(next.equals("game")) {
            MyFragment gameFragment = new GameFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, gameFragment).addToBackStack(null).commit();
        }
        else if(next.equals("restart")) {
            MyFragment gameFragment = new GameFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, gameFragment).addToBackStack(null).commit();
        }
    }

    public Data getData() {
        return data;
    }

    public void pop() {
        getSupportFragmentManager().popBackStack();
    }

    public void backHome() {
        getSupportFragmentManager().popBackStack(null, getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);
        mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
    }

    public void startBgm(String music) {
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        if(music.equals("main")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.main);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
        else if(music.equals("classic")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.classic);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
        else if(music.equals("special")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.special);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
        else if(music.equals("duel")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.duel);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }

    public void stopBgm() {
        if(mediaPlayer == null)
            return;
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
