package ch.berufsbildungscenter.leagueofstats.model;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by zkillt on 03.07.2015.
 */
public class LRUCacheChampIcons extends LruCache<String, Bitmap> {

    @Override
    public int sizeOf(String key, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024 / 8 * 7;
            }

    public Bitmap getBitmapFromMemCache(String key) {
            return this.get(key);
            }

    public LRUCacheChampIcons() {
            // Ein Achtel von Maximalen Cache Size
            super(((int) Runtime.getRuntime().maxMemory() / 1024));
            }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            this.put(key, bitmap);
        }
    }
}
