package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.InGameActivity;
import ch.berufsbildungscenter.leagueofstats.model.InGame;

/**
 * Created by Phong6 on 07.07.2015.
 */
public class InGameLoader extends JsonLoadingTask{

    private InGameActivity inGameActivity;

    public InGameLoader(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        this.inGameActivity = (InGameActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        InGame inGame = jsonParser.getInGameStats(jsonString);
        inGameActivity.setData(inGame);
    }

    @Override
    protected URL createURL(String... params) {
        String region = params[0];
        String summonerId = params[1];
        URL url = null;
        try {
            url = new URL("https://"+region.toLowerCase()+".api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/"+region.toUpperCase()+"1/"+summonerId+"?api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
