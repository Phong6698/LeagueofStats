package ch.berufsbildungscenter.leagueofstats;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.json.LoadingAllChampionsTask;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;


public class AllChampionsActivity extends ActionBarActivity{

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions_all);
        mDialog = ProgressDialog.show(this, "Please wait", "Champions are loading");
        LoadingAllChampionsTask loadingAllChampionsTask = new LoadingAllChampionsTask(this, mDialog );
        try {
            loadingAllChampionsTask.execute(new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion?champData=image&api_key=58453580-a12b-497a-bdde-d1255bd0fda3"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


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
            ImageView championIcon = (ImageView) findViewById(R.id.champSquare);
            if(!championDataIt.getName().equals("Ekko")) {
                championDataIt.getPlayerIcon(championIcon);
            }
        }

        AllChampsAdapter allChampsAdapter = new AllChampsAdapter(this, R.id.all_champs_item, arrayList);
        GridView champStatList = (GridView) findViewById(R.id.champGrid);
        champStatList.setAdapter(allChampsAdapter);
    }
}
