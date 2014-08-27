package citygrill.login;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.VideoView;
//import com.order.R;
import com.example.testtab.R;

public class viewvideo extends Activity  {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setRequestedOrientation(0);
		setContentView(R.layout.videopage);
		VideoView video = (VideoView) findViewById(R.id.video);
		// Load and start the movie
		Uri video1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.restaurantvideo);
		video.setVideoURI(video1);
		video.start();
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/


}
