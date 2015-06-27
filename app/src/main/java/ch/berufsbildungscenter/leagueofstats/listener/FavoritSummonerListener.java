package ch.berufsbildungscenter.leagueofstats.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import ch.berufsbildungscenter.leagueofstats.FavoritSummonerAdapter;
import ch.berufsbildungscenter.leagueofstats.SummonerActivity;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by Phong6 on 27.06.2015.
 */
public class FavoritSummonerListener implements AdapterView.OnItemClickListener {

    private Context context;

    public FavoritSummonerListener(Context context) {
        this.context = context;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FavoritSummonerAdapter favoritSummonerAdapter = (FavoritSummonerAdapter) parent.getAdapter();
        Summoner summoner = favoritSummonerAdapter.getItem(position);
        Intent intent = new Intent(context, SummonerActivity.class);
        intent.putExtra("summoner", summoner.getName());
        intent.putExtra("region", summoner.getRegion());
        context.startActivity(intent);
    }
}
