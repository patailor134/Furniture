package com.efunhub.furniture.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.efunhub.furniture.Adapter.CoffeeTableListAdapter;
import com.efunhub.furniture.Model.CoffeeTableListModel;
import com.efunhub.furniture.R;

import java.util.ArrayList;


public class CoffeeTablesFragment extends Fragment
{
    View view;

    //Top Selling Products
    RecyclerView rv_CTableList;
    CoffeeTableListAdapter mCoffeeTableListAdapter;
    ArrayList<CoffeeTableListModel> coffeeTableListModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_coffee_tables, container, false);

        init();

        coffeeTableListModelArrayList = new ArrayList<>();

        //Sofa Name List
        ArrayList<String> CTableName= new ArrayList<>();
        CTableName.add("Malabar Storage Coffee Table");
        CTableName.add("Alita Storage Coffee Table");
        CTableName.add("Altura Coffee Table - Nested  Stools");
        CTableName.add("Zephyr Storage Coffee Table");
        CTableName.add("Altura Coffee Table");
        CTableName.add("Altura Coffee Table - Nested  Stools");
        CTableName.add("Zephyr Storage Coffee Table");
        CTableName.add("Altura Coffee Table");

        //Sofa Image List
        ArrayList<String> CTableImageList = new ArrayList<>();
        CTableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/163160/product/Cortado_Coffee_Table_Mahogany_2.jpg?1515649466");
        CTableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/161639/product/Zephyr_Storage_Coffee_Table_53.jpg?1513937524");
        CTableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/108926/product/Malabar_Storage_Coffee_Table_00_LP.jpg?1474950795");
        CTableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/53399/product/Altura_Coffee_Table_Two_Tone_00_LP.jpg?1462882933");
        CTableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/162714/product/Alita_Storage_Coffee_Table_Open_1.jpg?1515144802");
        CTableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/108926/product/Malabar_Storage_Coffee_Table_00_LP.jpg?1474950795");
        CTableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/53399/product/Altura_Coffee_Table_Two_Tone_00_LP.jpg?1462882933");
        CTableImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/162714/product/Alita_Storage_Coffee_Table_Open_1.jpg?1515144802");

        //Sofa Name List
        ArrayList<String> CTableFinish= new ArrayList<>();
        CTableFinish.add("Teak Finish");
        CTableFinish.add("Walnut Finish");
        CTableFinish.add("Two-Tone Finish");
        CTableFinish.add("Mahogany Finish");
        CTableFinish.add("Two-Tone Finish");
        CTableFinish.add("Two-Tone Finish");
        CTableFinish.add("Mahogany Finish");
        CTableFinish.add("Two-Tone Finish");

        //Sofa Price List
        ArrayList<String> CTablePrice= new ArrayList<>();
        CTablePrice.add("Rs. 15,999");
        CTablePrice.add("Rs. 11,299");
        CTablePrice.add("Rs. 10,999");
        CTablePrice.add("Rs. 30,999");
        CTablePrice.add("Rs. 15,999");
        CTablePrice.add("Rs. 11,299");
        CTablePrice.add("Rs. 10,999");
        CTablePrice.add("Rs. 30,999");

        //Sofa List Items
        for (int i = 0; i <CTableImageList.size(); i++)
        {
            CoffeeTableListModel coffeeTableListModel = new CoffeeTableListModel();
            coffeeTableListModel.setcTableName(CTableName.get(i));
            coffeeTableListModel.setcTableFinish(CTableFinish.get(i));
            coffeeTableListModel.setcTablePrice(CTablePrice.get(i));
            coffeeTableListModel.setcTableImage(CTableImageList.get(i));
            coffeeTableListModelArrayList.add(coffeeTableListModel);
        }

        //Sofa Set Adapter
        mCoffeeTableListAdapter = new CoffeeTableListAdapter(getContext(), coffeeTableListModelArrayList);
        rv_CTableList.setHasFixedSize(true);
        rv_CTableList.setNestedScrollingEnabled(false);
        GridLayoutManager topSelling = new GridLayoutManager(getContext(), 2);
        rv_CTableList.setLayoutManager(topSelling);
        rv_CTableList.setItemAnimator(new DefaultItemAnimator());
        rv_CTableList.setAdapter(mCoffeeTableListAdapter);

        return view;
    }
    private void init()
    {
        rv_CTableList = view.findViewById(R.id.rv_CoffeeTable);
    }

}
