package com.test.hakolightnovelclone;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.test.hakolightnovelclone.adapter.ChapterAdapter;
import com.test.hakolightnovelclone.db.LightnovelDB;
import com.test.hakolightnovelclone.object.Chapter;
import com.test.hakolightnovelclone.object.Lightnovel;

import java.util.ArrayList;
import java.util.Objects;

public class ChapterActivity extends AppCompatActivity {
    ImageView imgLn;
    TextView tvTenLn;
    Lightnovel lightnovel;
    ListView lvChapters;
    ArrayList<Chapter> chapters;
    ChapterAdapter chapterAdapter;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        //Hiển thị nút back trên actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Init();
        SetControl();
        SetEvent();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void Init() {
        //Nhận bundle từ mainactivity
        Bundle bundle = getIntent().getBundleExtra("data");
        lightnovel = (Lightnovel) bundle.getSerializable("lightnovel");

        //Update lại title cho actionbar
        Objects.requireNonNull(getSupportActionBar()).setTitle(lightnovel.getTenLn());

        //Lấy dữ liệu chapter list từ db
        LightnovelDB lightnovelDB = new LightnovelDB(this);
        chapters = new ArrayList<>();
        Cursor cursor = lightnovelDB.getChapters(lightnovel);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Chapter chapter = new Chapter();
                chapter.setId("" + cursor.getInt(0));
                chapter.setTenLn(cursor.getString(2));
                chapter.setChapterName(cursor.getString(1));
                chapter.setNoiDung(cursor.getString(3));
                chapters.add(chapter);
            }
        }
        chapterAdapter = new ChapterAdapter(this, 0, chapters);
    }

    private void SetEvent() {
        //Lấy dữ liệu từ bundle để gán
        tvTenLn.setText(lightnovel.getTenLn());
        Glide.with(this).load(lightnovel.getImgLink()).into(imgLn);

        lvChapters.setAdapter(chapterAdapter);

        //Khi ấn vào 1 chapter sẽ gửi title và path cho detail activity
        lvChapters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ChapterActivity.this, DetailActivity.class);
                intent.putExtra("title", chapters.get(position).getChapterName());
                intent.putExtra("path", lightnovel.getTenLn());
                startActivity(intent);
            }
        });
    }

    private void SetControl() {
        imgLn = findViewById(R.id.imgLn);
        tvTenLn = findViewById(R.id.tvTenLn);
        lvChapters = findViewById(R.id.lvChapters);
    }

    //Function back trên actionbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
