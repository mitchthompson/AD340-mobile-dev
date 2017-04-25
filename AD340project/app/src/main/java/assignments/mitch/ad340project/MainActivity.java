package assignments.mitch.ad340project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "assignments.mitch.ad340project.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ButtonAdapter(this));


    }

    public void funFacts(View view) {
        Intent intent = new Intent(this, DisplayFunFactsActivity.class);
        startActivity(intent);
    }

}