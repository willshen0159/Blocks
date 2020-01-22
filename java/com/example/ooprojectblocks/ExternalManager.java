package com.example.ooprojectblocks;

import android.support.v4.app.Fragment;

public interface ExternalManager {
    void replaceFragment(String next);
    void pop();
    void backHome();
    Data getData();
    void startBgm(String music);
    void stopBgm();
}
