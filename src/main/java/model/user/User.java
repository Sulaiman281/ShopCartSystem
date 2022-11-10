package model.user;

import model.shop.Receipt;
import model.communitybadges.CommunityBadge;
import model.communitybadges.CommunityBadgeBronze;
import model.communitybadges.CommunityBadgeGold;
import model.communitybadges.CommunityBadgeSilver;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private CommunityBadge communityBadge;
    private String name, gender, email, username, password;
    private ProfessionList professionList;
    private Receipt receipt;

    private ArrayList<Profession> professionListUser;

    public User(String name, String gender, String email, String username, String password) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.username = username;
        this.password = password;

        this.professionList = new ProfessionList();

        professionListUser = new ArrayList<>();
        //addProfessionToUser();

    }

    public User(String name, String username, String password) {
        this.username = username;
        this.password = password;
        this.name = name;

        this.professionList = new ProfessionList();

        professionListUser = new ArrayList<>();

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CommunityBadge getCommunityBadge(){
        return communityBadge;
    }

    public void setCommunityBadge(CommunityBadge communityBadge) {
        this.communityBadge = communityBadge;
    }

    public ArrayList<Profession> getProfessionListUser() {
        return professionListUser;
    }

    public void printProfessionListUser(){
        int number = 1;
        for(Profession profession : professionListUser){
            System.out.println(number + ": " + profession.getName());
            number++;
        }
    }

    //Bepaald welke badge de gebruiker krijgt
    public CommunityBadge assignCommunityBadge(){
        if(professionListUser.size() >= 2 && professionListUser.size() < 4){
            return communityBadge = new CommunityBadgeBronze();
        }
        else if(professionListUser.size() >= 4 && professionListUser.size() < 6){
            return communityBadge = new CommunityBadgeSilver();
        }
        else if(professionListUser.size() >= 6){
            return communityBadge = new CommunityBadgeGold();
        }
        else{
            return null;
        }
    }

    public void addProfessionToUser(){
        Boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("Choose your profession :\n");
            professionList.printProfessionList();
            System.out.println("0: To exit");
            int chosenNumber = scanner.nextInt();

            if(chosenNumber == 0) {
                loop = false;
            }

            else if(loop && chosenNumber <= professionList.getProfessions().size()){
                addProfessionToUser(chosenNumber);
                System.out.println("Profession added!");
            }
            else{
                System.out.println("Profession not found, try again.");
            }
        }
    }

    public void addProfessionToUser(int chosenNumber) {
        if (chosenNumber != 0 && chosenNumber <= 10) {
            professionListUser.add(professionList.getProfessions().get(chosenNumber - 1));
        } else if(chosenNumber == 0) {
            this.communityBadge = assignCommunityBadge();
        } else {
            System.out.println("Profession not found, try again.");
        }
    }
}
