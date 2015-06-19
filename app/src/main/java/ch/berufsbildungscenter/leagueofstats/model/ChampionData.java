package ch.berufsbildungscenter.leagueofstats.model;

import java.util.ArrayList;

/**
 * Created by zkillt on 18.06.2015.
 */
public class ChampionData {

    private ArrayList<ChampionStat> championStats = new ArrayList<ChampionStat>();

    private String title;
    private String name;
    private int id;

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


