package ch.berufsbildungscenter.leagueofstats.json;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import ch.berufsbildungscenter.leagueofstats.model.ChampionData;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;
import ch.berufsbildungscenter.leagueofstats.model.SummonerRanked;

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

                JSONObject subImageObject = subObject.getJSONObject("image");
                String image = subImageObject.getString("full");
                championData.setImage(image);


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

            int wins = 0;

            if (jArray != null) {
                for (int i=0;i<jArray.length();i++){
                    JSONObject unrankedObj = new JSONObject(jArray.get(i).toString());
                    if(unrankedObj.getString("playerStatSummaryType").equals("Unranked")){
                        wins = unrankedObj.getInt("wins");
                    }
                }
            }

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

            ArrayList<String> rankedList = new ArrayList<String>();
            JSONArray jArray = (JSONArray)jsonObj.getJSONArray(""+summoner.getId());
            if (jArray != null) {
                for (int i=0;i<jArray.length();i++){
                    rankedList.add(jArray.get(i).toString());
                }
            }
            String ranked = rankedList.get(0);
            JSONObject rankedObj = new JSONObject(ranked);


            ArrayList<String> rankedSubList = new ArrayList<String>();
            JSONArray jArray2 = (JSONArray)rankedObj.getJSONArray("entries");
            if (jArray2 != null) {
                for (int i=0;i<jArray2.length();i++){
                    rankedSubList.add(jArray2.get(i).toString());
                }
            }
            String rankedSub = rankedSubList.get(0);
            JSONObject rankedSubObj = new JSONObject(rankedSub);

            SummonerRanked summonerRanked = new SummonerRanked();

            summonerRanked.setName(rankedObj.getString("name"));
            summonerRanked.setTier(rankedObj.getString("tier"));
            summonerRanked.setQueue(rankedObj.getString("queue"));

            summonerRanked.setDivision(rankedSubObj.getString("division"));
            summonerRanked.setLeaguePoints(rankedSubObj.getInt("leaguePoints"));
            summonerRanked.setWins(rankedSubObj.getInt("wins"));
            summonerRanked.setLosses(rankedSubObj.getInt("losses"));

            summoner.getSummonerRankeds().add(summonerRanked);

        } catch (JSONException e) {
            Log.v("JSONParser", e.toString());
        }
        return summoner;
    }
}
