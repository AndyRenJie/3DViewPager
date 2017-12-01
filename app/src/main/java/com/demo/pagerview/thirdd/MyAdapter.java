package com.demo.pagerview.thirdd;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Andy.Ren on 2017/3/30.
 */

public class MyAdapter extends PagerAdapter{

    private Context mContext;
    private ArrayList<ImageView> mList;

    public MyAdapter(Context context, ArrayList<ImageView> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = mList.get(position);
        container.addView(imageView,position);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
