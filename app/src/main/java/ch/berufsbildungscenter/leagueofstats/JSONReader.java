package ch.berufsbildungscenter.leagueofstats;

import android.app.Activity;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class JSONReader extends Activity{

    protected static long getPlayerID(String playerName, Activity activity) {
        long id = 0;
        try {
            JSONObject jsonObject = new JSONObject(playerName);
            Iterator keys = jsonObject.keys();
            while(keys.hasNext()) {
                String key = (String) keys.next();
                JSONObject subObject = jsonObject.getJSONObject(key);
                id = subObject.getLong("id");
            }
        } catch (JSONException e) {
            Log.v("JSONReader", e.toString());
        }
        return id;
    }
}
