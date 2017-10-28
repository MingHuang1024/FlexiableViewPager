package com.example.huangming.flexibleviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * 可循环滑动的ViewPager
 *
 * @author Huangming  2017/10/17
 */
public class CyclicViewPager extends ViewPager {
    private int mCount;
    private int mCurrentItem;
    private OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            System.out.println("onPageSelected--->position = " + position);
            mCurrentItem = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
                case SCROLL_STATE_IDLE:
                    // 已停止滑动
                    if (mCurrentItem == 0) {
                        setCurrentItem(mCount - 2, false);
                    } else if (mCurrentItem == mCount - 1) {
                        setCurrentItem(1, false);
                    }
                    break;
                case SCROLL_STATE_DRAGGING:
                    // 正在手动拖动
                    break;
                case SCROLL_STATE_SETTLING:
                    // 正在归位，即松手后自动完成滑动的过程
                    break;
            }
        }
    };

    public CyclicViewPager(Context context) {
        super(context);
        init();
    }

    public CyclicViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        this.addOnPageChangeListener(onPageChangeListener);
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
        mCount = adapter.getCount();
        mCurrentItem = 1;
        setCurrentItem(1);
    }
}
