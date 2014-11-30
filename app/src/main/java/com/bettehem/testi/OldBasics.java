package com.bettehem.testi;

import android.app.*;
import android.content.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class OldBasics extends Activity implements View.OnClickListener{

	Button version076;
	Intent basics076;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		stuff();
		
		View view = findViewById(R.id.backround);
		   int orientation = getResources().getConfiguration().orientation;
		   if (orientation == Configuration.ORIENTATION_LANDSCAPE){
			   view.setBackgroundResource(R.drawable.mcpewallvaaka);
		   }else{
			   view.setBackgroundResource(R.drawable.mcpeinfowall);
		   }
		
	}
	
	public void stuff(){
		setContentView(R.layout.oldbasics);
		
		version076 = (Button) findViewById(R.id.version076);
		
		version076.setOnClickListener(this);
		
		basics076 = new Intent ("com.bettehem.testi.BASICS076");
		
	}
	
	public void onClick(View v){
		switch(v.getId()){
		
		case R.id.version076:
			startActivity(basics076);
			break;
		
		}
	}
	
}
