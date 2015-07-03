package ch.berufsbildungscenter.leagueofstats.model;

import android.widget.ImageView;

import ch.berufsbildungscenter.leagueofstats.ImageDownloader;

/**
 * Created by zpengc on 03.07.2015.
 */
public class Item {

    private String name;
    private String description;
    private int id;
    private int goldTotal;
    private int goldBase;

    public void getItemIcon(ImageView image) {
        String url = "http://ddragon.leagueoflegends.com/cdn/5.12.1/img/item/"+id+".png" ;
        new ImageDownloader(image).execute(url);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGoldTotal() {
        return goldTotal;
    }

    public void setGoldTotal(int goldTotal) {
        this.goldTotal = goldTotal;
    }

    public int getGoldBase() {
        return goldBase;
    }

    public void setGoldBase(int goldBase) {
        this.goldBase = goldBase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
