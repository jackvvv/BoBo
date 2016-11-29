package sinia.com.bobo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import sinia.com.bobo.R;
import sinia.com.bobo.adapter.LiveGiftListAdapter;
import sinia.com.bobo.base.BaseFragment;

/**
 * Created by 忧郁的眼神 on 2016/11/29 0029.
 */

public class GiftListFragment extends BaseFragment {
    @Bind(R.id.listView)
    ListView listView;
    private LiveGiftListAdapter adapter;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_gift_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        adapter = new LiveGiftListAdapter(getActivity());
        listView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
