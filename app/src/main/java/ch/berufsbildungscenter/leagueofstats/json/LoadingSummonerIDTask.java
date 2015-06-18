package ch.berufsbildungscenter.leagueofstats.json;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by zpengc on 18.06.2015.
 */
public class LoadingSummonerIDTask extends JsonLoadingTask {


    public LoadingSummonerIDTask(Context activity, ProgressDialog mDialog) {
        super(activity, mDialog);
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        int summonerID = jsonParser.getSummonerIDByString(jsonString);
        mDialog.dismiss();
    }
}
