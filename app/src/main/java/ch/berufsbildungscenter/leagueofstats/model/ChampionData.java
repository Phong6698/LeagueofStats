package ch.berufsbildungscenter.leagueofstats.model;

import java.util.ArrayList;

/**
 * Created by zkillt on 18.06.2015.
 */
public class ChampionData {

    private final String health = "Health";
    private final String healthRegen = "Health-Regen";
    private final String manaRegen = "Mana-Regen";
    private final String mana = "Mana";
    private final String range = "Range";
    private final String ad = "Attack Damage";
    private final String attackSpeed = "Attackspeed";
    private final String armor = "Armor";
    private final String magicResist = "Magic Resist";
    private final String movementSpeed = "Movement Speed";

    private String health_stat = "test";
    private String healthRegen_stat = "test";
    private String mana_stat = "test";
    private String manaRegen_stat = "test";
    private String ad_stat = "test";
    private String attackSpeed_stat = "test";
    private String armor_stat = "test";
    private String magicResist_stat = "test";
    private String movementSpeed_stat = "test";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ChampionStat> getChampionStats() {
        return championStats;
    }

    public void setChampionStats(ArrayList<ChampionStat> championStats) {
        this.championStats = championStats;
    }

    private String title;
    private String name;
    private int id ;


    private ArrayList<ChampionStat> championStats = new ArrayList<ChampionStat>();

    public String getHealthRegen() {
        return healthRegen;
    }

    public String getHealthRegen_stat() {
        return healthRegen_stat;
    }

    public void setHealthRegen_stat(String lifeRegen_stat) {
        this.healthRegen_stat = lifeRegen_stat;
    }

    public String getMana() {
        return mana;
    }

    public String getMana_stat() {
        return mana_stat;
    }

    public void setMana_stat(String mana_stat) {
        this.mana_stat = mana_stat;
    }

    public String getManaRegen() {
        return manaRegen;
    }

    public String getManaRegen_stat() {
        return manaRegen_stat;
    }

    public void setManaRegen_stat(String manaRegen_stat) {
        this.manaRegen_stat = manaRegen_stat;
    }

    public String getAd() {
        return ad;
    }

    public String getAd_stat() {
        return ad_stat;
    }

    public void setAd_stat(String ad_stat) {
        this.ad_stat = ad_stat;
    }

    public String getAttackSpeed() {
        return attackSpeed;
    }

    public String getAttackSpeed_stat() {
        return attackSpeed_stat;
    }

    public void setAttackSpeed_stat(String attackSpeed_stat) {
        this.attackSpeed_stat = attackSpeed_stat;
    }

    public String getArmor() {
        return armor;
    }

    public String getArmor_stat() {
        return armor_stat;
    }

    public void setArmor_stat(String armor_stat) {
        this.armor_stat = armor_stat;
    }

    public String getMagicResist() {
        return magicResist;
    }

    public String getMagicResist_stat() {
        return magicResist_stat;
    }

    public void setMagicResist_stat(String magicResist_stat) {
        this.magicResist_stat = magicResist_stat;
    }

    public String getMovementSpeed() {
        return movementSpeed;
    }

    public String getMovementSpeed_stat() {
        return movementSpeed_stat;
    }

    public void setMovementSpeed_stat(String movementSpeed_stat) {
        this.movementSpeed_stat = movementSpeed_stat;
    }

    public String getHealth() {
        return health;
    }

    public String getHealth_stat() {
        return health_stat;
    }

    public void setHealth_stat(String health_stat) {
        this.health_stat = health_stat;
    }
}
