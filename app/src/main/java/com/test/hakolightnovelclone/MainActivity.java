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
import com.test.hakolightnovelclone.object.Chapter;
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

    //Hàm sự kiện
    private void SetEvent() {
        gvDanhSachLn.setAdapter(adapter);

        //Khi click vào item trong grid item sẽ gửi 1 bundle sang cho activity chapter để nó nạp vào
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

        //Chức năng live
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
                //Refresh lại để update position
                adapter.refresh(lightnovels);
            }
        });
    }

    private void Init() {
        LightnovelDB lightnovelDB = new LightnovelDB(this);
//        Lightnovel ln1 = new Lightnovel("Overlord", "https://c1.hako.re/lightnovel/covers/s253-2e5b9953-dbdb-41b1-8a98-cf27c12a11b4-m.jpg");
//        Lightnovel ln2 = new Lightnovel("Kono Subarashii Sekai Ni Shukufuku o!", "https://c1.hako.re/lightnovel/covers/s6111-b554319a-2dff-4236-9e60-06f40cff50a8-m.jpg");
//        Lightnovel ln3 = new Lightnovel("Mahouka Koukou no Rettousei", "https://c1.hako.re/lightnovel/covers/s2891-33c9e9e9-14a4-4690-80af-942edc968487-m.jpg");
//        Lightnovel ln4 = new Lightnovel("Rokujouma no Shinryakusha!?", "https://c1.hako.re/lightnovel/covers/s247-f7ebeb5a-203a-45bf-9050-a4bbc0486ae7-m.jpg");
//        lightnovelDB.addLn(ln1);
//        lightnovelDB.addLn(ln2);
//        lightnovelDB.addLn(ln3);
//        lightnovelDB.addLn(ln4);

//        Chapter ch9 = new Chapter("Vol 1 Mở đầu", "Kono Subarashii Sekai Ni Shukufuku o!", "Vol 1 Mở đầu.html");
//        lightnovelDB.addChapter(ch9);
//        Chapter ch2 = new Chapter("Vol 1 Chương 1", "Kono Subarashii Sekai Ni Shukufuku o!", "Vol 1 Chương 1.html");
//        lightnovelDB.addChapter(ch2);
//        Chapter ch3 = new Chapter("Vol 1 Chương 2", "Kono Subarashii Sekai Ni Shukufuku o!", "Vol 1 Chương 2.html");
//        lightnovelDB.addChapter(ch3);
//        Chapter ch4 = new Chapter("Vol 1 Chương 3", "Kono Subarashii Sekai Ni Shukufuku o!", "Vol 1 Chương 3.html");
//        lightnovelDB.addChapter(ch4);
//        Chapter ch5 = new Chapter("Vol 1 Chương 4", "Kono Subarashii Sekai Ni Shukufuku o!", "Vol 1 Chương 4.html");
//        lightnovelDB.addChapter(ch5);
//        Chapter ch1 = new Chapter("Vol 1 Chương kết", "Kono Subarashii Sekai Ni Shukufuku o!", "Vol 1 Chương kết.html");
//        lightnovelDB.addChapter(ch1);
//        Chapter ch10 = new Chapter("Vol 1 Lời bạt", "Kono Subarashii Sekai Ni Shukufuku o!", "Vol 1 Lời bạt.html");
//        lightnovelDB.addChapter(ch10);
//
//        lightnovelDB.close();

//        for (int i = 19; i <= 26; i++) {
//            lightnovelDB.delchapter(i);
//        }

        //Đọc dữ liệu từ db đổ vào grid item
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
