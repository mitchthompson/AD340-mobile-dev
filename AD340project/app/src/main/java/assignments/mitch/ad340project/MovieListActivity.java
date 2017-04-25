package assignments.mitch.ad340project;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.RelativeLayout;


public class MovieListActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    String[][] movies =
            {
                    {"Jurassic Park", "1993"},
                    {"Contact", "1997"},
                    {"The Empire Strikes Back", "1980"},
                    {"The Lion King", "1994"},
                    {"Shawshank Redemption", "1994"},
                    {"Interstellar", "2014"},
                    {"Back to the Future II", "1985"},
                    {"Alien", "1979"},
                    {"Wall-E", "2008"},
                    {"V for Vendetta", "2005"},
                    {"The Big Lebowski", "1998"},
                    {"Fargo", "1996"},
                    {"Groundhog Day", "1993"}
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_movie_list);

        context = getApplicationContext();

        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout1);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);

        recylerViewLayoutManager = new LinearLayoutManager(context);

        recyclerView.setLayoutManager(recylerViewLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(context, movies);

        recyclerView.setAdapter(recyclerViewAdapter);
    }
}

