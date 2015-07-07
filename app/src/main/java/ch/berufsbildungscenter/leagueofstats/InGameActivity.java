package ch.berufsbildungscenter.leagueofstats;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import ch.berufsbildungscenter.leagueofstats.json.InGameLoader;
import ch.berufsbildungscenter.leagueofstats.model.InGame;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;


public class InGameActivity extends ActionBarActivity {

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        Intent intent = getIntent();

        int summonerId = intent.getIntExtra("summonerId", 0);
        String region = intent.getStringExtra("region");

        mDialog = ProgressDialog.show(this,  "Please wait", "Loading In Game Stat");
        InGameLoader inGameLoader = new InGameLoader(this, mDialog);
        inGameLoader.execute(region, ""+summonerId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_in_game, menu);
        return true;
    }

    public void setData(InGame inGame) {

        mDialog.dismiss();
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
