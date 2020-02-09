package com.example.myapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.fragment.CommonFragment;
import com.example.myapplication.fragment.CustomFragment;
import com.example.myapplication.fragment.OtherFragment;
import com.example.myapplication.fragment.ThirdPartyFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private RadioGroup rg_main;
    private ArrayList<BaseFragment> fragments;
    private int position = 0;
    private Fragment preFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment();
        initView();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new CommonFragment());
        fragments.add(new ThirdPartyFragment());
        fragments.add(new CustomFragment());
        fragments.add(new OtherFragment());
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        rg_main = findViewById(R.id.rg_main);
        rg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        rg_main.check(R.id.rb_common_frame);
    }

    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int id) {
            switch (id) {
                case R.id.rb_common_frame:
                    position = 0;
                    break;
                case R.id.rb_third_part_frame:
                    position = 1;
                    break;
                case R.id.rb_custom_frame:
                    position = 2;
                    break;
                case R.id.rb_other_frame:
                    position = 3;
                    break;
                default:
                    break;
            }
            Fragment toFragment = fragments.get(position);
            changeToCheckedFragment(preFragment, toFragment);
        }


    }

    /**
     * 使用hide以及add来解决重复创建的问题
     * @param fromFragment
     * @param toFragment
     */
    private void changeToCheckedFragment(Fragment fromFragment, Fragment toFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fromFragment != toFragment && toFragment != null) {
            //更新fromFragment
            preFragment = toFragment;

            if (!toFragment.isAdded()) {
                transaction.add(R.id.fragment_layout_main, toFragment);
            }
            if (fromFragment != null) {
                transaction.hide(fromFragment);
            }
            transaction.show(toFragment).commit();
        }
    }
//        private void changeToCheckedFragment(Fragment toFragment) {
//            //1.得到manager
//            FragmentManager manager = getSupportFragmentManager();
//            //2.得到事务transaction
//            FragmentTransaction transaction = manager.beginTransaction();
//            //3.添加事务
//            transaction.replace(R.id.fragment_layout_main, toFragment);
//            //4.提交事务
//            transaction.commit();
//        }
}
