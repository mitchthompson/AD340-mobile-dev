package assignments.mitch.ad340project;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BackgroundTask {
    private static final String TAG = BackgroundTask.class.getSimpleName();
    Context context;
    String jsonURL = "http://mitchlthompson.com/ad340/movies.json";
    ArrayList<MovieObject> arrayList = new ArrayList<>();

    public BackgroundTask(Context ctx){

        this.context = ctx;
    }

    public ArrayList<MovieObject> getMovies(){

        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, jsonURL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int count=0;count<response.length();count++)
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                MovieObject movie = new MovieObject(jsonObject.getString("title"), jsonObject.getString("year"), jsonObject.getString("img_url"));
                                arrayList.add(movie);
                                //Log.e(TAG, "Test: " + jsonObject.getString("title") + " " + jsonObject.getString("img_url"));

                            } catch (JSONException e) {

                                Log.e(TAG, "JSONException: " + e.toString());
                            }

                        MovieListActivity.recyclerViewAdapter.notifyDataSetChanged();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Volley Error: " + error.toString());
            }
        });
        MySingleton.getSingleton(context).addToRequest(jsonArrayRequest);
        return arrayList;
    };
}