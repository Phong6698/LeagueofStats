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
public class FavSummonerLoader extends JsonLoadingTask {

    private Summoner summoner;
    private FavoritSummonerActivity favoritSummonerActivity;
    private URL url;

    public FavSummonerLoader(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        favoritSummonerActivity = (FavoritSummonerActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        summoner = jsonParser.getSummoner(jsonString);
        int summonerId = summoner.getId();
        FavSummonerStatsLoader favSummonerStatsLoader = new FavSummonerStatsLoader(activity, mDialog, summoner);
        favSummonerStatsLoader.execute(""+summonerId);
    }

    @Override
    protected URL createURL(String... params) {
        String summonerId = params[0];
        URL url = null;
        try {
            url = new URL("https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/"+summonerId +"?api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
