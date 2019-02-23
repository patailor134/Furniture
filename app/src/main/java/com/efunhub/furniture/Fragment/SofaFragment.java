package com.efunhub.furniture.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.efunhub.furniture.Adapter.SofaListAdapter;
import com.efunhub.furniture.Model.SofaListModel;
import com.efunhub.furniture.R;

import java.util.ArrayList;


public class SofaFragment extends Fragment
{
    View view;

    //Top Selling Products
    RecyclerView rv_SofaList;
    SofaListAdapter sofaListAdapter;
    ArrayList<SofaListModel> sofaListModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sofa, container, false);

        init();

        sofaListModelArrayList = new ArrayList<>();

        //Sofa Name List
        ArrayList<String> SofaName= new ArrayList<>();
        SofaName.add("Wooden Sofa Sets");
        SofaName.add("Leatherette Sofa Set");
        SofaName.add("Fabric Sofa Set");
        SofaName.add("Leather Sofa Set");
        SofaName.add("Wooden Sofa Sets");
        SofaName.add("Leatherette Sofa Set");
        SofaName.add("Fabric Sofa Set");
        SofaName.add("Leather Sofa Set");

        //Sofa Image List
        ArrayList<String> SofaImageList = new ArrayList<>();
        SofaImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/68717/slide/666x363/Raymond_Low_Wooden_Sofa_2_Seater_Grey_01.jpg?1450707074");
        SofaImageList.add("https://ul-a.akamaihd.net/images/products/88061/original/FNSF53RBBR1_-_main_1.jpg?1464079647");
        SofaImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/77211/sofa_listing/FNSF51WCCO3_-_main_1.jpg?1464079594");
        SofaImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/15378/sofa_listing/FNSF54TSBO3_-_main_1.jpg?1464071626");
        SofaImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/68717/slide/666x363/Raymond_Low_Wooden_Sofa_2_Seater_Grey_01.jpg?1450707074");
        SofaImageList.add("https://ul-a.akamaihd.net/images/products/88061/original/FNSF53RBBR1_-_main_1.jpg?1464079647");
        SofaImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/77211/sofa_listing/FNSF51WCCO3_-_main_1.jpg?1464079594");
        SofaImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/15378/sofa_listing/FNSF54TSBO3_-_main_1.jpg?1464071626");

        //Sofa Name List
        ArrayList<String> SofaColor= new ArrayList<>();
        SofaColor.add("Gary");
        SofaColor.add("Mist");
        SofaColor.add("Navy Blue");
        SofaColor.add("Maroon");
        SofaColor.add("Gary");
        SofaColor.add("Mist");
        SofaColor.add("Navy Blue");
        SofaColor.add("Maroon");

        //Sofa Price List
        ArrayList<String> SofaPrice= new ArrayList<>();
        SofaPrice.add("Rs. 15,999");
        SofaPrice.add("Rs. 11,299");
        SofaPrice.add("Rs. 10,999");
        SofaPrice.add("Rs. 30,999");
        SofaPrice.add("Rs. 15,999");
        SofaPrice.add("Rs. 11,299");
        SofaPrice.add("Rs. 10,999");
        SofaPrice.add("Rs. 30,999");

        //Sofa List Items
        for (int i = 0; i <SofaImageList.size(); i++)
        {
            SofaListModel sofaListModel = new SofaListModel();
            sofaListModel.setSofaName(SofaName.get(i));
            sofaListModel.setSofaColor(SofaColor.get(i));
            sofaListModel.setSofaPrice(SofaPrice.get(i));
            sofaListModel.setSofaImage(SofaImageList.get(i));
            sofaListModelArrayList.add(sofaListModel);
        }

        //Sofa Set Adapter
        sofaListAdapter = new SofaListAdapter(getContext(), sofaListModelArrayList);
        rv_SofaList.setHasFixedSize(true);
        rv_SofaList.setNestedScrollingEnabled(false);
        GridLayoutManager topSelling = new GridLayoutManager(getContext(), 2);
        rv_SofaList.setLayoutManager(topSelling);
        rv_SofaList.setItemAnimator(new DefaultItemAnimator());
        rv_SofaList.setAdapter(sofaListAdapter);

        return view;
    }

    private void init()
    {
        rv_SofaList = view.findViewById(R.id.rv_Sofas);
    }
}
