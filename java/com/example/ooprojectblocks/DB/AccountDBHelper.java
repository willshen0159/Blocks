package com.example.ooprojectblocks.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccountDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Account.db";
    private static final int DATABASE_VERSION = 1;

    public AccountDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE Account(" +
                "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "id TEXT NOT NULL, " +
                "password TEXT NOT NULL, " +
                "topScore INTEGER, " +
                "topStage INTEGER, " +
                "email TEXT NOT NULL);";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Account");
        onCreate(db);
    }
}
