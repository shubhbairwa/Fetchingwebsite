package com.example.fetching_website;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
public class setUpFetch extends AsyncTask<String ,Void,String>{

    @Override
    protected String doInBackground(String... strings) {
        URL url;
        String page="";
        HttpsURLConnection httpURLConnection=null;

        try{
            url=new URL(strings[0]); //get the url
            httpURLConnection= (HttpsURLConnection) url.openConnection();//opening browser
            InputStream inputStream=httpURLConnection.getInputStream(); //hitting enter
            InputStreamReader reader=new InputStreamReader(inputStream);

int data=reader.read();
while (data!=-1){
    char storeData=(char)data;
    page +=storeData;
    data=reader.read();
}
return page;

        }
        catch (Exception e){
e.printStackTrace();
return "cannot fetch web";
        }
    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
setUpFetch request=new setUpFetch();
String page=null;

try{
    page=request.execute("https://www.hiteshchoudhary.com/").get();
}
catch (Exception e){
    e.printStackTrace();
}
        Log.i("google",page);

}
}
