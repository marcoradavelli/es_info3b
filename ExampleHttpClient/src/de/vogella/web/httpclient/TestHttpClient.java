package de.vogella.web.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class TestHttpClient {
    public static void main(String[] args) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(
                "http://submitcss.altervista.org/api.php");

        try {

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("email", "youremail"));
            nameValuePairs
                    .add(new BasicNameValuePair("password", "yourpassword"));
            nameValuePairs.add(new BasicNameValuePair("nome", "mionome"));
            nameValuePairs.add(new BasicNameValuePair("accountType", "GOOGLE"));
            nameValuePairs.add(new BasicNameValuePair("source",
                    "Google-cURL-Example"));
            nameValuePairs.add(new BasicNameValuePair("service", "ac2dm"));

            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));

            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                if (line.startsWith("Auth=")) {
                    String key = line.substring(5);
                    // do something with the key
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}