package ch.berufsbildungscenter.leagueofstats;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.json.AllItemsLoader;
import ch.berufsbildungscenter.leagueofstats.listener.AllItemsListener;
import ch.berufsbildungscenter.leagueofstats.model.Item;

public class AllItemsActivity extends ActionBarActivity {

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_items);
        mDialog = ProgressDialog.show(this, "Please wait", "Loading Items...");
        AllItemsLoader allItemsLoader = new AllItemsLoader(this, mDialog);
        allItemsLoader.execute();
    }

    public void setData(ArrayList<Item> items){
        AllItemsAdapter allItemsAdapter = new AllItemsAdapter(this, R.id.freeToPlayChampItem, items);
        ListView allItemsListView = (ListView) findViewById(R.id.allItemsListView);
        allItemsListView.setAdapter(allItemsAdapter);

        allItemsListView.setOnItemClickListener(new AllItemsListener(this));
        allItemsListView.setItemsCanFocus(true);

        mDialog.dismiss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_all_items, menu);
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
