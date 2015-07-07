package ch.berufsbildungscenter.leagueofstats.model;

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
