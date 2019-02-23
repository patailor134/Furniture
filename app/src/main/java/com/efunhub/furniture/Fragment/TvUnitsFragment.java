package com.efunhub.furniture.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.efunhub.furniture.Adapter.TvUnitsListAdapter;
import com.efunhub.furniture.Model.TvUnitsListModel;
import com.efunhub.furniture.R;

import java.util.ArrayList;


public class TvUnitsFragment extends Fragment
{
    View view;

    //Top Selling Products
    RecyclerView rv_TvUnitList;
    TvUnitsListAdapter mTvUnitsListAdapter;
    ArrayList<TvUnitsListModel> tvUnitsListModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tv_units, container, false);

        init();

        tvUnitsListModelArrayList = new ArrayList<>();

        //Sofa Name List
        ArrayList<String> TvUnitName= new ArrayList<>();
        TvUnitName.add("Syrcuse Tv Units");
        TvUnitName.add("Ferdinand Tv Units");
        TvUnitName.add("Iwaki Swivel 59 Tv Units");
        TvUnitName.add("Bayern 75 Tv Units");
        TvUnitName.add("Syrcuse Tv Units");
        TvUnitName.add("Ferdinand Tv Units");
        TvUnitName.add("Iwaki Swivel 59 Tv Units");
        TvUnitName.add("Bayern 75 Tv Units");

        //Sofa Image List
        ArrayList<String> TvUnitImageList = new ArrayList<>();
        TvUnitImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/105071/product/Syracuse_Entertainment_Set_DW_00_LP.jpg?1471410677");
        TvUnitImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/106278/product/Ferdinand_Entertainment_Unit_Set_DW_00_LP.jpg?1472622258");
        TvUnitImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/147631/product/Iwaki_swivel_TV_unit1_LP.jpg?1496315477");
        TvUnitImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/41131/product/Bayern_TV_Unit_LP_Dark_walnut.jpg?1515992120");
        TvUnitImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/105071/product/Syracuse_Entertainment_Set_DW_00_LP.jpg?1471410677");
        TvUnitImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/106278/product/Ferdinand_Entertainment_Unit_Set_DW_00_LP.jpg?1472622258");
        TvUnitImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/147631/product/Iwaki_swivel_TV_unit1_LP.jpg?1496315477");
        TvUnitImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/41131/product/Bayern_TV_Unit_LP_Dark_walnut.jpg?1515992120");

        //Sofa Name List
        ArrayList<String> TvUnitFinish= new ArrayList<>();
        TvUnitFinish.add("Teak Finish");
        TvUnitFinish.add("Walnut Finish");
        TvUnitFinish.add("Two-Tone Finish");
        TvUnitFinish.add("Mahogany Finish");
        TvUnitFinish.add("Two-Tone Finish");
        TvUnitFinish.add("Two-Tone Finish");
        TvUnitFinish.add("Mahogany Finish");
        TvUnitFinish.add("Two-Tone Finish");

        //Sofa Price List
        ArrayList<String> TvUnitPrice= new ArrayList<>();
        TvUnitPrice.add("Rs. 15,999");
        TvUnitPrice.add("Rs. 11,299");
        TvUnitPrice.add("Rs. 10,999");
        TvUnitPrice.add("Rs. 30,999");
        TvUnitPrice.add("Rs. 15,999");
        TvUnitPrice.add("Rs. 11,299");
        TvUnitPrice.add("Rs. 10,999");
        TvUnitPrice.add("Rs. 30,999");

        //Sofa List Items
        for (int i = 0; i <TvUnitImageList.size(); i++)
        {
            TvUnitsListModel tvUnitsListModel = new TvUnitsListModel();
            tvUnitsListModel.setTvunitName(TvUnitName.get(i));
            tvUnitsListModel.setTvunitFinish(TvUnitFinish.get(i));
            tvUnitsListModel.setTvunitPrice(TvUnitPrice.get(i));
            tvUnitsListModel.setTvunitImages(TvUnitImageList.get(i));
            tvUnitsListModelArrayList.add(tvUnitsListModel);
        }

        //Sofa Set Adapter
        mTvUnitsListAdapter = new TvUnitsListAdapter(getContext(), tvUnitsListModelArrayList);
        rv_TvUnitList.setHasFixedSize(true);
        rv_TvUnitList.setNestedScrollingEnabled(false);
        GridLayoutManager topSelling = new GridLayoutManager(getContext(), 2);
        rv_TvUnitList.setLayoutManager(topSelling);
        rv_TvUnitList.setItemAnimator(new DefaultItemAnimator());
        rv_TvUnitList.setAdapter(mTvUnitsListAdapter);

        return view;
    }

    private void init()
    {
        rv_TvUnitList = view.findViewById(R.id.rv_TvUnits);
    }
}
