package com.efunhub.furniture.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.efunhub.furniture.Model.OrderListModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by PATailor on 13-02-2018.
 */

public class OrderListAdapter extends RecyclerView.Adapter
{
    private Context mContext;
    private ArrayList<OrderListModel> arrayList;

    public OrderListAdapter(Context mContext, ArrayList<OrderListModel> orderListArrayList)
    {
        this.mContext = mContext;
        this.arrayList = orderListArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_item, null);
        viewHolder = new OrderListAdapter.ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        OrderListModel orderListModel = arrayList.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

        itemViewHolder.txtname.setText(orderListModel.getOrderName());

        // Log.v("IMGES",cartProductsModel.getProductImage());
        Picasso.with(mContext).load(orderListModel.getOrderImages())
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
        TextView txtname,txt_orderStrikePrice,txt_Price;
        Button btnWriteReviews;

        ItemViewHolder(View itemView)
        {
            super(itemView);

            // declare your footer views
            imageView =  itemView.findViewById(R.id.iv_Orderlist);
            btnWriteReviews =  itemView.findViewById(R.id.btn_OrderReviews);
            txtname =  itemView.findViewById(R.id.tvOrderListName);
            txt_Price = itemView.findViewById(R.id.tvOrderProductPrice);
            txt_orderStrikePrice = itemView.findViewById(R.id.tvOrderStrikeAmount);

            //set strike on text view
            txt_orderStrikePrice.setPaintFlags(txt_orderStrikePrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
