package com.efunhub.furniture.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.efunhub.furniture.Model.CartProductsModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by PATailor on 24-01-2018.
 */

public class CartRVAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayList<CartProductsModel> arrayList;
    private int minteger = 1;

    public CartRVAdapter(Context context, ArrayList<CartProductsModel> cartProductsModelsArrayList) {
        this.mContext = context;
        this.arrayList = cartProductsModelsArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartproduct_list_item, null);
        viewHolder = new ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        CartProductsModel cartProductsModel = arrayList.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

        itemViewHolder.txtname.setText(cartProductsModel.getProductName());

       // Log.v("IMGES",cartProductsModel.getProductImage());
        Picasso.with(mContext).load(cartProductsModel.getProductImage())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(itemViewHolder.imageView);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView,cartcloseIV;
        ImageButton ibtn_Delete;
        TextView txtname, tvQuantityCart,txt_cartStrikePrice;
        Button btnDecreaseCart, btnIncreaseCart,btnBuy;

        ItemViewHolder(View itemView)
        {
            super(itemView);

            // declare your footer views
            tvQuantityCart = itemView.findViewById(R.id.tvQuantityCart);
            btnDecreaseCart = itemView.findViewById(R.id.btnDecreaseCart);
            btnIncreaseCart = itemView.findViewById(R.id.btnIncreaseCart);
            imageView =  itemView.findViewById(R.id.cartproduct);
            txtname =  itemView.findViewById(R.id.tvCartProductName);
            btnBuy =  itemView.findViewById(R.id.cartbuyProduct);
           // ibtn_Delete = itemView.findViewById(R.id.ibtn_deleteItem);
            txt_cartStrikePrice = itemView.findViewById(R.id.tvCartStrikeAmount);

            //set strike on text view
            txt_cartStrikePrice.setPaintFlags(txt_cartStrikePrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            btnDecreaseCart.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if (minteger != 1)
                    {
                        minteger = minteger - 1;
                    }
                    tvQuantityCart.setText("" + minteger);
                }
            });

            btnIncreaseCart.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    minteger = minteger + 1;
                    tvQuantityCart.setText("" + minteger);
                }
            });
        }
    }
}
