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

public class FreeToPlayChampionsAdapter extends ArrayAdapter<ChampionData> {

    private Context context;
    private ChampionData championData;

    public FreeToPlayChampionsAdapter(Context context, int resource, List<ChampionData> freeToPlayChampions) {
        super(context, resource, freeToPlayChampions);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adapter_free_to_play_champions, parent, false);
        championData = this.getItem(position);


        TextView champion = (TextView) rowView.findViewById(R.id.champion);
        TextView attack = (TextView) rowView.findViewById(R.id.attack);
        TextView magic = (TextView) rowView.findViewById(R.id.magic);
        TextView defense = (TextView) rowView.findViewById(R.id.defense);
        TextView difficulty = (TextView) rowView.findViewById(R.id.difficulty);

        ImageView championIcon = (ImageView) rowView.findViewById(R.id.championIcon);
        championData.getPlayerIconImageView(championIcon);

        champion.setText(championData.getName());
        attack.setText(""+championData.getAttack());
        magic.setText(""+championData.getMagic());
        defense.setText(""+championData.getDefense());
        difficulty.setText(""+championData.getDifficulty());


        return rowView;
    }


    public ChampionData getChampionData() {
        return championData;
    }

    public void setChampionData(ChampionData championData) {
        this.championData = championData;
    }
}
