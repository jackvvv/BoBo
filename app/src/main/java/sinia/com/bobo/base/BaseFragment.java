package sinia.com.bobo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import sinia.com.bobo.R;

/**
 * Created by 忧郁的眼神 on 2016/11/17 0017.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = initView(inflater, container);
        ButterKnife.bind(this, view);
        return view;
    }

    public abstract View initView(LayoutInflater inflater, ViewGroup container);

    public void showToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    protected void startActivityForNoIntent(Class forwordClass) {
        Intent intent = new Intent(getActivity(), forwordClass);
        startActivity(intent);
    }

    /**
     */
    protected void startActivityForIntent(Class forwordClass, Intent intent) {
        intent.setClass(getActivity(), forwordClass);
        startActivity(intent);
    }

    protected void startLoginActivityForNoIntent(Class forwordClass) {
        Intent intent = new Intent(getActivity(), forwordClass);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.login_open, 0);
    }

    protected void startLoginActivityForIntent(Class forwordClass, Intent intent) {
        intent.setClass(getActivity(), forwordClass);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.login_open, 0);
    }

}
