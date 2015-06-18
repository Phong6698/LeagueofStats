package ch.berufsbildungscenter.leagueofstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ChampStatAdapter extends ArrayAdapter<PlayerData> {

    private Context context;

    public ChampStatAdapter(Context context, int resource, List<PlayerData> playerDataList) {

        super(context, resource, playerDataList);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_champ_stat_adapter, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.health);
        TextView subtitle = (TextView) rowView.findViewById(R.id.health_stat);
        // ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        PlayerData playerData = this.getItem(position);

        title.setText(playerData.getHealth());
        subtitle.setText(playerData.getHealth_stat());


        return rowView;
    }
}
