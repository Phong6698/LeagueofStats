package ch.berufsbildungscenter.leagueofstats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class LoreActivity extends ActionBarActivity implements ActionBar.TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lore);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // changes color of action bar:
        // actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0099CC")));
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText(R.string.champion_tab_lore).setTabListener(this), true);
        actionBar.addTab(actionBar.newTab().setText(R.string.champion_tab_stats).setTabListener(this), false);
        actionBar.addTab(actionBar.newTab().setText(R.string.champion_tab_spells).setTabListener(this), false);

        Intent intent = getIntent();

        String allyTips = intent.getStringExtra("allyTips");
        String enemyTips = intent.getStringExtra("enemyTips");
        String lore = intent.getStringExtra("lore");


        TextView tipsText = (TextView) findViewById(R.id.tips);
        TextView loreText = (TextView) findViewById(R.id.lore);
        TextView enemyTipsText  = (TextView) findViewById(R.id.enemyTips);

        tipsText.setText(allyTips);
        enemyTipsText.setText(enemyTips);
        loreText.setText(lore.replaceAll("<br>", "\n"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lore, menu);
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

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
