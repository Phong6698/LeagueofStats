package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;


import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.SummonerActivity;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by zpengc on 18.06.2015.
 */
public class SummonerIDLoader extends JsonLoadingTask {

    private URL url;
    private String region;
    private SummonerActivity summonerActivity;

    public SummonerIDLoader(Activity activity, ProgressDialog mDialog, String region) {
        super(activity, mDialog);
        summonerActivity = (SummonerActivity) activity;
        this.region = region;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        Summoner summoner = jsonParser.getSummoner(jsonString);
        summoner.setRegion(region);
        int summonerId = summoner.getId();

        SummonerStatsLoader summonerStatsLoader = new SummonerStatsLoader(activity, mDialog, summoner);
        summonerStatsLoader.execute(region, ""+summonerId);

    }

    @Override
    protected URL createURL(String... params) {
        String summonername = params[1];
        String region = params[0];

        URL url = null;
        try {
            url = new URL("https://euw.api.pvp.net/api/lol/"+region+"/v1.4/summoner/by-name/"+summonername.replaceAll("\\s+", "%20")+"?api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
