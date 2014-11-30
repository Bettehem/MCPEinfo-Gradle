package com.bettehem.testi;
import android.app.*;
import android.content.res.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class PlayPic080 extends Activity implements View.OnClickListener
{
   Button back;
   Typeface font;
   
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
	   setContentView(R.layout.playpic080);
	   
	   font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
	   
	   back = (Button) findViewById(R.id.back);
	   back.setOnClickListener(this);
	   
	   back.setTypeface(font);
   }
   
   public void onClick(View v){
	   switch (v.getId()){
		   case R.id.back:
		   finish();
		   break;
	   }
   }
   
}
