package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by zkillt on 19.06.2015.
 */
public class LoadingChampionStatsTask extends JsonLoadingTask{

    public LoadingChampionStatsTask(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
    }


    @Override
    protected void onCostumPostExecute(String jsonString) {

    }
}
