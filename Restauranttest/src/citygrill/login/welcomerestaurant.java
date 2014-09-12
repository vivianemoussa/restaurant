package citygrill.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

import citygrill.login.Login;
import citygrill.login.signup;
import com.order.R;
import citygrill.login.info;
import citygrill.login.help;

public class welcomerestaurant extends Activity {
	Intent i = null;
	Button registeredButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setRequestedOrientation(0);
		setContentView(R.layout.welcomerestaurant);
		ImageButton facebook = (ImageButton) findViewById(R.id.facebook_link);

		facebook.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
				startActivity(browserIntent);

			}

			// TODO Auto-generated method stub

		});
		ImageButton twitter = (ImageButton) findViewById(R.id.twiter_link);

		twitter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"));
				startActivity(twitterIntent);

			}

			// TODO Auto-generated method stub

		});

	}

	/*
	 * Button help = (Button) findViewById(R.id.Help);
	 * 
	 * help.setOnClickListener(new OnClickListener() {
	 * 
	 * @Override public void onClick(View v) { // TODO Auto-generated method
	 * stub // starting new activity on button click Intent i1 = new
	 * Intent(welcomerestaurant.this, help.class); startActivity(i1);
	 * 
	 * } }); Button info = (Button) findViewById(R.id.Info);
	 * info.setOnClickListener(new OnClickListener() {
	 * 
	 * @Override public void onClick(View v) { // TODO Auto-generated method
	 * stub // starting new activity on button click Intent i1 = new
	 * Intent(welcomerestaurant.this, info.class); startActivity(i1);
	 * 
	 * } });}
	 */

	/*
	 * registeredButton = (Button)findViewById(R.id.log_inuser);
	 * 
	 * registeredButton.setOnClickListener(new OnClickListener() {
	 * 
	 * @Override public void onClick(View v) { Intent iL =new
	 * Intent(welcomerestaurant.this,login.class); startActivity(iL); } }); }
	 */

	public void login_sigin(View v) {
		switch (v.getId()) {
		case R.id.log_inuser:
			i = new Intent(this, Login.class);
			startActivityForResult(i, 500);
			overridePendingTransition(R.anim.slide_in_right,
					R.anim.slide_out_left);
			finish();
			break;
		case R.id.sign_up:
			i = new Intent(this, signup.class);
			startActivityForResult(i, 500);
			overridePendingTransition(R.anim.slide_in_right,
					R.anim.slide_out_left);

			break;
		case R.id.Help:
			i = new Intent(this, help.class);
			startActivityForResult(i, 500);
			overridePendingTransition(R.anim.slide_in_right,
					R.anim.slide_out_left);

			break;
		case R.id.Info:
			i = new Intent(this, info.class);
			startActivityForResult(i, 500);
			overridePendingTransition(R.anim.slide_in_right,
					R.anim.slide_out_left);

			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	}
}
