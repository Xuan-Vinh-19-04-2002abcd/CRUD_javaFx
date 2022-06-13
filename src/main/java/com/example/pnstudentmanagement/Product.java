package com.example.pnstudentmanagement;

public class Product {
    int id;
    public String name;
    public String img;
    public  String price;

    Product(int id, String name,String price,String img) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
    }
    Product( String name,String price,String img) {
        this.name = name;
        this.img = img;
        this.price = price;
    }


}
