package model.shop;

import java.util.ArrayList;

public class Supply implements Category {

    private ArrayList<Product> supplyProducts;

    public Supply() {
        supplyProducts = new ArrayList<>();
        createCategory();
    }

    public ArrayList<Product> getProducts() {
        return supplyProducts;
    }

    @Override
    public void createCategory() {
        supplyProducts.add(new Product("Plank", 3, 5, "Description", professions.getProfessions().get(9)));
        supplyProducts.add(new Product("Screws", 4, 2.99, "Description", professions.getProfessions().get(9)));
        supplyProducts.add(new Product("Nails", 5, 2.49, "Description", professions.getProfessions().get(9)));
    }

    @Override
    public void printProducts() {
        for (Product product : supplyProducts) {
            System.out.println(product.getProductNumber() + " " + product.getName() + " " + product.getPrice());
        }
    }

    @Override
    public Product productByNumber(int productNumber) {
        for(Product product : supplyProducts) {
            if(product.getProductNumber() == productNumber) {
                return product;
            }
        }
        return null;
    }
}
