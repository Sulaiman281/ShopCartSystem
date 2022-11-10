package model.shop;

import model.communitybadges.CommunityBadge;
import model.communitybadges.CommunityBadgeBronze;
import model.communitybadges.CommunityBadgeGold;
import model.communitybadges.CommunityBadgeSilver;
import model.user.Profession;
import model.user.User;

import java.util.ArrayList;

public class Discount {

    private User user;
    private Product product;
    private double discountPercentage;

    public Discount(User user, Product product) {
        this.user = user;
        this.product = product;
        this.discountPercentage = totalDiscount();
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double totalDiscount() {
        CommunityBadge communityBadge = user.getCommunityBadge();
        ArrayList<Profession> professionsUser = user.getProfessionListUser();
        ArrayList<String> professionsProduct = product.getProfessionList();
        return communityBadgeDiscount(communityBadge) + professionDiscount(professionsUser, professionsProduct);
    }

    public int communityBadgeDiscount(CommunityBadge communityBadge) {
        if(communityBadge instanceof CommunityBadgeBronze) {
            return 5;
        } else if(communityBadge instanceof CommunityBadgeSilver) {
            return 10;
        } else if(communityBadge instanceof CommunityBadgeGold) {
            return 15;
        } else return 0;
    }

    public double professionDiscount(ArrayList<Profession> professionsUser, ArrayList<String> professionsProduct) {
        int amount = 0;
        for(Profession professionUser : professionsUser) {
            for(String professionProduct : professionsProduct) {
                if(professionUser.getName().equals(professionProduct)) {
                    amount++;
                }
            }
        }
        return 2.5 * amount;
    }
}
