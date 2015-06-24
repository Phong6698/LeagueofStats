package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import ch.berufsbildungscenter.leagueofstats.FreeToPlayChampionsActivity;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;

/**
 * Created by zpengc on 24.06.2015.
 */
public class LoadingFreeToPlayChampionsByIdTask extends JsonLoadingTask{

    private FreeToPlayChampionsActivity freeToPlayChampionsActivity;

    public LoadingFreeToPlayChampionsByIdTask(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        freeToPlayChampionsActivity = (FreeToPlayChampionsActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        ChampionData championData = jsonParser.getFreeToPlayChampionById(jsonString);
        freeToPlayChampionsActivity.addFreeToPlayChampion(championData);

        freeToPlayChampionsActivity.setData();

        mDialog.dismiss();
    }
}
