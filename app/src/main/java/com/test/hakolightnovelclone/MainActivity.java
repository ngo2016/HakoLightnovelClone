package com.test.hakolightnovelclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gvDanhSachLn;
    LightnovelAdapter adapter;
    ArrayList<Lightnovel> lightnovels;

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
    }

    private void Init() {
        lightnovels = new ArrayList<>();
        lightnovels.add(new Lightnovel("Overlord", "https://c1.hako.re/lightnovel/covers/s253-2e5b9953-dbdb-41b1-8a98-cf27c12a11b4-m.jpg"));
        lightnovels.add(new Lightnovel("Kono Subarashii Sekai Ni Shukufuku o!", "https://c1.hako.re/lightnovel/covers/s6111-b554319a-2dff-4236-9e60-06f40cff50a8-m.jpg"));
        lightnovels.add(new Lightnovel("Mahouka Koukou no Rettousei", "https://c1.hako.re/lightnovel/covers/s2891-33c9e9e9-14a4-4690-80af-942edc968487-m.jpg"));
        lightnovels.add(new Lightnovel("Rokujouma no Shinryakusha!?", "https://c1.hako.re/lightnovel/covers/s247-f7ebeb5a-203a-45bf-9050-a4bbc0486ae7-m.jpg"));
        lightnovels.add(new Lightnovel("Overlord", "https://c1.hako.re/lightnovel/covers/s253-2e5b9953-dbdb-41b1-8a98-cf27c12a11b4-m.jpg"));
        lightnovels.add(new Lightnovel("Kono Subarashii Sekai Ni Shukufuku o!", "https://c1.hako.re/lightnovel/covers/s6111-b554319a-2dff-4236-9e60-06f40cff50a8-m.jpg"));
        lightnovels.add(new Lightnovel("Mahouka Koukou no Rettousei", "https://c1.hako.re/lightnovel/covers/s2891-33c9e9e9-14a4-4690-80af-942edc968487-m.jpg"));
        lightnovels.add(new Lightnovel("Rokujouma no Shinryakusha!?", "https://c1.hako.re/lightnovel/covers/s247-f7ebeb5a-203a-45bf-9050-a4bbc0486ae7-m.jpg"));
        lightnovels.add(new Lightnovel("Overlord", "https://c1.hako.re/lightnovel/covers/s253-2e5b9953-dbdb-41b1-8a98-cf27c12a11b4-m.jpg"));
        lightnovels.add(new Lightnovel("Kono Subarashii Sekai Ni Shukufuku o!", "https://c1.hako.re/lightnovel/covers/s6111-b554319a-2dff-4236-9e60-06f40cff50a8-m.jpg"));
        lightnovels.add(new Lightnovel("Mahouka Koukou no Rettousei", "https://c1.hako.re/lightnovel/covers/s2891-33c9e9e9-14a4-4690-80af-942edc968487-m.jpg"));
        lightnovels.add(new Lightnovel("Rokujouma no Shinryakusha!?", "https://c1.hako.re/lightnovel/covers/s247-f7ebeb5a-203a-45bf-9050-a4bbc0486ae7-m.jpg"));

        adapter = new LightnovelAdapter(this, 0, lightnovels);
    }

    private void SetControl() {
        gvDanhSachLn = findViewById(R.id.gvDanhSachLn);
    }
}
