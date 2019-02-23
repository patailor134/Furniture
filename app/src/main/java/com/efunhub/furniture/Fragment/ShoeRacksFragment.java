package com.efunhub.furniture.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.efunhub.furniture.Adapter.ShoeRackListAdapter;
import com.efunhub.furniture.Model.ShoeRackListModel;
import com.efunhub.furniture.R;

import java.util.ArrayList;


public class ShoeRacksFragment extends Fragment
{
    View view;

    //Top Selling Products
    RecyclerView rv_ShoeRackList;
    ShoeRackListAdapter mShoeRackListAdapter;
    ArrayList<ShoeRackListModel> shoeRackListModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_shoe_racks, container, false);

        init();

        shoeRackListModelArrayList = new ArrayList<>();

        //Sofa Name List
        ArrayList<String> ShoeRackName= new ArrayList<>();
        ShoeRackName.add("Pointe Shoe Rack");
        ShoeRackName.add("Pointe Shoe Rack");
        ShoeRackName.add("Zanotti Shoe Rack");
        ShoeRackName.add("Manolo Shoe Rack");
        ShoeRackName.add("Pointe Shoe Rack");
        ShoeRackName.add("Pointe Shoe Rack");
        ShoeRackName.add("Zanotti Shoe Rack");
        ShoeRackName.add("Manolo Shoe Rack");

        //Sofa Image List
        ArrayList<String> ShoeRackImageList = new ArrayList<>();
        ShoeRackImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/60730/product/Pointe_Shoe_Cabinet_3x3_Dark_Walnut_00_LP.jpg?1446212667");
        ShoeRackImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/106268/product/Pointe_L_shaped_Shoe_Cabinet_Walnut_00_LP.jpg?1472570555");
        ShoeRackImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/161016/product/Zanotti_Shoe_Cabinet_32_Pair_LP.jpg?1513092180");
        ShoeRackImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/33883/product/Abeha_01_55.jpg?1433614929");
        ShoeRackImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/60730/product/Pointe_Shoe_Cabinet_3x3_Dark_Walnut_00_LP.jpg?1446212667");
        ShoeRackImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/106268/product/Pointe_L_shaped_Shoe_Cabinet_Walnut_00_LP.jpg?1472570555");
        ShoeRackImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/161016/product/Zanotti_Shoe_Cabinet_32_Pair_LP.jpg?1513092180");
        ShoeRackImageList.add("https://ul-a.akamaihd.net/opt/ul-a.akamaihd.net/images/products/33883/product/Abeha_01_55.jpg?1433614929");

        //Sofa Name List
        ArrayList<String> ShoeRackFinish= new ArrayList<>();
        ShoeRackFinish.add("Teak Finish");
        ShoeRackFinish.add("Walnut Finish");
        ShoeRackFinish.add("Two-Tone Finish");
        ShoeRackFinish.add("Mahogany Finish");
        ShoeRackFinish.add("Two-Tone Finish");
        ShoeRackFinish.add("Two-Tone Finish");
        ShoeRackFinish.add("Mahogany Finish");
        ShoeRackFinish.add("Two-Tone Finish");

        //Sofa Price List
        ArrayList<String> ShoeRackPrice= new ArrayList<>();
        ShoeRackPrice.add("Rs. 15,999");
        ShoeRackPrice.add("Rs. 11,299");
        ShoeRackPrice.add("Rs. 10,999");
        ShoeRackPrice.add("Rs. 30,999");
        ShoeRackPrice.add("Rs. 15,999");
        ShoeRackPrice.add("Rs. 11,299");
        ShoeRackPrice.add("Rs. 10,999");
        ShoeRackPrice.add("Rs. 30,999");

        //Sofa List Items
        for (int i = 0; i <ShoeRackImageList.size(); i++)
        {
            ShoeRackListModel shoeRackListModel = new ShoeRackListModel();
            shoeRackListModel.setShoeRackName(ShoeRackName.get(i));
            shoeRackListModel.setShoeRackFinish(ShoeRackFinish.get(i));
            shoeRackListModel.setShoeRackPrice(ShoeRackPrice.get(i));
            shoeRackListModel.setShoeRackImage(ShoeRackImageList.get(i));
            shoeRackListModelArrayList.add(shoeRackListModel);
        }

        //Sofa Set Adapter
        mShoeRackListAdapter = new ShoeRackListAdapter(getContext(), shoeRackListModelArrayList);
        rv_ShoeRackList.setHasFixedSize(true);
        rv_ShoeRackList.setNestedScrollingEnabled(false);
        GridLayoutManager topSelling = new GridLayoutManager(getContext(), 2);
        rv_ShoeRackList.setLayoutManager(topSelling);
        rv_ShoeRackList.setItemAnimator(new DefaultItemAnimator());
        rv_ShoeRackList.setAdapter(mShoeRackListAdapter);

        return view;
    }

    private void init()
    {
        rv_ShoeRackList = view.findViewById(R.id.rv_ShoeRack);
    }
}
