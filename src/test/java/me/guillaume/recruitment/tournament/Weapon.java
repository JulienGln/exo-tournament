package me.guillaume.recruitment.tournament;

public class Weapon {
    private String name;
    private String type;
    private int damage;
    private int durability;
    private boolean block;

    public Weapon(String name,String type, int damage){
        this.type = type;
        this.damage = damage;
        durability = 10;
        block = true;
    }

    public Weapon(String name,String type, int damage, int durability){
        this.type = type;
        this.damage = damage;
        this.durability = durability;
        block = true;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurability() {
        return durability;
    }

    public void decreaseDurability(){
        if(durability > 0) {
            durability--;
        }
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }
}
