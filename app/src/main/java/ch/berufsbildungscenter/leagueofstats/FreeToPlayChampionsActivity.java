package ch.berufsbildungscenter.leagueofstats;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.net.URL;
import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.json.FreeToPlayChampionsIdLoader;
import ch.berufsbildungscenter.leagueofstats.listener.FreeToPlayChampListener;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;


public class FreeToPlayChampionsActivity extends ActionBarActivity {

    private ProgressDialog mDialog;
    private URL url;
    private ArrayList<ChampionData> freeToPlayChampions;
    ArrayList<ChampionData> champions = new ArrayList<ChampionData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_to_play_champions);

        mDialog = ProgressDialog.show(this, "Please wait", "Loading Free To Play Champions...");

        FreeToPlayChampionsIdLoader freeToPlayChampionsIdLoader = new FreeToPlayChampionsIdLoader(this, mDialog);
        freeToPlayChampionsIdLoader.execute();

        freeToPlayChampions = new ArrayList<ChampionData>();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_free_to_play_champions, menu);
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

    public void addFreeToPlayChampion(ChampionData championData) {
        freeToPlayChampions.add(championData);
    }

    public void setData(){

        if(freeToPlayChampions.size()==10) {
            // define items
            FreeToPlayChampionsAdapter freeToPlayChampionsAdapter = new FreeToPlayChampionsAdapter(this, R.id.freeToPlayChampItem, freeToPlayChampions);
            ListView freeToPlayChampionListView = (ListView) findViewById(R.id.freeToPlayChampionListView);
            freeToPlayChampionListView.setAdapter(freeToPlayChampionsAdapter);

            freeToPlayChampionListView.setOnItemClickListener(new FreeToPlayChampListener(this));
            freeToPlayChampionListView.setItemsCanFocus(true);

            mDialog.dismiss();
        }


    }
}
