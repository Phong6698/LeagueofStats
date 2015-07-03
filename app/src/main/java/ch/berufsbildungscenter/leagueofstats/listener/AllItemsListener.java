package ch.berufsbildungscenter.leagueofstats.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import ch.berufsbildungscenter.leagueofstats.ItemActivity;
import ch.berufsbildungscenter.leagueofstats.AllItemsAdapter;
import ch.berufsbildungscenter.leagueofstats.model.Item;

/**
 * Created by zpengc on 03.07.2015.
 */
public class AllItemsListener implements  AdapterView.OnItemClickListener {

    private Context context;


    public AllItemsListener(Context context){
        this.setContext(context);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AllItemsAdapter allItemsAdapter = (AllItemsAdapter) parent.getAdapter();
        Item item = allItemsAdapter.getItem(position);
        Intent intent = new Intent(context, ItemActivity.class);
        intent.putExtra("itemId", item.getId());
        context.startActivity(intent);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
