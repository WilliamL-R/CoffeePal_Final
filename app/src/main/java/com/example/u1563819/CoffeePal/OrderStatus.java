package com.example.u1563819.CoffeePal;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.u1563819.CoffeePal.Common.Common;
import com.example.u1563819.CoffeePal.Interface.ItemClickListener;
import com.example.u1563819.CoffeePal.Model.Order;
import com.example.u1563819.CoffeePal.Model.Request;
import com.example.u1563819.CoffeePal.Viewholder.OrderViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrderStatus extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Request, OrderViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference orderRequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        database = FirebaseDatabase.getInstance();
        orderRequests = database.getReference("Requests");

        recyclerView = findViewById(R.id.listOrders);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if(getIntent() == null) {
            loadOrders(Common.currentUser.getName());
        }else{
            loadOrders(getIntent().getStringExtra("userName"));
        }
    }

    private void loadOrders(String name){
            FirebaseRecyclerOptions<Request> request = new FirebaseRecyclerOptions.Builder<Request>().setQuery(orderRequests,Request.class).build();
        adapter = new FirebaseRecyclerAdapter<Request, OrderViewHolder>(request) {
            @Override
            protected void onBindViewHolder(@NonNull OrderViewHolder holder, int position, @NonNull Request model) {
                holder.textOrderId.setText(adapter.getRef(position).getKey());
                holder.textOrderStatus.setText(convertCodeToStatus(model.getStatus()));
                holder.textUserName.setText(model.getName());

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                    }
                });
            }

            @NonNull
            @Override
            public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.order_layout,parent,false);
                return new OrderViewHolder(view);
            }
        };
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    public void onStop(){
        super.onStop();
        adapter.stopListening();
    }

    public static String convertCodeToStatus(String status){
        if("0".equals(status)){
            return "Placed";
        }
        else if("1".equals(status)){
            return "Drinks are being made";
        }else{
            return "Drinks are ready and waiting!";
        }
    }
//
//    public int getItemCount() {
//        return
//    }
}
