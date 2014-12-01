package com.bettehem.testi;

//This is the java code for the main menu. Unlike the XML code, here you tell the application what to do.

//The imports are things that we want to load for the code to work correctly
import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.content.res.*;
import android.graphics.*;
import android.media.*;
import android.os.*;
import android.preference.*;
import android.view.*;
import android.widget.*;


/*The class. It extends the Activity library so we can do Android stuff in Java.
 The OnClickListener is also implemented so that a method for that can be added within this class and the method will be used to interact with buttons in main.xml
 */
public class MainMenu extends Activity implements View.OnClickListener
{
    //Here all of the variables are named.
	Button exit, intro, basic, cmd, send;
	Intent introD, basiC, CmdScreen, email, pref, about;
	TextView header, text, beta, app, version;
	MediaPlayer music;
	int test = 0;
	boolean musicset;
	String pack, versiontxt, appversion;
	int numero;
	Typeface font;


	//This is the onCreate method. This is what the application will do when it's started.
	@Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);

		font = Typeface.createFromAsset(this.getAssets(), "Minecraftia.ttf"); //Here we set up the font.

		setContentView(R.layout.main); //Here we tell the application to look at the main.xml code and make the main menu look like it has been made in the xml
		stuff(); //This tells the application to look at a method called stuff and do everything in it


		//The following is to set the background for the main menu for different orientations(landscape and portrait).
		View view = findViewById(R.id.backround);
		int orientation = getResources().getConfiguration().orientation;
		if (orientation == Configuration.ORIENTATION_LANDSCAPE){
			view.setBackgroundResource(R.drawable.mcpewallvaaka);
		}else{
			view.setBackgroundResource(R.drawable.mcpeinfowall);
		}

		isAppInstalled("UTK package");
    }



	public void stuff(){ //This is the stuff method.

		pack = "com.bettehem.testi.";

		//An Intent, in this case, tells the application to start an other Activity, meaning other parts of the application.
		introD = new Intent(pack + "INTRODUCTION");//the text in the quotes is something that the Intent looks for in the AndroidManifest.xml file.
		basiC = new Intent(pack + "BASICS080");
		CmdScreen = new Intent(pack + "CMDSCREEN");
		email = new Intent(pack + "FEEDBACK");
		pref = new Intent(pack + "PREFS");
		about = new Intent(pack + "ABOUT");


		//Here we tell all of the buttons to have the id of a button in the main.xml
		exit = (Button) findViewById(R.id.exit);
		intro = (Button) findViewById(R.id.introD);
		basic = (Button) findViewById(R.id.basics);
		cmd = (Button) findViewById(R.id.secret);
		send = (Button) findViewById(R.id.email);

		//the same thing with the textViews.
		header = (TextView) findViewById(R.id.mainHeader);
		text = (TextView) findViewById(R.id.cmdText);
		beta = (TextView) findViewById(R.id.betanote);
		app = (TextView) findViewById(R.id.test);
		version = (TextView) findViewById(R.id.appversion);

		//here we tell the app that when we say music somewhere in this class(meaning this page of code), it knows we are talking about the sunlight.mp3 file in the raw folder.
		music = MediaPlayer.create(MainMenu.this, R.raw.everlast);

		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());//used to check the settings in the preference menu
		musicset = getPrefs.getBoolean("music_check", true);

		text.setTextColor(Color.GREEN);//The text colour for this TextView is changed to green.
		beta.setTextColor(Color.WHITE);//The text colour for this TextView is changed to blue.
		version.setTextColor(Color.CYAN);//The text colour for this TextView is changed to red.

		if (musicset == true){//checks if music is enabled in the settings
			music.start();//this starts the MediaPlayer. I called it music, so it's easy to understand.
		}

		exit.setOnClickListener (this);//all of these are just to set an OnClickListener for the buttons. An OnClickListener tells the app to check if a button is clicked.
		intro.setOnClickListener(this);
		basic.setOnClickListener(this);
		cmd.setOnClickListener(this);
		send.setOnClickListener(this);

		//Here the font is enabled for all of the buttons
		exit.setTypeface(font);
		intro.setTypeface(font);
		basic.setTypeface(font);
		cmd.setTypeface(font);
		send.setTypeface(font);

		//Same thing for the TextViews
		header.setTypeface(font);
		text.setTypeface(font);
		beta.setTypeface(font);
		app.setTypeface(font);
		version.setTypeface(font);

		versiontxt = getString(R.string.version); //here he get the string from the resources, wich contains "App version:"
		appversion = getString(R.string.manappvs); //and here is the actual app version

		version.setText(versiontxt + " " + appversion); //here the two strings are combined, and displayed in the TextView variable called version.
	}



	public void onClick(View view) //here is everything that happens after a button is clicked
	{
		switch(view.getId()){ //this gets the id of the clicked button. switch case thing is a bit like if and else.
			case R.id.introD: //If the id is introD, the app will do the following
				startActivity(introD);//This will start a new activity through an Intent that is named introD.
				break; //break acts in the same way as a closing bracket in an if else thing that looks like this: }.

			case R.id.basics:
				startActivity(basiC);
				break;

			case R.id.exit:
				finish();
				break;

			case R.id.secret:
				music.pause();
				startActivity(CmdScreen);
				break;

			case R.id.email:
				startActivity(email);
				break;
		}
	}

	@Override
	public void onPause(){ //the following is done when the Activity is paused, meaning the main menu. the Activity gets paused when you open a new Activity on top of this Activity. It happens when tapping a button or something else that has been programmed to start a new Activity.
		super.onPause();
		if (numero == 0){
			music.pause();//this pauses the music
		}
	}

	@Override 
	public void onResume(){ //the following is done when the Activity is resumed.
		super.onResume();
		if (musicset == true){
			music.start(); //the music starts playing again
	    }
		numero = 0;
	}

	@Override
	protected void onDestroy() //When the app is closed, it will check this code
	{
		super.onDestroy();
		music.release(); //The music gets stopped.
	}





	private boolean isAppInstalled(String packageName) {//Here the app checks if you have UTK installed. Not in use atm.
		PackageManager pm = getPackageManager();
		boolean installed = false;
		try {
			pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
			installed = true;
			//	test = 1;
			jotai();
		} catch (PackageManager.NameNotFoundException e) {
			installed = false;
		}
		return installed;

	}

	public void jotai(){
		if (test == 1){
			app.setText("UTK installed!");
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)//This is the setup for the menu
	{
		// TODO: Implement this method
		super.onCreateOptionsMenu(menu);
		MenuInflater inflaatteri = getMenuInflater();
		inflaatteri.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()){

			case R.id.settings:
				finish();
				startActivity(pref);
				break;

			case R.id.about:
				startActivity(about);
				numero = 1;
				break;

		}

		return false;
	}

}
