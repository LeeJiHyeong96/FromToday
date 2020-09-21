package com.example.fromtoday;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_Home extends Fragment {
    ImageView imageChart, imageRun, imageMap;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_home, container, false);
        // PNG 파일 색상 바꾸기
        imageChart = (ImageView)view.findViewById(R.id.imageChart);
        imageChart.setColorFilter(Color.parseColor("#50A0FF"), PorterDuff.Mode.SRC_IN);
        imageRun = (ImageView)view.findViewById(R.id.imageRun);
        imageRun.setColorFilter(Color.parseColor("#19DC7C"), PorterDuff.Mode.SRC_IN);
        imageMap = (ImageView)view.findViewById(R.id.imageMap);
        imageMap.setColorFilter(Color.parseColor("#FF7840"), PorterDuff.Mode.SRC_IN);

        return view;

    }
}
