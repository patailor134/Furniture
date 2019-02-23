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
import com.efunhub.furniture.Model.FurnitureProductRVModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by PATailor on 10-02-2018.
 */

public class FurnitureProductRVAdapter extends RecyclerView.Adapter
{
    private Context mContext;
    private ArrayList<FurnitureProductRVModel> arrayList;

    public FurnitureProductRVAdapter(Context mContext, ArrayList<FurnitureProductRVModel> OnwordsProductArrayList)
    {
        this.mContext = mContext;
        this.arrayList = OnwordsProductArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder;

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_onwords_list_item, parent, false);
        viewHolder = new FurnitureProductRVAdapter.ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        FurnitureProductRVModel furnitureProductRVModell = arrayList.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

        itemViewHolder.txtONName.setText(furnitureProductRVModell.getOnwrodsName());

        Picasso.with(mContext).load(furnitureProductRVModell.getOnwordsImage())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(itemViewHolder.ONImageView);
    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ONImageView;
        TextView txtONName;

        ItemViewHolder(final View itemView)
        {
            super(itemView);

            // declare your footer views
            ONImageView = itemView.findViewById(R.id.iv_onwordsList);
            txtONName = itemView.findViewById(R.id.txt_onwordsName);

            ONImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent intentcategories = new Intent(mContext, SofaDescriptionActivity.class);
                    mContext.startActivity(intentcategories);
                }
            });

        }
    }
}
