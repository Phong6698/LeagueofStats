package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.AllItemsActivity;
import ch.berufsbildungscenter.leagueofstats.model.Item;

/**
 * Created by zpengc on 03.07.2015.
 */
public class AllItemsLoader extends JsonLoadingTask {

    private AllItemsActivity allItemsActivity;

    public AllItemsLoader(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        this.allItemsActivity = (AllItemsActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        ArrayList<Item> items = jsonParser.getAllItems(jsonString);
        allItemsActivity.setData(items);
    }

    @Override
    protected URL createURL(String... params) {
        URL url = null;
        try {
            url = new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/item?itemListData=image&api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
