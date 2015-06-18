package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class JSONParser{

    protected static int getSummonerIDByString(String jsonString) {
        int summonerID = 0;
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            Iterator keys = jsonObject.keys();
            while(keys.hasNext()) {
                String key = (String) keys.next();
                JSONObject subObject = jsonObject.getJSONObject(key);
                summonerID = subObject.getInt("id");
            }
        } catch (JSONException e) {
            Log.v("JSONParser", e.toString());
        }
        return summonerID;
    }

}
