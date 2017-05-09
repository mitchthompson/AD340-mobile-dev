package assignments.mitch.ad340project;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = DisplayFunFactsActivity.class.getSimpleName();
    String[] movieTitle;
    String[] movieYear;
    Context context;
    View view1;
    ViewHolder viewHolder1;
    String[][] movieList;


    public RecyclerViewAdapter(Context context1, String[][] movies){
        movieList = movies;
        context = context1;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public TextView textView2;

        public ViewHolder(View v){

            super(v);

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

        holder.textView.setText(movieList[position][0]);
        holder.textView2.setText(movieList[position][1]);
    }

    @Override
    public int getItemCount(){

        return movieList.length;
    }

}