package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import ch.berufsbildungscenter.leagueofstats.model.Summoner;

public class JSONParser{

    private static final String LOG_TAG = JSONParser.class.getCanonicalName();

    protected static Summoner getSummonerIDByString(String jsonString) {
        Summoner summoner = new Summoner();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            Iterator keys = jsonObject.keys();
            while(keys.hasNext()) {
                String key = (String) keys.next();
                JSONObject subObject = jsonObject.getJSONObject(key);
                int id = subObject.getInt("id");
                String name = subObject.getString("name");
                int summonerLevel = subObject.getInt("summonerLevel");
                int profileIconId = subObject.getInt("profileIconId");
                summoner.setId(id);
                summoner.setName(name);
                summoner.setSummonerLevel(summonerLevel);
                summoner.setProfileIconId(profileIconId);

                Log.e(LOG_TAG, "id: " + id);
                Log.e(LOG_TAG, "name: " + name);
                Log.e(LOG_TAG, "summonerLevel: " + summonerLevel);
                Log.e(LOG_TAG, "profileIconId: " +profileIconId);



            }
        } catch (JSONException e) {
            Log.v("JSONParser", e.toString());
        }
        return summoner;
    }

}
