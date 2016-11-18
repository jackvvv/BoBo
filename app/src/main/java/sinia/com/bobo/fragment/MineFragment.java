package sinia.com.bobo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sinia.com.bobo.R;
import sinia.com.bobo.base.BaseFragment;

/**
 * Created by 忧郁的眼神 on 2016/11/17 0017.
 */

public class MineFragment extends BaseFragment {
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        return view;
    }
}
