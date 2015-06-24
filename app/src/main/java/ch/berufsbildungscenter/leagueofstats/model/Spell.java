package ch.berufsbildungscenter.leagueofstats.model;

/**
 * Created by zkillt on 24.06.2015.
 */
public class Spell {

    private String name;
    private String description;
    private int cooldownBurn;
    private int cost;
    private int range;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCooldownBurn() {
        return cooldownBurn;
    }

    public void setCooldownBurn(int cooldownBurn) {
        this.cooldownBurn = cooldownBurn;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
