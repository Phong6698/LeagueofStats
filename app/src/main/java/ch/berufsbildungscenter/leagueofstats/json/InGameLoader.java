package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Phong6 on 07.07.2015.
 */
public class InGameLoader extends JsonLoadingTask{


    public InGameLoader(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {

    }

    @Override
    protected URL createURL(String... params) {
        String region = params[0];
        String summonerName = params[1];
        URL url = null;
        try {
            url = new URL("https://"+region.toLowerCase()+".api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/"+region.toLowerCase()+"1/"+summonerName.replaceAll("\\s+", "%20")+"?api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
