package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.SummonerActivity;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by zpengc on 19.06.2015.
 */
public class SummonerRankedStatsLoader extends JsonLoadingTask{

    private Summoner summoner;
    private SummonerActivity summonerActivity;

    public SummonerRankedStatsLoader(Activity activity, ProgressDialog mDialog, Summoner summoner) {
        super(activity, mDialog);
        this.summoner = summoner;
        this.summonerActivity = (SummonerActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {

        summoner = jsonParser.getSummonerRankedStats(jsonString, summoner);

        summonerActivity.setData(summoner);


    }

    @Override
    protected URL createURL(String... params) {
        String summonerId = params[0];
        String region = params[1];
        URL url = null;
        try {
            url = new URL("https://"+region.toLowerCase()+".api.pvp.net/api/lol/"+region.toLowerCase()+"/v2.5/league/by-summoner/" + summonerId + "/entry?api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
