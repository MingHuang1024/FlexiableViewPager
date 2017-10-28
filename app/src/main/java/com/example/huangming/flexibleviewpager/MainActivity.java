package com.example.huangming.flexibleviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        CyclicViewPager cyclicViewPager = (CyclicViewPager) findViewById(R.id.cyclicViewPager);
        List<View> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            // 这里除了两个用于循环的view，只用一个view来显示日历的内容，用最少的view来实现日历场景
            TextView tv = new TextView(this);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            tv.setLayoutParams(params);
            tv.setBackgroundColor(Color.parseColor("#997b66"));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(30);
            list.add(tv);
        }
        cyclicViewPager.setAdapter(new CyclicPagerAdapter(list));
    }
}
