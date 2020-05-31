package com.test.hakolightnovelclone.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.test.hakolightnovelclone.object.Chapter;
import com.test.hakolightnovelclone.object.Lightnovel;

public class LightnovelDB {
    private static SQLiteDatabase database;
    private DBHelper dbHelper;

    public LightnovelDB(Context context) {
        dbHelper = new DBHelper(context);
        try {
            database = dbHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            database = dbHelper.getReadableDatabase();
        }
    }

    //Lấy ln từ db
    public Cursor getLns() {
        // Biến cot là khai báo danh sách các cột cần lấy.
        String[] cot = {DBHelper.COT_ID,
                DBHelper.TEN_LN,
                DBHelper.IMG_LINK};
        Cursor cursor;
        cursor = database.query(DBHelper.
                        LIGHTNOVEL, cot, null, null, null, null,
                DBHelper.COT_ID + " DESC");
        return cursor;
    }

    //Lấy chapter list từ db
    public Cursor getChapters(Lightnovel lightnovel) {
        // Biến cot là khai báo danh sách các cột cần lấy.
        String[] cot = {DBHelper.COT_ID,
                DBHelper.TEN_CHAPTER,
                DBHelper.TEN_LN,
                DBHelper.NOI_DUNG};
        Cursor cursor;
        cursor = database.query(DBHelper.
                        LISTCHAPTER, cot, DBHelper.TEN_LN + " = '" + lightnovel.getTenLn() + "'", null, null, null,
                DBHelper.COT_ID + " ASC");
        return cursor;
    }

    public void close() {
        dbHelper.close();
    }

//    public long addLn(Lightnovel lightnovel) {
//        ContentValues values = new ContentValues();
//        values.put(DBHelper.TEN_LN, lightnovel.getTenLn());
//        values.put(DBHelper.IMG_LINK, lightnovel.getImgLink());
//        return database.insert(DBHelper.LIGHTNOVEL, null, values);
//    }

//    public long addChapter(Chapter chapter) {
//        ContentValues values = new ContentValues();
//        values.put(DBHelper.TEN_LN, chapter.getTenLn());
//        values.put(DBHelper.TEN_CHAPTER, chapter.getChapterName());
//        values.put(DBHelper.NOI_DUNG, chapter.getNoiDung());
//        return database.insert(DBHelper.LISTCHAPTER, null, values);
//    }

    //    public long delLn(int id) {
//        return database.delete(DBHelper
//                .LIGHTNOVEL, DBHelper
//                .COT_ID + " = " + "'" +
//                id + "'", null);
//    }
//
//    public long delchapter(int id) {
//        return database.delete(DBHelper
//                .LISTCHAPTER, DBHelper
//                .COT_ID + " = " + "'" +
//                id + "'", null);
//    }
}
