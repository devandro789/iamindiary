package com.iamindiary.activity;

import android.annotation.TargetApi;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.iamindiary.R;
import com.iamindiary.fragment.HomeFragment;
import com.iamindiary.fragment.InboxFragment;
import com.iamindiary.fragment.MyDiaryFragment;
import com.iamindiary.fragment.ProfileFragment;
import com.iamindiary.fragment.RequestsFragment;
import com.iamindiary.fragment.SearchFragment;
import com.iamindiary.utils.ProjectUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by User on 14-10-2016.
 */

public class BaseActivity extends FragmentActivity implements View.OnClickListener{
    private FragmentManager fragmentManager;
    private String TAG = "BaseActivity";
    private Context mContext;
    private Calendar calendar;


    /*Pedometer Variables*/

    private String formattedDate = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss aa");
    /*Pedometer Variable ends Here*/
    FloatingActionButton fab;

    BottomBar bottomBar;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProjectUtils.changeStatusBarColor(BaseActivity.this);
        setContentView(R.layout.base_layout);
        mContext = BaseActivity.this;
        ProjectUtils.baseActivity = this;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            formattedDate = formatter.format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        fragmentManager = getSupportFragmentManager();
        initView();
        bottomBarClicks();
    }

    public void initView() {

        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        fragmentManager.beginTransaction().add(R.id.container,new HomeFragment()).commit();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        ProjectUtils.showAlertDialogWithCancel(BaseActivity.this, "Exit Application!", "Are you sure want to exit?", "Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finishAffinity();
            }
        }, "Cancel", null);
    }
    public void setPagePosition(int position) {
        //questionsTabActivity.setPagePosition(position);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void bottomBarClicks()
    {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch(tabId)
                {
                    case R.id.tab_inbox:
                    {
                        clickInbox();
                        break;
                    }
                    case R.id.tab_diary:
                    {
                        clickDiary();
                        break;
                    }
                    case R.id.tab_search:
                    {
                        clickSearch();
                        break;
                    }
                    case R.id.tab_profile:
                    {
                        clickProfile();
                        break;
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.fab:
            {
                clickFloatingButton(view);
                break;
            }
        }
    }
    public void clickFloatingButton(View view)
    {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
    public void clickInbox()
    {
        fragmentManager.beginTransaction().add(R.id.container,new InboxFragment()).commit();
    }
    public void clickDiary()
    {
        fragmentManager.beginTransaction().add(R.id.container,new MyDiaryFragment()).commit();
    }
    public void clickProfile()
    {
        fragmentManager.beginTransaction().add(R.id.container,new ProfileFragment()).commit();
    }
    public void clickSearch()
    {
        fragmentManager.beginTransaction().add(R.id.container,new SearchFragment()).commit();
    }

}
