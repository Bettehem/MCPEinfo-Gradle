package com.bettehem.testi;

import android.app.*;
import android.content.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.view.inputmethod.*;

public class OtherFeedback extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener
{

	Spinner otherfbsub;
	TextView comment, selectSub, tapToSend, iplang;
	EditText typedcomment;
	Button sendbtn;
	String contact, subject, version, message, nomodify, feedback, msgfortoast, selectotherfbsub;
	int numero = 0;
	int duration;
	CharSequence toastmsg;
	Context context;
	Intent emailIntent;
	ArrayAdapter<String> adapter;
	Typeface font;
	InputMethodManager imm;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.otherfeedback);
		
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
		String[] subjects = getResources().getStringArray(R.array.otherfeedback_array);
		otherfbsub = (Spinner) findViewById(R.id.otherfbsub);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, subjects);
		otherfbsub.setAdapter(adapter);
		otherfbsub.setOnItemSelectedListener(this);
		
		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
		
		comment = (TextView)findViewById(R.id.extracomment);
		typedcomment = (EditText)findViewById(R.id.extracommentanswer);
		sendbtn = (Button)findViewById(R.id.sendbtn);
		
		version = getString(R.string.version);
		nomodify = getString(R.string.nomodify);
		
		contact = "bettehem@gmail.com";
		
		sendbtn.setOnClickListener(this);
		
		duration = Toast.LENGTH_LONG;
		
		context = getApplicationContext();
		
		selectSub = (TextView) findViewById(R.id.otherfbsubtxt);
		tapToSend = (TextView) findViewById(R.id.taptosend);
		iplang = (TextView) findViewById(R.id.inputlang);
		
		//comment.setTypeface(font);
		typedcomment.setTypeface(font);
		selectSub.setTypeface(font);
		tapToSend.setTypeface(font);
		sendbtn.setTypeface(font);
		iplang.setTypeface(font);
		
		imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId()){
			case R.id.sendbtn:
				subject = otherfbsub.getSelectedItem().toString();
				feedback = typedcomment.getText().toString();
				if(feedback.contentEquals("")){
					msgfortoast = getString(R.string.typesomethingfirst);
					toastmsg = msgfortoast;
					Toast.makeText(context, toastmsg, duration).show();
				}
				else{
					msgfortoast = getString(R.string.thanksforfb);
					toastmsg = msgfortoast;
					Toast.makeText(context, toastmsg, duration).show();
					
					imm.hideSoftInputFromWindow(typedcomment.getWindowToken(), 0);
					
					emailmessage();
					sending();
				}
				break;
		}
	}
	
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		int position = otherfbsub.getSelectedItemPosition();

		switch (position){
			case 0:
				sendbtn.setVisibility(Button.INVISIBLE);
				break;

			case 1:
				sendbtn.setVisibility(Button.VISIBLE);
				break;

			case 2:
				sendbtn.setVisibility(Button.INVISIBLE);
				break;
		}
	}
	
	@Override
	public void onNothingSelected(AdapterView<?> p1)
	{
		
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
			"\nFeedback message:\n"
			+ feedback;
	}
	
}
