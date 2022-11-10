package model.shop;

import model.user.User;

import java.util.ArrayList;

public class Cart {
    private ArrayList<ShopItem> shopItems;
    private double totalPrice;
    private double discountedTotalPrice;
    private double discountPercentage;
    private Discount contains;
    private Receipt prints;
    private User user;


    public Cart(User user) {
        this.user = user;
        this.shopItems = new ArrayList<>();
    }

    private Cart getCart() {
        this.totalPrice = calculateTotalPrice();
        this.discountedTotalPrice = calculateDiscountedTotalPrice();
        this.discountPercentage = calculateDiscountPercentage();
        return this;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscountedTotalPrice() {
        return discountedTotalPrice;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<ShopItem> getShopItems() {
        return shopItems;
    }

    public void addItems(int quantity, Product product) {
        shopItems.add(new ShopItem(quantity, product));
    }

    public void printCart() {
        for (ShopItem shopItem : shopItems) {
            System.out.println(shopItem.getQuantity() + " " + shopItem.getContains().getName());
        }
    }

    public double calculateTotalPrice() {
        double total = 0;
        for(ShopItem shopItem : getShopItems()) {
            total += shopItem.getContains().getPrice() * shopItem.getQuantity();
        }
        return total;
    }

    public double calculateDiscountedTotalPrice() {
        double total = 0;
        for(ShopItem shopItem : getShopItems()) {
            contains = new Discount(user, shopItem.getContains());
            total += shopItem.getContains().getPrice() * shopItem.getQuantity() * (100 - contains.getDiscountPercentage()) / 100;
        }
        return total;
    }

    public double calculateDiscountPercentage() {
        return (getTotalPrice() - getDiscountedTotalPrice()) / getTotalPrice() * 100;
    }

    public void makeReceipt() {
        this.getCart();
        this.prints = new Receipt(getTotalPrice(), getDiscountedTotalPrice(), getDiscountPercentage(), user.getName(), getShopItems());
    }

    public void printReceipt() {
        makeReceipt();
        prints.printReceipt();
    }

    public String getReceipt(){
        return prints.getReceiptString();
    }
}
