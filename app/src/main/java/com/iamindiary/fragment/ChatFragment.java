package com.iamindiary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iamindiary.R;

/**
 * Created by Amit on 10-04-2017.
 */

public class ChatFragment extends Fragment
{
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.layout_inbox,null,false);
        return view;
    }
}
