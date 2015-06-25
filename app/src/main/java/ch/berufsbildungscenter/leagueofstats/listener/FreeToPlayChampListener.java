package ch.berufsbildungscenter.leagueofstats.listener;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import ch.berufsbildungscenter.leagueofstats.ChampionStatsActivity;
import ch.berufsbildungscenter.leagueofstats.FreeToPlayChampionsAdapter;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;

/**
 * Created by zpengc on 25.06.2015.
 */
public class FreeToPlayChampListener implements AdapterView.OnItemClickListener {

    private static final String LOG_TAG = FreeToPlayChampListener.class.getCanonicalName();

    Context context;

    public FreeToPlayChampListener(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FreeToPlayChampionsAdapter freeToPlayChampionsAdapter = (FreeToPlayChampionsAdapter) parent.getAdapter();
        ChampionData championData = freeToPlayChampionsAdapter.getChampionData();
        Intent intent = new Intent(context, ChampionStatsActivity.class);
        Log.e(LOG_TAG, "name: " + championData.getName());
        intent.putExtra("championId", championData.getId());
        intent.putExtra("championName", championData.getName());
        context.startActivity(intent);
    }
}
