package com.efunhub.furniture.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.efunhub.furniture.Adapter.OrderListAdapter;
import com.efunhub.furniture.Model.OrderListModel;
import com.efunhub.furniture.R;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity
{

    Toolbar mToolbar;
    RecyclerView order_RecyclerView;
    OrderListAdapter orderListAdapter;
    ArrayList<OrderListModel> orderListArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        init();

        mToolbar.setTitle("My Orders");

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

        orderListArrayList = new ArrayList<>();

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
            OrderListModel orderListModel = new OrderListModel();
            orderListModel.setOrderName(namelist.get(i));
            orderListModel.setOrderImages(images.get(i));
            orderListArrayList.add(orderListModel);
        }

        orderListAdapter = new OrderListAdapter(this, orderListArrayList);
        order_RecyclerView.setHasFixedSize(true);
        order_RecyclerView.setNestedScrollingEnabled(false);
        GridLayoutManager linearLayoutManager1 = new GridLayoutManager(this, 1);
        order_RecyclerView.setLayoutManager(linearLayoutManager1);
        order_RecyclerView.setItemAnimator(new DefaultItemAnimator());
        order_RecyclerView.setAdapter(orderListAdapter);
    }

    private void init()
    {
        mToolbar = findViewById(R.id.toolbar);
        order_RecyclerView = findViewById(R.id.rv_Orderlist);
    }
}
