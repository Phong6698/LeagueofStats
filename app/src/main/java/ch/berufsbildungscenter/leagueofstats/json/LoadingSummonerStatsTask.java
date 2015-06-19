package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.SummonerActivity;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by zpengc on 18.06.2015.
 */
public class LoadingSummonerStatsTask extends JsonLoadingTask {

    private URL url;

    private Summoner summoner;
    private SummonerActivity summonerActivity;

    public LoadingSummonerStatsTask(Activity activity, ProgressDialog mDialog, Summoner summoner) {
        super(activity, mDialog);
        this.summoner = summoner;
        this.summonerActivity = (SummonerActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        summoner = jsonParser.getSummonerWins(jsonString, summoner);

        int summonerId = summoner.getId();
        try {
            url = new URL("https://euw.api.pvp.net/api/lol/euw/v2.5/league/by-summoner/"+summonerId+"/entry?api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        LoadingSummonerRankedStatsTask loadingSummonerRankedStatsTask = new LoadingSummonerRankedStatsTask(activity, mDialog, summoner);
        loadingSummonerRankedStatsTask.execute(url);


    }
}
