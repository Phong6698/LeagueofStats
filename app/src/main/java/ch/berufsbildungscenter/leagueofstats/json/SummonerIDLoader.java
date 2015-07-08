package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;


import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.SummonerActivity;
import ch.berufsbildungscenter.leagueofstats.listener.FavoritSummonerListener;
import ch.berufsbildungscenter.leagueofstats.listener.FindSummonerActivityButtonListener;
import ch.berufsbildungscenter.leagueofstats.listener.InGameChampionListener;
import ch.berufsbildungscenter.leagueofstats.listener.InGameListener;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by zpengc on 18.06.2015.
 */
public class SummonerIDLoader extends JsonLoadingTask {

    private String region;
    private FindSummonerActivityButtonListener findSummonerActivityButtonListener;
    private FavoritSummonerListener favoritSummonerListener;
    private InGameListener inGameListener;

    public SummonerIDLoader(Activity activity, ProgressDialog mDialog, FindSummonerActivityButtonListener findSummonerActivityButtonListener) {
        super(activity, mDialog);
        this.findSummonerActivityButtonListener = findSummonerActivityButtonListener;

    }
    public SummonerIDLoader(Activity activity, ProgressDialog mDialog, FavoritSummonerListener favoritSummonerListener) {
        super(activity, mDialog);
        this.favoritSummonerListener = favoritSummonerListener;

    }

    public SummonerIDLoader(Activity activity, ProgressDialog mDialog, InGameListener inGameListener) {
        super(activity, mDialog);
        this.inGameListener = inGameListener;

    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        if (null == jsonString) {
            mDialog.dismiss();
            Toast.makeText(activity, "Summoner not found", Toast.LENGTH_SHORT).show();
        } else {
            Summoner summoner = jsonParser.getSummoner(jsonString);
            summoner.setRegion(region);
            if(findSummonerActivityButtonListener != null) {
                findSummonerActivityButtonListener.startActivity(summoner);
            }
            if(favoritSummonerListener != null){
                favoritSummonerListener.startActivity(summoner);
            }
            if(inGameListener != null){
                inGameListener.startActivity(summoner);
            }
        }
    }

    @Override
    protected URL createURL(String... params) {
        String summonername = params[1];
        String region = params[0];
        this.region = region;
        URL url = null;
        try {
            url = new URL("https://"+region.toLowerCase()+".api.pvp.net/api/lol/"+region.toLowerCase()+"/v1.4/summoner/by-name/"+summonername.replaceAll("\\s+", "%20")+"?api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
