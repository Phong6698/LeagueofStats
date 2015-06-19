package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by zpengc on 18.06.2015.
 */
public class LoadingSummonerStatsTask extends JsonLoadingTask {

    private Summoner summoner;

    public LoadingSummonerStatsTask(Activity activity, ProgressDialog mDialog, Summoner summoner) {
        super(activity, mDialog);
        this.summoner = summoner;

    }

    @Override
    protected void onCostumPostExecute(String jsonString) {

        mDialog.dismiss();

    }
}
