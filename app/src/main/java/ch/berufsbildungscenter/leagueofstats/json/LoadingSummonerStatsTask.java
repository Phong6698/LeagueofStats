package ch.berufsbildungscenter.leagueofstats.json;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by zpengc on 18.06.2015.
 */
public class LoadingSummonerStatsTask extends JsonLoadingTask {

    public LoadingSummonerStatsTask(Context activity, ProgressDialog mDialog) {
        super(activity, mDialog);
    }

    @Override
    protected Object onCostumPostExecute(String jsonString) {

        mDialog.dismiss();
        return null;
    }
}
