package assignments.mitch.ad340project;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class MySingleton {

    private static MySingleton singleton;
    private RequestQueue requestQueue;
    private ImageLoader mImageLoader;
    private static Context context;

    private MySingleton(Context ctx){
        context = ctx.getApplicationContext();
        requestQueue = getRequestQueue();

        mImageLoader = new ImageLoader(requestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });

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

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}
