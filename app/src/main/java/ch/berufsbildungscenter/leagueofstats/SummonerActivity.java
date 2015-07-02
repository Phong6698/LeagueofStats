package ch.berufsbildungscenter.leagueofstats;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import ch.berufsbildungscenter.leagueofstats.json.SummonerIDLoader;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;
import ch.berufsbildungscenter.leagueofstats.model.SummonerRanked;


public class SummonerActivity extends ActionBarActivity implements ActionBar.TabListener {

    private String summonername;
    private String region;
    private URL url;
    private Summoner summoner;
    private Menu menu;

    private ProgressDialog mDialog;

    private static final String LOG_TAG = SummonerActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summoner);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText(R.string.summomer_gamehistory).setTabListener(this), false);
        actionBar.addTab(actionBar.newTab().setText(R.string.summoner_overview).setTabListener(this), true);
        actionBar.addTab(actionBar.newTab().setText(R.string.summoner_stats).setTabListener(this), false);



        Intent intent = getIntent();
        summonername = intent.getStringExtra("summoner");
        region = intent.getStringExtra("region");

        mDialog = ProgressDialog.show(this, "Search Summoner", "Please wait...");


        SummonerIDLoader summonerIDLoader = new SummonerIDLoader(this, mDialog, region);
        summonerIDLoader.execute(region,summonername);
    }

    public void setData(Summoner summoner){
        this.summoner = summoner;
        TextView levelTextView = (TextView)findViewById(R.id.summonerLevel);
        TextView winsTextView = (TextView)findViewById(R.id.wins);
        ImageView championIcon = (ImageView) findViewById(R.id.championIcon);

        levelTextView.setText("" + summoner.getSummonerLevel());
        winsTextView.setText("" + summoner.getWins());
        summoner.getSummonerIcon(championIcon);



        if(summoner.getSummonerLevel() ==30) {
            ArrayList<SummonerRanked> summonerRankeds = new ArrayList<SummonerRanked>();

            // add Rows
            summonerRankeds.add(summoner.getSummonerRankeds().get(0));
            summonerRankeds.add(summoner.getSummonerRankeds().get(0));
            summonerRankeds.add(summoner.getSummonerRankeds().get(0));
            // define items
            RankedAdapter rankedAdapter = new RankedAdapter(this, R.id.rankedItem, summonerRankeds);
            ListView rankedListView = (ListView) findViewById(R.id.rankedListView);
            rankedListView.setAdapter(rankedAdapter);
        }

        setTitle(summoner.getName());
        MenuItem favoriting = (MenuItem)menu.findItem(R.id.action_favoriting_summoner);
        boolean favorit = checkFavorit();

        if (favorit){
            favoriting.setIcon(R.mipmap.fav_summoner);
        }else if(!favorit){
            favoriting.setIcon(R.mipmap.unfav_summoner);
        }

        mDialog.dismiss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_summoner, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        boolean favorit = checkFavorit();
        if(item.getItemId() == R.id.action_favoriting_summoner){
            if(!favorit){
                addFavorit();
                item.setIcon(R.mipmap.fav_summoner);
                Toast toast = Toast.makeText(getApplicationContext(), "Add to Favorits", Toast.LENGTH_SHORT);
                toast.show();
            } else if(favorit){
                removeFavorit();
                item.setIcon(R.mipmap.unfav_summoner);
                Toast toast = Toast.makeText(getApplicationContext(), "Removed from Favorits", Toast.LENGTH_SHORT);
                toast.show();
            }
        } else if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean checkFavorit(){
        boolean checkFavorit = false;
        SharedPreferences favoritSummoners = getSharedPreferences("FavoritSummoners", 0);
        Map<String, ?> allEntries = favoritSummoners.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            if(!checkFavorit && ((Integer) entry.getValue()) == summoner.getId()) {
                checkFavorit = true;
            }else if(!checkFavorit && ((Integer) entry.getValue()) != summoner.getId()){
                checkFavorit = false;
            }
        }
        return checkFavorit;
    }

    public void addFavorit(){
        SharedPreferences favoritSummoners = getSharedPreferences("FavoritSummoners", 0);
        SharedPreferences.Editor editor = favoritSummoners.edit();
        int i = 1;
        while (favoritSummoners.contains("FavoritSummoner" + i)){
            i++;
        }
        editor.putInt("FavoritSummoner" + i, this.summoner.getId());
        editor.commit();
    }

    public void removeFavorit(){
        SharedPreferences favoritSummoners = getSharedPreferences("FavoritSummoners", 0);
        SharedPreferences.Editor editor = favoritSummoners.edit();
        Map<String, ?> allEntries = favoritSummoners.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            if ((Integer)entry.getValue() == summoner.getId()){
                editor.remove(entry.getKey());
                editor.commit();
            }
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (tab.getPosition() == 0) {
            Log.i(LOG_TAG, "Game History");
        } else if (tab.getPosition() == 2) {
            Log.i(LOG_TAG, "Stats");
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

}
