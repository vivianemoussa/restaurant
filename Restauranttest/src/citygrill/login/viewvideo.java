package citygrill.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.VideoView;
import android.widget.MediaController;
import com.order.R;

public class viewvideo extends Activity {
	private VideoView video;
	/*private ImageButton mPlay;
	private ImageButton mPause;
	private ImageButton mReset;
	private ImageButton mStop;
	private String current;*/
	private int position=0;
	private MediaController mediaControls;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(0);
		setContentView(R.layout.videopage);
		
			 
		if (mediaControls==null){
			mediaControls=new MediaController(viewvideo.this);
			
		}
		video = (VideoView) findViewById(R.id.video);
		/*mPlay = (ImageButton) findViewById(R.id.play);
		mPause = (ImageButton) findViewById(R.id.pause);
		mReset = (ImageButton) findViewById(R.id.reset);
		mStop = (ImageButton) findViewById(R.id.stop);*/
		
		final ProgressDialog progressdialog = new ProgressDialog(viewvideo.this);
		progressdialog.setTitle("View Video Restaurant");
		progressdialog.setMessage("Loading ...");
		progressdialog.setCancelable(false);
		progressdialog.show();
		
		try{
			video.setMediaController(mediaControls);
			// Load and start the movie
			Uri video1 = Uri.parse("android.resource://" + getPackageName() + "/"
					+ R.raw.restaurantvideo);
			video.setVideoURI(video1);
			//video.start();
		}catch (Exception e){
			Log.e("Error",e.getMessage());
			e.printStackTrace();
		}
		
		video.requestFocus();
		
		video.setOnPreparedListener(new OnPreparedListener() {
			
			public void onPrepared(MediaPlayer mediaplayer) {
				// TODO Auto-generated method stub
				progressdialog.dismiss();
				video.seekTo(position);
				if(position==0){
					video.start();
				}else{
					video.pause();
				}
				
			}
		});
	}
		
		


	

	/*	mPlay.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				if (video != null) {
					video.pause();
				}
			}
		});

		mPause.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				if (video != null) {
					video.pause();
				}
			}
		});
		mReset.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				if (video != null) {
					video.seekTo(0);
				}
			}
		});
		mStop.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				if (video != null) {
					current = null;
					video.stopPlayback();
				}
			}
		});

	}*/

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putInt("Position", video.getCurrentPosition());
		video.pause();
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		position = savedInstanceState.getInt("Position");
		video.seekTo(position);
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 */

}
