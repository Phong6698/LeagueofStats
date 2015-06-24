package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.FreeToPlayChampionsActivity;

/**
 * Created by zpengc on 24.06.2015.
 */
public class LoadingFreeToPlayChampionsIdTask extends JsonLoadingTask {

    FreeToPlayChampionsActivity freeToPlayChampionsActivity;

    public LoadingFreeToPlayChampionsIdTask(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        freeToPlayChampionsActivity = (FreeToPlayChampionsActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        ArrayList<Integer> freeToPlayChampions = jsonParser.getFreeToPlayChampionsId(jsonString);


        for(int championId : freeToPlayChampions){
            URL url = null;
            try {
                url = new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+championId+"?champData=all&api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            LoadingFreeToPlayChampionsByIdTask loadingFreeToPlayChampionsByIdTask = new LoadingFreeToPlayChampionsByIdTask(activity, mDialog);
            loadingFreeToPlayChampionsByIdTask.execute(url);
        }




    }
}
