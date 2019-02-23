package com.efunhub.furniture.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.efunhub.furniture.R;

public class MyAccountActivity extends AppCompatActivity
{
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        init();

        mToolbar.setTitle("My Account");
        setSupportActionBar(mToolbar);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void init()
    {
        mToolbar = findViewById(R.id.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.my_account_option_menu,menu);
        return true;
    }
}
