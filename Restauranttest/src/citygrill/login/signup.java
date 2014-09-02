package citygrill.login;

import android.app.Activity;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import citygrill.login.Login;
import citygrill.gui.MainActivity;
import com.example.testtab.R;

public class signup extends Activity{
	Intent i=null;
	ImageView im=null;
	EditText tv1,tv2,tv3,tv4,tv5;
	boolean flag=false;
	SQLiteDatabase db=null;
	LoginDataBaseAdapter loginDataBaseAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		im=(ImageView)findViewById(R.id.show_hidepass);
		tv1=(EditText)findViewById(R.id.username);
		tv2=(EditText)findViewById(R.id.email_iduser);
		tv3=(EditText)findViewById(R.id.phonenumber);
		tv4=(EditText)findViewById(R.id.passwordlogin);
		tv5=(EditText)findViewById(R.id.ConfirmPassworduser);
		db=openOrCreateDatabase("mydb", MODE_PRIVATE, null);
		db.execSQL("create table if not exists login(name varchar,mobile_no varchar,email_id varchar,password varchar,flag varchar)");
		
		im.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
			
				if(flag==false)
				{
					im.setImageResource(R.drawable.hidenew);
					tv4.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
					flag=true;
				}
				else
				{
					im.setImageResource(R.drawable.shownew);
					tv4.setInputType(129);
					flag=false;
					
				}
			}
		});
	}
	
	public void action(View v)
	{
	switch(v.getId())
	{
	case R.id.loginuser: 
		i=new Intent(this,Login.class);
		startActivityForResult(i, 500);
		overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom); 
		finish();
		break;
	case R.id.signupuser:
		String name=tv1.getText().toString();
		String email_id=tv2.getText().toString();
		String mobile_no=tv3.getText().toString();
		String password=tv4.getText().toString();
		String confirmpassword=tv5.getText().toString();
		if(name==null||name==""||name.length()<3)
		{
			show("Please Enter Correct Name.");
		}
		else if(mobile_no==null||mobile_no==""||mobile_no.length()<10)
		{
			show("Please Enter Correct mobile number.");
		}
		else if(email_id==null||email_id==""||email_id.length()<10)
		{
			show("Please Enter Correct Email id.");
		}
		else if(password==null||password==""||password.length()<6  )
		{
			show("Please Enter Strong Password.");
		}
		else if(confirmpassword==null||confirmpassword=="" )
		{
			show("Please ReEnter  Password on confirmPassword");
		}
		
		else if(!password.equals(confirmpassword))
         {
			 //show("Please ReEnter  Password on confirmPassword");
			 Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
             return;
         }
		else
		{
			db.execSQL("insert into login values('"+name+"','"+mobile_no+"','"+email_id+"','"+password+"','nothing')");
			i=new Intent(this,MainActivity.class);
			startActivityForResult(i, 500);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); 
			db.close();
			finish();
		}
		break;
	}
  }
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	} 
	
	public void show(String str)
	{
	Toast.makeText(this, str, Toast.LENGTH_LONG).show();	
	}
}