package me.guillaume.recruitment.tournament;

public class Swordsman extends Fighter {

    public Swordsman() {
        super(100, new Weapon("sword", "attack", 5));
    }

    public Swordsman equip(String weapon){
        Weapon arms = null;
        if(weapon.equals("buckler") || weapon.equals("armor")){
            if(weapon.equals("buckler")){
                arms = new Weapon(weapon, "defense", 0, 3);
            } else {
                arms = new Weapon(weapon, "defense", 0, 100);
            }
        } else {
            arms = new Weapon(weapon, "attack", 5);
        }
        addWeapon(arms);
        return this;
    }

}
