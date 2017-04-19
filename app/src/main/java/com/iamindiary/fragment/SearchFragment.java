package com.iamindiary.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.michael.easydialog.EasyDialog;
import com.iamindiary.R;
import com.iamindiary.activity.CreateEvent;
import com.iamindiary.activity.FindTimeActivity;
import com.iamindiary.bean.EventBean;
import com.iamindiary.bean.PeopleBean;
import com.iamindiary.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements View.OnClickListener {

    ImageView ivAddSearch;
    RelativeLayout rlInviteFriends;
    LinearLayout llPeople, llEvents;
    TextView tvEvents, tvPeople;
    RecyclerView rvPeople;
    List<PeopleBean> peopleList;
    List<EventBean> eventList;
    PeopleAdapter peopleAdapter;
    EventAdapter eventAdapter;
    TextView tvPeopleListTitle;
    EditText etFilterBy;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        initView(rootView);

        peopleList = new ArrayList<>();
        peopleList.add(new PeopleBean("Shreyas Sharma", "Android Developer", "false", ""));
        peopleList.add(new PeopleBean("Shreyas Sharma", "Android Developer", "false", ""));

        eventList = new ArrayList<>();
        eventList.add(new EventBean("Steps Concert and Venga Boys", "Sun 19 Nov 2017", "1:00 AM - 4.30 AM", ""));

        changeSelection(true);
        return rootView;
    }

    public void setPeopleAdapter() {
        peopleAdapter = new PeopleAdapter(peopleList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvPeople.setLayoutManager(mLayoutManager);
        rvPeople.setItemAnimator(new DefaultItemAnimator());
        rvPeople.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rvPeople.setAdapter(peopleAdapter);
    }

    public void setEventAdapter() {
        eventAdapter = new EventAdapter(eventList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvPeople.setLayoutManager(mLayoutManager);
        rvPeople.setItemAnimator(new DefaultItemAnimator());
        rvPeople.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rvPeople.setAdapter(eventAdapter);
    }

    public void initView(View rootView) {
        ivAddSearch = (ImageView) rootView.findViewById(R.id.ivAddSearch);
        ivAddSearch.setOnClickListener(this);
        rlInviteFriends = (RelativeLayout) rootView.findViewById(R.id.rlInviteFriends);
        rlInviteFriends.setOnClickListener(this);
        llPeople = (LinearLayout) rootView.findViewById(R.id.llPeople);
        llPeople.setOnClickListener(this);
        llEvents = (LinearLayout) rootView.findViewById(R.id.llEvents);
        llEvents.setOnClickListener(this);
        tvPeople = (TextView) rootView.findViewById(R.id.tvPeople);
        tvEvents = (TextView) rootView.findViewById(R.id.tvEvents);
        rvPeople = (RecyclerView) rootView.findViewById(R.id.rvPeople);
        tvPeopleListTitle = (TextView) rootView.findViewById(R.id.tvPeopleListTitle);
        etFilterBy = (EditText) rootView.findViewById(R.id.etFilterBy);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivAddSearch:
                View easyViewPopup = getActivity().getLayoutInflater().inflate(R.layout.add_event_popup, null);
                EasyDialog easyDialog = new EasyDialog(getActivity())
                        .setLayout(easyViewPopup)
                        .setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white))
                        .setLocationByAttachedView(ivAddSearch)
                        .setTouchOutsideDismiss(true)
                        .setOutsideColor(ContextCompat.getColor(getActivity(), R.color.light_black))
                        .setMarginLeftAndRight(15, 15);


                LinearLayout llCreateEvent = (LinearLayout) easyViewPopup.findViewById(R.id.llCreateEvent);
                llCreateEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().startActivity(new Intent(getActivity(), CreateEvent.class));
                    }
                });

                LinearLayout llFindTime = (LinearLayout) easyViewPopup.findViewById(R.id.llFindTime);
                llFindTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().startActivity(new Intent(getActivity(), FindTimeActivity.class));
                    }
                });

                easyDialog.show();
                break;
            case R.id.rlInviteFriends:
                Toast.makeText(getActivity(), "Invite Friends", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llPeople:
                Toast.makeText(getActivity(), "People Friends", Toast.LENGTH_SHORT).show();
                changeSelection(true);
                break;
            case R.id.llEvents:
                Toast.makeText(getActivity(), "Events Friends", Toast.LENGTH_SHORT).show();
                changeSelection(false);
                break;
        }
    }

    public void changeSelection(boolean isPeopleSelected) {
        if (isPeopleSelected) {
            llPeople.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.white_left_rounded_corner));
            llEvents.setBackgroundColor(Color.TRANSPARENT);
            tvPeople.setSelected(true);
            tvEvents.setSelected(false);
            tvPeopleListTitle.setText(getString(R.string.text_people_you_may_know));
            etFilterBy.setVisibility(View.GONE);
            rlInviteFriends.setVisibility(View.VISIBLE);
            setPeopleAdapter();
        } else {
            llEvents.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.white_right_rounded_corner));
            llPeople.setBackgroundColor(Color.TRANSPARENT);
            tvPeople.setSelected(false);
            tvEvents.setSelected(true);
            tvPeopleListTitle.setText(getString(R.string.text_some_popular_events));
            etFilterBy.setVisibility(View.VISIBLE);
            rlInviteFriends.setVisibility(View.GONE);
            setEventAdapter();
        }
    }


    public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.MyViewHolder> {

        private List<PeopleBean> peopleBeansList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView tvName, tvNickName;

            public MyViewHolder(View view) {
                super(view);
                tvName = (TextView) view.findViewById(R.id.tvName);
                tvNickName = (TextView) view.findViewById(R.id.tvNickName);
            }
        }


        public PeopleAdapter(List<PeopleBean> peopleBeansList) {
            this.peopleBeansList = peopleBeansList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_people, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            PeopleBean peopleBean = peopleBeansList.get(position);
            holder.tvName.setText(peopleBean.getName());
            holder.tvNickName.setText(peopleBean.getNickName());
        }

        @Override
        public int getItemCount() {
            return peopleBeansList.size();
        }
    }


    public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

        private List<EventBean> eventList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView tvEventTitle, tvEventDate, tvEventTime;

            public MyViewHolder(View view) {
                super(view);
                tvEventTitle = (TextView) view.findViewById(R.id.tvEventTitle);
                tvEventDate = (TextView) view.findViewById(R.id.tvEventDate);
                tvEventTime = (TextView) view.findViewById(R.id.tvEventTime);
            }
        }


        public EventAdapter(List<EventBean> eventList) {
            this.eventList = eventList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_events, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            EventBean eventBean = eventList.get(position);
            holder.tvEventTitle.setText(eventBean.getTitle());
            holder.tvEventDate.setText(eventBean.getDate());
            holder.tvEventTime.setText(eventBean.getTime());
        }

        @Override
        public int getItemCount() {
            return eventList.size();
        }
    }
}