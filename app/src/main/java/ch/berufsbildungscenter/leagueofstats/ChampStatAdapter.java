package ch.berufsbildungscenter.leagueofstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ch.berufsbildungscenter.leagueofstats.model.ChampionData;


public class ChampStatAdapter extends ArrayAdapter<ChampionData> {

    private Context context;
    public ChampStatAdapter(Context context, int resource, List<ChampionData> championDataList) {

        super(context, resource, championDataList);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_champ_stat_adapter, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.health);
        TextView subtitle = (TextView) rowView.findViewById(R.id.health_stat);
        // ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        ChampionData championData = this.getItem(position);

        return rowView;
    }
}
