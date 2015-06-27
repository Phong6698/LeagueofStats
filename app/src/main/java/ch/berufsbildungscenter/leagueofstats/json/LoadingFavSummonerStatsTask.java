package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import ch.berufsbildungscenter.leagueofstats.FavoritSummonerActivity;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by Phong6 on 27.06.2015.
 */
public class LoadingFavSummonerStatsTask extends JsonLoadingTask {

    private Summoner summoner;
    private FavoritSummonerActivity favoritSummonerActivity;

    public LoadingFavSummonerStatsTask(Activity activity, ProgressDialog mDialog, Summoner summoner) {
        super(activity, mDialog);
        this.summoner = summoner;
        favoritSummonerActivity = (FavoritSummonerActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        summoner = jsonParser.getSummonerWins(jsonString, summoner);
        favoritSummonerActivity.setData(summoner);
    }
}
