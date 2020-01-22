package com.example.ooprojectblocks;

import android.content.Context;
import android.support.v4.app.Fragment;

public class MyFragment extends Fragment {
    protected ExternalManager externalManager;

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            externalManager = (ExternalManager) context;
        } catch (ClassCastException castException) {
            /** The activity does not implement the externalManager. */
        }
    }
}
