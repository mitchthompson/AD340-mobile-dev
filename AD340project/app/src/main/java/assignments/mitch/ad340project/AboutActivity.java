package assignments.mitch.ad340project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

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
