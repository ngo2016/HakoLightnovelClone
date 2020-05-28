package com.test.hakolightnovelclone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.test.hakolightnovelclone.adapter.ChapterAdapter;
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

        chapters = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            chapters.add(new Chapter("Chapter " + i));
        }
        chapterAdapter = new ChapterAdapter(this, 0, chapters);
    }

    private void SetEvent() {
        tvTenLn.setText(lightnovel.getTenLn());
        Glide.with(this).load(lightnovel.getImgLink()).into(imgLn);

        lvChapters.setAdapter(chapterAdapter);
    }

    private void SetControl() {
        imgLn = findViewById(R.id.imgLn);
        tvTenLn = findViewById(R.id.tvTenLn);
        lvChapters = findViewById(R.id.lvChapters);
    }
}
