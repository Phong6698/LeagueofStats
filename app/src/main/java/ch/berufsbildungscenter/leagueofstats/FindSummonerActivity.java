package ch.berufsbildungscenter.leagueofstats;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import ch.berufsbildungscenter.leagueofstats.listener.FindSummonerActivityButtonListener;


public class FindSummonerActivity extends ActionBarActivity {


    private String regionSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_summoner);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        EditText summonerTextField = (EditText)findViewById(R.id.findSummonerTextField);

        Spinner regionSpinner = (Spinner) findViewById(R.id.regionSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.region, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        regionSpinner.setAdapter(adapter);



        Button searchSummonerButton = (Button) findViewById(R.id.searchSummonerButton);
        searchSummonerButton.setOnClickListener(new FindSummonerActivityButtonListener(this, summonerTextField, regionSpinner));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_find_summoner, menu);
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


    public String getRegionSelected() {
        return regionSelected;
    }

    public void setRegionSelected(String regionSelected) {
        this.regionSelected = regionSelected;
    }
}
