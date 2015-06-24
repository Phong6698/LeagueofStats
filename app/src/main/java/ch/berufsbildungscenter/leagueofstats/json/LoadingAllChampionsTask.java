package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.AllChampionsActivity;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;

/**
 * Created by zpengc on 19.06.2015.
 */
public class LoadingAllChampionsTask extends JsonLoadingTask {

    private AllChampionsActivity allChampionsActivity;

    public LoadingAllChampionsTask(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        allChampionsActivity = (AllChampionsActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        ArrayList<ChampionData> champions = jsonParser.getAllChampions(jsonString);
        allChampionsActivity.setData(champions);
        mDialog.dismiss();
    }
}
