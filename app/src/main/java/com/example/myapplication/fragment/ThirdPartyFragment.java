package com.example.myapplication.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.base.BaseFragment;

public class ThirdPartyFragment extends BaseFragment {
    private static final String TAG = ThirdPartyFragment.class.getSimpleName();
    private TextView tv;
    @Override
    protected View initView() {
        Log.d(TAG, "initView: 第三方Fragment页面初始化");
        tv = new TextView(getmContext());
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(20);
        tv.setTextColor(Color.BLACK);
        return tv;
    }

    @Override
    public void initData() {
        Log.d(TAG, "initData: 第三方Fragment数据初始化");
        tv.setText("第三方Fragment");
    }
}
