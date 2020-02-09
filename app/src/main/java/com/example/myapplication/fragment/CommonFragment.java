package com.example.myapplication.fragment;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;

public class CommonFragment extends BaseFragment {
    private static final String TAG = CommonFragment.class.getSimpleName();
    private ListView contentList;
    private static String[] datas;
    private MyCommonAdapter adapter;

    @Override
    protected View initView() {
        Log.d(TAG, "initView: 常用框架Fragment页面初始化");
        View view = View.inflate(getmContext(), R.layout.common_fragment, null);
        contentList = view.findViewById(R.id.common_list);

        contentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String content = datas[i];
                Toast.makeText(getContext(), content, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void initData() {
        Log.d(TAG, "initData: 常用框架Fragment数据初始化");
        datas = new String[]{"OKHttp", "xUtils3", "Retrofit2", "Fresco", "Glide", "greenDao", "RxJava",
                "volley", "Gson", "FastJson", "picasso", "evenBus",
                "jcvideoplayer", "pulltorefresh", "Expandablelistview",
                "UniversalVideoView", "....."};
        adapter = new MyCommonAdapter(getmContext(), datas);
        contentList.setAdapter(adapter);
    }

    private class MyCommonAdapter extends BaseAdapter {

        private Context mContext;
        private String[] mDatas;

        public MyCommonAdapter(Context mContext, String[] mDatas) {
            this.mContext = mContext;
            this.mDatas = mDatas;
        }

        @Override
        public int getCount() {
            return datas.length;
        }

        @Override
        public Object getItem(int i) {
            return datas[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(mContext);
            textView.setPadding(10, 10, 0, 10);
            textView.setText(mDatas[i]);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(20);
            return textView;

        }
    }
}
