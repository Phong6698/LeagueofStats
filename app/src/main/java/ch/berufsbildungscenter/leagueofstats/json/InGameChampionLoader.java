package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.InGameActivity;
import ch.berufsbildungscenter.leagueofstats.model.InGame;
import ch.berufsbildungscenter.leagueofstats.model.InGameSummoner;

/**
 * Created by zpengc on 08.07.2015.
 */
public class InGameChampionLoader extends JsonLoadingTask {

    private InGameActivity inGameActivity;
    private InGame inGame;
    private InGameSummoner inGameSummoner;

    public InGameChampionLoader(Activity activity, ProgressDialog mDialog, InGame inGame, InGameSummoner inGameSummoner) {
        super(activity, mDialog);
        this.inGameActivity = (InGameActivity) activity;
        this.inGame = inGame;
        this.inGameSummoner = inGameSummoner;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {

        InGameSummoner inGameSummoner = jsonParser.getInGameChampion(jsonString, this.inGameSummoner);

        inGameActivity.setData(inGameSummoner, inGame);
    }

    @Override
    protected URL createURL(String... params) {
        String championId = params[0];
        URL url = null;
        try {
            url = new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+championId+"?champData=image&api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
