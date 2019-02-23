package com.efunhub.furniture.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.efunhub.furniture.Adapter.BedListAdapter;
import com.efunhub.furniture.Model.BedListModel;
import com.efunhub.furniture.R;

import java.util.ArrayList;


public class BedsFragment extends Fragment
{
    View view;

    //Top Selling Products
    RecyclerView rv_BedList;
    BedListAdapter mBedListAdapter;
    ArrayList<BedListModel> bedListModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_beds, container, false);

        init();

        bedListModelArrayList = new ArrayList<>();

        //Sofa Name List
        ArrayList<String> BedName= new ArrayList<>();
        BedName.add("Matrix Noraml Bed");
        BedName.add("Covelo Storage Bed");
        BedName.add("Boston Storage Bed");
        BedName.add("Yuri Single Bed");
        BedName.add("Matrix Noraml Bed");
        BedName.add("Covelo Storage Bed");
        BedName.add("Boston Storage Bed");
        BedName.add("Yuri Single Bed");

        //Sofa Image List
        ArrayList<String> BedImageList = new ArrayList<>();
        BedImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/162485/product/dfg.jpg?1515489746");
        BedImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/154009/product/Covelo_Storage_Bed_Drawer_Box_LP.jpg?1503472958");
        BedImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/75547/product/Boston_Bed_King_Teak_00_LP.jpg?1474281856");
        BedImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/155019/product/Yuri_Single_Bed_00_LP.jpg?1504881880");
        BedImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/162485/product/dfg.jpg?1515489746");
        BedImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/154009/product/Covelo_Storage_Bed_Drawer_Box_LP.jpg?1503472958");
        BedImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/75547/product/Boston_Bed_King_Teak_00_LP.jpg?1474281856");
        BedImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/155019/product/Yuri_Single_Bed_00_LP.jpg?1504881880");

        //Sofa Name List
        ArrayList<String> BedFinish= new ArrayList<>();
        BedFinish.add("Teak Finish");
        BedFinish.add("Walnut Finish");
        BedFinish.add("Two-Tone Finish");
        BedFinish.add("Mahogany Finish");
        BedFinish.add("Two-Tone Finish");
        BedFinish.add("Two-Tone Finish");
        BedFinish.add("Mahogany Finish");
        BedFinish.add("Two-Tone Finish");

        //Sofa Price List
        ArrayList<String> BedPrice= new ArrayList<>();
        BedPrice.add("Rs. 15,999");
        BedPrice.add("Rs. 11,299");
        BedPrice.add("Rs. 10,999");
        BedPrice.add("Rs. 30,999");
        BedPrice.add("Rs. 15,999");
        BedPrice.add("Rs. 11,299");
        BedPrice.add("Rs. 10,999");
        BedPrice.add("Rs. 30,999");

        //Sofa List Items
        for (int i = 0; i <BedImageList.size(); i++)
        {
            BedListModel bedListModel = new BedListModel();
            bedListModel.setBedName(BedName.get(i));
            bedListModel.setBedFinish(BedFinish.get(i));
            bedListModel.setBedPrice(BedPrice.get(i));
            bedListModel.setBedImage(BedImageList.get(i));
            bedListModelArrayList.add(bedListModel);
        }

        //Sofa Set Adapter
        mBedListAdapter = new BedListAdapter(getContext(), bedListModelArrayList);
        rv_BedList.setHasFixedSize(true);
        rv_BedList.setNestedScrollingEnabled(false);
        GridLayoutManager topSelling = new GridLayoutManager(getContext(), 2);
        rv_BedList.setLayoutManager(topSelling);
        rv_BedList.setItemAnimator(new DefaultItemAnimator());
        rv_BedList.setAdapter(mBedListAdapter);

        return view;
    }
    private void init()
    {
        rv_BedList = view.findViewById(R.id.rv_Beds);
    }
}
