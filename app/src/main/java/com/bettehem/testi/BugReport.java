package com.bettehem.testi;

import android.app.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;

public class BugReport extends Activity implements View.OnClickListener
{

	Button crash, gfxbug;
	Intent CrashReport, GraphicalBug;
	String pack;
	Typeface font;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
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
		
		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
		
		pack = "com.bettehem.testi.";
		
		setContentView(R.layout.bugreport);
		
		crash = (Button)findViewById(R.id.crash);
		gfxbug = (Button)findViewById(R.id.gfxbug);
		
		CrashReport = new Intent(pack + "CRASHREPORT");
		GraphicalBug = new Intent(pack + "GRAPHICALBUG");
		
		crash.setOnClickListener(this);
		gfxbug.setOnClickListener(this);
		
		crash.setTypeface(font);
		gfxbug.setTypeface(font);
	}
	
	public void onClick(View v){
		switch (v.getId()){
			
			case R.id.crash:
				startActivity(CrashReport);
				break;
				
			case R.id.gfxbug:
				startActivity(GraphicalBug);
				break;
			
		}
		
	}
	
}
