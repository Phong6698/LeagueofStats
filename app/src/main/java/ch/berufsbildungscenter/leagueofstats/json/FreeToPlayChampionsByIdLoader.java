package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.FreeToPlayChampionsActivity;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;

/**
 * Created by zpengc on 24.06.2015.
 */
public class FreeToPlayChampionsByIdLoader extends JsonLoadingTask{

    private FreeToPlayChampionsActivity freeToPlayChampionsActivity;

    public FreeToPlayChampionsByIdLoader(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        freeToPlayChampionsActivity = (FreeToPlayChampionsActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        ChampionData championData = jsonParser.getFreeToPlayChampionById(jsonString);
        freeToPlayChampionsActivity.addFreeToPlayChampion(championData);
        freeToPlayChampionsActivity.setData();

    }

    @Override
    protected URL createURL(String... params) {
        String championId = params[0];
        URL url = null;
        try {
            url = new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+championId+"?champData=all&api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
