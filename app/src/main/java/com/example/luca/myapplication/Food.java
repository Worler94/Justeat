package com.example.luca.myapplication;

public class Food {

    private String name;
    private int quantity = 0;
    private float price;

    public Food(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setPrice(float price) {
        this.price = price;
    }

    public void decreaseQuantity(){
        this.quantity--;
    }

    public void increaseQuantity(){
        this.quantity++;
    }
}
