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

import com.efunhub.furniture.Model.WishListModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by PATailor on 13-02-2018.
 */

public class WishListAdapter extends RecyclerView.Adapter
{
    private Context mContext;
    private ArrayList<WishListModel> arrayList;

    public WishListAdapter(Context mContext, ArrayList<WishListModel> wishListArrayList)
    {
        this.mContext = mContext;
        this.arrayList = wishListArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_list_item, null);
        viewHolder = new WishListAdapter.ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        WishListModel wishListModel = arrayList.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

        itemViewHolder.txtname.setText(wishListModel.getWishName());

        // Log.v("IMGES",cartProductsModel.getProductImage());
        Picasso.with(mContext).load(wishListModel.getWishImages())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(itemViewHolder.imageView);
    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }


    private class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView,ibtn_Delete;
        TextView txtname,txt_cartStrikePrice,txt_Price;
        Button btnAddCart;

        ItemViewHolder(View itemView)
        {
            super(itemView);

            // declare your footer views
            imageView =  itemView.findViewById(R.id.iv_Wishlist);
            btnAddCart =  itemView.findViewById(R.id.btn_WishAddCart);
            ibtn_Delete = itemView.findViewById(R.id.iv_deleteItem);
            txtname =  itemView.findViewById(R.id.tvWishListName);
            txt_Price = itemView.findViewById(R.id.tvWishProductPrice);
            txt_cartStrikePrice = itemView.findViewById(R.id.tvWishStrikeAmount);

            //set strike on text view
            txt_cartStrikePrice.setPaintFlags(txt_cartStrikePrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
