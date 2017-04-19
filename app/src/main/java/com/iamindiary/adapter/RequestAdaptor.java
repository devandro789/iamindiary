package com.iamindiary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.iamindiary.R;

/**
 * Created by Amit on 11-04-2017.
 */

public class RequestAdaptor extends BaseAdapter
{
    private Context context;
    private LayoutInflater inflater;
    public RequestAdaptor(Context mContext)
    {
        this.context = mContext;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view = inflater.inflate(R.layout.request_rows,null,false);

        return row_view;
    }
    static class ViewHolder
    {

    }
}
