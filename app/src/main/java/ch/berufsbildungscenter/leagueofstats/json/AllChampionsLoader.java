package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.AllChampionsActivity;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;

/**
 * Created by zpengc on 19.06.2015.
 */
public class AllChampionsLoader extends JsonLoadingTask {

    private AllChampionsActivity allChampionsActivity;

    public AllChampionsLoader(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        allChampionsActivity = (AllChampionsActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        ArrayList<ChampionData> champions = jsonParser.getAllChampions(jsonString);
        allChampionsActivity.setData(champions);
        mDialog.dismiss();
    }

    @Override
    protected URL createURL(String... params) {
        URL url = null;
        try {
            url = new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion?champData=image&api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }
}
