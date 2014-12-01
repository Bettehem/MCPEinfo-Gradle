package com.bettehem.testi;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.res.*;
import android.graphics.*;
import android.view.inputmethod.*;

public class Rating extends Activity implements View.OnClickListener
{
	Button sendbtn;
	EditText extra;
	Intent emailIntent;
	String contact, subject, version, message, extratxt, nomodify, ratingsub, appversion;
	RatingBar ratingbar;
	float starsvalue;
	int stars;
	TextView text1, text2, text3, iplang;
	Typeface font;
	InputMethodManager imm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		stuff();
		
		//View view = findViewById(R.id.backround);
		int orientation = getResources().getConfiguration().orientation;
		if (orientation == Configuration.ORIENTATION_LANDSCAPE){
			//view.setBackgroundResource(R.drawable.mcpewallvaaka);
			getWindow().setBackgroundDrawableResource(R.drawable.mcpewallvaaka);
		}else{
			//view.setBackgroundResource(R.drawable.mcpeinfowall);
			getWindow().setBackgroundDrawableResource(R.drawable.mcpeinfowall);
		}
	}
	
	public void stuff(){
		setContentView(R.layout.rating);
		
		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
		
		version = getString(R.string.version);
		nomodify = getString(R.string.nomodify);
		ratingsub = getString(R.string.ratingsub);
		appversion = getString(R.string.manappvs);

		contact = "bettehem@gmail.com";
		subject = ratingsub + " " + version + " " + appversion;
		
		sendbtn = (Button)findViewById(R.id.sendbtn);
		sendbtn.setOnClickListener(this);
		
		extra = (EditText)findViewById(R.id.extracommentanswer);
		
		ratingbar = (RatingBar)findViewById(R.id.ratingbar);
		
		text1 = (TextView) findViewById(R.id.ratingtxt);
		text2 = (TextView) findViewById(R.id.extracomment);
		text3 = (TextView) findViewById(R.id.taptosend);
		iplang = (TextView) findViewById(R.id.inputlang);
		
		sendbtn.setTypeface(font);
		extra.setTypeface(font);
		text1.setTypeface(font);
		text2.setTypeface(font);
		text3.setTypeface(font);
		iplang.setTypeface(font);
		
		imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
	}
	
	public void onClick (View v){
		switch (v.getId()){
			case R.id.sendbtn:
				extratxt = extra.getText().toString();
				
				starsvalue = ratingbar.getRating();
				stars = (int)starsvalue;
				
				imm.hideSoftInputFromWindow(extra.getWindowToken(), 0);
				
				emailmessage();
				
				sending();
				break;
		}
	}
	
	public void sending(){

		String emailaddress[] = {contact};
        emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(emailIntent);
		finish();
	}

	public void emailmessage(){
		message =
			nomodify +
			"\nThis user gave you the following rating:\n"
			+ stars + " stars" +
			"\n\nExtra comment:\n"
			+ extratxt;
	}
	
}
