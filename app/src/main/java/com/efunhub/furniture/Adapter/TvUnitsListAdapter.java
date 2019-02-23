package com.efunhub.furniture.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.efunhub.furniture.Activity.SofaDescriptionActivity;
import com.efunhub.furniture.Model.TvUnitsListModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by PATailor on 14-02-2018.
 */

public class TvUnitsListAdapter extends RecyclerView.Adapter
{
    private Context mContext;
    private ArrayList<TvUnitsListModel> arrayList;
    boolean click = true;

    public TvUnitsListAdapter(Context mContext, ArrayList<TvUnitsListModel> tvUnitsListArrayList) {
        this.mContext = mContext;
        this.arrayList = tvUnitsListArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tvunits_list_item, null);
        viewHolder = new TvUnitsListAdapter.ItemViewHolder(view);

        return viewHolder;    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        TvUnitsListModel tvUnitsListModel = arrayList.get(position);
        TvUnitsListAdapter.ItemViewHolder itemViewHolder = (TvUnitsListAdapter.ItemViewHolder) holder;

        itemViewHolder.txtName.setText(tvUnitsListModel.getTvunitName());
        itemViewHolder.txtFinish.setText(tvUnitsListModel.getTvunitFinish());
        itemViewHolder.txtPrice.setText(tvUnitsListModel.getTvunitPrice());

        // Log.v("IMGES",cartProductsModel.getProductImage());
        Picasso.with(mContext).load(tvUnitsListModel.getTvunitImages())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(itemViewHolder.imageView);
    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView,iv_iconWishList;
        TextView txtName,txtFinish,txtPrice;

        ItemViewHolder(View itemView)
        {
            super(itemView);

            // declare your footer views
            imageView =  itemView.findViewById(R.id.iv_tvunit);
            txtName =  itemView.findViewById(R.id.txt_tvunitName);
            txtPrice = itemView.findViewById(R.id.txt_tvunitPrice);
            txtFinish = itemView.findViewById(R.id.txt_tvunitFinish);
            iv_iconWishList = itemView.findViewById(R.id.iv_tvunitWish);

            iv_iconWishList.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if (click)
                    {
                        iv_iconWishList.setImageResource(R.drawable.ic_favorite_black_24dp);
                        click = false;
                    } else {
                        iv_iconWishList.setImageResource(R.drawable.ic_favorite_red_24dp);
                        click = true;
                    }
                }
            });

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Intent intentTvUnit = new Intent(mContext, SofaDescriptionActivity.class);
                    mContext.startActivity(intentTvUnit);
                }
            });

        }
    }
}
