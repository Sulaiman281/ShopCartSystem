package model.user;

import java.util.ArrayList;

public class ProfessionList {
    private ArrayList<Profession> professions;

    public ProfessionList() {
        this.professions = new ArrayList<>();
        professions = new ArrayList<>();
        professions.add(new Profession("tailor"));
        professions.add(new Profession("Baker"));
        professions.add(new Profession("Fisherman"));
        professions.add(new Profession("Teacher"));
        professions.add(new Profession("Doctor"));
        professions.add(new Profession("Soldier"));
        professions.add(new Profession("TikTok Star"));
        professions.add(new Profession("Miner"));
        professions.add(new Profession("Bodyguard"));
        professions.add(new Profession("Builder"));
        professions.add(new Profession("Scientist"));
    }

    public void printProfessionList(){
        int number = 1;

        for(Profession profession : professions){
            System.out.println(number + ": " + profession.getName());
            number++;
        }
    }

    public ArrayList<Profession> getProfessions() {
        return professions;
    }
}
