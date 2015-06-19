package ch.berufsbildungscenter.leagueofstats.json;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import ch.berufsbildungscenter.leagueofstats.model.ChampionData;
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

    public static ArrayList<ChampionData> getAllChampions(String jsonstring) {

        ArrayList<ChampionData> champions = new ArrayList<ChampionData>();
        try {
            JSONObject jsonObject = new JSONObject(jsonstring);
            JSONObject championsJsonObject = jsonObject.getJSONObject("data");
            Iterator keys = championsJsonObject.keys();
            while(keys.hasNext()) {
                ChampionData championData = new ChampionData();
                String key = (String) keys.next();
                JSONObject subObject = championsJsonObject.getJSONObject(key);
                int id = subObject.getInt("id");
                String name = subObject.getString("name");
                championData.setId(id);
                championData.setName(name);

                champions.add(championData);

                Log.e(LOG_TAG, "id: " + id);
                Log.e(LOG_TAG, "name: " + name);
            }
        } catch (JSONException e) {
            Log.v("JSONParser", e.toString());
        }
        System.out.print("DIE CHAMPIONS" + champions);
        return champions;
    }

    protected static Summoner getSummonerWins(String jsonString, Summoner summoner){
        try {
            JSONObject jsonObj = new JSONObject(jsonString);

            ArrayList<String> listdata = new ArrayList<String>();
            JSONArray jArray = (JSONArray)jsonObj.getJSONArray("playerStatSummaries");

            if (jArray != null) {
                for (int i=0;i<jArray.length();i++){
                    listdata.add(jArray.get(i).toString());
                }
            }
            String unranked = listdata.get(11);
            JSONObject unrankedObj = new JSONObject(unranked);

            int wins = unrankedObj.getInt("wins");

            Log.e(LOG_TAG, "wins: " + wins);

            summoner.setWins(wins);

        } catch (JSONException e) {
            Log.v("JSONParser", e.toString());
        }
        return summoner;
    }

    protected static Summoner getSummonerRankedStats(String jsonString, Summoner summoner) {


        try {
            JSONObject jsonObj = new JSONObject(jsonString);

            ArrayList<String> listdata = new ArrayList<String>();
            JSONArray jArray = (JSONArray)jsonObj.getJSONArray("playerStatSummaries");

            if (jArray != null) {
                for (int i=0;i<jArray.length();i++){
                    listdata.add(jArray.get(i).toString());
                }
            }
            String unranked = listdata.get(11);
            JSONObject unrankedObj = new JSONObject(unranked);

            int wins = unrankedObj.getInt("wins");

            Log.e(LOG_TAG, "wins: " + wins);

            summoner.setWins(wins);

        } catch (JSONException e) {
            Log.v("JSONParser", e.toString());
        }
        return summoner;
    }
}
