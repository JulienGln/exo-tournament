package me.guillaume.recruitment.tournament;

public class Viking extends Fighter{
    public Viking(){
        super(120, new Weapon("axe", "attack", 6));
    }

    public Viking equip(String weapon){
        Weapon arms = null;
        if(weapon.equals("buckler")){
            arms = new Weapon(weapon, "defense", 0, 3);
        } else {
            arms = new Weapon(weapon, "attack", 5);
        }
        addWeapon(arms);
        return this;
    }

}
