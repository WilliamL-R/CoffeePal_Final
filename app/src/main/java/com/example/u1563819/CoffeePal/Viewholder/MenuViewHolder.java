package com.example.u1563819.CoffeePal.Viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.u1563819.CoffeePal.Interface.ItemClickListener;
import com.example.u1563819.CoffeePal.R;

/**
 * Created by u1563819 on 14/02/2019.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView textMenuName;
    public ImageView imageView;
    public TextView textPrice;

    private ItemClickListener itemClickListener;


    public MenuViewHolder(View drinkView) {
        super(drinkView);

        textMenuName = (TextView) itemView.findViewById(R.id.drink_name);
        imageView = (ImageView) itemView.findViewById(R.id.drink_image);
        textPrice = (TextView) itemView.findViewById(R.id.drink_price);
        drinkView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    @Override
    public void onClick(View view){
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}

