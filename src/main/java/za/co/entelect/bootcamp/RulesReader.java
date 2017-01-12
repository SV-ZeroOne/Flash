package za.co.entelect.bootcamp;

import java.io.*;
import java.util.ArrayList;

/**
 * @author byron.dinkelmann
 *
 * Created on 2017/01/12.
 */
public class RulesReader {

    private ArrayList<Weapon> allWeaponInformation;
    private ArrayList<String> weapons;

    public RulesReader()
    {
        this.allWeaponInformation = new ArrayList<Weapon>();
        this.weapons = new ArrayList<String>();
    }

    public void readDatabase() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("rulesDataset.txt"));
        try {
            String line;
            while ((line = br.readLine()) != null)
            {
                splitWeaponFromRule(line);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in readDatabase "+e);
        }
    }

    private void splitWeaponFromRule(String rule)
    {
        String[] parts = rule.split(" ");
        String weapon = parts[0];
        String description = parts[1];
        String winCondition = parts[2];

        if(!weapons.contains(weapon))
        {
            weapons.add(weapon);
            allWeaponInformation.add(new Weapon(weapon,description));
        }

        for (int i = 0; i < allWeaponInformation.size() ; i++)
        {
            if(allWeaponInformation.get(i).getName().equals(weapon))
            {

                if(!allWeaponInformation.get(i).getWinConditions().contains(winCondition))
                {
                    allWeaponInformation.get(i).addWinConditions(winCondition);
                }
            }
        }
    }

    private ArrayList<Weapon> getAllWeaponInformation()
    {
        return allWeaponInformation;
    }

    public Weapon getWeapon(String weaponName) {
        for (Weapon weapon : getAllWeaponInformation()) {
            if (weaponName.equals(weapon.getName())) {
                return weapon;
            }
        }
        return null;
    }

    public ArrayList<String> getWeapons() {
        return weapons;
    }
    /*private class WeaponInformation
    {
        private String weapon;
        private String decsription;
        private ArrayList winConditions;

        public WeaponInformation(String weaponIn, String descriptionIn)
        {
            this.weapon = weaponIn;
            this.decsription = descriptionIn;
            this.winConditions = new ArrayList<String>();
        }

        public String getWeapon() {
            return weapon;
        }

        public String getDecsription() {
            return decsription;
        }

        public ArrayList getWinConditions() {
            return winConditions;
        }

        public void addWinConditions(String winConditions) {
            this.winConditions.add(winConditions);
        }
    }*/

}
