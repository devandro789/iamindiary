package com.iamindiary.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iamindiary.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyDiaryFragment extends Fragment {


    public MyDiaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_diary, container, false);
        return rootView;
    }

}
