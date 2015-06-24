package ch.berufsbildungscenter.leagueofstats;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.json.LoadingChampionStatsTask;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;


public class ChampionStatsActivity extends ActionBarActivity {

    private URL url;
    private ProgressDialog mDialog;
    private ArrayList<ChampionData> championDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_stats);

        Intent intent = getIntent();

        int championId = intent.getIntExtra("championId", -1);
        String titleName = intent.getStringExtra("championName");
        Log.e("ChampStatActicity", "champID: " + championId);
        setTitle(titleName);

        mDialog = ProgressDialog.show(this, titleName, "Stats are loading...");

        try {
            url = new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/" + championId + "?champData=all&api_key=53ee3303-7114-413e-af65-3a767e515436");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        LoadingChampionStatsTask loadingChampionStatsTask = new LoadingChampionStatsTask(this, mDialog );
        loadingChampionStatsTask.execute(url);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_champion_stats, menu);
        return true;
    }

    public void setData(ChampionData champion) {

        ProgressBar adBar  = (ProgressBar) findViewById(R.id.ad_bar);
        ProgressBar apBar  = (ProgressBar) findViewById(R.id.ap_bar);
        ProgressBar defBar  = (ProgressBar) findViewById(R.id.def_bar);
        ProgressBar diffBar  = (ProgressBar) findViewById(R.id.difficulty_bar);

        adBar.setProgress(champion.getAttack());
        apBar.setProgress(champion.getMagic());
        defBar.setProgress(champion.getDefense());
        diffBar.setProgress(champion.getDifficulty());

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
}
