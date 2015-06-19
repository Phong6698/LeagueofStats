package ch.berufsbildungscenter.leagueofstats;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.model.ChampionData;


public class ChampionStatsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_stats);

        ChampionData championData = new ChampionData();

        ArrayList<ChampionData> arrayList = new ArrayList<ChampionData>();
        // add Rows
        arrayList.add(championData);
        arrayList.add(championData);
        arrayList.add(championData);
        arrayList.add(championData);
        arrayList.add(championData);
        arrayList.add(championData);
        arrayList.add(championData);
        arrayList.add(championData);
        arrayList.add(championData);
        ChampStatAdapter champStatAdapter = new ChampStatAdapter(this, R.id.champ_stat_item,arrayList);
        ListView champStatList = (ListView) findViewById(R.id.champ_stat_list);
        champStatList.setAdapter(champStatAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_champion_stats, menu);
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
