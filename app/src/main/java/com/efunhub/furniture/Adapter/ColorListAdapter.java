package com.efunhub.furniture.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.efunhub.furniture.Activity.RecyclerViewItemClickListener;
import com.efunhub.furniture.Model.ColorListModel;
import com.efunhub.furniture.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;

/**
 * Created by PATailor on 15-02-2018.
 */

public class ColorListAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<ColorListModel> arrayList;
    private RecyclerViewItemClickListener mRecyclerViewItemClickListener;
    int adapterposition;

    public void setListenerRecyclerView(RecyclerViewItemClickListener mRecyclerViewItemClickListener) {
        this.mRecyclerViewItemClickListener = mRecyclerViewItemClickListener;
    }

    public ColorListAdapter(Context mContext, ArrayList<ColorListModel> colorListArrayList) {
        this.mContext = mContext;
        this.arrayList = colorListArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.colors_list_item, null);
        viewHolder = new ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        ColorListModel colorListModel = arrayList.get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

        Log.v("Color", String.valueOf(colorListModel.getColorImage()));

        Picasso.with(mContext).load(colorListModel.getColorImage())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .transform(new CircleTransform())
                .into(itemViewHolder.imageView);


    }

    private static class CircleTransform implements Transformation {

        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());

            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
            if (squaredBitmap != source) {
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
        public String key() {
            return "circle";
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public int getItemViewType(int position)
    {
        return position;
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;

        ItemViewHolder(View itemView)
        {
            super(itemView);

            // declare your footer views
            imageView = itemView.findViewById(R.id.iv_color);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    adapterposition = getAdapterPosition();
                    Log.v("colorChange", String.valueOf(getAdapterPosition()));
                    mRecyclerViewItemClickListener.onItemClick(adapterposition);
                }
            });
        }
    }
}
