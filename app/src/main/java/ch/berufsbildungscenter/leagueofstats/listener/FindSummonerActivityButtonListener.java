package ch.berufsbildungscenter.leagueofstats.listener;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import ch.berufsbildungscenter.leagueofstats.R;
import ch.berufsbildungscenter.leagueofstats.SummonerActivity;

/**
 * Created by zpengc on 18.06.2015.
 */
public class FindSummonerActivityButtonListener implements View.OnClickListener {

    private static final String LOG_TAG = FindSummonerActivityButtonListener.class.getCanonicalName();

    private Context context;
    private EditText summonerTextField;
    private Spinner regionSpinner;



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
            Intent intent = new Intent(context, SummonerActivity.class);
            intent.putExtra("summoner", summoner);
            intent.putExtra("region", region);
            context.startActivity(intent);
        }
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
