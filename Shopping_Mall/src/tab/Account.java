package tab;


import com.tab.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Account extends Activity implements OnClickListener{

	ImageButton faceBook;
	ImageButton twitter;
	ImageButton web;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account);
		faceBook = (ImageButton) findViewById(R.id.button1);
		twitter = (ImageButton) findViewById(R.id.button2);
		web = (ImageButton) findViewById(R.id.button3);
		faceBook.setOnClickListener(this);
		twitter.setOnClickListener(this);
		web.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
