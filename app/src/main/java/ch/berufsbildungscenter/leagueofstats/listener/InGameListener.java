package ch.berufsbildungscenter.leagueofstats.listener;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import ch.berufsbildungscenter.leagueofstats.FavoritSummonerActivity;
import ch.berufsbildungscenter.leagueofstats.FavoritSummonerAdapter;
import ch.berufsbildungscenter.leagueofstats.InGameActivity;
import ch.berufsbildungscenter.leagueofstats.InGameAdapter;
import ch.berufsbildungscenter.leagueofstats.SummonerActivity;
import ch.berufsbildungscenter.leagueofstats.json.SummonerIDLoader;
import ch.berufsbildungscenter.leagueofstats.model.InGameSummoner;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by zpengc on 08.07.2015.
 */
public class InGameListener implements AdapterView.OnItemClickListener {

    private Context context;
    private ProgressDialog mDialog;

    public InGameListener(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("Listener", "Click");
        InGameAdapter inGameAdapter = (InGameAdapter) parent.getAdapter();
        InGameSummoner inGameSummoner = inGameAdapter.getItem(position);

        mDialog = ProgressDialog.show(context, "Please wait", "Searching Summoner...");

        SummonerIDLoader summonerIDLoader = new SummonerIDLoader((InGameActivity) context, mDialog, this);
        summonerIDLoader.execute(inGameSummoner.getRegion(), inGameSummoner.getName());
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
