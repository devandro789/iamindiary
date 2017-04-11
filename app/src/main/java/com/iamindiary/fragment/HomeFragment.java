package com.iamindiary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iamindiary.R;
import com.iamindiary.adaptor.RequestAdaptor;
import com.iamindiary.utils.CustomTextViewLight;

/**
 * Created by Amit on 10-04-2017.
 */

public class HomeFragment extends Fragment implements View.OnClickListener
{
    private View view;
    private RelativeLayout tab_requests,tab_chats;
    private TextView tab_request_selected,tab_chat_selected;
    private ListView requestListView;
    private RequestAdaptor adaptor;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.layout_home,null,false);
        initView(view);
        return view;
    }
    public void initView(View view)
    {
        tab_requests = (RelativeLayout) view.findViewById(R.id.tab_request);
        tab_requests.setOnClickListener(this);
        tab_chats = (RelativeLayout) view.findViewById(R.id.tab_chats);
        tab_chats.setOnClickListener(this);
        tab_request_selected = (TextView) view.findViewById(R.id.requests_selectedTV);
        tab_chat_selected = (TextView) view.findViewById(R.id.chat_selectedTV);
        adaptor = new RequestAdaptor(getActivity());
        requestListView = (ListView) view.findViewById(R.id.list_request);
        requestListView.setAdapter(adaptor);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tab_request:
                setSelectedTab(R.id.tab_request);
                break;
            case R.id.tab_chats:
                setSelectedTab(R.id.tab_chats);
                break;
        }
    }
    public void setSelectedTab(int value)
    {
         switch (value)
         {
             case R.id.tab_request:
                 tab_chat_selected.setVisibility(View.INVISIBLE);
                 tab_request_selected.setVisibility(View.VISIBLE);
                 break;
             case R.id.tab_chats:
                 tab_chat_selected.setVisibility(View.VISIBLE);
                 tab_request_selected.setVisibility(View.INVISIBLE);
                 break;
             default:
                 tab_chat_selected.setVisibility(View.INVISIBLE);
                 tab_request_selected.setVisibility(View.VISIBLE);
                 break;
         }
    }
}
