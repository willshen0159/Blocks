package com.example.ooprojectblocks.DB;

import android.app.Activity;

public interface AccountManager {
    void openDB(Activity activity);
    void closeDB();
    boolean isAccountExist(String id);
    boolean verify(String id, String password);
    boolean verifyEmail(String id, String email);
    boolean addAccount(String id, String password, String email);
    void setPassword(String id, String password);
    int getTopScore(String id);
    void setTopScore(String id, int score);
    /*int getTopStage(String id);
    void setTopStage(String id, int stage);*/
    String[][] giveBillboard();
}
