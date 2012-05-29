package tab;



import com.tab.R;

import goodsInfo.*;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.AdapterView.OnItemClickListener;

public class FindStore extends ListActivity{
	MyListAdapter adapter;	
	Button next;
	Button previous;
	ViewFlipper vf;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findstorelist);
        ListView listview1 = (ListView) findViewById(android.R.id.list);
       // ListView listview2 = (ListView) findViewById(android.R.id.list);
        //ListView listview3 = (ListView) findViewById(android.R.id.list);
        adapter = new MyListAdapter(this);
        setListAdapter(adapter);
        //vf = (ViewFlipper) findViewById(R.id.ViewFlipper01);
        //next = (Button) findViewById(R.id.Button01);
       // previous = (Button) findViewById(R.id.Button02);
        //next.setOnClickListener(flipperClick);
        //previous.setOnClickListener(flipperClick);
       
        
        listview1.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//ImageView iv = (ImageView)view.findViewById(R.id.imageView1);
				//iv.setImageResource(R.drawable.icon);
				// When clicked, show a toast with the TextView text
				switch (position){
				case 0: {
					Intent i = new Intent(FindStore.this,GoodsInfoInFlushing.class);
					startActivity(i);break;}
				case 1:{
					Intent i = new Intent(FindStore.this,GoodsInfoInRegoPark.class);
					startActivity(i);break;}
				case 2:{
					Intent i = new Intent(FindStore.this,GoodsInfoInGallery.class);
					startActivity(i);break;}
				}
				//Toast.makeText(getApplicationContext(), "Item Clicked" + adapter.getItemId(view.getId()), Toast.LENGTH_LONG).show();
				//adapter.getView(position, view, parent);
			}
		}); 
        
    }

	private OnClickListener flipperClick = new OnClickListener(){
		public void onClick(View myView){
			 if (myView == next) {
			 vf.showNext();
			 }
			 if (myView == previous) {
			 vf.showPrevious();
			 }
		}
	};
    public class MyListAdapter extends BaseAdapter{
    	Context mContext;
    	public static final int ACTIVITY_CREATE = 10;
    	String [] name = { "Quaker Bridge Mall\n Quakerbridge Road, Lawrence Township, NJ 08648 \n(609) 799-8177 ‎\nToday's Hours : 9:00AM - 11:00PM\nTomorrow's Hours : 8:00AM - 11:00PM",
    			"Quaker Bridge Mall\n150 Quaker Bridge Mall, Lawrenceville, NJ\n(609) 275-1917\nToday's Hours : 9:00AM - 11:00PM \nTomorrow's Hours : 8:00AM - 11:00PM",
    			"Quaker Bridge Mall\n3320 Brunswick Pike, Lawrenceville, NJ 08648\n718/760-7101\nToday's Hours : 10:00AM - 9:30PM \nTomorrow's Hours : 10:00AM - 9:00PM "};
    	int [] pic = {R.drawable.q1,R.drawable.q2,R.drawable.q3};
    	public MyListAdapter(Context c){
    		mContext = c;
    	}

    	@Override
    	public int getCount() {
    		// TODO Auto-generated method stub
    		return 3;
    	}

    	@Override
    	public Object getItem(int position) {
    		// TODO Auto-generated method stub
    		Toast.makeText(mContext, "Item " + position + " clicked " + Toast.LENGTH_LONG, Toast.LENGTH_LONG).show();
    		return null;
    	}

    	public void getItem(int position, long id) {
    		Toast.makeText(mContext, "Item " + position + " clicked " + id, Toast.LENGTH_LONG).show();
    	}
    	@Override
    	public long getItemId(int position) {
    		// TODO Auto-generated method stub
    		return 0;
    	}

    	@Override
    	public View getView(int position, View convertView, ViewGroup parent) {
    		// TODO Auto-generated method stub
           LayoutInflater mInflater;
    		
    		mInflater = LayoutInflater.from(mContext);
    		View v;
    		if(convertView==null){
    			//LayoutInflater li = getLayoutInflater();
    			v = mInflater.inflate(R.layout.storeinfo, null);
    			TextView tv = (TextView) v.findViewById(R.id.col1);
    			tv.setText(name[position]);
    			ImageView iv = (ImageView)v.findViewById(R.id.ImageView01);
    			iv.setImageResource(pic[position]);

    		}
    		else
    		{
    			v = convertView;
    		}
    		return v;
    		
    	}
    	
    }
}
