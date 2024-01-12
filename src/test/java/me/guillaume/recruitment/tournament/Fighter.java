package me.guillaume.recruitment.tournament;

public class Fighter {

    private int hitPoints;
    private Weapon weapon;

    public Fighter(int hitPoints, Weapon weapon){
        this.hitPoints = hitPoints;
        this.weapon = weapon;
    }

    public void engage(Fighter fighter) {
        while (hitPoints > 0 && fighter.hitPoints() > 0){
            fighter.reduceHitPoints(weapon.getDamage());
            reduceHitPoints(fighter.getWeapon().getDamage());
        }
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public void reduceHitPoints(int dmg){
        if (hitPoints - dmg >= 0){
            hitPoints -= dmg;
        } else {
            hitPoints = 0;
        }

    }

    public int hitPoints() {
        return hitPoints;
    }

}
