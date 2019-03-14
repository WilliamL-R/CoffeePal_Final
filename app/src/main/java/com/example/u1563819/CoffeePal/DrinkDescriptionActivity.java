package com.example.u1563819.CoffeePal;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.u1563819.CoffeePal.Database.Database;
import com.example.u1563819.CoffeePal.Model.Drink;
import com.example.u1563819.CoffeePal.Model.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DrinkDescriptionActivity extends AppCompatActivity {

    TextView drink_name,drink_price, drink_allergerns;
    ImageView drink_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String drinkId="";

    FirebaseDatabase database;
    DatabaseReference drinks;

    Drink currentDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_description);

        //Database instance
        database = FirebaseDatabase.getInstance();
        drinks = database.getReference("Drinks");

        //View initalisation
        numberButton = (ElegantNumberButton) findViewById(R.id.number_button);
        btnCart = (FloatingActionButton) findViewById(R.id.buttonCart);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToBasket(new Order(
                        drinkId,
                        currentDrink.getName(),
                        numberButton.getNumber(),
                        currentDrink.getPrice()
                ));
                Toast.makeText(DrinkDescriptionActivity.this,"Added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        drink_name = (TextView) findViewById(R.id.drink_name);
        drink_price = (TextView) findViewById(R.id.drink_price);
        drink_image = (ImageView) findViewById(R.id.img_drink);
        drink_allergerns = findViewById(R.id.drink_allergerns);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        if (getIntent() != null) {
            drinkId = getIntent().getStringExtra("drinkId");
        }
        if (!drinkId.isEmpty()) {
            getDetailDrink(drinkId);
        }
    }

        private void getDetailDrink(String drinkId){
            drinks.child(drinkId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    currentDrink = dataSnapshot.getValue(Drink.class);

                    Picasso.get().load(currentDrink.getImage())
                            .into(drink_image);
                    collapsingToolbarLayout.setTitle(currentDrink.getName());
                    drink_price.setText("£" + currentDrink.getPrice());
                    drink_name.setText(currentDrink.getName());
                    drink_allergerns.setText("Allergies: "+currentDrink.getAllergerns());
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
}

