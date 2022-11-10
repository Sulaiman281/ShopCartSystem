package model.shop;

import java.util.ArrayList;

public class Equipment implements Category {

    private ArrayList<Product> equipmentProducts;

    public Equipment() {
        equipmentProducts = new ArrayList<>();
        createCategory();
    }

    @Override
    public void createCategory() {
        equipmentProducts.add(new Product("Hammer", 0, 9.99, "Description", professions.getProfessions().get(9), professions.getProfessions().get(7)));
        equipmentProducts.add(new Product("Bucksaw", 1, 19.95, "Description", professions.getProfessions().get(9)));
        equipmentProducts.add(new Product("Drill", 2, 34.99, "Description", professions.getProfessions().get(9), professions.getProfessions().get(7)));
    }

    @Override
    public void printProducts() {
        for (Product product : equipmentProducts) {
            System.out.println(product.getProductNumber() + " " + product.getName() + " " + product.getPrice());
        }
    }

    @Override
    public Product productByNumber(int productNumber) {
        for(Product product : equipmentProducts) {
            if(product.getProductNumber() == productNumber) {
                return product;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Product> getProducts() {
        return equipmentProducts;
    }
}
