package ch.berufsbildungscenter.leagueofstats.listener;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import ch.berufsbildungscenter.leagueofstats.ChampionStatsActivity;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;
import ch.berufsbildungscenter.leagueofstats.model.InGameSummoner;

/**
 * Created by zpengc on 08.07.2015.
 */
public class InGameChampionListener implements View.OnClickListener {

    private static final String LOG_TAG = InGameChampionListener.class.getCanonicalName();

    private Context context;
    private InGameSummoner inGameSummoner;

    public InGameChampionListener(Context context, InGameSummoner inGameSummoner){
        this.context = context;
        this.inGameSummoner = inGameSummoner;

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, ChampionStatsActivity.class);
        Log.e(LOG_TAG, "name: " + inGameSummoner.getChampionName());
        intent.putExtra("championId", inGameSummoner.getPlayingChampionId());
        intent.putExtra("championName", inGameSummoner.getChampionName());
        intent.putExtra("image", inGameSummoner.getSummonerImage());
        context.startActivity(intent);
    }
}
