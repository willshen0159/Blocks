package com.example.ooprojectblocks;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.ooprojectblocks.DB.AccountManager;
import com.example.ooprojectblocks.DB.SQLiteAccountManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillboardFragment extends MyFragment {
    private ImageButton backButton;
    private AccountManager manager;
    private ListView billboard;
    private String[][] record;
    private BillboardAdapter adapter;
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
        view = inflater.inflate(R.layout.billboard, container, false);
        billboard = (ListView) view.findViewById(R.id.billboard);
        manager = new SQLiteAccountManager();
        manager.openDB(getActivity());
        record = new String[11][3];
        record = manager.giveBillboard();
        manager.closeDB();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        map = new HashMap<String, Object>();
        map.put("rank", "Rank");
        map.put("id", "ID");
        map.put("score", "Score");
        list.add(map);
        for(int i=0;i<10;i++) {
            map = new HashMap<String, Object>();
            map.put("rank", record[i][0]);
            map.put("id", record[i][1]);
            map.put("score", record[i][2]);
            list.add(map);
        }
        adapter = new BillboardAdapter(getActivity(), list);
        billboard.setAdapter(adapter);
        backButton = (ImageButton) view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalManager.pop();
            }
        });
        return view;
    }
}
