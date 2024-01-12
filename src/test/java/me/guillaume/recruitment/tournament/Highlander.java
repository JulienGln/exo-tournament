package me.guillaume.recruitment.tournament;

public class Highlander extends Fighter {
    private int fatigue;
    public Highlander() {
        super(150, new Weapon("greatsword", "attack", 12, 10, 2));
        fatigue = 0;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void addFatigue() {
        fatigue = (fatigue + 1) % 3;
    }
}
