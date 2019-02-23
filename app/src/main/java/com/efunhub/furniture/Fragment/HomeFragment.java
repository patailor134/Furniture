package com.efunhub.furniture.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.efunhub.furniture.Adapter.CoffeeTableRVAdapter;
import com.efunhub.furniture.Adapter.FurnitureProductRVAdapter;
import com.efunhub.furniture.Adapter.TopSellingProductAdapter;
import com.efunhub.furniture.Model.CoffeeTableRVModel;
import com.efunhub.furniture.Model.FurnitureProductRVModel;
import com.efunhub.furniture.Model.TopSellingProductModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class HomeFragment extends Fragment
{
    View view;
    ImageView ivNewArrival,ivCoffeeTables,ivOffers;

    //Coffee Tables
    RecyclerView rv_CoffeeTableList;
    CoffeeTableRVAdapter mCoffeeTableRVAdapter;
    ArrayList<CoffeeTableRVModel> coffeeTableRVModelArrayList;

    //Furniture Products
    RecyclerView rv_FurnitureList;
    FurnitureProductRVAdapter mFurnitureProductRVAdapter;
    ArrayList<FurnitureProductRVModel> furnitureListArrayList;


    //Top Selling Products
    RecyclerView rv_TopSellingList;
    TopSellingProductAdapter mTopSellingProductAdapter;
    ArrayList<TopSellingProductModel> topSellingProductModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        init();

        Picasso.with(getContext())
                .load("https://worldeye.in/wp-content/uploads/2017/07/Maharaja-Furniture-Karnal.jpg")
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(ivNewArrival);

        Picasso.with(getContext())
                .load("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/161573/product/Epsilon_Coffee_Table_Mahogany_59.jpg?1513936584")
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(ivCoffeeTables);

        coffeeTableRVModelArrayList = new ArrayList<>();
        furnitureListArrayList = new ArrayList<>();
        topSellingProductModelArrayList = new ArrayList<>();


        //Coffee Image List
        ArrayList<String> CtableImageList = new ArrayList<>();
        CtableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/163160/product/Cortado_Coffee_Table_Mahogany_2.jpg?1515649466");
        CtableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/161639/product/Zephyr_Storage_Coffee_Table_53.jpg?1513937524");
        CtableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/108926/product/Malabar_Storage_Coffee_Table_00_LP.jpg?1474950795");
        CtableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/53399/product/Altura_Coffee_Table_Two_Tone_00_LP.jpg?1462882933");
        CtableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/162714/product/Alita_Storage_Coffee_Table_Open_1.jpg?1515144802");
       // CtableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/67920/product/Altura_Coffee_Table_Two_Tone_Finish_00-img_0537_square.jpg?1450347733");

        //Coffee Name List
        ArrayList<String> CtableName= new ArrayList<>();
        CtableName.add("Malabar Storage Coffee Table");
        CtableName.add("Alita Storage Coffee Table");
        CtableName.add("Altura Coffee Table - Nested  Stools");
        CtableName.add("Zephyr Storage Coffee Table");
        CtableName.add("Altura Coffee Table");

        //Coffee Finishing List
        ArrayList<String> CtableFinishing= new ArrayList<>();
        CtableFinishing.add("Teak Finish");
        CtableFinishing.add("Walnut Finish");
        CtableFinishing.add("Two-Tone Finish");
        CtableFinishing.add("Mahogany Finish");
        CtableFinishing.add("Two-Tone Finish");


        //Coffee Price List
        ArrayList<String> CtablePrice= new ArrayList<>();
        CtablePrice.add("Rs. 15,999");
        CtablePrice.add("Rs. 6,299");
        CtablePrice.add("Rs. 13,999");
        CtablePrice.add("Rs. 14,999");
        CtablePrice.add("Rs. 6,999");


        //Coffee Tables Set List Items
        for (int i = 0; i <CtableImageList.size(); i++)
        {
            CoffeeTableRVModel topRatedModel = new CoffeeTableRVModel();
            topRatedModel.setProductName(CtableName.get(i));
            topRatedModel.setProductImage(CtableImageList.get(i));
            topRatedModel.setProductFinishing(CtableFinishing.get(i));
            topRatedModel.setProductPrice(CtablePrice.get(i));
            coffeeTableRVModelArrayList.add(topRatedModel);
        }

        //Coffee Tabl Set Adapter
        mCoffeeTableRVAdapter = new CoffeeTableRVAdapter(getContext(), coffeeTableRVModelArrayList);
        rv_CoffeeTableList.setHasFixedSize(true);
        rv_CoffeeTableList.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rv_CoffeeTableList.setLayoutManager(linearLayoutManager);
        rv_CoffeeTableList.setItemAnimator(new DefaultItemAnimator());
        rv_CoffeeTableList.setAdapter(mCoffeeTableRVAdapter);


        //Furniture Image List
        ArrayList<String> FurnitureImageList = new ArrayList<>();
        FurnitureImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/taxon_images/taxon/332/taxon_col_2/Nashville_4_Seater_Dining_Table_Set_Golden_Oak_01.jpg");
        FurnitureImageList.add("https://ii2.pepperfry.com/media/catalog/product/e/n/236x260/enraku-entertainment-unit-in-tobacco-finish-by-mintwud-enraku-entertainment-unit-in-tobacco-finish-b-raeueh.jpg");
        FurnitureImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/1411/product/Rhodes_Folding_Book_Shelf_Teak_Finish_00_img_9999_183_square.jpg?1455530114");
        FurnitureImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/162785/product/Lawrence_Murphy_Bed_WalnutQueen_LP.jpg?1515408993");
        FurnitureImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/taxon_images/taxon/332/taxon_col_2/Nashville_4_Seater_Dining_Table_Set_Golden_Oak_01.jpg");
        FurnitureImageList.add("https://ii2.pepperfry.com/media/catalog/product/e/n/236x260/enraku-entertainment-unit-in-tobacco-finish-by-mintwud-enraku-entertainment-unit-in-tobacco-finish-b-raeueh.jpg");
        FurnitureImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/1411/product/Rhodes_Folding_Book_Shelf_Teak_Finish_00_img_9999_183_square.jpg?1455530114");
        FurnitureImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/162785/product/Lawrence_Murphy_Bed_WalnutQueen_LP.jpg?1515408993");

        //Furniture Name List
        ArrayList<String> FurnitureName= new ArrayList<>();
        FurnitureName.add("Dining");
        FurnitureName.add("TV Units");
        FurnitureName.add("Bookshelves");
        FurnitureName.add("Beds");
        FurnitureName.add("Dining");
        FurnitureName.add("TV Units");
        FurnitureName.add("Bookshelves");
        FurnitureName.add("Beds");

        //Furniture Product Set List Items
        for (int i = 0; i <FurnitureImageList.size(); i++)
        {
            FurnitureProductRVModel furnitureProductRVModel = new FurnitureProductRVModel();
            furnitureProductRVModel.setOnwrodsName(FurnitureName.get(i));
            furnitureProductRVModel.setOnwordsImage(FurnitureImageList.get(i));
            furnitureListArrayList.add(furnitureProductRVModel);
        }

        //Furniture Product Set Adapter
        mFurnitureProductRVAdapter = new FurnitureProductRVAdapter(getContext(), furnitureListArrayList);
        rv_FurnitureList.setHasFixedSize(true);
        rv_FurnitureList.setNestedScrollingEnabled(false);
        GridLayoutManager linearLayoutManager2 = new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false);
        rv_FurnitureList.setLayoutManager(linearLayoutManager2);
        rv_FurnitureList.setItemAnimator(new DefaultItemAnimator());
        rv_FurnitureList.setAdapter(mFurnitureProductRVAdapter);

        //Offer Image
        Picasso.with(getContext())
                .load("https://www.habitat.co.uk/design/content/assets/images/big-ideas-small-spaces/ss16-p0-banner.jpg")
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(ivOffers);


        //TopSelling Name List
        ArrayList<String> TopName= new ArrayList<>();
        TopName.add("Diner 4 Seater Dining");
        TopName.add("Zephyr 65 TV Units");
        TopName.add("Rhodes Folding Book Shelf");
        TopName.add("Lawrence Murphy Single Bed");

        //TopSelling Image List
        ArrayList<String> TopImageList = new ArrayList<>();
        TopImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/taxon_images/taxon/332/taxon_col_2/Nashville_4_Seater_Dining_Table_Set_Golden_Oak_01.jpg");
        TopImageList.add("https://ii2.pepperfry.com/media/catalog/product/e/n/236x260/enraku-entertainment-unit-in-tobacco-finish-by-mintwud-enraku-entertainment-unit-in-tobacco-finish-b-raeueh.jpg");
        TopImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/1411/product/Rhodes_Folding_Book_Shelf_Teak_Finish_00_img_9999_183_square.jpg?1455530114");
        TopImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/162785/product/Lawrence_Murphy_Bed_WalnutQueen_LP.jpg?1515408993");

        //TopSelling Price List
        ArrayList<String> TopPrice= new ArrayList<>();
        TopPrice.add("Rs. 15,999");
        TopPrice.add("Rs. 11,299");
        TopPrice.add("Rs. 10,999");
        TopPrice.add("Rs. 30,999");

        //Top Selling List Items
        for (int i = 0; i <TopImageList.size(); i++)
        {
            TopSellingProductModel topSellingProductModel = new TopSellingProductModel();
            topSellingProductModel.setTopName(TopName.get(i));
            topSellingProductModel.setTopPrice(TopPrice.get(i));
            topSellingProductModel.setTopImage(TopImageList.get(i));
            topSellingProductModelArrayList.add(topSellingProductModel);
        }

        //Onwords Product Set Adapter
        mTopSellingProductAdapter = new TopSellingProductAdapter(getContext(), topSellingProductModelArrayList);
        rv_TopSellingList.setHasFixedSize(true);
        rv_TopSellingList.setNestedScrollingEnabled(false);
        GridLayoutManager topSelling = new GridLayoutManager(getContext(), 2);
        rv_TopSellingList.setLayoutManager(topSelling);
        rv_TopSellingList.setItemAnimator(new DefaultItemAnimator());
        rv_TopSellingList.setAdapter(mTopSellingProductAdapter);

        return view;
    }

    private void init()
    {
        ivNewArrival = view.findViewById(R.id.iv_newArrival);
        ivCoffeeTables = view.findViewById(R.id.iv_coffeetables);
        ivOffers = view.findViewById(R.id.iv_offers);
        rv_CoffeeTableList = view.findViewById(R.id.rv_coffeetabls);
        rv_FurnitureList = view.findViewById(R.id.rv_productOnwords);
        rv_TopSellingList = view.findViewById(R.id.rv_Topselling);
    }
}
