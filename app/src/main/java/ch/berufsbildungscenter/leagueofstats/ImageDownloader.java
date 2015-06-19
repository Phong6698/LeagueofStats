package ch.berufsbildungscenter.leagueofstats;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by zdomaa on 18.06.2015.
 */
public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
    private ImageButton bmImage;

    private static final String LOG_TAG = ImageDownloader.class.getCanonicalName();

    public ImageDownloader(ImageButton bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap mIcon = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            mIcon = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        return mIcon;
    }

    protected void onPostExecute(Bitmap result) {

        bmImage.setImageBitmap(result);
    }

}