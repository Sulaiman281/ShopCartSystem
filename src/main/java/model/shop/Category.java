package model.shop;

import model.user.ProfessionList;

import java.util.ArrayList;

public interface Category {
    ProfessionList professions = new ProfessionList();
    void createCategory();
    void printProducts();
    Product productByNumber(int productNumber);
    ArrayList<Product> getProducts();
}
