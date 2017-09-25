package com.gengen.news.newsproject.activities.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gengen.news.newsproject.R;
import com.gengen.news.newsproject.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HisFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewroot = inflater.inflate(R.layout.fragment_his, container, false);
        setViewroot(viewroot);
        initCommonTopBar(getResources().getString(R.string.history), 1);
        return viewroot;
    }

}
