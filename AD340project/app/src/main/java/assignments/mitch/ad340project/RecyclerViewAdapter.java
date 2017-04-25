package assignments.mitch.ad340project;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    String[] MovieNames;
    String[] MovieYears;
    Context context;
    View view1;
    ViewHolder viewHolder1;
    TextView textView;

    public RecyclerViewAdapter(Context context1, String[][] movies){
        String[] names = new String[13];
        String[] years = new String[13];
        for (int i = 0; i < movies.length; i++){
                names[i] = movies[i][0];
                years[i] = movies[i][1];
        }

        MovieNames = names;
        MovieYears = years;
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

        holder.textView.setText(MovieNames[position]);
        holder.textView2.setText(MovieYears[position]);
    }

    @Override
    public int getItemCount(){

        return MovieNames.length;
    }
}