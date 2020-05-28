package com.test.hakolightnovelclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.test.hakolightnovelclone.R;
import com.test.hakolightnovelclone.object.Chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterAdapter extends ArrayAdapter<Chapter> {
    private Context context;
    private ArrayList<Chapter> chapters;

    public ChapterAdapter(@NonNull Context context, int resource, @NonNull List<Chapter> objects) {
        super(context, resource, objects);
        this.context = context;
        this.chapters = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_chapter, null);
        }

        if (chapters.size() > 0) {
            TextView tvChaptername;
            tvChaptername = convertView.findViewById(R.id.tvChaptername);

            Chapter chapter = chapters.get(position);
            tvChaptername.setText(chapter.getChapterName());
        }
        return convertView;
    }
}
