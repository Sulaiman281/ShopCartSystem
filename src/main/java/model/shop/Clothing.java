package model.shop;

import java.util.ArrayList;

public class Clothing implements Category {

    private ArrayList<Product> clothingProducts;

    public Clothing() {
        clothingProducts = new ArrayList<>();
        createCategory();
    }

    @Override
    public void createCategory() {
        clothingProducts.add(new Product("Jeans", 6, 15, "Description", professions.getProfessions().get(0), professions.getProfessions().get(2)));
        clothingProducts.add(new Product("Shoes", 7, 22.99, "Description", professions.getProfessions().get(9), professions.getProfessions().get(8)));
        clothingProducts.add(new Product("Shirt", 8, 9.90, "Description", professions.getProfessions().get(2), professions.getProfessions().get(4)));
    }

    @Override
    public void printProducts() {
        for (Product product : clothingProducts) {
            System.out.println(product.getProductNumber() + " " + product.getName() + " " + product.getPrice());
        }
    }

    @Override
    public Product productByNumber(int productNumber) {
        for(Product product : clothingProducts) {
            if(product.getProductNumber() == productNumber) {
                return product;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Product> getProducts() {
        return clothingProducts;
    }
}
