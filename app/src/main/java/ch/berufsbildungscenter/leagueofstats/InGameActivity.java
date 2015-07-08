package ch.berufsbildungscenter.leagueofstats;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import ch.berufsbildungscenter.leagueofstats.json.InGameLoader;
import ch.berufsbildungscenter.leagueofstats.listener.FavoritSummonerListener;
import ch.berufsbildungscenter.leagueofstats.listener.InGameListener;
import ch.berufsbildungscenter.leagueofstats.model.InGame;
import ch.berufsbildungscenter.leagueofstats.model.InGameSummoner;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;


public class InGameActivity extends ActionBarActivity {

    private InGame inGame;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        Intent intent = getIntent();

        int summonerId = intent.getIntExtra("summonerId", 0);
        String region = intent.getStringExtra("region");

        mDialog = ProgressDialog.show(this,  "Please wait", "Loading In Game Stat...");
        InGameLoader inGameLoader = new InGameLoader(this, mDialog);
        inGameLoader.execute(region, ""+summonerId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_in_game, menu);
        return true;
    }

    public void setData(InGameSummoner inGameSummoner, InGame inGame) {

        if(inGameSummoner.getTeamId() == 100){
            this.inGame.getInGameSummonersTeam1().add(inGameSummoner);
        } else if(inGameSummoner.getTeamId() == 200){
            this.inGame.getInGameSummonersTeam2().add(inGameSummoner);
        }

        if (this.inGame.getInGameSummonersTeam1().size() == inGame.getInGameSummonersTeam1().size() && this.inGame.getInGameSummonersTeam2().size() == inGame.getInGameSummonersTeam2().size()) {


            TextView gameModeTextView = (TextView) findViewById(R.id.gameModeTextView);
            gameModeTextView.setText(inGame.getGameMode());

            // define items
            InGameAdapter inGameAdapter1 = new InGameAdapter(this, R.id.InGameSummonerItem, inGame.getInGameSummonersTeam1());
            ListView team1ListView = (ListView) findViewById(R.id.team1ListView);
            team1ListView.setAdapter(inGameAdapter1);
            team1ListView.setOnItemClickListener(new InGameListener(this));


            InGameAdapter inGameAdapter2 = new InGameAdapter(this, R.id.InGameSummonerItem, inGame.getInGameSummonersTeam2());
            ListView team2ListView = (ListView) findViewById(R.id.team2ListView);
            team2ListView.setAdapter(inGameAdapter2);
            team2ListView.setOnItemClickListener(new InGameListener(this));
          


            mDialog.dismiss();
        }
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

    public InGame getInGame() {
        return inGame;
    }

    public void setInGame(InGame inGame) {
        this.inGame = inGame;
    }
}
