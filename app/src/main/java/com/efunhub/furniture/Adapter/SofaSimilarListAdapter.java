package com.efunhub.furniture.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.efunhub.furniture.Model.SofaSimilarListModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by PATailor on 15-02-2018.
 */

public class SofaSimilarListAdapter extends RecyclerView.Adapter
{
    private Context mContext;
    private ArrayList<SofaSimilarListModel> arrayList;

    public SofaSimilarListAdapter(Context mContext, ArrayList<SofaSimilarListModel> sofaSimilarListArrayList)
    {
        this.mContext = mContext;
        this.arrayList = sofaSimilarListArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sofas_similar_product_list_item, null);
        viewHolder = new SofaSimilarListAdapter.ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        SofaSimilarListModel sofaSimilarListModel = arrayList.get(position);
        SofaSimilarListAdapter.ItemViewHolder itemViewHolder = (SofaSimilarListAdapter.ItemViewHolder) holder;

        itemViewHolder.txtName.setText(sofaSimilarListModel.getsSimilarName());
        itemViewHolder.txtColor.setText(sofaSimilarListModel.getsSimilarColor());
        itemViewHolder.txtPrice.setText(sofaSimilarListModel.getsSimilarPrice());


        // Log.v("IMGES",cartProductsModel.getProductImage());
        Picasso.with(mContext).load(sofaSimilarListModel.getsSimilarImage())
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
        ImageView imageView;
        TextView txtName,txtColor,txtPrice;

        ItemViewHolder(View itemView)
        {
            super(itemView);

            // declare your footer views
            imageView =  itemView.findViewById(R.id.iv_sofaSimilar);
            txtName =  itemView.findViewById(R.id.txt_sofaSimilarName);
            txtPrice = itemView.findViewById(R.id.txt_sofaSimilarPrice);
            txtColor = itemView.findViewById(R.id.txt_sofaSimilarColor);
        }
    }
}
