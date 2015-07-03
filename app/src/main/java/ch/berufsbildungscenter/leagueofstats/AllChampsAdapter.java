package ch.berufsbildungscenter.leagueofstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import ch.berufsbildungscenter.leagueofstats.listener.AllChampionsListener;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;

/**
 * Created by zkillt on 19.06.2015.
 */
public class AllChampsAdapter extends ArrayAdapter<ChampionData> {

    protected String name = "";
    private Context context;


    public AllChampsAdapter(Context context, int resource, List<ChampionData> championDataList) {
        super(context, resource, championDataList);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adapter_all_champs, parent, false);
        ChampionData championData = this.getItem(position);

        ImageButton championIcon = (ImageButton) rowView.findViewById(R.id.championIcon);
        championIcon.setOnClickListener(new AllChampionsListener(context, championData));
        championData.getChampionIconImageButton(championIcon);

        TextView name = (TextView) rowView.findViewById(R.id.nameField);
        name.setText(championData.getName());
        return rowView;
    }
}
