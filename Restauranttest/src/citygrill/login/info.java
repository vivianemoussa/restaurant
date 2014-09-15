package citygrill.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import com.order.R;

public class info extends Activity {
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setRequestedOrientation(0);
		// initialise form widget
		setContentView(R.layout.info);
		Button videov = (Button) findViewById(R.id.buttonvideo);

		videov.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// starting new activity on button click
				Intent i1 = new Intent(info.this, viewvideo.class);
				startActivity(i1);

			}
		});

	}
}