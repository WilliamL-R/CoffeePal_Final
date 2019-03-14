//package com.example.u1563819.CoffeePal;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.example.u1563819.CoffeePal.Model.Drink;
//
//import java.util.ArrayList;
//
///**This is the functionality of the listview and card view by making the card of the drink items
// * @author William Loveridge-Rushforth
// * @version Janurary 2019
// */
//
//// Create the basic adapter extending from RecyclerView.Adapter
//// Note that we specify the custom ViewHolder which gives us access to our views
//public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder>{
//
//
//    // Provide a direct reference to each of the views within a data item
//    // Used to cache the views within the item layout for fast access
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        // Your holder should contain a member variable
//        // for any view that will be set as you render a row
//        public ImageView drinkImage;
//        public TextView drinkTextView;
//        public Button messageButton;
//
//        // We also create a constructor that accepts the entire item row
//        // and does the view lookups to find each subview
//        public ViewHolder(View itemView){
//            // Stores the itemView in a public final member variable that can be used
//            // to access the context from any ViewHolder instance.
//            super(itemView);
//
//            drinkImage = itemView.findViewById(R.id.drink_image);
//            drinkTextView = itemView.findViewById(R.id.drink_name);
//            messageButton = itemView.findViewById(R.id.message_button);
//
//            messageButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//
//            messageButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
////                    onClick(view,getAdapterPosition(),false);
//                }
//            });
//        }
//    }
//
//    Context context;
//    private ArrayList<Drink> dNames;
//
//    public DrinkAdapter(Context c,ArrayList<Drink> drinks){
//        this.context = c;
//        dNames = drinks;
//    }
//
//    @NonNull
//    @Override
//    public DrinkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
////        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        View drinkView = inflater.inflate(R.layout.item_drink, parent, false);
//
//        return new ViewHolder(drinkView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull DrinkAdapter.ViewHolder viewHolder, int position) {
//        Drink drink = dNames.get(position);
////
////        TextView textView = viewHolder.drinkTextView;
////        textView.setText(drink.getdName());
////        Button button = viewHolder.messageButton;
////        button.setText(drink.isdAvail()? "Order" : "Unavailable");
////        button.setEnabled(drink.isdAvail());
//
//        viewHolder.drinkImage.setImageResource(drink.getdImage());
//        //Glide used to handle image caching issues.
//        Glide.with(context).load(drink.getdImage()).into(viewHolder.drinkImage);
//        viewHolder.drinkTextView.setText(drink.getdName());
//        viewHolder.messageButton.setEnabled(drink.isdAvail());
//
//    }
//
//    @Override
//    public int getItemCount(){
//        return dNames.size();
//    }
//}
