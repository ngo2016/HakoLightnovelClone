package com.test.hakolightnovelclone.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.test.hakolightnovelclone.object.Lightnovel;

import java.util.ArrayList;

public class DBAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DBAccess instance;
    Cursor c = null;

    private DBAccess(Context context) {
        this.openHelper = new DBHelper(context);
    }

    public static DBAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DBAccess(context);
        }
        return instance;
    }

    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    public void close() {
        if (db != null) {
            this.db.close();
        }
    }

    public ArrayList<Lightnovel> getLNs() {
        ArrayList<Lightnovel> lightnovels = new ArrayList<Lightnovel>();

        String[] cot = {"id",
                "tenLn",
                "imgLink"};
        c = db.query("Lightnovel", cot, null, null, null, null,
                "id" + " DESC");

        if (c != null) {
            lightnovels.clear();
            while (c.moveToNext()) {
                Lightnovel lightnovel = new Lightnovel();
                lightnovel.setId(c.getInt(0));
                lightnovel.setTenLn(c.getString(1));
                lightnovel.setImgLink(c.getString(2));
                lightnovels.add(lightnovel);
            }
        }
        return lightnovels;
    }
}