package ch.berufsbildungscenter.leagueofstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ch.berufsbildungscenter.leagueofstats.model.SummonerRanked;


public class RankedAdapter extends ArrayAdapter<SummonerRanked> {
    private Context context;
    public RankedAdapter(Context context, int resource, List<SummonerRanked> summonerRankedList) {
        super(context, resource, summonerRankedList);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adapter_ranked, parent, false);
        SummonerRanked summonerRanked = this.getItem(position);

        ImageView rankedImage = (ImageView)rowView.findViewById(R.id.rankedImage);
        TextView queueTextView = (TextView) rowView.findViewById(R.id.queueTextView);
        TextView rankedTextView = (TextView) rowView.findViewById(R.id.rankedTextView);
        TextView leaguePointsTextView = (TextView) rowView.findViewById(R.id.leaguePointsTextView);
        TextView winsTextView = (TextView) rowView.findViewById(R.id.winsTextView);
        TextView textView = (TextView) rowView.findViewById(R.id.textView);




        String queue = summonerRanked.getQueue();
        queue = queue.replaceAll("_", " ");
        queueTextView.setText(queue);
        rankedTextView.setText(summonerRanked.getTier() + " " +summonerRanked.getDivision());
        leaguePointsTextView.setText(""+summonerRanked.getLeaguePoints()+"LP");
        winsTextView.setText(""+summonerRanked.getWins());
        textView.setText(""+summonerRanked.getLosses());
        String tier = summonerRanked.getTier() + "_" +summonerRanked.getDivision();
        int id = context.getResources().getIdentifier(tier.toLowerCase(), "drawable", context.getPackageName());
        rankedImage.setImageResource(id);

        return rowView;
    }
}
