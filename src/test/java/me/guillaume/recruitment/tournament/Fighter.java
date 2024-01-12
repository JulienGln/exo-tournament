package me.guillaume.recruitment.tournament;

import java.util.ArrayList;

public class Fighter {

    private int hitPoints;
    private ArrayList<Weapon> weapons = new ArrayList<>();

    public Fighter(int hitPoints, Weapon weapon){
        this.hitPoints = hitPoints;
        this.weapons.add(weapon);
    }

    public void engage(Fighter fighter) {
        while (hitPoints > 0 && fighter.hitPoints() > 0){
            if(fighter.hasArmor()){
                fighter.reduceHitPoints(weapons.get(0).getDamage() - 1);
            } else {
                fighter.reduceHitPoints(weapons.get(0).getDamage());
            }
            if(hasArmor()){
                reduceHitPoints(fighter.getWeapon().getDamage() - 1);
            } else {
                reduceHitPoints(fighter.getWeapon().getDamage());
            }
        }
    }

    public boolean hasDefense(){
        for (Weapon weapon : weapons){
           if(weapon.getType().equals("defense")){
               return true;
           }
        };
        return false;
    }

    public boolean hasArmor(){
        for (Weapon weapon : weapons){
            if(weapon.getType().equals("defense") && weapon.getName().equals("armor")){
                return true;
            }
        };
        return false;
    }


    public Weapon getDefense(){
        for (Weapon weapon : weapons){
            if(weapon.getType().equals("defense")){
                return weapon;
            }
        };
        return null;
    }

    public Weapon getWeapon(){
        return weapons.get(0);
    }

    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }

    public void addWeapon(Weapon w){
        weapons.add(w);
    }

    public void reduceHitPoints(int dmg){
        if(hasDefense()){
            Weapon defense = getDefense();
            if(defense.isBlock()){
                defense.setBlock(false);
                defense.decreaseDurability();
            } else {
                attack(dmg);
                if(defense.getDurability() > 0) {
                    defense.setBlock(true);
                }
            }
        } else {
            attack(dmg);
        }
    }

    public int hitPoints() {
        return hitPoints;
    }

    public void attack(int dmg) {
        if (this instanceof Highlander){
            ((Highlander) this).addFatigue();
            if(((Highlander) this).getFatigue() == 2) {
                return; // le highlander ne peut pas attaqué car il est fatigué
            }
        }

        if (hitPoints - dmg >= 0){
            if(hasArmor()){
                hitPoints -= (dmg - 3);
            }
        } else {
            hitPoints = 0;
        }
    }

}
