package com.nuhin13.allNewspaper;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

import java.util.ArrayList;

/**
 * Created by nuhin13 on 1/14/2016.
 */
public class EnglishNewPaper extends AppCompatActivity {


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

        item.add("The Daily Independent");

        item.add("The Daily Sun");

        item.add("The Daily Dhaka Tribune");

        item.add("The Daily Star");

        item.add("The Daily New Age");

        item.add("The Daily Observer");

        item.add("The Daily Bangladesh Today");

        item.add("The Daily Hawker");

        item.add("The Daily Gurdian");

        item.add("The Daily News Today");

        item.add("The Daily Prothom-alo");

        item.add("The Daily Financial Express");

        item.add("The Daily Good Morning");

        item.add("The Daily Bd News24");

        item.add("The Daily Golf News");

        item.add("The Daily Economist");


        itemForBank = new ArrayList<String>();

        itemForBank.add("History");
        itemForBank.add("Bank Informations");
        itemForBank.add("Branches");

        CustomAdapter adapter = new CustomAdapter(this, item);
        listView.setAdapter(adapter);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("English Newspaper");



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
        

                        Intent intent = new Intent(EnglishNewPaper.this,BanglaNews.class);
                        startActivity(intent);


                        return true;
                        // For rest of the options we just show a toast on click

                    case R.id.starred:

                        return true;

                    case R.id.sent_mail:
                        Intent intent2 = new Intent(EnglishNewPaper.this,OnlineNewPaper.class);
                        startActivity(intent2);

                        return true;
                    case R.id.drafts:
                        Intent intent3 = new Intent(EnglishNewPaper.this,SportsNewsPaper.class);
                        startActivity(intent3);

                        return true;
                    case R.id.allmail:
                        Intent intent4 = new Intent(EnglishNewPaper.this,TechnologyBasedNewspaper.class);
                        startActivity(intent4);

                        return true;
                    case R.id.trash:
                        Intent intent5 = new Intent(EnglishNewPaper.this,Local1st.class);
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
                        String facebookUrl = fb.getFacebookPageURL(EnglishNewPaper.this);
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
                    Intent intent = new Intent(EnglishNewPaper.this, Independent.class);
                    startActivity(intent);
                }

                if (position == 1) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnglishNewPaper.this, Sun.class);
                    startActivity(intent);
                }
                if (position == 2) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnglishNewPaper.this, DhakaTribune.class);
                    startActivity(intent);
                }
                if (position == 3) {

                    Intent intent = new Intent(EnglishNewPaper.this, DailyStar.class);
                    startActivity(intent);
                }
                if (position == 4) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnglishNewPaper.this, NewAge.class);
                    startActivity(intent);
                }
                if (position == 5) {

                    //Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnglishNewPaper.this, Observer.class);
                    startActivity(intent);
                }

                if (position == 6) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnglishNewPaper.this, BangladeshToday.class);
                    startActivity(intent);
                }
                if (position == 7) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnglishNewPaper.this, Hawker.class);
                    startActivity(intent);
                }
                if (position ==8) {

                    Intent intent = new Intent(EnglishNewPaper.this, Gurdian.class);
                    startActivity(intent);
                }
                if (position ==9) {

                    Intent intent = new Intent(EnglishNewPaper.this, NewsToday.class);
                    startActivity(intent);
                }
                if (position == 10) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnglishNewPaper.this, Prothom_alo_english.class);
                    startActivity(intent);
                }
                if (position == 11) {

                    //Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnglishNewPaper.this, FinancialExpress.class);
                    startActivity(intent);
                }

                if (position == 12) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnglishNewPaper.this, GoodMorning.class);
                    startActivity(intent);
                }
                if (position == 13) {

                    Intent intent = new Intent(EnglishNewPaper.this, BdNews24.class);
                    startActivity(intent);

                }
                if (position == 14) {

                    Intent intent = new Intent(EnglishNewPaper.this, GolfNews.class);
                    startActivity(intent);
                }
                if (position == 15) {


                    Intent intent = new Intent(EnglishNewPaper.this, Economist.class);
                    startActivity(intent);
                }


    
            }
        });

//        AdView ad = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        ad.loadAd(adRequest);
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


    public void webview(View v){

        Intent intent = new Intent(EnglishNewPaper.this,Webcontent.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"sdag",Toast.LENGTH_SHORT).show();


    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    Context context;
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            Toast.makeText(context, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    }
