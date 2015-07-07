package ch.berufsbildungscenter.leagueofstats.listener;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import ch.berufsbildungscenter.leagueofstats.FavoritSummonerActivity;
import ch.berufsbildungscenter.leagueofstats.FavoritSummonerAdapter;
import ch.berufsbildungscenter.leagueofstats.FindSummonerActivity;
import ch.berufsbildungscenter.leagueofstats.SummonerActivity;
import ch.berufsbildungscenter.leagueofstats.json.SummonerIDLoader;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by Phong6 on 27.06.2015.
 */
public class FavoritSummonerListener implements AdapterView.OnItemClickListener {

    private Context context;
    private ProgressDialog mDialog;

    public FavoritSummonerListener(Context context) {
        this.context = context;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FavoritSummonerAdapter favoritSummonerAdapter = (FavoritSummonerAdapter) parent.getAdapter();
        Summoner summoner = favoritSummonerAdapter.getItem(position);

        mDialog = ProgressDialog.show(context, "Please wait", "Searching Summoner...");

        SummonerIDLoader summonerIDLoader = new SummonerIDLoader((FavoritSummonerActivity) context, mDialog, this);
        summonerIDLoader.execute(summoner.getRegion(), summoner.getName());

    }
    public void startActivity(Summoner summoner){
        Intent intent = new Intent(context, SummonerActivity.class);
        intent.putExtra("summonerId", summoner.getId());
        intent.putExtra("summonerLevel", summoner.getSummonerLevel());
        intent.putExtra("profileIconId", summoner.getProfileIconId());
        intent.putExtra("region", summoner.getRegion());
        intent.putExtra("summonerName", summoner.getName());
        context.startActivity(intent);
        mDialog.dismiss();
    }

}
