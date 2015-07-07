package ch.berufsbildungscenter.leagueofstats.listener;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import ch.berufsbildungscenter.leagueofstats.FindSummonerActivity;
import ch.berufsbildungscenter.leagueofstats.R;
import ch.berufsbildungscenter.leagueofstats.SummonerActivity;
import ch.berufsbildungscenter.leagueofstats.json.SummonerIDLoader;
import ch.berufsbildungscenter.leagueofstats.model.Summoner;

/**
 * Created by zpengc on 18.06.2015.
 */
public class FindSummonerActivityButtonListener implements View.OnClickListener {

    private static final String LOG_TAG = FindSummonerActivityButtonListener.class.getCanonicalName();

    private Context context;
    private EditText summonerTextField;
    private Spinner regionSpinner;
    private ProgressDialog mDialog;


    public FindSummonerActivityButtonListener(Context context, EditText summonerTextField, Spinner regionSpinner){
        this.setContext(context);
        this.setSummonerTextField(summonerTextField);
        this.setRegionSpinner(regionSpinner);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.searchSummonerButton){
            String summoner = summonerTextField.getText().toString();
            String region = regionSpinner.getSelectedItem().toString();
            Log.e(LOG_TAG, "summoner: " + summoner);
            Log.e(LOG_TAG, "region: " + region);

            mDialog = ProgressDialog.show(context, "Please wait", "Searching Summoner...");

            SummonerIDLoader summonerIDLoader = new SummonerIDLoader((FindSummonerActivity) context, mDialog, this);
            summonerIDLoader.execute(region, summoner);
        }
    }

    public void startActivity(Summoner summoner){
        Intent intent = new Intent(context, SummonerActivity.class);
        intent.putExtra("summonerId", summoner.getId());
        intent.putExtra("summonerLevel", summoner.getSummonerLevel());
        intent.putExtra("profileIconId", summoner.getProfileIconId());
        intent.putExtra("region", summoner.getRegion());
        intent.putExtra("summonerName", summoner.getName());
        context.startActivity(intent);
        mDialog.dismiss();
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public EditText getSummonerTextField() {
        return summonerTextField;
    }

    public void setSummonerTextField(EditText summonerTextField) {
        this.summonerTextField = summonerTextField;
    }

    public Spinner getRegionSpinner() {
        return regionSpinner;
    }

    public void setRegionSpinner(Spinner regionSpinner) {
        this.regionSpinner = regionSpinner;
    }


}
