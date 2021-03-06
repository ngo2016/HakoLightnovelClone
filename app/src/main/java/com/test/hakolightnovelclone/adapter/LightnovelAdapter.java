package com.test.hakolightnovelclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.test.hakolightnovelclone.R;
import com.test.hakolightnovelclone.object.Lightnovel;

import java.util.ArrayList;
import java.util.List;

public class LightnovelAdapter extends ArrayAdapter<Lightnovel> {
    Context context;
    ArrayList<Lightnovel> lightnovels;

    public LightnovelAdapter(@NonNull Context context, int resource, @NonNull List<Lightnovel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.lightnovels = new ArrayList<>(objects);
    }

    public void SortLn(String s) {
        s = s.toUpperCase();
        int k = 0;
        for (int i = 0; i < lightnovels.size(); i++) {
            Lightnovel lightnovel = lightnovels.get(i);
            String name = lightnovel.getTenLn().toUpperCase();
            if (name.contains(s)) {
                lightnovels.set(i, lightnovels.get(k));
                lightnovels.set(k, lightnovel);
                k++;
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_ln, null);
        }

        if (lightnovels.size() > 0) {
            Lightnovel lightnovel = this.lightnovels.get(position);

            TextView tvLnName = convertView.findViewById(R.id.tvLnName);
            ImageView imgLn = convertView.findViewById(R.id.imgLn);

            tvLnName.setText(lightnovel.getTenLn());
            Glide.with(this.context).load(lightnovel.getImgLink()).into(imgLn);
        }

        return convertView;
    }
}
