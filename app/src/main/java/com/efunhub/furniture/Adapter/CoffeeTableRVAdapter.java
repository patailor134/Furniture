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
import com.efunhub.furniture.Model.CoffeeTableRVModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by STARKIO on 27-Jan-18.
 */

public class CoffeeTableRVAdapter extends RecyclerView.Adapter
{
    private Context mContext;
    private ArrayList<CoffeeTableRVModel> arrayList;
//    FragmentTransaction mFragmentTransaction;
//    FragmentManager fragmentManager;

    public CoffeeTableRVAdapter(Context mContext, ArrayList<CoffeeTableRVModel> coffeeTableRVModels)
    {
        this.mContext = mContext;
        this.arrayList = coffeeTableRVModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        RecyclerView.ViewHolder viewHolder;

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_tables_home_list_item, parent, false);
        viewHolder = new CoffeeTableRVAdapter.ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        CoffeeTableRVModel categoryModel = arrayList.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

        itemViewHolder.txtCTName.setText(categoryModel.getProductName());
        itemViewHolder.txtCTFinishing.setText(categoryModel.getProductFinishing());
        itemViewHolder.txtCTPrice.setText(categoryModel.getProductPrice());

        Picasso.with(mContext).load(categoryModel.getProductImage())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(itemViewHolder.CTImageView);
    }

    /*private static class CircleTransform implements Transformation
    {

        @Override
        public Bitmap transform(Bitmap source)
        {
            int size = Math.min(source.getWidth(), source.getHeight());

            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
            if (squaredBitmap != source)
            {
                source.recycle();
            }

            Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            BitmapShader shader = new BitmapShader(squaredBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setAntiAlias(true);

            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);

            squaredBitmap.recycle();
            return bitmap;
        }

        @Override
        public String key()
        {
            return "circle";
        }
    }*/

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder
    {
        ImageView CTImageView;
        TextView txtCTName,txtCTFinishing,txtCTPrice;

        ItemViewHolder(final View itemView)
        {
            super(itemView);

            // declare your footer views
            CTImageView = itemView.findViewById(R.id.iv_coffeetablesList);
            txtCTName = itemView.findViewById(R.id.txt_coffeetableName);
            txtCTFinishing = itemView.findViewById(R.id.txt_coffeetableFinish);
            txtCTPrice = itemView.findViewById(R.id.txt_coffeetablePrice);

            CTImageView.setOnClickListener(new View.OnClickListener()
            {
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
