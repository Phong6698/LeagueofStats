package ch.berufsbildungscenter.leagueofstats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


public class FavoritSummonerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit_summoner);

        ListView listview = (ListView) findViewById(R.id.favSummonerListView);
        if (listview.getCount() != 0) {
            TextView nofavorites = (TextView) findViewById(R.id.noFavoritesText);
            nofavorites.setVisibility(View.INVISIBLE);
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
        }

        //noinspection SimplifiableIfStatement
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
