package citygrill.login;



import android.app.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import citygrill.login.login;
import citygrill.login.signup;
import com.example.testtab.R;


public class welcomerestaurant extends Activity{
	Intent i=null;
	Button registeredButton;
	
	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcomerestaurant);
		registeredButton = (Button)findViewById(R.id.log_inuser);
	
		registeredButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent iL =new Intent(welcomerestaurant.this,login.class);
			startActivity(iL);
		}
	});
	}
	/*public void login_sigin(View v)
	{
		switch(v.getId())
		{
		case R.id.log_inuser:
			i=new Intent(this,login.class);
			startActivity(i);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); 
			break;
		case R.id.sign_up:
			i=new Intent(this,signup.class);
			startActivity(i);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);;
			break;	
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	} */
}
