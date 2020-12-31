package com.example.parsejson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
      RecyclerView recyclerView;
      List<Song>  songs ;
      private static String Json_Url="http://starlord.backereath.com/studio";
      Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.songlist);
        songs =new ArrayList<>();
        extractSongs();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,songs);
        recyclerView.setAdapter(adapter);


    }

    private void extractSongs() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, Json_Url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject songobject = response.getJSONObject(i);
                        Song song = new Song();
                        song.setTitle(songobject.getString("song").toString());
                        song.setArtist(songobject.getString("artists").toString());
                        song.setCoverImage(songobject.getString("cover_image"));
                        song.getSongURL(songobject.getString("url"));

                        songs.add(song);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag","on eroor Response: " + error.getMessage());
            }
        });
    }
}