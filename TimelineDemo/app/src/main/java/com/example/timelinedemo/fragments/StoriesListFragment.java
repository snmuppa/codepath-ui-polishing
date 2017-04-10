package com.example.timelinedemo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.timelinedemo.R;
import com.example.timelinedemo.adapters.MomentsAdapter;
import com.example.timelinedemo.models.Moment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class StoriesListFragment extends Fragment {
    private Context mContext;

    @BindView(R.id.rvMoments)
    RecyclerView rvMoments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stories_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mContext = getActivity();
        initView();
    }

    private void initView() {
        List<Moment> testMomentList = Moment.generateTestData();
        MomentsAdapter adapter = new MomentsAdapter(mContext, testMomentList);
        rvMoments.setAdapter(adapter);
        rvMoments.setLayoutManager(new LinearLayoutManager(mContext));

    }
}
