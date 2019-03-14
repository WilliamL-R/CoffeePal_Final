package com.example.u1563819.CoffeePal;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.u1563819.CoffeePal.Interface.ItemClickListener;
import com.example.u1563819.CoffeePal.Model.Order;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


class BasketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView textBasketName, textPrice;
    public ImageView imageBasketCount;

    private ItemClickListener itemClickListener;

    public void setTextBasketName(TextView textBasketName){
        this.textBasketName = textBasketName;
    }

    public void setTextPrice(TextView textPrice){
        this.textPrice = textPrice;
    }

    public BasketViewHolder(View view){
        super(view);
        textBasketName = (TextView)itemView.findViewById(R.id.basket_drink_name);
        textPrice = (TextView)itemView.findViewById(R.id.basket_drink_price);
        imageBasketCount = (ImageView)itemView.findViewById(R.id.basket_drink_count);
    }

    @Override
    public void onClick(View view){

    }
}

public class BasketAdapter extends RecyclerView.Adapter<BasketViewHolder> {

    private List<Order> listData = new ArrayList<>();
    private Context context;

    public BasketAdapter(List<Order> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }


    @NonNull
    @Override
    public BasketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.basket_layout, parent, false);
        return new BasketViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BasketViewHolder holder, int position) {
        TextDrawable drawable = TextDrawable.builder().buildRound("" + listData.get(position)
                .getQuantity(), Color.RED);
        holder.imageBasketCount.setImageDrawable(drawable);

        Locale locale = new Locale("en", "GB");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        int price = (Integer.parseInt(listData.get(position).ignorePound(listData.get(position).getPrice()))) *
                (Integer.parseInt(listData.get(position).getQuantity()));
        holder.textPrice.setText(format.format(price));
        holder.textBasketName.setText(listData.get(position).getItemName());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

}
