package com.example.ooprojectblocks.DB;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQLiteAccountManager implements AccountManager {
    private SQLiteDatabase db;

    public void openDB(Activity activity) {
        AccountDBHelper dbh = new AccountDBHelper(activity);
        db = dbh.getWritableDatabase();
        this.db = db;
    }

    public void closeDB() {
        db.close();
    }

    public boolean isAccountExist(String id) {
        Cursor c = db.rawQuery("SELECT * FROM Account WHERE id = '" + id + "'", null);
        if(c.getCount() == 0)
            return false;
        else
            return true;
    }

    public boolean verify(String id, String password) {
        if(id.equals("") || password.equals(""))
            return false;
        Cursor c = db.rawQuery("SELECT * FROM Account WHERE id = '" + id +
                "' AND password = '" + password + "'", null);
        if(c.getCount() == 0)
            return false;
        else
            return true;
    }

    public boolean verifyEmail(String id, String email) {
        if(id.equals("") || email.equals(""))
            return false;
        Cursor c = db.rawQuery("SELECT * FROM Account WHERE id = '" + id +
                "' AND email = '" + email + "'", null);
        if(c.getCount() == 0)
            return false;
        else
            return true;
    }

    public boolean addAccount(String id, String password, String email) {
        if(id.equals("") || password.equals("") || email.equals(""))
            return false;
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        cv.put("password", password);
        cv.put("topScore", 0);
        cv.put("topStage", 0);
        cv.put("email", email);
        db.insert("Account", null, cv);
        return true;
    }

    public void setPassword(String id, String password) {
        ContentValues cv = new ContentValues();
        cv.put("password", password);
        db.update("Account", cv, "id = '" + id + "'", null);
    }

    public int getTopScore(String id) {
        Cursor c = db.rawQuery("SELECT * FROM Account WHERE id = '" + id + "'", null);
        c.moveToFirst();
        return c.getInt(3);
    }

    public void setTopScore(String id, int score) {
        ContentValues cv = new ContentValues();
        cv.put("topScore", score);
        db.update("Account", cv, "id = '" + id + "'", null);
    }

    /*public int getTopStage(String id) {
        Cursor c = db.rawQuery("SELECT * FROM Account WHERE id = '" + id + "'", null);
        c.moveToFirst();
        return c.getInt(4);
    }

    public void setTopStage(String id, int stage) {
        ContentValues cv = new ContentValues();
        cv.put("topStage", stage);
        db.update("Account", cv, "id = '" + id + "'", null);
    }*/

    public String[][] giveBillboard() {
        String[][] result = new String[10][3];
        for(int i = 0; i < 10; i++) {
            for(int j = 1; j < 3; j++) {
                result[i][0] = "" + (i + 1);
                result[i][j] = null;
            }
        }
        String[] find = {"id", "topScore"};
        Cursor c = db.query("Account", find, null, null, null, null, "topScore" + " DESC");
        c.moveToFirst();
        int count = 0;
        for(c.moveToFirst(); !c.isAfterLast() && count < 10; c.moveToNext()) {
            result[count][1] = c.getString(0);
            result[count][2] = c.getString(1);
            count++;
        }
        return result;
    }
}
