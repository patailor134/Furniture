package com.efunhub.furniture.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.efunhub.furniture.Adapter.TabAdapter;
import com.efunhub.furniture.Fragment.HomeFragment;
import com.efunhub.furniture.R;

public class MainActivity extends AppCompatActivity
{
    Toolbar mToolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    TabLayout tbl_pages;
    ViewPager vp_pages;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.main_toolbar);
        mToolbar.setTitle("Furniture");
        setSupportActionBar(mToolbar);

        init();

        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mToolbar.setTitleTextColor(getResources().getColor(R.color.White));

        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        vp_pages.setAdapter(tabAdapter);

        tbl_pages.setupWithViewPager(vp_pages);

        HomeFragment homeFragment = new HomeFragment();
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.main_viewpager, homeFragment);
        mFragmentTransaction.commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which i  tem was being clicked and perform appropriate action
                switch (item.getItemId())
                {
                    case R.id.item_home:
                        Intent intentHome = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intentHome);
                        return true;

                    case R.id.item_cart:
                        Intent intentCart = new Intent(MainActivity.this, CartActivity.class);
                        startActivity(intentCart);
                        return true;

                    case R.id.item_wishlist:
                        Intent intenWishlist = new Intent(MainActivity.this, WishListActivity.class);
                        startActivity(intenWishlist);
                        return true;

                    case R.id.item_orders:
                        Intent intentOrder = new Intent(MainActivity.this,OrderActivity.class);
                        startActivity(intentOrder);
                        return true;

                    case R.id.item_account:
                        Intent intentAccount = new Intent(MainActivity.this, MyAccountActivity.class);
                        startActivity(intentAccount);
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });

    }

    private void goToFragment(Fragment fragment, boolean addToBackStack)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (addToBackStack)
        {
            transaction.addToBackStack(null);
        }

        transaction.add(R.id.main_viewpager, fragment).commit();
    }

    private void init()
    {
        tbl_pages = findViewById(R.id.main_category_tabs);
        vp_pages = findViewById(R.id.main_viewpager);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar,R.string.openDrawer,R.string.closeDrawer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.option_cart:

                Intent intentCART = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intentCART);

                return true;
            case R.id.option_wishlist:

                Intent intentWISH = new Intent(MainActivity.this, WishListActivity.class);
                startActivity(intentWISH);

                return true;
            case R.id.option_profile:

                Intent intentPROFILE = new Intent(MainActivity.this, MyAccountActivity.class);
                startActivity(intentPROFILE);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
