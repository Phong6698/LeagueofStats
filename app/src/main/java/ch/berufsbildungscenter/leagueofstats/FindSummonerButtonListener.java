package ch.berufsbildungscenter.leagueofstats;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/**
 * Created by zpengc on 18.06.2015.
 */
public class FindSummonerButtonListener implements View.OnClickListener{

    private Context context;

    public FindSummonerButtonListener(Context context){
        this.setContext(context);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.searchSummonerButton){
            Intent intent = new Intent(context, SummonerActivity.class);
            context.startActivity(intent);
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
