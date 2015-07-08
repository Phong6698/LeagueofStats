package ch.berufsbildungscenter.leagueofstats;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.net.URL;
import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.animation.ProgressBarAnimation;
import ch.berufsbildungscenter.leagueofstats.json.ChampionStatLoader;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;
import ch.berufsbildungscenter.leagueofstats.model.ChampionStat;


public class ChampionStatsActivity extends ActionBarActivity implements ActionBar.TabListener{

    private URL url;
    private ProgressDialog mDialog;
    private String image;
    private ChampionData championData;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_stats);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // changes color of action bar:
        // actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0099CC")));
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText(R.string.champion_tab_lore).setTabListener(this), false);
        actionBar.addTab(actionBar.newTab().setText(R.string.champion_tab_stats).setTabListener(this), true);

        Intent intent = getIntent();

        int championId = intent.getIntExtra("championId", -1);
        String titleName = intent.getStringExtra("championName");
        image = intent.getStringExtra("image");
        Log.e("ChampStatActicity", "champID: " + championId);
        setTitle(titleName);

        mDialog = ProgressDialog.show(this, titleName, "Stats are loading...");

        ChampionStatLoader championStatLoader = new ChampionStatLoader(this, mDialog);
        championStatLoader.execute("" + championId);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_champion_stats, menu);
        return true;
    }

    public void setData(ChampionData champion) {

        championData = champion;
        champion.setImage(image);
        ArrayList<ChampionStat> arrayList = new ArrayList<ChampionStat>();

        for(ChampionStat championStats : champion.getChampionStats()) {
            arrayList.add(championStats);
        }

        ImageView champSquare = (ImageView)findViewById(R.id.champ_square);
        champion.getChampionIconImageView(champSquare);


        ChampStatAdapter champStatAdapter = new ChampStatAdapter(this, R.id.champ_stat_item, arrayList);
        ListView champStatList = (ListView) findViewById(R.id.Champ_stat_list);
        champStatList.setAdapter(champStatAdapter);

        ProgressBar adBar  = (ProgressBar) findViewById(R.id.ad_bar);
        ProgressBar apBar  = (ProgressBar) findViewById(R.id.ap_bar);
        ProgressBar defBar  = (ProgressBar) findViewById(R.id.def_bar);
        ProgressBar diffBar  = (ProgressBar) findViewById(R.id.difficulty_bar);

        adBar.setProgress(champion.getAttack());
        apBar.setProgress(champion.getMagic());
        defBar.setProgress(champion.getDefense());
        diffBar.setProgress(champion.getDifficulty());


        // Animations NEED REFACTOR
        ProgressBarAnimation adAnim = new ProgressBarAnimation(adBar, 0, adBar.getProgress() * 100);
        adAnim.setDuration(1000);
        adBar.startAnimation(adAnim);

        ProgressBarAnimation apAnim = new ProgressBarAnimation(apBar, 0, apBar.getProgress() * 100);
        apAnim.setDuration(1000);
        apBar.startAnimation(apAnim);

        ProgressBarAnimation defAnim = new ProgressBarAnimation(defBar, 0, defBar.getProgress() * 100);
        defAnim.setDuration(1000);
        defBar.startAnimation(defAnim);

        ProgressBarAnimation diffAnim = new ProgressBarAnimation(diffBar, 0, diffBar.getProgress() * 100);
        diffAnim.setDuration(1000);
        diffBar.startAnimation(diffAnim);

        Log.v("ChampionActivity", "AD BAR: " + champion.getAttack());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        if(tab.getPosition() == 0) {
            Intent intent = new Intent(this, LoreActivity.class);
            intent.putExtra("allyTips", championData.getAllyTips());
            intent.putExtra("enemyTips", championData.getEnemyTips());
            intent.putExtra("lore", championData.getLore());
            intent.putExtra("image", championData.getImage());
            intent.putExtra("id", championData.getId());
            intent.putExtra("championName", championData.getName());
            startActivity(intent);
            Log.v("TAB 1", "Selected");
            actionBar.getTabAt(1).select();

        }
        else if(tab.getPosition() == 1) {
            Log.v("TAB 2", "Selected");
        }



    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
