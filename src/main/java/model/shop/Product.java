package model.shop;

import model.user.Profession;

import java.util.ArrayList;

public class Product {
    private String name, description;
    private Integer productNumber;
    private Double price;
    private ArrayList<String> professionList;

    public Product(String name, Integer productNumber, double price, String description, Profession profession1){
        this.name = name;
        this.productNumber = productNumber;
        this.price = price;
        this.description = description;
        professionList = new ArrayList<>();
        professionList.add(profession1.getName());
    }

    public Product(String name, Integer productNumber, double price, String description, Profession profession1, Profession profession2){
        this.name = name;
        this.productNumber = productNumber;
        this.price = price;
        this.description = description;
        professionList = new ArrayList<>();
        professionList.add(profession1.getName());
        professionList.add(profession2.getName());
    }

    public String getName(){
        return name;
    }

    public Integer getProductNumber(){
        return productNumber;
    }

    public Double getPrice(){
        return price;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getProfessionList() {
        return professionList;
    }
}
