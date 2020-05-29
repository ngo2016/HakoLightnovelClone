package com.test.hakolightnovelclone;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.test.hakolightnovelclone.adapter.ChapterAdapter;
import com.test.hakolightnovelclone.db.LightnovelDB;
import com.test.hakolightnovelclone.object.Chapter;
import com.test.hakolightnovelclone.object.Lightnovel;

import java.util.ArrayList;

public class ChapterActivity extends AppCompatActivity {
    ImageView imgLn;
    TextView tvTenLn;
    Lightnovel lightnovel;
    ListView lvChapters;
    ArrayList<Chapter> chapters;
    ChapterAdapter chapterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        Init();
        SetControl();
        SetEvent();
    }

    private void Init() {
        Bundle bundle = getIntent().getBundleExtra("data");
        lightnovel = (Lightnovel) bundle.getSerializable("lightnovel");

        LightnovelDB lightnovelDB = new LightnovelDB(this);
        chapters = new ArrayList<>();
        Cursor cursor = lightnovelDB.getChapters();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Chapter chapter = new Chapter();
                chapter.setId("" + cursor.getInt(0));
                chapter.setTenLn(cursor.getString(1));
                chapter.setChapterName(cursor.getString(2));
                chapter.setNoiDung(cursor.getString(3));
                chapters.add(chapter);
            }
        }
        chapterAdapter = new ChapterAdapter(this, 0, chapters);
    }

    private void SetEvent() {
        tvTenLn.setText(lightnovel.getTenLn());
        Glide.with(this).load(lightnovel.getImgLink()).into(imgLn);

        lvChapters.setAdapter(chapterAdapter);

        lvChapters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ChapterActivity.this, DetailActivity.class);
                intent.putExtra("title", position);
                startActivity(intent);
            }
        });
    }

    private void SetControl() {
        imgLn = findViewById(R.id.imgLn);
        tvTenLn = findViewById(R.id.tvTenLn);
        lvChapters = findViewById(R.id.lvChapters);
    }
}
