package com.nuhin13.allNewspaper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
 * Created by nuhin13 on 1/15/2016.
 */
public class Other_local extends AppCompatActivity {


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

        item.add("আজকের জামালপুর");

        item.add("চলমান নোয়াখালী");

        item.add("গ্রামের কাগজ");

        item.add("লোক সংবাদ");

        item.add("দিনাজপুর নিউজ");

        item.add("United News");

        item.add("নতুন খবর");



        itemForBank = new ArrayList<String>();

        itemForBank.add("History");
        itemForBank.add("Bank Informations");
        itemForBank.add("Branches");

        CustomAdapter adapter = new CustomAdapter(this, item);
        listView.setAdapter(adapter);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Others");

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
                       /* Toast.makeText(getApplicationContext(),"Inbox Selected",Toast.LENGTH_SHORT).show();
                        ContentFragment fragmentt = new ContentFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,fragment);
                        fragmentTransaction.commit();
                        return true;*/

                        Intent intent = new Intent(Other_local.this,BanglaNews.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "sdag", Toast.LENGTH_SHORT).show();
                        return true;

                        // For rest of the options we just show a toast on click

                    case R.id.starred:
                        Intent intent1 = new Intent(Other_local.this,EnglishNewPaper.class);
                        startActivity(intent1);

                        return true;

                    case R.id.sent_mail:
                        Intent intent2 = new Intent(Other_local.this,OnlineNewPaper.class);
                        startActivity(intent2);

                        return true;
                    case R.id.drafts:
                        Intent intent3 = new Intent(Other_local.this,SportsNewsPaper.class);
                        startActivity(intent3);

                        return true;
                    case R.id.allmail:
                        Intent intent4 = new Intent(Other_local.this,TechnologyBasedNewspaper.class);
                        startActivity(intent4);

                        return true;
                    case R.id.trash:
                        Intent intent5 = new Intent(Other_local.this,Local1st.class);
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
                        String facebookUrl = fb.getFacebookPageURL(Other_local.this);
                        facebookIntent.setData(Uri.parse(facebookUrl));
                        startActivity(facebookIntent);
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(),"Somethings Wrong",Toast.LENGTH_SHORT).show();
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
                    Intent intent = new Intent(Other_local.this, AjkerJamalpur.class);
                    startActivity(intent);
                }

                if (position == 1) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Other_local.this, CholomanNoyakhali.class);
                    startActivity(intent);
                }
                if (position == 2) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Other_local.this, GramerKagoj.class);
                    startActivity(intent);
                }
                if (position == 3) {

                    Intent intent = new Intent(Other_local.this, LokSongbas.class);
                    startActivity(intent);
                }
                if (position == 4) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Other_local.this, DinajpurNews.class);
                    startActivity(intent);
                }
                if (position == 5) {

                    //Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Other_local.this, UnitedNew24.class);
                    startActivity(intent);
                }

                if (position == 6) {

                    // Toast.makeText(getApplicationContext(),"Prothom alo",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Other_local.this, NotunKhonr.class);
                    startActivity(intent);
                }


            }
        });

        AdView ad = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        ad.loadAd(adRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
