package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import ch.berufsbildungscenter.leagueofstats.SummonerActivity;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by zpengc on 19.06.2015.
 */
public class LoadingSummonerRankedStatsTask extends JsonLoadingTask{

    private Summoner summoner;
    private SummonerActivity summonerActivity;

    public LoadingSummonerRankedStatsTask(Activity activity, ProgressDialog mDialog, Summoner summoner) {
        super(activity, mDialog);
        this.summoner = summoner;
        this.summonerActivity = (SummonerActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {

        summoner = jsonParser.getSummonerRankedStats(jsonString, summoner);

        summonerActivity.setData(summoner);

        mDialog.dismiss();
    }
}
