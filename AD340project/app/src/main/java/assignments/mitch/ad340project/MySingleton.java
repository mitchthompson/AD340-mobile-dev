package assignments.mitch.ad340project;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {

    private static MySingleton singleton;
    private RequestQueue requestQueue;
    private static Context context;

    private MySingleton(Context ctx){
        context = ctx.getApplicationContext();
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){

        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    public static synchronized MySingleton getSingleton(Context ctx){

        if(singleton == null){
            singleton= new MySingleton(ctx.getApplicationContext());
        }

        return singleton;
    }

    public<T> void addToRequest(Request<T> request){

        requestQueue.add(request);
    }
}
