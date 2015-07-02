package ch.berufsbildungscenter.leagueofstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ch.berufsbildungscenter.leagueofstats.model.ChampionStat;


public class ChampStatAdapter extends ArrayAdapter<ChampionStat> {

    private Context context;

    public ChampStatAdapter(Context context, int resource, ArrayList<ChampionStat> championStats) {
        super(context, resource, championStats);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adapterchamp_stat, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.health);
        TextView stats = (TextView) rowView.findViewById(R.id.health_stat);

        ChampionStat championStat = this.getItem(position);

        StringBuilder rackingSystemSb = new StringBuilder();
        rackingSystemSb.append(championStat.getTitle());
        rackingSystemSb.setCharAt(0, Character.toUpperCase(rackingSystemSb.charAt(0)));
        championStat.setTitle(rackingSystemSb.toString());

        title.setText(championStat.getTitle());
        stats.setText("" + championStat.getStat());


        return rowView;
    }
}
