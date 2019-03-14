package com.example.u1563819.CoffeePal.Model;

/**
 * Created by u1563819 on 13/02/2019.
 */

public class User {
    private String Name;
    private String Password;
    private String isStaff;
    private String isManager;
    private String isOwner;

    public User(){
    }

    public User(String name, String password) {
        Name = name;
        Password = password;
        isStaff = "false";
        isManager = "false";
        isOwner = "false";
    }

    public String getIsManager() {
        return isManager;
    }

    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

    public String getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(String isOwner) {
        this.isOwner = isOwner;
    }

    public String getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(String isStaff) {
        this.isStaff = isStaff;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
