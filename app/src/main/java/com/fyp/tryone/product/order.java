package com.fyp.tryone.product;
import com.google.firebase.database.IgnoreExtraProperties;

public class order {
    String orderID;
    String custname;
    String custmail;
    String custphone;
    String custadd;
    String ordertotal;

    public order(){ }

    public order(String orderID, String custname, String custmail, String custphone, String custadd, String ordertotal) {
        this.orderID = orderID;
        this.custname = custname;
        this.custmail = custmail;
        this.custphone = custphone;
        this.custadd = custadd;
        this.ordertotal = ordertotal;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getCustname() {
        return custname;
    }

    public String getCustmail() {
        return custmail;
    }

    public String getCustphone() {
        return custphone;
    }

    public String getCustadd() {
        return custadd;
    }

    public String getOrdertotal() {
        return ordertotal;
    }
}
