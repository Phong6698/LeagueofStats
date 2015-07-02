package ch.berufsbildungscenter.leagueofstats;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.json.AllChampionsLoader;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;


public class AllChampionsActivity extends ActionBarActivity{

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions_all);
        mDialog = ProgressDialog.show(this, "Please wait", "Champions are loading...");
        AllChampionsLoader allChampionsLoader = new AllChampionsLoader(this, mDialog );
        allChampionsLoader.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_all_champions, menu);
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

    public void setData(ArrayList<ChampionData> champions){

        ArrayList<ChampionData> arrayList = new ArrayList<ChampionData>();
        // add Rows
        for(ChampionData championDataIt : champions) {
            arrayList.add(championDataIt);
        }

        AllChampsAdapter allChampsAdapter = new AllChampsAdapter(this, R.id.all_champs_item, arrayList);
        GridView champStatList = (GridView) findViewById(R.id.champGrid);
        champStatList.setAdapter(allChampsAdapter);
    }
}
