package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import ch.berufsbildungscenter.leagueofstats.ChampionStatsActivity;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;

/**
 * Created by zkillt on 19.06.2015.
 */
public class LoadingChampionStatsTask extends JsonLoadingTask{

    private ChampionStatsActivity championStatsActivity;

    public LoadingChampionStatsTask(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        championStatsActivity = (ChampionStatsActivity) activity;

    }


    @Override
    protected void onCostumPostExecute(String jsonString) {
        ChampionData champion = jsonParser.getChampionDetails(jsonString);
        championStatsActivity.setData(champion);
        mDialog.dismiss();
    }
}
