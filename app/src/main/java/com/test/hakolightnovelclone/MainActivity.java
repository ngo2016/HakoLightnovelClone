package com.test.hakolightnovelclone;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.test.hakolightnovelclone.adapter.LightnovelAdapter;
import com.test.hakolightnovelclone.db.DBHelper;
import com.test.hakolightnovelclone.db.LightnovelDB;
import com.test.hakolightnovelclone.object.Lightnovel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gvDanhSachLn;
    EditText etSearch;
    LightnovelAdapter adapter;
    ArrayList<Lightnovel> lightnovels = new ArrayList<Lightnovel>();
    private DBHelper mDBHelper = new DBHelper(this);
    private SQLiteDatabase database;

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
        LightnovelDB lightnovelDB = new LightnovelDB(this);

//        Lightnovel ln1 = new Lightnovel("Overlord", "https://c1.hako.re/lightnovel/covers/s253-2e5b9953-dbdb-41b1-8a98-cf27c12a11b4-m.jpg");
//        Lightnovel ln2 = new Lightnovel("Kono Subarashii Sekai Ni Shukufuku o!", "https://c1.hako.re/lightnovel/covers/s6111-b554319a-2dff-4236-9e60-06f40cff50a8-m.jpg");
//        Lightnovel ln3 = new Lightnovel("Mahouka Koukou no Rettousei", "https://c1.hako.re/lightnovel/covers/s2891-33c9e9e9-14a4-4690-80af-942edc968487-m.jpg");
//        Lightnovel ln4 = new Lightnovel("Rokujouma no Shinryakusha!?", "https://c1.hako.re/lightnovel/covers/s247-f7ebeb5a-203a-45bf-9050-a4bbc0486ae7-m.jpg");
//        lightnovelDB.them(ln1);
//        lightnovelDB.them(ln2);
//        lightnovelDB.them(ln3);
//        lightnovelDB.them(ln4);


        Cursor cursor = lightnovelDB.getLns();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Lightnovel lightnovel = new Lightnovel();
                lightnovel.setId("" + cursor.getInt(0));
                lightnovel.setTenLn(cursor.getString(1));
                lightnovel.setImgLink(cursor.getString(2));
                lightnovels.add(lightnovel);
            }
        }
        adapter = new LightnovelAdapter(this, 0, lightnovels);
    }

    private void SetControl() {
        gvDanhSachLn = findViewById(R.id.gvDanhSachLn);
        etSearch = findViewById(R.id.etSearch);
    }
}
