package com.atguigu.mytestapp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LiXin on 2017/1/6.
 */

public abstract class BaseFragment extends Fragment {
    public Context mContext;
    @Override
    //系统创建baseFragment类时回调
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }

    @Nullable
    @Override
    //系统创建fragment视图时回调
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    public abstract  View initView();
    //抽象方法，不同的fragment实现该方法，创建不同的布局

    @Override
    //Activity创建成功后回调
    //初始化数据，联网请求数据，绑定数据
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    public void initData() {

    }

    @Override
    //隐藏状态变化时调用,当显示时刷新数据
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e("TAG",this.toString()+"hidden=="+hidden);
        if (!hidden) {
            onRefreshData();
        }
    }

    //刷新数据时调用
    public void onRefreshData() {


    }
}
