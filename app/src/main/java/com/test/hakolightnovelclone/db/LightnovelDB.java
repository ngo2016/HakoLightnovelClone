package com.test.hakolightnovelclone.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

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

    public static Cursor layTatCaDuLieu() {
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

    public void close() {
        dbHelper.close();
    }

    public static long them(String name, String img) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.TEN_LN, name);
        values.put(DBHelper.IMG_LINK, img);
        return database.insert(DBHelper.LIGHTNOVEL, null, values);
    }
//
//    public static long xoa(PhieuPhanCong phieuPhanCong) {
//        return database.delete(DBHelper
//                .LIGHTNOVEL, DBHelper
//                .TEN_LN + " = " + "'" +
//                phieuPhanCong.getSoPhieu() + "'", null);
//    }
//
//    public static long sua(PhieuPhanCong phieuPhanCong) {
//        ContentValues values = new ContentValues();
//        values.put(DBHelper.TEN_LN,
//                phieuPhanCong.getSoPhieu());
//        values.put(DBHelper.IMG_LINK,
//                phieuPhanCong.getNgay());
//        values.put(DBHelper.COT_XUATPHAT,
//                phieuPhanCong.getXuatPhat());
//        values.put(DBHelper.COT_TUYEN,
//                phieuPhanCong.getTuyen());
//        values.put(DBHelper.COT_TINH,
//                phieuPhanCong.getTinh());
//        values.put(DBHelper.COT_XE,
//                phieuPhanCong.getXe());
//        return database.update(DBHelper
//                        .LIGHTNOVEL, values,
//                DBHelper.TEN_LN + " = "
//                        + phieuPhanCong.getSoPhieu(), null);
//    }
}
