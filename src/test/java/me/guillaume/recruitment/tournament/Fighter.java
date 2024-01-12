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
            fighter.reduceHitPoints(weapons.get(0).getDamage());
            reduceHitPoints(fighter.getWeapon().getDamage());
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
                if (hitPoints - dmg >= 0){
                    hitPoints -= dmg;
                } else {
                    hitPoints = 0;
                }
                if(defense.getDurability() > 0) {
                    defense.setBlock(true);
                }
            }
        } else {
            if (hitPoints - dmg >= 0){
                hitPoints -= dmg;
            } else {
                hitPoints = 0;
            }
        }
    }

    public int hitPoints() {
        return hitPoints;
    }

}
