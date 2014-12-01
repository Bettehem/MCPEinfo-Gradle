package com.bettehem.testi;

//This is the java code for the main menu. Unlike the XML code, here you tell the application what to do.

//The imports are things that we want to load for the code to work correctly
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build;


//The class. It extends the Activity library so we can do Android stuff in Java.
public class MainActivity extends Activity
{
	Intent defaultAPI, api21;
	String pack;
	
	
	//This is the onCreate method. This is what the application will do when it's started.
	@Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		stuff();
    }
	
	
	public void stuff(){
		
		pack = getPackageName();
		
		defaultAPI = new Intent(pack + "." + "MAINMENU");
		api21 = new Intent(pack + "." + "MAINMENU21");
		
		test();
	}
	
	public void test(){
		switch (Build.VERSION.SDK_INT){
			case 21:
				startActivity(defaultAPI);
				finish();
				break;
				
			default:
				startActivity(defaultAPI);
				finish();
				break;
		}
	}

}
