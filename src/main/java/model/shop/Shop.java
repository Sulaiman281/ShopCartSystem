package model.shop;

import model.user.User;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Category> categories;
    private String name;
    private String address;
    private Cart cart;

    public Shop(String name, String address, User user){
        this.name = name;
        this.address = address;
        this.cart = new Cart(user);
        this.categories = new ArrayList<>();

        addCategory(new CategoryFactory().getInstance("Equipment"));
        addCategory(new CategoryFactory().getInstance("Supplies"));
        addCategory(new CategoryFactory().getInstance("Clothing"));
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public Cart getCart() {
        return cart;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void printProducts() {
        for(Category category : categories) {
            category.printProducts();
        }
    }

    public void addShopItemToCart(int quantity, int productNumber) {
        for(Category category : categories) {
            Product product = category.productByNumber(productNumber);
            if(product != null) {
                cart.addItems(quantity, product);
            }
        }
    }
}

