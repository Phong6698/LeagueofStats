package ch.berufsbildungscenter.leagueofstats;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import ch.berufsbildungscenter.leagueofstats.json.ItemLoader;
import ch.berufsbildungscenter.leagueofstats.json.SummonerIDLoader;
import ch.berufsbildungscenter.leagueofstats.model.Item;


public class ItemActivity extends ActionBarActivity {

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent intent = getIntent();
        int itemId = intent.getIntExtra("itemId",-1);

        mDialog = ProgressDialog.show(this,  "Please wait", "Loading Item...");

        ItemLoader itemLoader = new ItemLoader(this, mDialog);
        itemLoader.execute(""+itemId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
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

    public void setData(Item item) {

        TextView itemName = (TextView) findViewById(R.id.itemName);
        TextView itemTextView = (TextView) findViewById(R.id.itemTextView);
        TextView cost = (TextView) findViewById(R.id.cost);
        TextView sell = (TextView) findViewById(R.id.sell);
        ImageView itemImageView = (ImageView) findViewById(R.id.itemImageView);

        itemName.setText(item.getName());
        itemTextView.setText(Html.fromHtml(item.getDescription()));
        cost.setText(""+item.getGoldTotal()+"("+item.getGoldBase()+")");
        sell.setText(""+item.getGoldSell());
        item.getItemIcon(itemImageView);

        mDialog.dismiss();
    }
}
