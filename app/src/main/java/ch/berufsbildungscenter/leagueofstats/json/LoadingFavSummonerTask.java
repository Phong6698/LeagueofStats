package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.FavoritSummonerActivity;
import ch.berufsbildungscenter.leagueofstats.SummonerActivity;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by Phong6 on 27.06.2015.
 */
public class LoadingFavSummonerTask extends JsonLoadingTask {

    private Summoner summoner;
    private FavoritSummonerActivity favoritSummonerActivity;
    private URL url;

    public LoadingFavSummonerTask(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        favoritSummonerActivity = (FavoritSummonerActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        summoner = jsonParser.getSummonerIDByString(jsonString);
        int summonerId = summoner.getId();
        try {
            url = new URL("https://euw.api.pvp.net/api/lol/euw/v1.3/stats/by-summoner/"+summonerId+"/summary?season=SEASON2015&api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        LoadingFavSummonerStatsTask loadingFavSummonerStatsTask = new LoadingFavSummonerStatsTask(activity, mDialog, summoner);
        loadingFavSummonerStatsTask.execute(url);
    }
}
