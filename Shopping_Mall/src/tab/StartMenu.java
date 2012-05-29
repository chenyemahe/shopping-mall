package tab;

import com.tab.R;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class StartMenu extends TabActivity {

	String logType;

	public void onCreate(Bundle SavedInstanceState) {
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.start);
		logType = null;
		Bundle bundle = getIntent().getExtras();
		if (bundle != null)
			logType = bundle.getString("logType");

		Resources res = getResources();
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		if (logType == null) {
			intent = new Intent().setClass(this, Home.class);
			spec = tabHost.newTabSpec("Home")
					.setIndicator("", res.getDrawable(R.drawable.home))
					.setContent(intent);
			tabHost.addTab(spec);
		} else {
			if (logType.equals("signIn")) {
				intent = new Intent().setClass(this, SignIn.class);
				spec = tabHost.newTabSpec("Home")
						.setIndicator("", res.getDrawable(R.drawable.home))
						.setContent(intent);
				tabHost.addTab(spec);

			}
		}
		// Create an Intent to launch an Activity for the tab (to be reused)
		intent = new Intent().setClass(this, FindStore.class);

		// Initialize a TabSpec for each tab and add it to the TabHost
		spec = tabHost.newTabSpec("FindStore")
				.setIndicator("", res.getDrawable(R.drawable.search))
				.setContent(intent);
		tabHost.addTab(spec);

		// Do the same for the other tabs
		intent = new Intent().setClass(this, History.class);
		spec = tabHost.newTabSpec("History")
				.setIndicator("", res.getDrawable(R.drawable.history))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, Account.class);
		spec = tabHost.newTabSpec("Account")
				.setIndicator("", res.getDrawable(R.drawable.account))
				.setContent(intent);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(0);
	}
}
