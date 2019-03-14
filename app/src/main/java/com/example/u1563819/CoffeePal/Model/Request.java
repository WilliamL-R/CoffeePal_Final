package com.example.u1563819.CoffeePal.Model;

import java.util.List;

public class Request {
    private String name;
    private String total;
    private String status;
    private List<Order> drinks;

    public Request(){
    }

    public Request(String name, String total, List<Order> drinks) {
        this.name = name;
        this.total = total;
        this.drinks = drinks;
        this.status = "0"; // Default is 0, 0: Placed , 1:Drink being made, 2:Made and waiting!
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Order> drinks) {
        this.drinks = drinks;
    }
}
