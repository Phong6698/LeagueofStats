package ch.berufsbildungscenter.leagueofstats.json;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;


import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by zpengc on 18.06.2015.
 */
public class LoadingSummonerIDTask extends JsonLoadingTask {

    private URL url;

    public LoadingSummonerIDTask(Context activity, ProgressDialog mDialog) {
        super(activity, mDialog);
    }

    @Override
    protected Summoner onCostumPostExecute(String jsonString) {
        Summoner summoner = jsonParser.getSummonerIDByString(jsonString);
//        try {
//            url = new URL("https://euw.api.pvp.net/api/lol/"+region+"/v1.4/summoner/by-name/"+summoner+"?api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        LoadingSummonerIDTask loadingSummonerIDTask = new LoadingSummonerIDTask(activity, mDialog);
//        loadingSummonerIDTask.execute(url);
        mDialog.dismiss();
        Toast toast = Toast.makeText(activity, "Summoner: "+summoner.getName() + "\nID: " + summoner.getId() + "\nLevel: " + summoner.getSummonerLevel(), Toast.LENGTH_SHORT);
        toast.show();
        return summoner;


    }
}
