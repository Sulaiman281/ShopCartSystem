package model.shop;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Receipt {
    private double totalPrice;
    private double discountedTotalPrice;
    private double discountPercentage;
    private String userName;
    private ArrayList<ShopItem> shopItems;

    public Receipt(double totalPrice, double discountedTotalPrice, double discountPercentage, String userName, ArrayList<ShopItem> shopItems){
        this.totalPrice = totalPrice;
        this.discountedTotalPrice = discountedTotalPrice;
        this.discountPercentage = discountPercentage;
        this.userName = userName;
        this.shopItems = shopItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double getDiscountedTotalPrice() {
        return discountedTotalPrice;
    }

    public void printReceipt() {
        System.out.println(userName + "\n");
        for(ShopItem shopItem : shopItems) {
            System.out.printf("(%d) " + shopItem.getContains().getName() + " €%.2f\n", shopItem.getQuantity(), shopItem.getQuantity() * shopItem.getContains().getPrice());
        }
        System.out.printf("\n€%.2f no discount\n", getTotalPrice());
        System.out.printf("avg. discount: %.2f" , getDiscountPercentage());
        System.out.println("%");
        System.out.printf("€%.2f discount added\n", getDiscountedTotalPrice());
    }

    public String getReceiptString(){
        String receipt = "";
        receipt = receipt.concat("User Name: " + userName+"\n");
        DecimalFormat dFormat = new DecimalFormat("##.00");
        for (ShopItem shopItem : shopItems) {
            receipt = receipt.concat(
                    "Quantity: (" + shopItem.getQuantity() + ") \t\tName: " +
                            shopItem.getContains().getName() + "\t\tPrice: €" +
                            dFormat.format(shopItem.getContains().getPrice() * shopItem.getQuantity())+"\n");
        }
        receipt = receipt.concat("€"+ dFormat.format(getTotalPrice()) + " without discount \n");
        receipt = receipt.concat("avg. discount: " + dFormat.format(getDiscountPercentage()) + "%\n");
        receipt = receipt.concat("€" + dFormat.format(getDiscountedTotalPrice()) + " with discount\n");
        return receipt;
    }
}
