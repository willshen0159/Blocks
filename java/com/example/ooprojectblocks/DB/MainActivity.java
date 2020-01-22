/*package com.example.ooprojectblocks.DB;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private EditText idtext;
    private EditText passwordtext;
    private EditText emailtext;
    private Button bt;
    AccountManager manager;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AccountDBHelper dbh = new AccountDBHelper(this);
        db = dbh.getWritableDatabase();
        manager = new SQLiteAccountManager(db);
        text = (TextView) findViewById(R.id.TextView);
        String temp = "";
        Cursor c = db.rawQuery("SELECT * FROM Account", null);
        if(c.moveToFirst()) {
            do {
                temp += c.getString(0) + " ";
                temp += c.getString(1) + " ";
                temp += c.getString(2) + " ";
                temp += c.getString(3) + " ";
                temp += c.getString(4) + " ";
                temp += c.getString(5) + "\n";
            } while(c.moveToNext());
        }
        text.setText(temp);
        idtext = (EditText) findViewById(R.id.editText);
        passwordtext = (EditText) findViewById(R.id.editText2);
        emailtext = (EditText) findViewById(R.id.editText3);
        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!manager.isAccountExist(idtext.getText().toString()))
                    manager.addAccount(idtext.getText().toString(), passwordtext.getText().toString(), emailtext.getText().toString());
                Cursor c = db.rawQuery("SELECT * FROM Account", null);
                String temp = "";
                if(c.moveToFirst()) {
                    do {
                        temp += c.getString(0) + " ";
                        temp += c.getString(1) + " ";
                        temp += c.getString(2) + " ";
                        temp += c.getString(3) + " ";
                        temp += c.getString(4) + " ";
                        temp += c.getString(5) + "\n";
                    } while(c.moveToNext());
                }
                text.setText(temp);
            }
        });
    }
}*/
