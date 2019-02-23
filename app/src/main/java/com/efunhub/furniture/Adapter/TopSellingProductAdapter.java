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
import com.efunhub.furniture.Model.TopSellingProductModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by PATailor on 12-02-2018.
 */

public class TopSellingProductAdapter extends RecyclerView.Adapter
{
    private Context mContext;
    private ArrayList<TopSellingProductModel> arrayList;

    public TopSellingProductAdapter(Context mContext, ArrayList<TopSellingProductModel> topSellingArrayList) {
        this.mContext = mContext;
        this.arrayList = topSellingArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder;

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_selling_list_item, parent, false);
        viewHolder = new TopSellingProductAdapter.ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        TopSellingProductModel topSellingProductModel = arrayList.get(position);
        TopSellingProductAdapter.ItemViewHolder itemViewHolder = (TopSellingProductAdapter.ItemViewHolder) holder;

        itemViewHolder.txtTopName.setText(topSellingProductModel.getTopName());
        itemViewHolder.txtTopPrice.setText(topSellingProductModel.getTopPrice());

        Picasso.with(mContext).load(topSellingProductModel.getTopImage())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(itemViewHolder.TOPImageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder
    {
        ImageView TOPImageView;
        TextView txtTopName,txtTopPrice;

        ItemViewHolder(final View itemView)
        {
            super(itemView);

            // declare your footer views
            TOPImageView = itemView.findViewById(R.id.iv_topselling);
            txtTopName = itemView.findViewById(R.id.txt_topsellingName);
            txtTopPrice = itemView.findViewById(R.id.txt_topsellingPrice);

            TOPImageView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intentSofa = new Intent(mContext,SofaDescriptionActivity.class);
                    mContext.startActivity(intentSofa);
                }
            });
        }
    }
}
