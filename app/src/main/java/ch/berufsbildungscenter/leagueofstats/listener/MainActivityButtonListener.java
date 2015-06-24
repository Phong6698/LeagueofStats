package ch.berufsbildungscenter.leagueofstats.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import ch.berufsbildungscenter.leagueofstats.AllChampionsActivity;
import ch.berufsbildungscenter.leagueofstats.FavoritSummonerActivity;
import ch.berufsbildungscenter.leagueofstats.FreeToPlayChampionsActivity;
import ch.berufsbildungscenter.leagueofstats.R;

/**
 * Created by zpengc on 17.06.2015.
 */
public class MainActivityButtonListener implements View.OnClickListener {

    private Context context;

    public MainActivityButtonListener(Context context){
        this.setContext(context);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.free_to_play_btn){
            Intent intent = new Intent(context, FreeToPlayChampionsActivity.class);
            context.startActivity(intent);
        } else if(v.getId() == R.id.champions_btn) {
            Intent intent = new Intent(context, AllChampionsActivity.class);
            context.startActivity(intent);
        } else if(v.getId() == R.id.items_btn) {

        }else if(v.getId() == R.id.favoritSummoners_btn) {
            Intent intent = new Intent(context, FavoritSummonerActivity.class);
            context.startActivity(intent);
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
