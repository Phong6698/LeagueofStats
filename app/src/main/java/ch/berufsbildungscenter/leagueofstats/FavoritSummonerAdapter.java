package ch.berufsbildungscenter.leagueofstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ch.berufsbildungscenter.leagueofstats.model.Summoner;


public class FavoritSummonerAdapter extends ArrayAdapter<Summoner> {

    private Context context;
    private Summoner summoner;

    public FavoritSummonerAdapter(Context context, int resource, List<Summoner> summoners) {
        super(context, resource, summoners);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adapter_favorit_summoner, parent, false);
        summoner = this.getItem(position);

        TextView summonerTextView = (TextView) rowView.findViewById(R.id.summoner);
        TextView level = (TextView) rowView.findViewById(R.id.level);
        TextView wins = (TextView) rowView.findViewById(R.id.wins);

        summonerTextView.setText(summoner.getName());
        level.setText(""+summoner.getSummonerLevel());
        wins.setText(""+summoner.getWins());

        return rowView;
    }


}
