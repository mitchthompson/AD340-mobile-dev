package assignments.mitch.ad340project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class MovieListActivity extends AppCompatActivity {
    private static final String TAG = MovieListActivity.class.getSimpleName();
    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    static RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    String url = "http://mitchlthompson.com/ad340/movies.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_movie_list);

        context = getApplicationContext();
        relativeLayout = (RelativeLayout) findViewById(R.id.movie_list_layout);
        recyclerView = (RecyclerView) findViewById(R.id.movie_list_recyclerview);

        recylerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);

        BackgroundTask backgroundTask = new BackgroundTask(context);

        ArrayList<MovieObject> movies = backgroundTask.getList();
        recyclerViewAdapter = new RecyclerViewAdapter(context, movies);
        recyclerView.setAdapter(recyclerViewAdapter);


        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_movies_list);
        item.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_about){
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_movies_list){
            Intent intent = new Intent(this, MovieListActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_fun_facts){
            Intent intent = new Intent(this, DisplayFunFactsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}

