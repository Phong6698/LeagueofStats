package ch.berufsbildungscenter.leagueofstats;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import ch.berufsbildungscenter.leagueofstats.json.FavSummonerLoader;
import ch.berufsbildungscenter.leagueofstats.listener.FavoritSummonerListener;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;


public class FavoritSummonerActivity extends ActionBarActivity {

    private ProgressDialog mDialog;
    private URL url;
    private ArrayList<Summoner> favoritSummoner;
    private int favSummonerNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit_summoner);

        ListView listview = (ListView) findViewById(R.id.favSummonerListView);
        if (listview.getCount() != 0) {
            TextView nofavorites = (TextView) findViewById(R.id.noFavoritesText);
            nofavorites.setVisibility(View.INVISIBLE);
        }
        favoritSummoner = new ArrayList<Summoner>();

        mDialog = ProgressDialog.show(this, "Please wait", "Loading Favorit Summoners...");
        showFavoritSummoners();

    }

    public void showFavoritSummoners(){

        SharedPreferences favoritSummoners = getSharedPreferences("FavoritSummoners", 0);
        Map<String, ?> allEntries = favoritSummoners.getAll();
        favSummonerNumber = allEntries.size();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            TextView noFavoritesText = (TextView) findViewById(R.id.noFavoritesText);
            noFavoritesText.setVisibility(View.INVISIBLE);

            FavSummonerLoader favSummonerLoader = new FavSummonerLoader(this, mDialog);
            favSummonerLoader.execute(""+entry.getValue());
        }

        if(favSummonerNumber == 0){
            mDialog.dismiss();
            Toast toast = Toast.makeText(getApplicationContext(), "You don't have any favorit Summoner", Toast.LENGTH_SHORT);
            toast.show();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_favorit_summoner, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if(item.getItemId() == R.id.action_search_summoner){
            Intent intent = new Intent(this, FindSummonerActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_settings) {//noinspection SimplifiableIfStatement
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setData(Summoner summoner) {
        favoritSummoner.add(summoner);
        if(favSummonerNumber == favoritSummoner.size()){


            FavoritSummonerAdapter favoritSummonerAdapter = new FavoritSummonerAdapter(this, R.id.freeToPlayChampItem, favoritSummoner);
            ListView favSummonerListView = (ListView) findViewById(R.id.favSummonerListView);
            favSummonerListView.setAdapter(favoritSummonerAdapter);

            favSummonerListView.setOnItemClickListener(new FavoritSummonerListener(this));
            favSummonerListView.setItemsCanFocus(true);

            mDialog.dismiss();


        }
    }
}
