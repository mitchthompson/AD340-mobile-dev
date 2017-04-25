package assignments.mitch.ad340project;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;


public class ButtonAdapter extends BaseAdapter {
    private Context mContext;

    private String[] filenames = {
            "Fav Movies",
            "Fav Books",
            "Projects",
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

            }else {
                Toast.makeText(mContext, filenames[position],
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

}

