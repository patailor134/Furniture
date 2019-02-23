package com.efunhub.furniture.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.efunhub.furniture.Adapter.WishListAdapter;
import com.efunhub.furniture.Model.WishListModel;
import com.efunhub.furniture.R;

import java.util.ArrayList;

public class WishListActivity extends AppCompatActivity
{

    Toolbar mToolbar;
    RecyclerView wish_RecyclerView;
    WishListAdapter wishListAdapter;
    ArrayList<WishListModel> wishListModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        init();

        mToolbar.setTitle("WishList");

        setSupportActionBar(mToolbar);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        wishListModelArrayList = new ArrayList<>();

        ArrayList<String> namelist = new ArrayList<>();
        namelist.add("Malabar Storage Coffee Table");
        namelist.add("Rhodes Folding Book Shelf");
        namelist.add("Malabar Storage Coffee Table");
        namelist.add("Rhodes Folding Book Shelf");
        namelist.add("Malabar Storage Coffee Table");
        namelist.add("Rhodes Folding Book Shelf");


        ArrayList<String> images = new ArrayList<>();
        images.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/163160/product/Cortado_Coffee_Table_Mahogany_2.jpg?1515649466");
        images.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/1411/product/Rhodes_Folding_Book_Shelf_Teak_Finish_00_img_9999_183_square.jpg?1455530114");
        images.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/163160/product/Cortado_Coffee_Table_Mahogany_2.jpg?1515649466");
        images.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/1411/product/Rhodes_Folding_Book_Shelf_Teak_Finish_00_img_9999_183_square.jpg?1455530114");
        images.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/163160/product/Cortado_Coffee_Table_Mahogany_2.jpg?1515649466");
        images.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/1411/product/Rhodes_Folding_Book_Shelf_Teak_Finish_00_img_9999_183_square.jpg?1455530114");

        for (int i = 0; i < images.size(); i++)
        {
            WishListModel wishListModel = new WishListModel();
            wishListModel.setWishName(namelist.get(i));
            wishListModel.setWishImages(images.get(i));
            wishListModelArrayList.add(wishListModel);

        }

        wishListAdapter = new WishListAdapter(this, wishListModelArrayList);
        wish_RecyclerView.setHasFixedSize(true);
        wish_RecyclerView.setNestedScrollingEnabled(false);
        GridLayoutManager linearLayoutManager1 = new GridLayoutManager(this, 1);
        wish_RecyclerView.setLayoutManager(linearLayoutManager1);
        wish_RecyclerView.setItemAnimator(new DefaultItemAnimator());
        wish_RecyclerView.setAdapter(wishListAdapter);
    }

    private void init()
    {
        mToolbar = findViewById(R.id.toolbar);
        wish_RecyclerView = findViewById(R.id.rv_Wishlist);
    }
}
