package ch.berufsbildungscenter.leagueofstats;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

import ch.berufsbildungscenter.leagueofstats.model.LRUCacheChampIcons;

public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
    private ImageView imageView;
    LRUCacheChampIcons cache;
    String name;
    private static final String LOG_TAG = ImageDownloader.class.getCanonicalName();

    public ImageDownloader(ImageView imageView, LRUCacheChampIcons cache, String name) {
        this.imageView = imageView;
        this.cache = cache;
        this.name = name;
    }

    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap mIcon = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            mIcon = BitmapFactory.decodeStream(in);
            cache.addBitmapToMemoryCache(name, mIcon);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        return mIcon;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }

}