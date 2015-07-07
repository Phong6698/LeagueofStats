package ch.berufsbildungscenter.leagueofstats.json;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import ch.berufsbildungscenter.leagueofstats.model.ChampionData;
import ch.berufsbildungscenter.leagueofstats.model.ChampionStat;
import ch.berufsbildungscenter.leagueofstats.model.InGame;
import ch.berufsbildungscenter.leagueofstats.model.InGameSummoner;
import ch.berufsbildungscenter.leagueofstats.model.Item;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;
import ch.berufsbildungscenter.leagueofstats.model.SummonerRanked;

public class JSONParser{

    private static final String LOG_TAG = JSONParser.class.getCanonicalName();

    protected static Summoner getSummoner(String jsonString) {
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
        return champions;
    }

    public static ChampionData getChampionDetails(String jsonstring) {

        ArrayList<ChampionStat> championStats = new ArrayList<ChampionStat>();
        ChampionData championsDetails = new ChampionData();
        try {
            JSONObject jsonObject = new JSONObject(jsonstring);
            JSONObject jsonInfoObj = jsonObject.getJSONObject("info");
            JSONObject jsonStatObj = jsonObject.getJSONObject("stats");
            int id = jsonObject.getInt("id");
            int ad = jsonInfoObj.getInt("attack");
            int ap = jsonInfoObj.getInt("magic");
            int defense = jsonInfoObj.getInt("defense");
            int difficulty = jsonInfoObj.getInt("difficulty");

            Iterator keys = jsonStatObj.keys();
            while(keys.hasNext()) {
                ChampionStat championStat = new ChampionStat();
                String key = (String) keys.next();
                championStat.setTitle(key);
                championStat.setStat(jsonStatObj.getInt(key));

                championStats.add(championStat);
                Log.e("Keys ", key);
                Log.e("Stat ", "" + jsonStatObj.getDouble(key));
            }

            championsDetails.setId(id);
            championsDetails.setAttack(ad);
            championsDetails.setMagic(ap);
            championsDetails.setDefense(defense);
            championsDetails.setDifficulty(difficulty);

            championsDetails.setChampionStats(championStats);


            Log.e(LOG_TAG, "Attack: " + ad);
            Log.e(LOG_TAG, "Magic: " + ap);
            Log.e(LOG_TAG, "Defense: " + defense);
            Log.e(LOG_TAG, "Difficulty: " + difficulty);
            Log.e(LOG_TAG, "ChampionStats: " + championStats);

        } catch (JSONException e) {
            Log.v("JSONParser", e.toString());
        }
        return championsDetails;
    }


    protected static Summoner getSummonerWins(String jsonString, Summoner sum){
        Summoner summoner = sum;
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


            JSONArray jArray = (JSONArray)jsonObj.getJSONArray(""+summoner.getId());
            if (jArray != null) {
                for (int i=0;i<jArray.length();i++){
                    JSONObject rankedObj = new JSONObject(jArray.get(i).toString());

                    SummonerRanked summonerRanked = new SummonerRanked();
                    summonerRanked.setName(rankedObj.getString("name"));
                    summonerRanked.setTier(rankedObj.getString("tier"));
                    summonerRanked.setQueue(rankedObj.getString("queue"));

                    JSONArray jArray2 = (JSONArray)rankedObj.getJSONArray("entries");
                    if (jArray2 != null) {
                        for (int y=0;y<jArray2.length();y++){
                            JSONObject rankedSubObj = new JSONObject(jArray2.get(y).toString());

                            summonerRanked.setDivision(rankedSubObj.getString("division"));
                            summonerRanked.setLeaguePoints(rankedSubObj.getInt("leaguePoints"));
                            summonerRanked.setWins(rankedSubObj.getInt("wins"));
                            summonerRanked.setLosses(rankedSubObj.getInt("losses"));
                        }
                    }
                    summoner.getSummonerRankeds().add(summonerRanked);

                }
            }





        } catch (JSONException e) {
            Log.v("JSONParser", e.toString());
        }
        return summoner;
    }

    protected static ArrayList getFreeToPlayChampionsId(String jsonString){
        ArrayList freeToPlayChampionsId = new ArrayList();

        try {
            JSONObject jsonObj = new JSONObject(jsonString);

            ArrayList<String> rankedList = new ArrayList<String>();
            JSONArray jArray = (JSONArray)jsonObj.getJSONArray("champions");
            if (jArray != null) {
                for (int i=0;i<jArray.length();i++){
                    JSONObject jsonObject = new JSONObject(jArray.get(i).toString());
                    Log.e(LOG_TAG, "ID: "+jsonObject.getInt("id"));
                    freeToPlayChampionsId.add(jsonObject.getInt("id"));
                }
            }

        } catch (JSONException e) {
            Log.v("JSONParser", e.toString());
        }

        return freeToPlayChampionsId;
    }

    protected static ChampionData getFreeToPlayChampionById(String jsonString){
        ChampionData championData = new ChampionData();

        try {
            JSONObject jsonObj = new JSONObject(jsonString);
            championData.setId(jsonObj.getInt("id"));
            championData.setName(jsonObj.getString("name"));

            JSONObject jsonInfoObj = jsonObj.getJSONObject("info");
            championData.setAttack(jsonInfoObj.getInt("attack"));
            championData.setMagic(jsonInfoObj.getInt("magic"));
            championData.setDefense(jsonInfoObj.getInt("defense"));
            championData.setDifficulty(jsonInfoObj.getInt("difficulty"));

            JSONObject jsonImageObj = jsonObj.getJSONObject("image");
            championData.setImage(jsonImageObj.getString("full"));

        } catch (JSONException e) {
            Log.v("JSONParser", e.toString());
        }

        return championData;
    }

    protected static ChampionData getChampionStats(String jsonString, ChampionData champion){
        ChampionData championData = champion;
        ArrayList<ChampionStat> championStats = new ArrayList<ChampionStat>();

        try {
            JSONObject jsonObj = new JSONObject(jsonString);
            JSONObject jsonStatObj = jsonObj.getJSONObject("stats");
            Iterator keys = jsonStatObj.keys();
            while(keys.hasNext()) {
                ChampionStat championStat = new ChampionStat();
                String key = (String) keys.next();
                championStat.setTitle(key);

                championStat.setStat(jsonStatObj.getDouble(key));

                championStats.add(championStat);
                Log.e("Keys", key);
                Log.e("Stat", ""+jsonStatObj.getDouble(key));
            }
            championData.setChampionStats(championStats);


        } catch (JSONException e) {
            Log.v("JSONParser", e.toString());
        }

        return championData;
    }

    protected ChampionData getLore(String jsonstring) {
        ChampionData championData = new ChampionData();
        return championData;
    }

    protected ArrayList<Item> getAllItems(String jsonString){
        ArrayList<Item> items = new ArrayList<Item>();

        try{
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject dataObj = jsonObject.getJSONObject("data");
            Iterator keys = dataObj.keys();
            while(keys.hasNext()) {
                Item item = new Item();
                String key = (String)keys.next();
                JSONObject itemObj = dataObj.getJSONObject(key);

                item.setId(itemObj.getInt("id"));
                item.setName(itemObj.getString("name"));

                items.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return items;
    }

    protected Item getItems(String jsonString){
        Item item = new Item();
        try{
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject goldObj = jsonObject.getJSONObject("gold");

            item.setId(jsonObject.getInt("id"));
            item.setName(jsonObject.getString("name"));
            item.setDescription(jsonObject.getString("description"));
            item.setGoldTotal(goldObj.getInt("total"));
            item.setGoldBase(goldObj.getInt("base"));
            item.setGoldSell(goldObj.getInt("sell"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return item;
    }

    protected InGame getInGameStats(String jsonString){
        InGame inGame = new InGame();
        try{
            JSONObject jsonObject = new JSONObject(jsonString);
            inGame.setGameMode(jsonObject.getString("gameMode"));

            JSONArray jArray = (JSONArray)jsonObject.getJSONArray("participants");
            if (jArray != null) {
                for (int i=0;i<jArray.length();i++){
                    InGameSummoner inGameSummoner = new InGameSummoner();

                    JSONObject participantObj = new JSONObject(jArray.get(i).toString());
                    inGameSummoner.setId(participantObj.getInt("summonerId"));
                    inGameSummoner.setName(participantObj.getString("summonerName"));
                    inGameSummoner.setPlayingChampionId(participantObj.getInt("championId"));
                    inGameSummoner.setSpellId1(participantObj.getInt("spell1Id"));
                    inGameSummoner.setSpellId2(participantObj.getInt("spell2Id"));
                    int teamId = participantObj.getInt("teamId");
                    inGameSummoner.setTeamId(teamId);

                    if(teamId == 100){
                        inGame.getInGameSummonersTeam1().add(inGameSummoner);
                    } else if (teamId == 200){
                        inGame.getInGameSummonersTeam2().add(inGameSummoner);
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return inGame;
    }
}
