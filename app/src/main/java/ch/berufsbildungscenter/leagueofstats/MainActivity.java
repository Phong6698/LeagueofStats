package ch.berufsbildungscenter.leagueofstats;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import ch.berufsbildungscenter.leagueofstats.listener.MainActivityButtonListener;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button freetoplayButton = (Button) findViewById(R.id.free_to_play_btn);
        Button championsButton = (Button) findViewById(R.id.champions_btn);
        Button itemsButton = (Button) findViewById(R.id.items_btn);
        Button favSummonersButton = (Button) findViewById(R.id.favoritSummoners_btn);

        freetoplayButton.setOnClickListener(new MainActivityButtonListener(this));
        championsButton.setOnClickListener(new MainActivityButtonListener(this));
        itemsButton.setOnClickListener(new MainActivityButtonListener(this));
        favSummonersButton.setOnClickListener(new MainActivityButtonListener(this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
