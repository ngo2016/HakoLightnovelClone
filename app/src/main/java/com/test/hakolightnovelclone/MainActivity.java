package com.test.hakolightnovelclone;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.test.hakolightnovelclone.adapter.LightnovelAdapter;
import com.test.hakolightnovelclone.db.DBAccess;
import com.test.hakolightnovelclone.object.Lightnovel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gvDanhSachLn;
    EditText etSearch;
    LightnovelAdapter adapter;
    ArrayList<Lightnovel> lightnovels;

    //    private DBHelper mDBHelper;
//    private SQLiteDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
        SetControl();
        SetEvent();
    }

    private void SetEvent() {
        gvDanhSachLn.setAdapter(adapter);

        gvDanhSachLn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lightnovel lightnovel = lightnovels.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("lightnovel", lightnovel);
                Intent intent = new Intent(MainActivity.this, ChapterActivity.class);
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String string = etSearch.getText().toString();
                adapter.SortLn(string);
            }
        });
    }

    private void Init() {
//        mDBHelper = new DBHelper(this);
//
//        try {
//            mDBHelper.updateDataBase();
//        } catch (IOException mIOException) {
//            throw new Error("UnableToUpdateDatabase");
//        }
//
//        try {
//            mDb = mDBHelper.getWritableDatabase();
//        } catch (SQLException mSQLException) {
//            throw mSQLException;
//        }
//
//        mDBHelper.openDataBase();
//        Cursor cursor = mDBHelper.layTatCaDuLieu();
//
//        if (cursor != null) {
//            lightnovels.clear();
//            while (cursor.moveToNext()) {
//                Lightnovel lightnovel = new Lightnovel();
//                lightnovel.setId(cursor.getInt(0));
//                lightnovel.setTenLn(cursor.getString(1));
//                lightnovel.setImgLink(cursor.getString(2));
//                lightnovels.add(lightnovel);
//            }
//
//            adapter = new LightnovelAdapter(this, 0, lightnovels);
//            adapter.notifyDataSetChanged();
//        }
//
//        mDBHelper.close();

        DBAccess dbAccess = DBAccess.getInstance(getApplicationContext());
        dbAccess.open();
        lightnovels = dbAccess.getLNs();
        adapter = new LightnovelAdapter(this, 0, lightnovels);
        adapter.notifyDataSetChanged();
    }

    private void SetControl() {
        gvDanhSachLn = findViewById(R.id.gvDanhSachLn);
        etSearch = findViewById(R.id.etSearch);
    }
}
