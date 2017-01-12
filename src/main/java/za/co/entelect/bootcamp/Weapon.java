package za.co.entelect.bootcamp;

public class Weapon {

    private String name;
    private String [] winConditions;
    private String description;

    public Weapon(String newName){
        setName(newName);
    }

    public Weapon(String newName, String newDescription){
        this.name = newName;
        this.description = newDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getWinConditions() {
        return winConditions;
    }

    public void setWinConditions(String[] winConditions) {
        this.winConditions = winConditions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
