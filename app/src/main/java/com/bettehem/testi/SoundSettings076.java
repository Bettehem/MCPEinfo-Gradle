package com.bettehem.testi;
import android.app.*;
import android.content.res.*;
import android.os.*;
import android.view.*;

public class SoundSettings076 extends Activity
{
	@Override
	public void onCreate (Bundle savedInstanceState){
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
		setContentView(R.layout.soundset076);
	}
}
