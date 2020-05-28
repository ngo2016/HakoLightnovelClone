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
            + "CREATE TABLE " + LIGHTNOVEL + " ( "
            + COT_ID + " integer primary key autoincrement ,"
            + TEN_LN + " text not null, "
            + IMG_LINK + " text not null );";

    private static final String TAO_BANG_LISTCHAPTER = ""
            + "CREATE TABLE " + LISTCHAPTER + " ( "
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
//        db.execSQL("INSERT INTO Lightnovel VALUES('Overlord','https://c1.hako.re/lightnovel/covers/s253-2e5b9953-dbdb-41b1-8a98-cf27c12a11b4-m.jpg');");
//        db.execSQL("INSERT INTO Lightnovel VALUES('Kono Subarashii Sekai Ni Shukufuku o!','https://c1.hako.re/lightnovel/covers/s6111-b554319a-2dff-4236-9e60-06f40cff50a8-m.jpg');");
//        db.execSQL("INSERT INTO Lightnovel VALUES('Mahouka Koukou no Rettousei','https://c1.hako.re/lightnovel/covers/s2891-33c9e9e9-14a4-4690-80af-942edc968487-m.jpg');");
//        db.execSQL("INSERT INTO Lightnovel VALUES('Rokujouma no Shinryakusha!?','https://c1.hako.re/lightnovel/covers/s247-f7ebeb5a-203a-45bf-9050-a4bbc0486ae7-m.jpg');");

        db.execSQL(TAO_BANG_LISTCHAPTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
