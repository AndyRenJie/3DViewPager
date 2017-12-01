package com.demo.pagerview.thirdd;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout mainLayout;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fillData();
        calculationPageWidth();
        initListener();
    }

    private void initListener() {
        mainLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return viewPager.dispatchTouchEvent(motionEvent);
            }
        });
    }

    private void calculationPageWidth() {
        int pagerWidth= (int) (getResources().getDisplayMetrics().widthPixels*3.0f/5.0f);
        ViewGroup.LayoutParams lp=viewPager.getLayoutParams();
        if (lp==null){
            lp=new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        }else {
            lp.width=pagerWidth;
        }
        viewPager.setLayoutParams(lp);
        viewPager.setPageMargin(-50);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        mainLayout = (LinearLayout) findViewById(R.id.main_layout);
        viewPager.setOffscreenPageLimit(3);
    }

    private void fillData() {
        ArrayList<ImageView> imageList = new ArrayList<>();

        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(R.mipmap.lufei1);
        imageView1.setScaleType(ImageView.ScaleType.FIT_XY);

        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.mipmap.lufei2);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);

        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.mipmap.lufei3);
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);

        ImageView imageView4 = new ImageView(this);
        imageView4.setImageResource(R.mipmap.lufei2);
        imageView4.setScaleType(ImageView.ScaleType.FIT_XY);

        ImageView imageView5 = new ImageView(this);
        imageView5.setImageResource(R.mipmap.lufei1);
        imageView5.setScaleType(ImageView.ScaleType.FIT_XY);

        imageList.add(imageView1);
        imageList.add(imageView2);
        imageList.add(imageView3);
        imageList.add(imageView4);
        imageList.add(imageView5);

        viewPager.setPageTransformer(true,new MyPageTransformer());
        adapter = new MyAdapter(this,imageList);
        viewPager.setAdapter(adapter);
    }
}
