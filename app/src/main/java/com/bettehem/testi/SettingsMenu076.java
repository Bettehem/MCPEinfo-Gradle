package com.bettehem.testi;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class SettingsMenu076 extends Activity implements View.OnClickListener
{
	Button gameset, ctrlset, graphset, soundset;
	Intent gamesetmenu, ctrlsetmenu, graphsetmenu, soundsetmenu;
	String name;
	
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
		setContentView(R.layout.settingsmenu076);
		
		gameset = (Button) findViewById(R.id.gameset);
		ctrlset = (Button) findViewById(R.id.ctrlset);
		graphset = (Button) findViewById(R.id.graphset);
		soundset = (Button) findViewById(R.id.soundset);
		
		gameset.setOnClickListener(this);
		ctrlset.setOnClickListener(this);
		graphset.setOnClickListener(this);
		soundset.setOnClickListener(this);
		
		name = "com.bettehem.testi.";
		
		gamesetmenu = new Intent (name + "GAMESETTINGS076");
		ctrlsetmenu = new Intent (name + "CONTROLSETTINGS076");
		graphsetmenu = new Intent (name + "GRAPHICSETTINGS076");
		soundsetmenu = new Intent (name + "SOUNDSETTINGS076");
	}
	
	public void onClick(View v){
		switch (v.getId()){
			
			case R.id.gameset:
			startActivity(gamesetmenu);
			break;
			
			case R.id.ctrlset:
			startActivity(ctrlsetmenu);
			break;
			
			case R.id.graphset:
			startActivity(graphsetmenu);
			break;
			
			case R.id.soundset:
			startActivity(soundsetmenu);
			break;
		}
	}
}
