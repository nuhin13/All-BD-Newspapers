package com.nuhin13.allNewspaper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Handler;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView, listviwForBank;
    ArrayList<String> item, itemForBank;

    ProgressDialog mProgress;
    private AdView ad;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    private GoogleApiClient client;

    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    boolean isUserFirstTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, "true"));

        Intent introIntent = new Intent(MainActivity.this, PagerActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);

        if (isUserFirstTime) {

            startActivity(introIntent);

        }

        setContentView(R.layout.bangla_newpaper);

        listView = (ListView) findViewById(R.id.listView1);

        item = new ArrayList<String>();

        item.add("দৈনিক প্রথম আলো");

        item.add("দৈনিক ইত্তেফাক");

        item.add("দৈনিক আমারদেশ");

        item.add("দৈনিক সমকাল");

        item.add("দৈনিক আমাদেরসময়");

        item.add("দৈনিক নয়া-দিগন্ত");

        item.add("দৈনিক কালের-কণ্ঠ");

        item.add("দৈনিক যায়-যায় দিন");

        item.add("দৈনিক বাংলাদেশ প্রতিদিন");

        item.add("দৈনিক ইনকিলাব");

        item.add("দৈনিক মানবজমিন");

        item.add("দৈনিক সংগ্রাম");

        item.add("দৈনিক ভোরের কাগজ");

        item.add("দৈনিক জণকন্ঠ");

        item.add("দৈনিক যুগান্তর");

        item.add("দৈনিক সংবাদ");

        item.add("দৈনিক সকালের খবর");

        item.add("দৈনিক গণকন্ঠ");

        item.add("দৈনিক বনিকবার্তা");

        item.add("দৈনিক দিনকালি");

        item.add("দৈনিক মানবকণ্ঠ");

        item.add("দৈনিক আলোকিত বাংলাদেশ");


        itemForBank = new ArrayList<String>();

        itemForBank.add("History");
        itemForBank.add("Bank Informations");
        itemForBank.add("Branches");

        CustomAdapter adapter = new CustomAdapter(this, item);
        listView.setAdapter(adapter);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Bangla Newspaper");

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        disableNavigationViewScrollbars(navigationView);
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.inbox:

                        return true;


                    case R.id.starred:
                        Intent intent1 = new Intent(MainActivity.this, EnglishNewPaper.class);
                        startActivity(intent1);

                        return true;

                    case R.id.sent_mail:
                        Intent intent2 = new Intent(MainActivity.this, OnlineNewPaper.class);
                        startActivity(intent2);

                        return true;
                    case R.id.drafts:
                        Intent intent3 = new Intent(MainActivity.this, SportsNewsPaper.class);
                        startActivity(intent3);

                        return true;
                    case R.id.allmail:
                        Intent intent4 = new Intent(MainActivity.this, TechnologyBasedNewspaper.class);
                        startActivity(intent4);

                        return true;
                    case R.id.trash:
                        Intent intent5 = new Intent(MainActivity.this, Local1st.class);
                        startActivity(intent5);

                        return true;


                    case R.id.rate:
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.nuhin13.allNewspaper"));
                        startActivity(intent);

                        return true;
                    case R.id.more:
                        Intent intentMore = new Intent(Intent.ACTION_VIEW);
                        intentMore.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.nuhin13.ExhaustiveKnowledge"));
                        startActivity(intentMore);

                        return true;
                    case R.id.like:
                        Facebook fb = new Facebook();
                        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                        String facebookUrl = fb.getFacebookPageURL(MainActivity.this);
                        facebookIntent.setData(Uri.parse(facebookUrl));
                        startActivity(facebookIntent);
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v,
                                    int position, long arg3) {
				/*
				 * Toast.makeText(getActivity().getApplicationContext(),
				 * item.get(position), Toast.LENGTH_LONG).show();
				 */

                if (position == 0) {

                    //Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Webcontent.class);
                    startActivity(intent);
                }

                if (position == 1) {

                    //Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, ittifaq.class);
                    startActivity(intent);


                }
                if (position == 2) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Amardesh.class);
                    startActivity(intent);
                }
                if (position == 3) {

                    Intent intent = new Intent(MainActivity.this, Samakal.class);
                    startActivity(intent);
                }
                if (position == 4) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, AmaderSomoy.class);
                    startActivity(intent);
                }
                if (position == 5) {

                    //Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Nayadiganta.class);
                    startActivity(intent);
                }

                if (position == 6) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, KalerKontha.class);
                    startActivity(intent);
                }
                if (position == 7) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, JJDin.class);
                    startActivity(intent);
                }
                if (position ==8) {

                    Intent intent = new Intent(MainActivity.this, BDprotidin.class);
                    startActivity(intent);
                }
                if (position == 9) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, inqilab.class);
                    startActivity(intent);
                }
                if (position == 10) {

                    //Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Manabjabin.class);
                    startActivity(intent);
                }

                if (position == 11) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Sangram.class);
                    startActivity(intent);
                }
                if (position == 12) {

                    Intent intent = new Intent(MainActivity.this, VorerKagoj.class);
                    startActivity(intent);

                }
                if (position == 13) {

                    Intent intent = new Intent(MainActivity.this, jonkontho.class);
                    startActivity(intent);
                }
                if (position == 14) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Zugantor.class);
                    startActivity(intent);
                }
                if (position == 15) {

                    //Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Sangbad.class);
                    startActivity(intent);
                }

                if (position == 16) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SokalerKhobor.class);
                    startActivity(intent);
                }
                if (position == 17) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Gonokontho.class);
                    startActivity(intent);
                }
                if (position == 18) {

                    Intent intent = new Intent(MainActivity.this, BonikBarta.class);
                    startActivity(intent);
                }
                if (position == 19) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Dinkal.class);
                    startActivity(intent);
                }
                if (position == 20) {

                    Intent intent = new Intent(MainActivity.this, Manabkontho.class);
                    startActivity(intent);
                    // startNewActivitys("com.facebook.katana");

                }

                if (position == 21) {

                    Intent intent = new Intent(MainActivity.this, AlokitoBangladesh.class);
                    startActivity(intent);



                }
                if (position == 22) {

                    Intent intent = new Intent(MainActivity.this, demo.class);
                    startActivity(intent);



                }else {
                   /* Toast.makeText(getApplicationContext(),
                            "Pai nai", Toast.LENGTH_LONG).show();*/
                }

            }
        });

        ad = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        ad.loadAd(adRequest);

        initAd();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void disableNavigationViewScrollbars(NavigationView mNavigationView) {
        if (mNavigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) mNavigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

 /*   public static String FACEBOOK_URL = "https://www.facebook.com/Droid-Builder-1718721518341575/";
    public static String FACEBOOK_PAGE_ID = "Droid-Builder-1718721518341575";

    //method to get the right URL to use in the intent
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }*/

    //int count = -1;

    int addCounter = 2;

    int count = 1;



    InterstitialAd mInterstitialAd;

    @Override
    public void onResume() {
        super.onResume(); // Always call the superclass method first

        count = count + 1;
        if (count>3) {
            // Toast.makeText(BanglaNews.this, count, Toast.LENGTH_SHORT).show();
            displayAd();

        }

    }


    private void initAd() {
        // Create the InterstitialAd and set the adUnitId.
        mInterstitialAd = new InterstitialAd(MainActivity.this);
        // Defined in values/strings.xml
        mInterstitialAd.setAdUnitId("ca-app-pub-9971154848057782/1986029758");
    }

    private void displayAd() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            // Toast.makeText(MainActivity.this, "Ad did not load",
            // Toast.LENGTH_SHORT).show();
            // LoadAdd();
			/*
			 * if (!mInterstitialAd.isLoaded()) {
			 * Toast.makeText(MainActivity.this, "not load",
			 * Toast.LENGTH_SHORT).show(); } else {
			 * Toast.makeText(MainActivity.this, "  not ", Toast.LENGTH_SHORT)
			 * .show(); }
			 */
        }
    }

    private void LoadAdd() {
        // Hide the retry button, load the ad, and start the timer.

        // initAd();
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
        // Toast.makeText(MainActivity.this, "loading",
        // Toast.LENGTH_SHORT).show();
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit the program", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
