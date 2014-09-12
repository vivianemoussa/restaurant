package citygrill.data;
import com.order.R;
import android.view.View;
import android.view.Window;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	   // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(0);
		setContentView(R.layout.main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
