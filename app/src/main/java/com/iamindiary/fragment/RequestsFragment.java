package com.iamindiary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iamindiary.R;
import com.iamindiary.adaptor.RequestAdaptor;

/**
 * Created by Amit on 10-04-2017.
 */

public class RequestsFragment extends Fragment
{
    private View view;
    private ListView requestListView;
    private RequestAdaptor adaptor;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.layout_inbox,null,false);
        initView(view);
        return view;
    }
    public void initView(View view)
    {
        adaptor = new RequestAdaptor(getActivity());
        requestListView = (ListView) view.findViewById(R.id.list_request);
        requestListView.setAdapter(adaptor);
    }
}
