package com.bettehem.testi;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;

public class CmdScreen extends Activity implements View.OnClickListener
{
   Button enterCmd;
   EditText input;
   String command;
   Intent clog, upc, oldb;
   TextView header, error;
   String pack;
   Typeface font;
   
   @Override
   public void onCreate(Bundle savedInstanceState){
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.commandscreen);
	   somthin();
	   
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
   
   
   public void somthin(){
	   
	   font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf");
	   
	   pack = "com.bettehem.testi.";
	   
	   enterCmd = (Button) findViewById(R.id.enter);
	   input = (EditText) findViewById(R.id.input);
	   header = (TextView) findViewById(R.id.cmdscreenheader);
	   error = (TextView) findViewById(R.id.error);
	   
	   enterCmd.setOnClickListener(this);
	   
	   clog = new Intent (pack + "CHANGELOG");
	   upc = new Intent (pack + "UPCOMING");
	   oldb = new Intent (pack + "OLDBASICS");
	   
	   enterCmd.setTypeface(font);
	   input.setTypeface(font);
	   header.setTypeface(font);
	   error.setTypeface(font);
   }
   
   public void onClick (View v){
	   switch(v.getId()){
		   case R.id.enter:
			   command = input.getText().toString();
		   if(command.contentEquals("changelog")){
			   startActivity(clog);
			   error.setText("");
		   }else if(command.contentEquals("")){
			   error.setText(R.string.nocmdtexterror);
		   }else if (command.contentEquals("upcoming")){
			   startActivity(upc);
			   error.setText("");
		   }else if (command.contentEquals("oldbasics")){
			   startActivity(oldb);
			   error.setText("");
		   }else if (command.contentEquals("showallcommands")){
			   error.setText("");
			   Dialog d = new Dialog(this);
			   d.setTitle(getString(R.string.allcommands));
			   TextView tv = new TextView(this);
			   tv.setTextSize(30);
			   tv.setTypeface(font);
			   tv.setText("\n" + "-changelog" + "\n" + "-upcoming" + "\n" + "-oldbasics" + "\n" + "-showallcommands" + "\n");
			   d.setContentView(tv);
			   d.show();
		   }else{
			   error.setText(R.string.nocmderror);
		   }
		   break;
	   }
   }
}
