package com.efunhub.furniture.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.efunhub.furniture.Model.SofaDescriptionModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by PATailor on 14-02-2018.
 */

public class SofaDescriptionAdapter extends PagerAdapter
{
    Context mContext;
    ArrayList<SofaDescriptionModel> sofaDescriptionModels;
    LayoutInflater layoutInflater;

    public SofaDescriptionAdapter(Context mContext, ArrayList<SofaDescriptionModel> sofaDescriptionModels)
    {
        this.mContext = mContext;
        this.sofaDescriptionModels = sofaDescriptionModels;
        layoutInflater= (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return sofaDescriptionModels.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == ((LinearLayout) object);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer)
    {
        if (observer != null)
        {
            super.unregisterDataSetObserver(observer);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position)
    {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.sofa_viewpager_list_item, container, false);
        SofaDescriptionModel sofaDescriptionModel = sofaDescriptionModels.get(position);
        ImageView imageView = itemView.findViewById(R.id.sofa_pagerImage);

        Log.v("OfferImage",sofaDescriptionModel.getProduct_image());
        /*imageView.setImageResource(offersList.get(position).getImg());*/

        Picasso.with(mContext).load(sofaDescriptionModel.getProduct_image()).into(imageView);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((LinearLayout) object);
    }
}
