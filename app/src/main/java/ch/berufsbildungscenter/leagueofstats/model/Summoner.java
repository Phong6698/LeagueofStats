package ch.berufsbildungscenter.leagueofstats.model;

import java.util.ArrayList;

/**
 * Created by zpengc on 18.06.2015.
 */
public class Summoner {
    private String name;
    private int id;
    private int summonerLevel;
    private int profileIconId;
    private String region = "euw";
    private ArrayList<SummonerRanked> summonerRankeds = new ArrayList<>();



    public ArrayList<SummonerRanked> getSummonerRankeds() {
        return summonerRankeds;
    }

    public void setSummonerRankeds(ArrayList<SummonerRanked> summonerRankeds) {
        this.summonerRankeds = summonerRankeds;
    }


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int wins;
}
