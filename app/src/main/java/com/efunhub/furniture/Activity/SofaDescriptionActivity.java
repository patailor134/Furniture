package com.efunhub.furniture.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.crystalviewpager.widgets.CrystalViewPager;
import com.efunhub.furniture.Adapter.ColorListAdapter;
import com.efunhub.furniture.Adapter.SofaDescriptionAdapter;
import com.efunhub.furniture.Adapter.SofaSimilarListAdapter;
import com.efunhub.furniture.Model.ColorListModel;
import com.efunhub.furniture.Model.SofaDescriptionModel;
import com.efunhub.furniture.Model.SofaSimilarListModel;
import com.efunhub.furniture.R;

import java.util.ArrayList;

public class SofaDescriptionActivity extends AppCompatActivity
{
    View view;
    Toolbar mToolbar;
    ImageView sofaWishList;
    boolean click = true;
    int backposition = -1;

    //NestedScrollView nestedScrollView; 4gb 2Rx8 PC3 - 10600S - 9 - 10 - F20

    //Crystal View Pager
    CrystalViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    SofaDescriptionAdapter sofaDescriptionAdapter;
    ArrayList<SofaDescriptionModel> sofaDescriptionArrayList;
    //CircleIndicator indicator;

    //Color RV
    RecyclerView rv_Color;
    ColorListAdapter colorListAdapter;
    ArrayList<ColorListModel> colorListModelArrayList;

    //Similar Product RV
    RecyclerView rv_SofaSimilar;
    SofaSimilarListAdapter sofaSimilarListAdapter;
    ArrayList<SofaSimilarListModel> sSimilarListModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sofa_description);

        init();

        mToolbar.setTitle("Product Description");

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

        //WishList
        sofaWishList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (click)
                {
                    sofaWishList.setImageResource(R.drawable.ic_favorite_black_24dp);
                    click = false;

                } else {
                    sofaWishList.setImageResource(R.drawable.ic_favorite_red_24dp);
                    click = true;
                }
            }
        });

        sofaDescriptionArrayList = new ArrayList<>();
        colorListModelArrayList = new ArrayList<>();
        sSimilarListModelArrayList = new ArrayList<>();

        //Sofa Description Arraylist
        ArrayList<String> sofaProduct_Image = new ArrayList<>();
        sofaProduct_Image.add("https://ul-a.akamaihd.net/images/products/77271/original/FNSF51WCSL3_-_main_1.jpg?1464079596");
        sofaProduct_Image.add("https://ul-a.akamaihd.net/images/products/77272/original/FNSF51WCSL3_-_main_2.jpg?1456652007");
        sofaProduct_Image.add("https://ul-a.akamaihd.net/images/products/77275/original/FNSF51WCSL3_-_main_5.jpg?1456652008");
        sofaProduct_Image.add("https://ul-a.akamaihd.net/images/products/77276/original/FNSF51WCSL3_-_main_6.jpg?1456652009");
        sofaProduct_Image.add("https://ul-a.akamaihd.net/images/products/77277/original/FNSF51WCSL3_-_main_7.jpg?1456652010");
        sofaProduct_Image.add("https://ul-a.akamaihd.net/images/products/77278/original/FNSF51WCSL3_-_main_8.jpg?1456652010");
        sofaProduct_Image.add("https://ul-a.akamaihd.net/images/products/77279/original/FNSF51WCSL3_-_main_9.jpg?1456652011");

        //Offer list
        for (int i = 0; i < sofaProduct_Image.size(); i++)
        {
            SofaDescriptionModel sofaDescriptionModel = new SofaDescriptionModel();
            sofaDescriptionModel.setProduct_image(sofaProduct_Image.get(i));
            sofaDescriptionArrayList.add(sofaDescriptionModel);
        }

        //Sofa Description List
        sofaDescriptionAdapter = new SofaDescriptionAdapter(SofaDescriptionActivity.this, sofaDescriptionArrayList);
        viewPager.setAdapter(sofaDescriptionAdapter);

        //Circle Indicator
        dotscount = sofaDescriptionAdapter.getCount();
        dots = new ImageView[dotscount];
a
        //Circle Indicator Counts
        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dots));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dots));

        //Circle Indicator Change On Page Listener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {}
            @Override
            public void onPageSelected(int position)
            {
                for (int i = 0; i < dotscount; i++)
                {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dots));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dots));
            }
            @Override
            public void onPageScrollStateChanged(int state)
            {}
        });

        //Sofa Color Arraylist
        ArrayList<String> sofaColor_Image = new ArrayList<>();
        sofaColor_Image.add("https://ul-a.akamaihd.net/media/option-types/colour/option-values/steel.jpg");
        sofaColor_Image.add("https://ul-a.akamaihd.net/media/option-types/colour/option-values/sangria-red.jpg");
        sofaColor_Image.add("https://ul-a.akamaihd.net/media/option-types/colour/option-values/malibu.jpg");

        //Sofa Colro list
        for (int i = 0; i < sofaColor_Image.size(); i++)
        {
            ColorListModel colorListModel = new ColorListModel();
            colorListModel.setColorImage(sofaColor_Image.get(i));
            colorListModelArrayList.add(colorListModel);
        }

        //Set Color Adapter
        colorListAdapter = new ColorListAdapter(this, colorListModelArrayList);
        colorListAdapter.setListenerRecyclerView(new RecyclerViewItemClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(int adapterPosition)
            {
                int selected = adapterPosition;

                Log.v("In fragmnt position", String.valueOf(adapterPosition));
                View v = rv_Color.getChildAt(adapterPosition);
                v.setBackground(getDrawable(R.drawable.color_darkgray));
                /*Toast.makeText(SofaDescriptionActivity.this, "'"+adapterPosition+"'" , Toast.LENGTH_SHORT ).show();
                Toast.makeText(SofaDescriptionActivity.this, "'"+backposition+"'" , Toast.LENGTH_SHORT ).show();*/

                View v2  =  rv_Color.getChildAt(backposition);

                if (backposition != -1)
                {

                    v2.setSelected(false);
                    v2.setBackgroundColor(Color.parseColor("#00000000"));

                }
                backposition = adapterPosition;
            }
        });
        rv_Color.setHasFixedSize(true);
        rv_Color.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rv_Color.setLayoutManager(linearLayoutManager1);
        rv_Color.setItemAnimator(new DefaultItemAnimator());
        rv_Color.setAdapter(colorListAdapter);


        //Sofa Name List
        ArrayList<String> SSimilarName= new ArrayList<>();
        SSimilarName.add("Wooden Sofa Sets");
        SSimilarName.add("Leatherette Sofa Set");
        SSimilarName.add("Fabric Sofa Set");
        SSimilarName.add("Leather Sofa Set");
        SSimilarName.add("Wooden Sofa Sets");
        SSimilarName.add("Leatherette Sofa Set");
        SSimilarName.add("Fabric Sofa Set");
        SSimilarName.add("Leather Sofa Set");

        //Sofa Image List
        ArrayList<String> SSimilarImageList = new ArrayList<>();
        SSimilarImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/68717/slide/666x363/Raymond_Low_Wooden_Sofa_2_Seater_Grey_01.jpg?1450707074");
        SSimilarImageList.add("https://ul-a.akamaihd.net/images/products/88061/original/FNSF53RBBR1_-_main_1.jpg?1464079647");
        SSimilarImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/77211/sofa_listing/FNSF51WCCO3_-_main_1.jpg?1464079594");
        SSimilarImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/15378/sofa_listing/FNSF54TSBO3_-_main_1.jpg?1464071626");
        SSimilarImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/68717/slide/666x363/Raymond_Low_Wooden_Sofa_2_Seater_Grey_01.jpg?1450707074");
        SSimilarImageList.add("https://ul-a.akamaihd.net/images/products/88061/original/FNSF53RBBR1_-_main_1.jpg?1464079647");
        SSimilarImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/77211/sofa_listing/FNSF51WCCO3_-_main_1.jpg?1464079594");
        SSimilarImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/15378/sofa_listing/FNSF54TSBO3_-_main_1.jpg?1464071626");

        //Sofa Name List
        ArrayList<String> SSimilarColor= new ArrayList<>();
        SSimilarColor.add("Gary");
        SSimilarColor.add("Mist");
        SSimilarColor.add("Navy Blue");
        SSimilarColor.add("Maroon");
        SSimilarColor.add("Gary");
        SSimilarColor.add("Mist");
        SSimilarColor.add("Navy Blue");
        SSimilarColor.add("Maroon");

        //Sofa Price List
        ArrayList<String> SSimilarPrice= new ArrayList<>();
        SSimilarPrice.add("Rs. 15,999");
        SSimilarPrice.add("Rs. 11,299");
        SSimilarPrice.add("Rs. 10,999");
        SSimilarPrice.add("Rs. 30,999");
        SSimilarPrice.add("Rs. 15,999");
        SSimilarPrice.add("Rs. 11,299");
        SSimilarPrice.add("Rs. 10,999");
        SSimilarPrice.add("Rs. 30,999");

        //Sofa List Items
        for (int i = 0; i <SSimilarImageList.size(); i++)
        {
            SofaSimilarListModel sofaSimilarListModel = new SofaSimilarListModel();
            sofaSimilarListModel.setsSimilarName(SSimilarName.get(i));
            sofaSimilarListModel.setsSimilarColor(SSimilarColor.get(i));
            sofaSimilarListModel.setsSimilarPrice(SSimilarPrice.get(i));
            sofaSimilarListModel.setsSimilarImage(SSimilarImageList.get(i));
            sSimilarListModelArrayList.add(sofaSimilarListModel);
        }

        //Sofa Set Adapter
        sofaSimilarListAdapter = new SofaSimilarListAdapter(this, sSimilarListModelArrayList);
        rv_SofaSimilar.setHasFixedSize(true);
        rv_SofaSimilar.setNestedScrollingEnabled(false);
        LinearLayoutManager topSelling = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rv_SofaSimilar.setLayoutManager(topSelling);
        rv_SofaSimilar.setItemAnimator(new DefaultItemAnimator());
        rv_SofaSimilar.setAdapter(sofaSimilarListAdapter);
    }

    private void init()
    {
        mToolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewpager_product);
        sliderDotspanel = findViewById(R.id.SliderDots);
        rv_Color = findViewById(R.id.rv_ColorList);
        rv_SofaSimilar = findViewById(R.id.rv_sofaSimilar);
        sofaWishList = findViewById(R.id.iv_sofaProductWish);
    }
}
