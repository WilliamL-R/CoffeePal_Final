package com.example.u1563819.CoffeePal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.u1563819.CoffeePal.Common.Common;
import com.example.u1563819.CoffeePal.Database.Database;
import com.example.u1563819.CoffeePal.Model.Order;
import com.example.u1563819.CoffeePal.Model.Request;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Basket extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference requests;

    TextView textTotalPrice;
    Button buttonOrder;

    List<Order> basket = new ArrayList<>();

    BasketAdapter basketAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        //Database initialisation
        database = FirebaseDatabase.getInstance();
        requests=database.getReference("Requests");

        //Recylcer initialisation

        recyclerView = (RecyclerView)findViewById(R.id.listBasket);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        textTotalPrice = (TextView)findViewById(R.id.total);
        buttonOrder = (Button)findViewById(R.id.buttonPlaceOrder);

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request request = new Request(
                        Common.currentUser.getName(),
                        textTotalPrice.getText().toString(),
                        basket
                );
                requests.child(String.valueOf(System.currentTimeMillis()))
                        .setValue(request);
                //Delete the Basket
                new Database(getBaseContext()).deleteBasket();
                Toast.makeText(Basket.this, "Thanks for ordering! See you soon", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        loadDrinkList();
    }

    private void loadDrinkList(){
        basket = new Database(this).getBasket();

        basketAdapter = new BasketAdapter(basket,this);
        recyclerView.setAdapter(basketAdapter);

        //Add up price
        int total = 0;
        for(Order order: basket)
            total+=(Integer.parseInt(order.ignorePound(order.getPrice())))*(Integer.parseInt(order.getQuantity()));

        Locale locale = new Locale("en","GB");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);

        textTotalPrice.setText(format.format(total));

    }

}
