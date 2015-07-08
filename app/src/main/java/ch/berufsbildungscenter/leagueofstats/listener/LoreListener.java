package ch.berufsbildungscenter.leagueofstats.listener;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ch.berufsbildungscenter.leagueofstats.LoreActivity;
import ch.berufsbildungscenter.leagueofstats.R;

/**
 * Created by zkillt on 08.07.2015.
 */
public class LoreListener implements View.OnClickListener {

    private static final String LOG_TAG = AllChampionsListener.class.getCanonicalName();
    private Context context;

    public LoreListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        LoreActivity loreActivity = (LoreActivity) context;
        Button allyTipsButton = (Button) loreActivity.findViewById(R.id.allytipsButton);
        Button enemytipsButton = (Button) loreActivity.findViewById(R.id.enemytipsButton);
        Button loreButton = (Button) loreActivity.findViewById(R.id.loreButton);

        if (v.getId() == R.id.allytipsButton) {
            TextView tips = (TextView) loreActivity.findViewById(R.id.tips);
            if (!loreActivity.isAllyTipsVisible()) {
                tips.setVisibility(View.VISIBLE);
                allyTipsButton.setText("hide");
                loreActivity.setAllyTipsVisible(true);
            } else if (loreActivity.isAllyTipsVisible()) {
                tips.setVisibility(View.GONE);
                allyTipsButton.setText("show");
                loreActivity.setAllyTipsVisible(false);
            }
        }

        if (v.getId() == R.id.enemytipsButton) {
            TextView tips = (TextView) loreActivity.findViewById(R.id.enemyTips);
            if (!loreActivity.isEnemyTipsVisible()) {
                tips.setVisibility(View.VISIBLE);
                enemytipsButton.setText("hide");
                loreActivity.setEnemyTipsVisible(true);
            } else if (loreActivity.isEnemyTipsVisible()) {
                tips.setVisibility(View.GONE);
                enemytipsButton.setText("show");
                loreActivity.setEnemyTipsVisible(false);
            }
        }

        if (v.getId() == R.id.loreButton) {
            TextView tips = (TextView) loreActivity.findViewById(R.id.lore);
            if (!loreActivity.isLoreVisible()) {
                tips.setVisibility(View.VISIBLE);
                loreButton.setText("hide");
                loreActivity.setLoreVisible(true);
            } else if (loreActivity.isLoreVisible()) {
                tips.setVisibility(View.GONE);
                loreButton.setText("show");
                loreActivity.setLoreVisible(false);
            }
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}

