package model.shop;

public class ShopItem {
    private Product contains;
    private int quantity;

    public ShopItem(int quantity, Product product) {
        this.quantity = quantity;
        contains = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ShopItem(Product product) {
        contains = product;
    }

    public Product getContains() {
        return contains;
    }

    public int getQuantity() {
        return quantity;
    }
}
