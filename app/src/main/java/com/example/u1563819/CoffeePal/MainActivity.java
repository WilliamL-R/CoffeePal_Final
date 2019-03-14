//package com.example.u1563819.CoffeePal;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.StaggeredGridLayoutManager;
//
//import com.example.u1563819.CoffeePal.Model.Drink;
//
//import java.util.ArrayList;

/**Instantiates the Main method for the customer
 * @author William Loveridge-Rushforth
// * @version Feburary 2019
// */
//public class MainActivity extends AppCompatActivity {
//
//    ArrayList<Drink> drinks;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user);
//
//
//        RecyclerView rvDrinks = findViewById(R.id.rvDrinks);
//
//        //Creates 10 drink objects, consider a size getter method.
//        drinks = Drink.createDrinksList(10);
//
//        DrinkAdapter adapter = new DrinkAdapter(this,drinks);
//
//        rvDrinks.setAdapter(adapter);
//        StaggeredGridLayoutManager gridLayoutManager =
//                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
//// Attach the layout manager to the recycler view
//        rvDrinks.setLayoutManager(gridLayoutManager);
////        rvDrinks.setLayoutManager(new LinearLayoutManager(this));
//    }
//}
