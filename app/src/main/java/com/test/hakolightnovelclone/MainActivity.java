package com.test.hakolightnovelclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import com.test.hakolightnovelclone.adapter.LightnovelAdapter;
import com.test.hakolightnovelclone.R;
import com.test.hakolightnovelclone.object.Lightnovel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gvDanhSachLn;
    EditText etSearch;
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
        lightnovels = new ArrayList<>();
        lightnovels.add(new Lightnovel("Overlord", "https://c1.hako.re/lightnovel/covers/s253-2e5b9953-dbdb-41b1-8a98-cf27c12a11b4-m.jpg"));
        lightnovels.add(new Lightnovel("Kono Subarashii Sekai Ni Shukufuku o!", "https://c1.hako.re/lightnovel/covers/s6111-b554319a-2dff-4236-9e60-06f40cff50a8-m.jpg"));
        lightnovels.add(new Lightnovel("Mahouka Koukou no Rettousei", "https://c1.hako.re/lightnovel/covers/s2891-33c9e9e9-14a4-4690-80af-942edc968487-m.jpg"));
        lightnovels.add(new Lightnovel("Rokujouma no Shinryakusha!?", "https://c1.hako.re/lightnovel/covers/s247-f7ebeb5a-203a-45bf-9050-a4bbc0486ae7-m.jpg"));

        adapter = new LightnovelAdapter(this, 0, lightnovels);
    }

    private void SetControl() {
        gvDanhSachLn = findViewById(R.id.gvDanhSachLn);
        etSearch = findViewById(R.id.etSearch);
    }
}
