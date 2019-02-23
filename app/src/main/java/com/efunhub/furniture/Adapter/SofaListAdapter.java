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
import com.efunhub.furniture.Model.SofaListModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by PATailor on 14-02-2018.
 */

public class SofaListAdapter extends RecyclerView.Adapter
{
    private Context mContext;
    private ArrayList<SofaListModel> arrayList;
    boolean click = true;

    public SofaListAdapter(Context mContext, ArrayList<SofaListModel> sofaListArrayList) {
        this.mContext = mContext;
        this.arrayList = sofaListArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sofas_lits_item, null);
        viewHolder = new SofaListAdapter.ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        SofaListModel sofaListModel = arrayList.get(position);
        SofaListAdapter.ItemViewHolder itemViewHolder = (SofaListAdapter.ItemViewHolder) holder;

        itemViewHolder.txtName.setText(sofaListModel.getSofaName());
        itemViewHolder.txtColor.setText(sofaListModel.getSofaColor());
        itemViewHolder.txtPrice.setText(sofaListModel.getSofaPrice());


        // Log.v("IMGES",cartProductsModel.getProductImage());
        Picasso.with(mContext).load(sofaListModel.getSofaImage())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(itemViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView,iv_iconWishList;
        TextView txtName,txtColor,txtPrice;

        ItemViewHolder(View itemView)
        {
            super(itemView);

            // declare your footer views
            imageView =  itemView.findViewById(R.id.iv_sofa);
            txtName =  itemView.findViewById(R.id.txt_sofaName);
            txtPrice = itemView.findViewById(R.id.txt_sofaPrice);
            txtColor = itemView.findViewById(R.id.txt_sofaColor);
            iv_iconWishList = itemView.findViewById(R.id.iv_sofaWish);

            iv_iconWishList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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
                    Intent intentSofa = new Intent(mContext, SofaDescriptionActivity.class);
                    mContext.startActivity(intentSofa);
                }
            });

        }
    }
}

