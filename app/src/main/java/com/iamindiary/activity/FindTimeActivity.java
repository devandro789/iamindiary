package com.iamindiary.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.iamindiary.R;

public class FindTimeActivity extends AppCompatActivity {

    Toolbar toolbar;
    RelativeLayout rlAddAnotherTimeSlot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_time);
        initview();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.ic_back));
    }

    public void initview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rlAddAnotherTimeSlot = (RelativeLayout) findViewById(R.id.rlAddAnotherTimeSlot);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
        }
        return false;
    }
}
