package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import ch.berufsbildungscenter.leagueofstats.ChampionStatsActivity;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;

/**
 * Created by zkillt on 02.07.2015.
 */
public class LoadingChampionStatDetails extends JsonLoadingTask{

    private ChampionStatsActivity championStatsActivity;
    protected ChampionData championData;

    public LoadingChampionStatDetails(Activity activity, ProgressDialog mDialog, ChampionData championData) {
        super(activity, mDialog);
        championStatsActivity = (ChampionStatsActivity) activity;
        this.championData = championData;
    }


    @Override
    protected void onCostumPostExecute(String jsonString) {
        ChampionData champion = jsonParser.getChampionStats(jsonString, championData);
        championStatsActivity.setData(champion);

        mDialog.dismiss();
    }
}
