package com.bettehem.testi;

import android.app.*;
import android.content.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.view.inputmethod.*;
import android.preference.*;

public class CrashReport extends Activity implements View.OnClickListener
{
	Button sendbtn;
	EditText issue, extra, whatrom;
	Intent emailIntent;
	String contact, subject, version, message, issuetxt, extratxt, nomodify, crashrepsub, msgfortoast, appversion, musicsetting, whatromtxt;
	TextView text1, text2, text3, text4, text5, iplang;
	Typeface font;
	CharSequence toastmsg;
	Context context;
	int duration, androidNum1, androidNum2, androidNum3;
	InputMethodManager imm;
	boolean musicset;
	NumberPicker androidversionNum1, androidversionNum2, androidversionNum3;
	Switch customromsw;
	int toggleon = 0;
	String androidversion, customromtoggletxt;
	ToggleButton customromtoggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
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
		setContentView(R.layout.crashreport);
		
		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
		
		version = getString(R.string.version);
		nomodify = getString(R.string.nomodify);
		crashrepsub = getString(R.string.crashrepsub);
		appversion = getString(R.string.manappvs);
		
		contact = "bettehem@gmail.com";
		subject = crashrepsub + " " + version + " " + appversion;
		
		sendbtn = (Button)findViewById(R.id.sendbtn);
		issue = (EditText)findViewById(R.id.whathappenedanswer);
		extra = (EditText)findViewById(R.id.extracommentanswer);
		whatrom = (EditText)findViewById(R.id.customromanswer);
		
		sendbtn.setOnClickListener(this);
		
		sendbtn.setTypeface(font);
		issue.setTypeface(font);
		extra.setTypeface(font);
		whatrom.setTypeface(font);
		
		text1 = (TextView) findViewById(R.id.whathappened);
		text2 = (TextView) findViewById(R.id.extracomment);
		text3 = (TextView) findViewById(R.id.taptosend);
		text4 = (TextView) findViewById(R.id.customromtxt);
		iplang = (TextView) findViewById(R.id.inputlang);
		
		text1.setTypeface(font);
		text2.setTypeface(font);
		text3.setTypeface(font);
		text4.setTypeface(font);
		iplang.setTypeface(font);
		
		context = getApplicationContext();
		
		duration = Toast.LENGTH_LONG;
		
		imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		
		
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());//used to check the settings in the preference menu
		musicset = getPrefs.getBoolean("music_check", true);
		if (musicset == true){
			musicsetting = "enabled";
		}else{
			musicsetting = "disabled";
		}
		
		
		customromtoggle = (ToggleButton) findViewById(R.id.customromtoggle);
		customromtoggle.setOnClickListener(this);
		customromtoggle.setTypeface(font);
	}
	
	@Override
	public void onClick (View v){
			switch (v.getId()){
				case R.id.sendbtn:
					issuetxt = issue.getText().toString();
					
					if (toggleon == 1){
						whatromtxt = whatrom.getText().toString();
					}


					if (issuetxt.contentEquals("")){

						if (toggleon == 1 && whatromtxt.contentEquals("")){
							msgfortoast = getString(R.string.typerequiredplusrom);
						}else{
							msgfortoast = getString(R.string.typerequired);
						}

						toastmsg = msgfortoast;
						Toast.makeText(context, toastmsg, duration).show();

					}else if (toggleon == 1 && whatromtxt.contentEquals("")){
						msgfortoast = getString(R.string.musttyperom);
						toastmsg = msgfortoast;
						Toast.makeText(context, toastmsg, duration).show();
					}else{
						extratxt = extra.getText().toString();

						imm.hideSoftInputFromWindow(issue.getWindowToken(), 0);
						imm.hideSoftInputFromWindow(extra.getWindowToken(), 0);
						
						androidversion = Build.VERSION.RELEASE.toString();

						emailmessage();

						sending();
					}
					break;
					
				case R.id.customromtoggle:
					customromtoggletxt = customromtoggle.getText().toString();
					if (customromtoggletxt.contentEquals(getString(R.string.yes))){
						whatrom.setVisibility(EditText.VISIBLE);
						toggleon = 1;
					}else{
						whatrom.setVisibility(EditText.INVISIBLE);
						whatrom.setText("");
						toggleon = 0;
					}
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
			"\nWhat happened:\n"
			+ issuetxt +
			"\n\nAndroid version is:\n"
			+ androidversion +
			"\n\nCustom ROM:\n"
			+ whatromtxt +
			"\n\nExtra comment:\n"
			+ extratxt + 
			"\n\nSettings:\n"
			+ "  Music is " + musicsetting;
	}
	
}
