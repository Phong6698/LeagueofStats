package ch.berufsbildungscenter.leagueofstats.model;

import android.util.Log;
import android.widget.ImageButton;

import ch.berufsbildungscenter.leagueofstats.ImageDownloader;

/**
 * Created by Phong6 on 07.07.2015.
 */
public class InGameSummoner {

    private String name;
    private int id;
    private int playingChampionId;
    private int spellId1;
    private int spellId2;
    private int teamId;
    private String summonerImage;

    public void getChampionIconImageButton(ImageButton image) {
        Log.e("Image", "Image: " + this.summonerImage);
        String url = "http://ddragon.leagueoflegends.com/cdn/5.12.1/img/champion/" + this.summonerImage;
        new ImageDownloader(image).execute(url);
    }

    public String getSummonerImage() {
        return summonerImage;
    }

    public void setSummonerImage(String summonerImage) {
        this.summonerImage = summonerImage;
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

    public int getPlayingChampionId() {
        return playingChampionId;
    }

    public void setPlayingChampionId(int playingChampionId) {
        this.playingChampionId = playingChampionId;
    }

    public int getSpellId1() {
        return spellId1;
    }

    public void setSpellId1(int spellId1) {
        this.spellId1 = spellId1;
    }

    public int getSpellId2() {
        return spellId2;
    }

    public void setSpellId2(int spellId2) {
        this.spellId2 = spellId2;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
