package ch.berufsbildungscenter.leagueofstats.listener;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import ch.berufsbildungscenter.leagueofstats.ChampionStatsActivity;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;

/**
 * Created by zkillt on 24.06.2015.
 */
public class AllChampionsListener implements View.OnClickListener {

    private static final String LOG_TAG = AllChampionsListener.class.getCanonicalName();

    private Context context;
    private ChampionData championData;

    public AllChampionsListener(Context context, ChampionData championData){
        this.setContext(context);
        this.setChampionData(championData);

    }

    @Override
    public void onClick(View v) {
            Intent intent = new Intent(context, ChampionStatsActivity.class);
            Log.e(LOG_TAG, "name: " + championData.getName());
            intent.putExtra("championId", championData.getId());
            intent.putExtra("championName", championData.getName());
            intent.putExtra("image", championData.getImage());
            context.startActivity(intent);
    }

    public Context getContext() {
            return context;
        }

    public void setContext(Context context) {
            this.context = context;
        }


    public ChampionData getChampionData() {
        return championData;
    }

    public void setChampionData(ChampionData championData) {
        this.championData = championData;
    }


}
