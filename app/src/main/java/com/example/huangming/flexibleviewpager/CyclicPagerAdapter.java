package com.example.huangming.flexibleviewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 日历ViewPager的适配器
 *
 * @author Huangming 2017/10/28
 */
public class CyclicPagerAdapter extends PagerAdapter {
    List<View> mViews;

    public CyclicPagerAdapter(List<View> views) {
        mViews = views;
    }

    @Override
    public int getCount() {
        // 这里作为示例我们只显示12个月的日期，另外加上两个用于循环的view
        return 12 + 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // 复用日历布局，动态改变布局展示的数据
        int index = position % mViews.size();
        View v = mViews.get(index);
        if (container.indexOfChild(v) != -1) {
            container.removeView(v);
        }
        container.addView(v);
        // 动态改变View里面的显示内容
        bindData(v, position);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }


    /**
     * 绑定数据
     * @param v
     * @param position
     */
    private void bindData(View v, int position) {
        // 这里只要根据position就可以知道要显示哪个月的内容了，而不必额外记住当前要显示什么内容
        TextView tv = (TextView) v;
        String s;
        if (position == 0) {
            s = (getCount() - 2) + "";
        } else if (position == getCount() - 1) {
            s = "1";
        } else {
            s = position + "";
        }
        tv.setText("2017年" + s + "月");
    }
}
