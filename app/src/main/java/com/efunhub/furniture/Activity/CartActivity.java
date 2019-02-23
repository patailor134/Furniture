package com.efunhub.furniture.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.efunhub.furniture.Adapter.CartRVAdapter;
import com.efunhub.furniture.Model.CartProductsModel;
import com.efunhub.furniture.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity
{

    Toolbar mToolbar;
    RecyclerView cartRecyclerView;
    CartRVAdapter cartRVAdapter;
    ArrayList<CartProductsModel> cartProductsModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        init();
        mToolbar.setTitle("My Cart");
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

        cartProductsModelArrayList = new ArrayList<>();

        ArrayList<String> namelist = new ArrayList<>();
        namelist.add("Malabar Storage Coffee Table");
        namelist.add("Rhodes Folding Book Shelf");


        ArrayList<String> images = new ArrayList<>();
        images.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/163160/product/Cortado_Coffee_Table_Mahogany_2.jpg?1515649466");
        images.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/1411/product/Rhodes_Folding_Book_Shelf_Teak_Finish_00_img_9999_183_square.jpg?1455530114");


        for (int i = 0; i < images.size(); i++)
        {
            CartProductsModel cartProductsModel = new CartProductsModel();
            cartProductsModel.setProductName(namelist.get(i));
            cartProductsModel.setProductImage(images.get(i));
            cartProductsModelArrayList.add(cartProductsModel);

        }

        cartRVAdapter = new CartRVAdapter(this, cartProductsModelArrayList);
        cartRecyclerView.setHasFixedSize(true);
        cartRecyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        cartRecyclerView.setLayoutManager(linearLayoutManager1);
        cartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        cartRecyclerView.setAdapter(cartRVAdapter);
    }

    private void init()
    {
        mToolbar = findViewById(R.id.toolbar);
        cartRecyclerView = findViewById(R.id.cartRecyclerView);
    }
}
