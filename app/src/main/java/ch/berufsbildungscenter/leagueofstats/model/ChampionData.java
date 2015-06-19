package ch.berufsbildungscenter.leagueofstats.model;

import android.widget.ImageView;

import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.ImageDownloader;

/**
 * Created by zkillt on 18.06.2015.
 */
public class ChampionData {

    private ArrayList<ChampionStat> championStats = new ArrayList<ChampionStat>();

    private String title = "NAME";
    private String name = "NAME";
    private int id = 1234;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void getPlayerIcon(ImageView image) {
        String url = "http://ddragon.leagueoflegends.com/cdn/5.7.2/img/champion/" + this.image;
        new ImageDownloader(image).execute(url);
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


