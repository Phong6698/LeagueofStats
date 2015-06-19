package ch.berufsbildungscenter.leagueofstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ch.berufsbildungscenter.leagueofstats.model.ChampionData;

/**
 * Created by zkillt on 19.06.2015.
 */
public class AllChampsAdapter extends ArrayAdapter<ChampionData> {

    private Context context;
    public AllChampsAdapter(Context context, int resource, List<ChampionData> championDataList) {
        super(context, resource, championDataList);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_activity_all_champs_adapter, parent, false);
        ImageView subtitle = (ImageView) rowView.findViewById(R.id.champ_square);
        TextView title = (TextView) rowView.findViewById(R.id.nameField);
        // ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        ChampionData championData = this.getItem(position);

        return rowView;
    }
}
