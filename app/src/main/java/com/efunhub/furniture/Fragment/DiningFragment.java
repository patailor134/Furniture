package com.efunhub.furniture.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.efunhub.furniture.Adapter.DiningListAdapter;
import com.efunhub.furniture.Model.DiningListModel;
import com.efunhub.furniture.R;

import java.util.ArrayList;


public class DiningFragment extends Fragment
{
    View view;

    //Top Selling Products
    RecyclerView rv_DiningList;
    DiningListAdapter mDiningListAdapter;
    ArrayList<DiningListModel> diningListModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_dining, container, false);

        init();

        diningListModelArrayList = new ArrayList<>();

        //Sofa Name List
        ArrayList<String> DiningName= new ArrayList<>();
        DiningName.add("Oribi 6 Seater Dining Table");
        DiningName.add("Diner 4 Seater Dining Table");
        DiningName.add("Vanalen 8 Seater Dining Table");
        DiningName.add("Zella 4 Seater Round Dining Table");
        DiningName.add("Oribi 6 Seater Dining Table");
        DiningName.add("Diner 4 Seater Dining Table");
        DiningName.add("Vanalen 8 Seater Dining Table");
        DiningName.add("Zella 4 Seater Round Dining Table");

        //Sofa Image List
        ArrayList<String> DiningImageList = new ArrayList<>();
        DiningImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/23132/product/Arabia_Oribi_6_Seater_Dining_Table_Set_00_IMG_9799_LP.jpg?1425910275");
        DiningImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/146953/product/Diner_4_Seater_Dining_Table_Set_LP.jpg?1493042117");
        DiningImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/67069/product/Vanalen_Extendable_Dalla_8_Seater_Glass_Top_Dining_Table_Set_Latte_00_LP.jpg?1450077139");
        DiningImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/125759/product/Liana_Oribi_4_Seater_Round_Dining_Table_Set_TK_TB_00_LP.jpg?1477651456");
        DiningImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/23132/product/Arabia_Oribi_6_Seater_Dining_Table_Set_00_IMG_9799_LP.jpg?1425910275");
        DiningImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/146953/product/Diner_4_Seater_Dining_Table_Set_LP.jpg?1493042117");
        DiningImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/67069/product/Vanalen_Extendable_Dalla_8_Seater_Glass_Top_Dining_Table_Set_Latte_00_LP.jpg?1450077139");
        DiningImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/125759/product/Liana_Oribi_4_Seater_Round_Dining_Table_Set_TK_TB_00_LP.jpg?1477651456");

        //Sofa Name List
        ArrayList<String> DiningFinish= new ArrayList<>();
        DiningFinish.add("Teak Finish");
        DiningFinish.add("Walnut Finish");
        DiningFinish.add("Two-Tone Finish");
        DiningFinish.add("Mahogany Finish");
        DiningFinish.add("Two-Tone Finish");
        DiningFinish.add("Two-Tone Finish");
        DiningFinish.add("Mahogany Finish");
        DiningFinish.add("Two-Tone Finish");

        //Sofa Price List
        ArrayList<String> DiningPrice= new ArrayList<>();
        DiningPrice.add("Rs. 15,999");
        DiningPrice.add("Rs. 11,299");
        DiningPrice.add("Rs. 10,999");
        DiningPrice.add("Rs. 30,999");
        DiningPrice.add("Rs. 15,999");
        DiningPrice.add("Rs. 11,299");
        DiningPrice.add("Rs. 10,999");
        DiningPrice.add("Rs. 30,999");

        //Sofa List Items
        for (int i = 0; i <DiningImageList.size(); i++)
        {
            DiningListModel diningListModel = new DiningListModel();
            diningListModel.setDiningName(DiningName.get(i));
            diningListModel.setDiningFinish(DiningFinish.get(i));
            diningListModel.setDiningPrice(DiningPrice.get(i));
            diningListModel.setDiningImgage(DiningImageList.get(i));
            diningListModelArrayList.add(diningListModel);
        }

        //Sofa Set Adapter
        mDiningListAdapter = new DiningListAdapter(getContext(), diningListModelArrayList);
        rv_DiningList.setHasFixedSize(true);
        rv_DiningList.setNestedScrollingEnabled(false);
        GridLayoutManager topSelling = new GridLayoutManager(getContext(), 2);
        rv_DiningList.setLayoutManager(topSelling);
        rv_DiningList.setItemAnimator(new DefaultItemAnimator());
        rv_DiningList.setAdapter(mDiningListAdapter);

        return view;
    }
    private void init()
    {
        rv_DiningList = view.findViewById(R.id.rv_Dining);
    }

}
