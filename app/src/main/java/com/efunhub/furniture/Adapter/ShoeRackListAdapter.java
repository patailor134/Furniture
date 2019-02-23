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
import com.efunhub.furniture.Model.ShoeRackListModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by PATailor on 14-02-2018.
 */

public class ShoeRackListAdapter extends RecyclerView.Adapter
{
    private Context mContext;
    private ArrayList<ShoeRackListModel> arrayList;
    boolean click = true;

    public ShoeRackListAdapter(Context mContext, ArrayList<ShoeRackListModel> shoeRackListArrayList)
    {
        this.mContext = mContext;
        this.arrayList = shoeRackListArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shoe_rack_list_item, null);
        viewHolder = new ShoeRackListAdapter.ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        ShoeRackListModel shoeRackListModel = arrayList.get(position);
        ShoeRackListAdapter.ItemViewHolder itemViewHolder = (ShoeRackListAdapter.ItemViewHolder) holder;

        itemViewHolder.txtName.setText(shoeRackListModel.getShoeRackName());
        itemViewHolder.txtFinish.setText(shoeRackListModel.getShoeRackFinish());
        itemViewHolder.txtPrice.setText(shoeRackListModel.getShoeRackPrice());

        // Log.v("IMGES",cartProductsModel.getProductImage());
        Picasso.with(mContext).load(shoeRackListModel.getShoeRackImage())
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
            imageView =  itemView.findViewById(R.id.iv_shoerack);
            txtName =  itemView.findViewById(R.id.txt_shoeRackName);
            txtPrice = itemView.findViewById(R.id.txt_shoeRackPrice);
            txtFinish = itemView.findViewById(R.id.txt_shoeRackFinish);
            iv_iconWishList = itemView.findViewById(R.id.iv_shoeRackWish);

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
                    Intent intentShoeRack = new Intent(mContext, SofaDescriptionActivity.class);
                    mContext.startActivity(intentShoeRack);
                }
            });

        }
    }
}
