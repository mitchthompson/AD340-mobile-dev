package assignments.mitch.ad340project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayFunFactsActivity extends AppCompatActivity {
    private static final String TAG = DisplayFunFactsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "onCreate() starting");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        if(message != null) {
            Log.d(TAG, "User text passed successfully from MainActivity");
            TextView textView = (TextView) findViewById(R.id.hw2_name);
            textView.setText("Hello, " + message + "! Here are some fun facts about me...");
        }else{
            Log.d(TAG, "Outputting default text...");
            TextView textView = (TextView) findViewById(R.id.hw2_name);
            textView.setText("Hello! Here are some fun facts about me...");
        }


        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.main_menu, menu);
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
