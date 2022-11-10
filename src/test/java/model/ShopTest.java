package model;

import model.shop.Discount;
import model.shop.Product;
import model.shop.Shop;
import model.user.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {


    @Test
    void getDiscount() {
        User user = new User("Test1", "male", "test@test.test1", "Test1", "testwachtwoord1");
        User user2 = new User("Test2", "male", "test@test.test2", "Test2", "testwachtwoord2");

        Shop shop = new Shop("test", "testShop", user);
        user.addProfessionToUser(1);
        user.addProfessionToUser(9);
        user.addProfessionToUser(10);
        user.addProfessionToUser(0);

        Product product1 = shop.getCategories().get(0).productByNumber(0);
        Product product2 = shop.getCategories().get(2).productByNumber(7);
        Discount discount1 = new Discount(user, product1);
        Discount discount2 = new Discount(user, product2);
        assertEquals(7.5, discount1.getDiscountPercentage());
        assertEquals(10, discount2.getDiscountPercentage());

        user.addProfessionToUser(4);
        user.addProfessionToUser(0);

        discount1 = new Discount(user, product1);
        discount2 = new Discount(user, product2);
        assertEquals(12.5, discount1.getDiscountPercentage());
        assertEquals(15, discount2.getDiscountPercentage());

        Discount discount3 = new Discount(user2, product1);
        assertEquals(0, discount3.getDiscountPercentage());
    }
}
