package ch.berufsbildungscenter.leagueofstats.json;

import android.app.Activity;
import android.app.ProgressDialog;

import java.net.MalformedURLException;
import java.net.URL;

import ch.berufsbildungscenter.leagueofstats.ItemActivity;
import ch.berufsbildungscenter.leagueofstats.model.Item;

/**
 * Created by zpengc on 03.07.2015.
 */
public class ItemLoader extends JsonLoadingTask {

    private ItemActivity itemActivity;

    public ItemLoader(Activity activity, ProgressDialog mDialog) {
        super(activity, mDialog);
        this.itemActivity = (ItemActivity) activity;
    }

    @Override
    protected void onCostumPostExecute(String jsonString) {
        Item item = jsonParser.getItems(jsonString);
        itemActivity.setData(item);
    }

    @Override
    protected URL createURL(String... params) {
        String itemId = params[0];
        URL url = null;
        try {
            url = new URL("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/item/"+itemId+"?itemData=gold&api_key=58453580-a12b-497a-bdde-d1255bd0fda3");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
