package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;


import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.R;
import ch.berufsbildungscenter.leagueofstats.SummonerActivity;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by zpengc on 18.06.2015.
 */
public class LoadingSummonerIDTask extends JsonLoadingTask {

    private URL url;

    private SummonerActivity summonerActivity;

    public LoadingSummonerIDTask(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        summonerActivity = (SummonerActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        Summoner summoner = jsonParser.getSummonerIDByString(jsonString);
        int summonerId = summoner.getId();
//        try {
//            url = new URL("https://euw.api.pvp.net/api/lol/euw/v1.3/stats/by-summoner/"+summonerId+"/summary?season=SEASON2015&api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        LoadingSummonerStatsTask loadingSummonerStatsTask = new LoadingSummonerStatsTask(activity, mDialog, summoner);
//        loadingSummonerStatsTask.execute(url);
//
//        summoner = (Summoner) loadingSummonerStatsTask.getObject();

        summonerActivity.setData(summoner);

        mDialog.dismiss();












    }
}
