package tab;


import com.tab.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class SignIn extends Activity{

	GridView grid_main;
	TextView myText;
	String[] name = {"Macy's","Sprint","GameStop", "Coach","Old Navy","Sears"};
	int[] no = {R.drawable.macy,R.drawable.sprint, R.drawable.gamestop,R.drawable.coach,R.drawable.oldnavy,R.drawable.sears};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shopmain);

		grid_main = (GridView) findViewById(R.id.gridview);
		grid_main.setAdapter(new ImageAdapter(this));
	}

	public class ImageAdapter extends BaseAdapter {
		Context mContext;
		public static final int ACTIVITY_CREATE = 10;

		public ImageAdapter(Context c) {
			mContext = c;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return name.length;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View v;
			if (convertView == null) {
				LayoutInflater li = getLayoutInflater();
				v = li.inflate(R.layout.grid_item, null);
				TextView tv = (TextView) v.findViewById(R.id.icon_text);
				tv.setText(name[position]);
				ImageView iv = (ImageView) v.findViewById(R.id.icon_image);
				iv.setImageResource(no[position]);

			} else {
				v = convertView;
			}
			return v;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}
