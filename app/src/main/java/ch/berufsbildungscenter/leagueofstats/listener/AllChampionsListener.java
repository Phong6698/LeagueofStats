package ch.berufsbildungscenter.leagueofstats.listener;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import ch.berufsbildungscenter.leagueofstats.ChampionStatsActivity;

/**
 * Created by zkillt on 24.06.2015.
 */
public class AllChampionsListener implements View.OnClickListener {

    private static final String LOG_TAG = AllChampionsListener.class.getCanonicalName();



    private Context context;
    private int championId;
    private String name;

    public AllChampionsListener(Context context, int id, String champName){
        this.setContext(context);
        this.setChampionId(id);
        this.setName(champName);
    }

    @Override
    public void onClick(View v) {
            Intent intent = new Intent(context, ChampionStatsActivity.class);
            Log.e(LOG_TAG, "name: " + name);
            intent.putExtra("championId", championId);
            intent.putExtra("championName", name);
            context.startActivity(intent);
    }

    public Context getContext() {
            return context;
        }

    public void setContext(Context context) {
            this.context = context;
        }


    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
