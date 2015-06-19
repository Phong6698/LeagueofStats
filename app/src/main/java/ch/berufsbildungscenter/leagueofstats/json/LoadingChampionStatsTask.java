package ch.berufsbildungscenter.leagueofstats.json;

import android.app.ProgressDialog;
import android.content.Context;

import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.model.ChampionData;

/**
 * Created by zkillt on 19.06.2015.
 */
public class LoadingChampionStatsTask extends JsonLoadingTask{

    public LoadingChampionStatsTask(Context activity, ProgressDialog mDialog) {
        super(activity, mDialog);
    }

    @Override
    protected Object onCostumPostExecute(String jsonString) {
        ArrayList<ChampionData> champions = jsonParser.getAllChampions(jsonString);
        return champions;
    }
}
