package com.test.hakolightnovelclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.test.hakolightnovelclone.R;
import com.test.hakolightnovelclone.object.Lightnovel;

public class ChapterActivity extends AppCompatActivity {
    ImageView imgLn;
    TextView tvTenLn;
    Lightnovel lightnovel;

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
    }

    private void SetEvent() {
        tvTenLn.setText(lightnovel.getTenLn());
        Glide.with(this).load(lightnovel.getImgLink()).into(imgLn);
    }

    private void SetControl() {
        imgLn = findViewById(R.id.imgLn);
        tvTenLn = findViewById(R.id.tvTenLn);
    }
}
