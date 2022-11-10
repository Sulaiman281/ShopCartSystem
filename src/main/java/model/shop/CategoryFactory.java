package model.shop;

public class CategoryFactory {

    public Category getInstance(String categoryName) {
        if (categoryName.equalsIgnoreCase("Supplies")) {
            return new Supply();
        } else if (categoryName.equalsIgnoreCase("Equipment")) {
            return new Equipment();
        } else if (categoryName.equalsIgnoreCase("Clothing")) {
            return new Clothing();
        } else return null;
    }
}
