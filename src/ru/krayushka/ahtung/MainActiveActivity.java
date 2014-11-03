package ru.krayushka.ahtung;

import org.apache.http.protocol.HTTP;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActiveActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_active);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_active, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent i = new Intent(this, SettingsActivity.class);
			startActivity(i);
			return true;
		}
		
		// mute clicked
		if (id == R.id.mute)
		{
			Context context = getApplicationContext();
			CharSequence text = "Muted!";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}
		
		// share clicked
		if (id == R.id.share)
		{
			
			// Create the text message with a string
			Intent sendIntent = new Intent();
			sendIntent.setAction(Intent.ACTION_SEND);
			sendIntent.putExtra(Intent.EXTRA_TEXT, "Z16D42Q");
			sendIntent.setType(HTTP.PLAIN_TEXT_TYPE); // "text/plain" MIME type

			// Verify that the intent will resolve to an activity
			if (sendIntent.resolveActivity(getPackageManager()) != null) {
			    startActivity(sendIntent);
			}

		}
		if (id == R.id.leave)
		{
			finish();
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
	public void warningClicked(View view)
	{
		Intent i = new Intent(this, IncomingSignalActivity.class);
		startActivity(i);
	}
	
	public void alertClicked(View view)
	{
		Intent i = new Intent(this, IncomingSignalActivity.class);
		startActivity(i);
	}
	
	public void cancelClicked(View view)
	{
		Intent i = new Intent(this, IncomingSignalActivity.class);
		startActivity(i);
	}

	
	
	
}
