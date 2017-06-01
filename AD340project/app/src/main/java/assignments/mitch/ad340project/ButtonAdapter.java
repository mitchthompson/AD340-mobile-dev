package assignments.mitch.ad340project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;


public class ButtonAdapter extends BaseAdapter {
    private static final String TAG = ButtonAdapter.class.getSimpleName();
    private Context mContext;

    private String[] filenames = {
            "Fav Movies",
            "Alert",
            "Map",
            "Contact"
    };

    public ButtonAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return filenames.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position,
                        View convertView, ViewGroup parent) {
        Button btn;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            btn = new Button(mContext);
            btn.setPadding(8, 8, 8, 8);
        }
        else {
            btn = (Button) convertView;
        }
        btn.setText(filenames[position]);
        // filenames is an array of strings
        btn.setTextColor(Color.parseColor("#3498DB"));
        btn.setBackgroundColor(Color.parseColor("#2C3E50"));
        btn.setId(position);

        btn.setOnClickListener(new MyOnClickListener(position));

        return btn;
    }

    class MyOnClickListener implements View.OnClickListener
    {
        private final int position;

        public MyOnClickListener(int position)
        {
            this.position = position;
        }

        public void onClick(View v)
        {
            if(position == 0){

                Intent intent = new Intent(mContext, MovieListActivity.class);
                mContext.startActivity(intent);

            }else if(position == 1){
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(mContext);
                mBuilder.setTitle(R.string.hw4_dialog_title);
                mBuilder.setMessage(R.string.hw4_dialog_message);
                mBuilder.setPositiveButton("It is cool", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "onClick() 'It is cool' selected");
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "onClick() 'Dimiss' selected");
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = mBuilder.create();
                alertDialog.show();

            }else if(position == 2){
                Intent intent = new Intent(mContext, MapLocation.class);
                mContext.startActivity(intent);
            }else{
                Toast.makeText(mContext, filenames[position],
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

}

