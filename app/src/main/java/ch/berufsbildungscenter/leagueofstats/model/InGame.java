package ch.berufsbildungscenter.leagueofstats.model;

import java.util.ArrayList;

/**
 * Created by Phong6 on 07.07.2015.
 */
public class InGame {

    private String gameMode;
    private ArrayList<InGameSummoner> inGameSummonersTeam1 = new ArrayList<InGameSummoner>();
    private ArrayList<InGameSummoner> inGameSummonersTeam2 = new ArrayList<InGameSummoner>();

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public ArrayList<InGameSummoner> getInGameSummonersTeam1() {
        return inGameSummonersTeam1;
    }

    public void setInGameSummonersTeam1(ArrayList<InGameSummoner> inGameSummonersTeam1) {
        this.inGameSummonersTeam1 = inGameSummonersTeam1;
    }

    public ArrayList<InGameSummoner> getInGameSummonersTeam2() {
        return inGameSummonersTeam2;
    }

    public void setInGameSummonersTeam2(ArrayList<InGameSummoner> inGameSummonersTeam2) {
        this.inGameSummonersTeam2 = inGameSummonersTeam2;
    }
}
