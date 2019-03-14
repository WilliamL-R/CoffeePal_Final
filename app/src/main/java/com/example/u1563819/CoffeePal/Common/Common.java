package com.example.u1563819.CoffeePal.Common;

import com.example.u1563819.CoffeePal.Model.User;

/**
 * Created by u1563819 on 14/02/2019.
 */

public class Common {
    public static User currentUser;

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
}
