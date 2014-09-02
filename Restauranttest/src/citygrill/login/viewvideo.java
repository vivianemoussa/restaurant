package citygrill.login;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.VideoView;
//import com.order.R;
import com.example.testtab.R;

public class viewvideo extends Activity  {
	private VideoView video;
	private ImageButton mPlay;
	private ImageButton mPause;
	private ImageButton mReset;
	private ImageButton mStop;
	private String current;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setRequestedOrientation(0);
		setContentView(R.layout.videopage);
		
		video = (VideoView) findViewById(R.id.video);
		mPlay = (ImageButton) findViewById(R.id.play);
		mPause = (ImageButton) findViewById(R.id.pause);
		mReset = (ImageButton) findViewById(R.id.reset);
		mStop = (ImageButton) findViewById(R.id.stop);
		
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
