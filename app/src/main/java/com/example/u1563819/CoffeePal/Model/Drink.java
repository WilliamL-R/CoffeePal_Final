//package com.example.u1563819.CoffeePal.Model;
//
//import java.util.ArrayList;
//
///** The drink object that can be ordered by the customer
// * @author William Loveridge-Rushforth
// * @version Janurary 2019
// */
//
//public class Drink{
//    private String dImage;
//    private String dName;
//    private boolean dAvail;
//    private String dPrice;
//
//    public Drink (String name, boolean available, String imageString){
//        dImage = imageString;
//        dName = name;
//        dAvail = available;
//        dPrice
//    }
//
//    public String getdImage(){return dImage;}
//
//    public String getdName(){
//        return dName;
//    }
//
//    public boolean isdAvail(){
//        return dAvail;
//    }
//
//    public void setdImage(String image){
//        this.dImage = image;
//    }
//
//    private static int lastDrinkID = 0;
//
////    public static ArrayList<Drink> createDrinksList(int numDrinks){
////        ArrayList<Drink> drinks = new ArrayList<Drink>();
////
////        Drink cappuchino = new Drink("Cappuchino", true, R.drawable.cappuchino);
////        drinks.add(cappuchino);
////        Drink latte = new Drink("Latte", true, R.drawable.latte);
////        drinks.add(latte);
////        Drink espresso = new Drink("Espresso", true, R.drawable.espresso);
////        drinks.add(espresso);
////        Drink americano = new Drink("Americano", true, R.drawable.americano);
////        drinks.add(americano);
////        Drink flatWhite = new Drink("Flat White", true, R.drawable.flat_white);
////        drinks.add(flatWhite);
////        Drink longBlack = new Drink("Long Black", true, R.drawable.long_black);
////        drinks.add(longBlack);
////        Drink mocha = new Drink("Mocha", true, R.drawable.mocha);
////        drinks.add(mocha);
////        Drink tea = new Drink("Tea", true, R.drawable.tea);
////        drinks.add(tea);
////        Drink instantCoffee = new Drink("Instant Coffee", true, R.drawable.instant_coffee);
////        drinks.add(instantCoffee);
////        Drink milk = new Drink("Milk", true, R.drawable.milk);
////        drinks.add(milk);
////
////
////        return drinks;
////    }
//}
package com.example.u1563819.CoffeePal.Model;

/**
 * Created by u1563819 on 14/02/2019.
 */

public class Drink {
    private String Name;
    private String Image;
    private String Allergerns;
    private String Price;

    public Drink(){

    }
    public Drink(String name, String image, String allergerns, String price){
        Name = name;
        Image = image;
        Allergerns = allergerns;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getAllergerns() {
        return Allergerns;
    }

    public void setAllergerns(String allergerns) {
        Allergerns = allergerns;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
