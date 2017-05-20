package assignments.mitch.ad340project;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import static android.R.id.list;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = RecyclerViewAdapter.class.getSimpleName();
    Context context;
    View view1;
    ViewHolder viewHolder1;
    ImageLoader imageLoader;
    ArrayList<MovieObject> arrayList = new ArrayList<>();


    public RecyclerViewAdapter(Context context1, ArrayList<MovieObject> arrayList1){
        this.arrayList = arrayList1;
        context = context1;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public TextView textView2;
        public NetworkImageView image;

        public ViewHolder(View v){

            super(v);
            image = (NetworkImageView) itemView.findViewById(R.id.movie_poster);
            textView = (TextView)v.findViewById(R.id.movie_name_textview);
            textView2 = (TextView)v.findViewById(R.id.movie_year_textview);
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        view1 = LayoutInflater.from(context).inflate(R.layout.view_movie_items,parent,false);

        viewHolder1 = new ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        imageLoader = MySingleton.getSingleton(context).getImageLoader();
        imageLoader.get(arrayList.get(position).img_url, ImageLoader.getImageListener(holder.image,
                R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));
        holder.image.setImageUrl(arrayList.get(position).img_url, imageLoader);
        holder.textView.setText(arrayList.get(position).getTitle());
        holder.textView2.setText(arrayList.get(position).getYear());
    }

    @Override
    public int getItemCount(){

        return arrayList.size();

    }
}
