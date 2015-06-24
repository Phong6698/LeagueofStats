package ch.berufsbildungscenter.leagueofstats.model;

import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.ImageDownloader;

/**
 * Created by zkillt on 18.06.2015.
 */
public class ChampionData {

    private ArrayList<ChampionStat> championStats = new ArrayList<ChampionStat>();

    private String title = "";
    private String name = "";
    private int id = 0;
    private String image;

    private int attack;
    private int magic;
    private int defense;
    private int difficulty;



    private int attackrange;
    private int manaPerLevelUp;
    private int mana;
    private int attackDamage;
    private int hpPerLevel;
    private int hp;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void getPlayerIconImageButton(ImageButton image) {
            String url = "http://ddragon.leagueoflegends.com/cdn/5.7.2/img/champion/" + this.image;
            new ImageDownloader(image).execute(url);
    }
    public void getPlayerIconImageView(ImageView image) {
        String url = "http://ddragon.leagueoflegends.com/cdn/5.7.2/img/champion/" + this.image;
        new ImageDownloader(image).execute(url);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

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

}


