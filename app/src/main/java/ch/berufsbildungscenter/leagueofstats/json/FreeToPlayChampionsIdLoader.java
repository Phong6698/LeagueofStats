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
public class FreeToPlayChampionsIdLoader extends JsonLoadingTask {

    FreeToPlayChampionsActivity freeToPlayChampionsActivity;

    public FreeToPlayChampionsIdLoader(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        freeToPlayChampionsActivity = (FreeToPlayChampionsActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        ArrayList<Integer> freeToPlayChampions = jsonParser.getFreeToPlayChampionsId(jsonString);


        for(int championId : freeToPlayChampions){
            URL url = null;

            FreeToPlayChampionsByIdLoader freeToPlayChampionsByIdLoader = new FreeToPlayChampionsByIdLoader(activity, mDialog);
            freeToPlayChampionsByIdLoader.execute(""+championId);
        }




    }

    @Override
    protected URL createURL(String... params) {
        URL url = null;
        try {
            url = new URL("https://euw.api.pvp.net/api/lol/euw/v1.2/champion?freeToPlay=true&api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
