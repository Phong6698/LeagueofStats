package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.FavoritSummonerActivity;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by Phong6 on 27.06.2015.
 */
public class FavSummonerStatsLoader extends JsonLoadingTask {

    private Summoner summoner;
    private FavoritSummonerActivity favoritSummonerActivity;

    public FavSummonerStatsLoader(Activity activity, ProgressDialog mDialog, Summoner summoner) {
        super(activity, mDialog);
        this.summoner = summoner;
        favoritSummonerActivity = (FavoritSummonerActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        summoner = jsonParser.getSummonerWins(jsonString, summoner);
        favoritSummonerActivity.setData(summoner);
    }

    @Override
    protected URL createURL(String... params) {
        String summonerId = params[0];
        URL url = null;
        try {
            url = new URL("https://euw.api.pvp.net/api/lol/euw/v1.3/stats/by-summoner/"+summonerId+"/summary?season=SEASON2015&api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
