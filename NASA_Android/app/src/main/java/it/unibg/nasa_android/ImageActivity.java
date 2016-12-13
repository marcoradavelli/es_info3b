package it.unibg.nasa_android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageActivity extends AppCompatActivity {

    private ImageView img;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        img = (ImageView)findViewById(R.id.img);
        Log.e("ImageActivity","onCreate");

        new AsyncTask<Void,Void,Bitmap>() {
            /** All the I/O operation (with internet for instance) MUST be done in a separate thread (i.e. in this funciton).
             * It is NOT possible to call graphics libraries here: only in the UI Thread (the default one) */
            @Override
            protected Bitmap doInBackground(Void... voids) {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL("https://api.nasa.gov/planetary/apod?concept_tags=True&api_key=DEMO_KEY");
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStreamReader isw = new InputStreamReader(urlConnection.getInputStream());

                    int data = isw.read();
                    StringBuilder sb=new StringBuilder();
                    while (data != -1) {
                        char current = (char) data;
                        data = isw.read();
                        System.out.print(current);
                        sb.append(current);
                    }
                    JSONObject json = new JSONObject(sb.toString());
                    // Save the title of the image. Example: {"title": "Meteors over Four Girls Mountain"}
                    title = json.getString("title");
                    // Example URL: {"url": "http://apod.nasa.gov/apod/image/1612/NorthSaturn_Cassini_960.jpg"}
                    // Another example: {"url": "http://apod.nasa.gov/apod/image/1612/Perseids4GirlMt_Wu_960.jpg"}
                    url = new URL(json.getString("url"));
                    // Create Bitmap from URL - this MUST be done in a thread (http://stackoverflow.com/questions/5776851/load-image-from-url)
                    return BitmapFactory.decodeStream(url.openConnection().getInputStream());
                } catch (Exception e) {
                    Log.e("ImageActivity",e.getMessage());
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
                return null;
            }

            /** This is the "Handler": the function executed right after the beackground operation.
             *  It is executed in the UI Thread, so DO NOT call any URL from here, but it is possible to modify Android UI.
             * @param bitmap The Bitmap retrieved from internet
             */
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                img.setImageBitmap(bitmap);
                // Show the image title as a Toast (a non-invasive popup message)
                Toast.makeText(ImageActivity.this, title, Toast.LENGTH_LONG);
            }
        }.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ImageActivity","onStart");
    }
}
