package ch.berufsbildungscenter.leagueofstats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ch.berufsbildungscenter.leagueofstats.listener.LoreListener;


public class LoreActivity extends ActionBarActivity implements ActionBar.TabListener {

    private boolean allyTipsVisible = false;
    private boolean enemyTipsVisible = false;
    private boolean loreVisible = false;

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
        tipsText.setVisibility(View.GONE);
        enemyTipsText.setVisibility(View.GONE);
        loreText.setVisibility(View.GONE);

        Button allytipsButton = (Button) findViewById(R.id.allytipsButton);
        Button enemytipsButton = (Button) findViewById(R.id.enemytipsButton);
        Button loreButton = (Button) findViewById(R.id.loreButton);
        allytipsButton.setOnClickListener(new LoreListener(this));
        enemytipsButton.setOnClickListener(new LoreListener(this));
        loreButton.setOnClickListener(new LoreListener(this));
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
        if(tab.getPosition() == 0) {

        }
        else if(tab.getPosition() == 1) {
            this.finish();
            Log.v("TAB 1", "Selected");
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public boolean isAllyTipsVisible() {
        return allyTipsVisible;
    }

    public void setAllyTipsVisible(boolean allyTipsVisible) {
        this.allyTipsVisible = allyTipsVisible;
    }

    public boolean isEnemyTipsVisible() {
        return enemyTipsVisible;
    }

    public void setEnemyTipsVisible(boolean enemyTipsVisible) {
        this.enemyTipsVisible = enemyTipsVisible;
    }

    public boolean isLoreVisible() {
        return loreVisible;
    }

    public void setLoreVisible(boolean loreVisible) {
        this.loreVisible = loreVisible;
    }
}
