package za.co.entelect.bootcamp;

public class Player {

    private String playerName;
    private Weapon weaponChoice;

    public Player() {
        this.playerName = null;
        this.weaponChoice = null;
    }

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Weapon getWeaponChoice() {
        return weaponChoice;
    }

    public void setWeaponChoice(Weapon weaponChoice) {
        this.weaponChoice = weaponChoice;
    }
}
