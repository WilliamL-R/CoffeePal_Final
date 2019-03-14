package com.example.u1563819.CoffeePal.Viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.u1563819.CoffeePal.Interface.ItemClickListener;
import com.example.u1563819.CoffeePal.R;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textOrderId, textOrderStatus, textUserName;

    private ItemClickListener itemClickListener;

    public OrderViewHolder(View itemView) {
        super(itemView);

        textOrderId = (TextView)itemView.findViewById(R.id.order_id);
        textOrderStatus = (TextView)itemView.findViewById(R.id.order_status);
        textUserName = (TextView)itemView.findViewById(R.id.order_customer);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }
}
