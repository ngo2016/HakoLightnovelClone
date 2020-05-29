package com.test.hakolightnovelclone.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // Tên cơ sở dữ liệu
    private static final String TEN_DATABASE = "HakoLnClone";
    // Tên bảng
    public static final String LIGHTNOVEL = "Lightnovel";
    public static final String LISTCHAPTER = "ListChapter";

    // Bảng gồm 3 cột _id, _ten và _lop.
    public static final String COT_ID = "id";
    public static final String TEN_LN = "tenLn";
    public static final String IMG_LINK = "imgLink";
    public static final String TEN_CHAPTER = "tenChapter";
    public static final String NOI_DUNG = "noiDung";

    private static final String TAO_BANG_LIGHTNOVEL = ""
            + "CREATE TABLE IF NOT EXISTS " + LIGHTNOVEL + " ( "
            + COT_ID + " integer primary key autoincrement ,"
            + TEN_LN + " text not null, "
            + IMG_LINK + " text not null );";

    private static final String TAO_BANG_LISTCHAPTER = ""
            + "CREATE TABLE IF NOT EXISTS " + LISTCHAPTER + " ( "
            + COT_ID + " integer primary key autoincrement ,"
            + TEN_LN + " text not null, "
            + TEN_CHAPTER + " text not null, "
            + NOI_DUNG + " text not null );";

    public DBHelper(Context context) {
        super(context, TEN_DATABASE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TAO_BANG_LIGHTNOVEL);
        db.execSQL(TAO_BANG_LISTCHAPTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
