package ch.berufsbildungscenter.leagueofstats;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ch.berufsbildungscenter.leagueofstats.listener.AllChampionsListener;
import ch.berufsbildungscenter.leagueofstats.model.ChampionData;
import ch.berufsbildungscenter.leagueofstats.model.InGameSummoner;


public class InGameAdapter extends ArrayAdapter<InGameSummoner> {

    private Context context;

    public InGameAdapter(Context context, int resource, List<InGameSummoner> inGameSummoners) {
        super(context, resource,inGameSummoners);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adapter_in_game, parent, false);

        InGameSummoner inGameSummoner = this.getItem(position);

        TextView summonerTextView = (TextView) rowView.findViewById(R.id.summonerTextView);
        ImageView spell1ImageView = (ImageView) rowView.findViewById(R.id.spell1ImageView);
        ImageView spell2ImageView = (ImageView) rowView.findViewById(R.id.spell2ImageView);
        ImageButton championImageButton = (ImageButton) rowView.findViewById(R.id.championImageButton);

        int imageResSpell1 = context.getResources().getIdentifier("drawable/spell"+inGameSummoner.getSpellId1(), null, context.getPackageName());
        int imageResSpell2 = context.getResources().getIdentifier("drawable/spell"+inGameSummoner.getSpellId2(), null, context.getPackageName());
        spell1ImageView.setImageDrawable(context.getResources().getDrawable(imageResSpell1));
        spell2ImageView.setImageDrawable(context.getResources().getDrawable(imageResSpell2));
        inGameSummoner.getChampionIconImageButton(championImageButton);
        summonerTextView.setText(inGameSummoner.getName());


        return rowView;
    }
}
