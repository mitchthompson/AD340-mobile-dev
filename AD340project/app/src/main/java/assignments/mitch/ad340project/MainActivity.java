package assignments.mitch.ad340project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "assignments.mitch.ad340project.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ButtonAdapter(this));

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayFunFactsActivity.class);
        EditText editText = (EditText) findViewById(R.id.hw2_edit_name);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    //Actionbar Menu
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