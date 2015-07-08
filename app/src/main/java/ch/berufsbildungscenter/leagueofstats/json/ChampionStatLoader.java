package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.ChampionStatsActivity;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;

/**
 * Created by zkillt on 02.07.2015.
 */
public class ChampionStatLoader extends JsonLoadingTask{

    private ChampionStatsActivity championStatsActivity;


    public ChampionStatLoader(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        championStatsActivity = (ChampionStatsActivity) activity;
    }


    @Override
    protected void onCostumPostExecute(String jsonString) {
        ChampionData champion = jsonParser.getChampionDetails(jsonString);
        championStatsActivity.setData(champion);
        Log.e("Name Details: ", champion.getName().toString());
        mDialog.dismiss();
    }

    @Override
    protected URL createURL(String... params) {
        String championId = params[0];
        URL url = null;
        try {
            url = new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/" + championId + "?champData=allytips,enemytips,info,lore,stats&api_key=53ee3303-7114-413e-af65-3a767e515436");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
