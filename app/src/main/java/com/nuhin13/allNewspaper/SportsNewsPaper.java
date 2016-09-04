package com.nuhin13.allNewspaper;

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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

/**
 * Created by nuhin13 on 1/14/2016.
 */
public class SportsNewsPaper extends AppCompatActivity {


    ListView listView, listviwForBank;
    ArrayList<String> item, itemForBank;


    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bangla_newpaper);

        listView = (ListView) findViewById(R.id.listView1);

        item = new ArrayList<String>();

        item.add("Bangla Cricket");

        item.add("Goal");

        item.add("Espn Cricinfo");

        item.add("Cricbuzz");

        item.add("Espn Fc");

        item.add("Fifa");

        item.add("Bangladesh Khela");

        item.add("BBC Sports");

        item.add("Bangladesh Cricket");

        item.add("Bangladesh Football");

        item.add("Khelar jagat");

        itemForBank = new ArrayList<String>();

        itemForBank.add("History");
        itemForBank.add("Bank Informations");
        itemForBank.add("Branches");

        CustomAdapter adapter = new CustomAdapter(this, item);
        listView.setAdapter(adapter);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sports Newspaper");

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.inbox:


                        Intent intent = new Intent(SportsNewsPaper.this,BanglaNews.class);
                        startActivity(intent);


                        return true;
                        // For rest of the options we just show a toast on click

                    case R.id.starred:
                        Intent intent1 = new Intent(SportsNewsPaper.this,EnglishNewPaper.class);
                        startActivity(intent1);

                        return true;

                    case R.id.sent_mail:
                        Intent intent2 = new Intent(SportsNewsPaper.this,OnlineNewPaper.class);
                        startActivity(intent2);

                        return true;
                    case R.id.drafts:

                        return true;
                    case R.id.allmail:
                        Intent intent4 = new Intent(SportsNewsPaper.this,TechnologyBasedNewspaper.class);
                        startActivity(intent4);

                        return true;
                    case R.id.trash:
                        Intent intent5 = new Intent(SportsNewsPaper.this,Local1st.class);
                        startActivity(intent5);

                        return true;
                    case R.id.rate:
                        Intent rate = new Intent(Intent.ACTION_VIEW);
                        rate.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.nuhin13.allNewspaper"));
                        startActivity(rate);

                        return true;
                    case R.id.more:
                        Intent intentMore = new Intent(Intent.ACTION_VIEW);
                        intentMore.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.nuhin13.ExhaustiveKnowledge"));
                        startActivity(intentMore);

                        return true;
                    case R.id.like:
                        Facebook fb = new Facebook();
                        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                        String facebookUrl = fb.getFacebookPageURL(SportsNewsPaper.this);
                        facebookIntent.setData(Uri.parse(facebookUrl));
                        startActivity(facebookIntent);
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(),"Somethings Wrong",Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });
        disableNavigationViewScrollbars(navigationView);
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
                    Intent intent = new Intent(SportsNewsPaper.this, BanglaCricket.class);
                    startActivity(intent);
                }

                if (position == 1) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SportsNewsPaper.this, Goal.class);
                    startActivity(intent);
                }
                if (position == 2) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SportsNewsPaper.this, EspnCricinfo.class);
                    startActivity(intent);
                }
                if (position == 4) {

                    Intent intent = new Intent(SportsNewsPaper.this, EspnFC.class);
                    startActivity(intent);
                }
                if (position == 5) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SportsNewsPaper.this, Fifa.class);
                    startActivity(intent);
                }
                if (position == 6) {

                    //Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SportsNewsPaper.this, BanladeshKhela.class);
                    startActivity(intent);
                }

                if (position == 7) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SportsNewsPaper.this, BBCsports.class);
                    startActivity(intent);
                }
                if (position == 8) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SportsNewsPaper.this, BangladeshCricket.class);
                    startActivity(intent);
                }
                if (position ==9) {

                    Intent intent = new Intent(SportsNewsPaper.this, BangladeshFootball.class);
                    startActivity(intent);
                }
                if (position == 10) {

                    Intent intent = new Intent(SportsNewsPaper.this, KhelarJogot.class);
                    startActivity(intent);
                }
                if (position == 3) {

                    Intent intent = new Intent(SportsNewsPaper.this, demo.class);
                    startActivity(intent);
                }


            }
        });

        AdView ad = (AdView) findViewById(R.id.adView);
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
      /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
      int count = 1;

    InterstitialAd mInterstitialAd;

    @Override
    public void onResume() {
        super.onResume(); // Always call the superclass method first

        if (mInterstitialAd.isLoaded() == false) {
            LoadAdd();
        }
        // Get the Camera instance as the activity achieves full user focu
        if (count ==1) {
            // Toast.makeText(MainActivity.this, count, Toast.LENGTH_SHORT)
            // .show();
            displayAd();

        }
    }

    private void initAd() {
        // Create the InterstitialAd and set the adUnitId.
        mInterstitialAd = new InterstitialAd(SportsNewsPaper.this);
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


}
