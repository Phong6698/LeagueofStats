package ch.berufsbildungscenter.leagueofstats;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ch.berufsbildungscenter.leagueofstats.R;
import ch.berufsbildungscenter.leagueofstats.model.Item;

public class AllItemsAdapter extends ArrayAdapter<Item> {

    private Context context;
    private Item item;

    public AllItemsAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adapter_all_items, parent, false);
        item = this.getItem(position);

        TextView itemName = (TextView) rowView.findViewById(R.id.itemName);
        ImageView itemImageView = (ImageView) rowView.findViewById(R.id.itemImageView);

        itemName.setText(item.getName());
        item.getItemIcon(itemImageView);



        return rowView;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
