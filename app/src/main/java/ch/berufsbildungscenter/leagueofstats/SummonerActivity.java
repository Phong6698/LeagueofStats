package ch.berufsbildungscenter.leagueofstats;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.json.LoadingSummonerIDTask;


public class SummonerActivity extends ActionBarActivity {

    private String summoner;
    private String region;
    private URL url;

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summoner);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        summoner = intent.getStringExtra("summoner");
        region = intent.getStringExtra("region");

        mDialog = ProgressDialog.show(this, "Search Summoner", "Please wait...");

        try {
            url = new URL("https://euw.api.pvp.net/api/lol/"+region+"/v1.4/summoner/by-name/"+summoner+"?api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        LoadingSummonerIDTask loadingSummonerIDTask = new LoadingSummonerIDTask(this, mDialog);
        loadingSummonerIDTask.execute(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_summoner, menu);
        return true;
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
