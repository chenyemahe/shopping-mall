package tab;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.tab.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Home extends Activity implements OnClickListener {

	Button signIn;
	public static final String PREFS_NAME = "userInfo";
	EditText userName;
	EditText passWord;
	JSONObject logInfo;
	static final int DIALOG_PAUSED_ID = 0;
	static final int DIALOG_GAMEOVER_ID = 1;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		signIn = (Button) findViewById(R.id.button1);
		userName = (EditText) findViewById(R.id.username);
		passWord = (EditText) findViewById(R.id.password);
		signIn.setOnClickListener(this);
		
		getUserInfo();

	}

	
	protected Dialog onCreateDialog(int id) {
		AlertDialog alert;
	    switch(id) {
	    case DIALOG_PAUSED_ID:
	        // do the work to define the pause Dialog
	    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Sorry, user name or password invalid!")
			       .setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			           }
			       });
			alert = builder.create();
	        break;
	    default:
	        alert = null;
	    }
	    return alert;
	}
	
	/**
	 * get user name and password from shared preference
	 */
	public void getUserInfo() {
		String username;
		String password;

		SharedPreferences pref = getSharedPreferences(PREFS_NAME, 0);

		username = pref.getString("id", "");
		password = pref.getString("pwd", "");

		if (username != "" && password != "") {
			userName.setText(username);
			passWord.setText(password);
		}
	}

	@Override
    protected void onStop(){
      super.onStop();

      //save user info when activity go onStop state
      String username = userName.getText().toString();
      String password = passWord.getText().toString();
      SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
      SharedPreferences.Editor editor = settings.edit();
      editor.putBoolean("save", true);
      editor.putString("id", username);
      editor.putString("pwd", password);

      // Commit the edits!
      editor.commit();
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1: {;
			if(checkUserID()){
				showDialog(DIALOG_PAUSED_ID);
				break;
				}
			Intent i = new Intent(this, StartMenu.class);
			Bundle bundle = new Bundle();
			bundle.putString("logType", "signIn");
			i.putExtras(bundle);
			startActivity(i);
			break;
		}
		}
	}


	private boolean checkUserID() {		
	      String username = userName.getText().toString();
	      String password = passWord.getText().toString();
	      
	      String Url = "http://venus.cs.qc.edu/~chye6063/phpSession/login.php";
	      
	      DefaultHttpClient myHttpClient = new DefaultHttpClient();
	      HttpPost myPost = new HttpPost(Url);
	      
	      
	      
		return false;
		
	}
}
