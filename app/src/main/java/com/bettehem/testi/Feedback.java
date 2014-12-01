package com.bettehem.testi;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;

public class Feedback extends Activity implements View.OnClickListener
{
   Button bugs, rating, other;
   Intent BugReport, rateapp, otherfb;
   String pack;
   TextView header;
   Typeface font;
   
   @Override
   public void onCreate(Bundle es){
	   super.onCreate(es);
	   setContentView(R.layout.feedback);
	   vars();
	   
	   
	   View view = findViewById(R.id.backround);
	   int orientation = getResources().getConfiguration().orientation;
	   if (orientation == Configuration.ORIENTATION_LANDSCAPE){
		   view.setBackgroundResource(R.drawable.mcpewallvaaka);
	   }else{
		   view.setBackgroundResource(R.drawable.mcpeinfowall);
	   }
	   
   }
   
   public void vars(){
	   font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
	   
	   pack = "com.bettehem.testi.";
	   
	   bugs = (Button) findViewById(R.id.bugFix);
	   rating = (Button) findViewById(R.id.fb);
	   other = (Button) findViewById(R.id.other);
	   
	   bugs.setOnClickListener(this);
	   rating.setOnClickListener(this);
	   other.setOnClickListener(this);
	   
	   BugReport = new Intent(pack + "BUGREPORT");
	   rateapp = new Intent(pack + "RATINGMETHOD");
	   otherfb = new Intent(pack + "OTHERFEEDBACK");
	   
	   bugs.setTypeface(font);
	   rating.setTypeface(font);
	   other.setTypeface(font);
	   
	   header = (TextView) findViewById(R.id.feedbackheader);
	   
	   header.setTypeface(font);
   }
   
   public void onClick(View v){
	   switch(v.getId()){
		   
		   case R.id.bugFix:
		   startActivity(BugReport);
		   break;
		   
		   case R.id.fb:
		   startActivity(rateapp);
		   break;
		   
		   case R.id.other:
		   startActivity(otherfb);
		   break;
	   }
   }
   
}
