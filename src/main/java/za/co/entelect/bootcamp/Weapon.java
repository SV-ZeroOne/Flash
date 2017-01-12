package za.co.entelect.bootcamp;

import java.util.ArrayList;

public class Weapon {

    private String name;
    private ArrayList winConditions;
    private String description;

    public Weapon(String newName){
        setName(newName);
    }

    public Weapon(String newName, String newDescription){
        this.name = newName;
        this.description = newDescription;
        this.winConditions = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getWinConditions() {
        return winConditions;
    }

    public String getDescription() {
        return description;
    }

    public void addWinConditions(String winConditions) {
        this.winConditions.add(winConditions);
    }
}
