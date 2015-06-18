package ch.berufsbildungscenter.leagueofstats.json;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by zpengc on 18.06.2015.
 */
public abstract class JsonLoadingTask extends AsyncTask<URL, Void, String> {

    protected JSONParser jsonParser;
    protected ProgressDialog mDialog;

    private static final String LOG_TAG = JsonLoadingTask.class.getCanonicalName();

    private ConnectivityManager connectivityManager;
    private Context activity;

    public JsonLoadingTask(Context activity, ProgressDialog mDialog) {
        this.activity = activity;
        this.mDialog = mDialog;
        jsonParser = new JSONParser();
    }




    @Override
    protected String doInBackground(URL... params) {

        URL url = params[0];
        Log.e(LOG_TAG,"url: "+url);



        String result = null;


        if(isNetworkConnectionAvailable()) {
            try {

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (HttpURLConnection.HTTP_OK == responseCode) {
                    result = readInput(connection.getInputStream());

                } else {
                    Log.e(LOG_TAG, String.format("An error occurred while loading the data in the background. HTTP status: %d", responseCode));
                }

                connection.disconnect();

            } catch (Exception e) {
                Log.e(LOG_TAG, "An error occurred while loading the data in the background", e);
            }
        }


        return result;
    }


    @Override
    protected void onPostExecute(String jsonString) {
        Log.e(LOG_TAG,"jasonString: "+jsonString);
        onCostumPostExecute(jsonString);
    }

    protected abstract void onCostumPostExecute(String jsonString);

    private boolean isNetworkConnectionAvailable() {
        ConnectivityManager connectivityService = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityService.getActiveNetworkInfo();

        return null != networkInfo && networkInfo.isConnected();
    }

    private String readInput(InputStream inputStream) throws IOException {
        StringBuilder resultBuilder = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

        String line;
        while (null != (line = bufferedReader.readLine())) {
            resultBuilder.append(line);
        }

        return resultBuilder.toString();
    }

}
