package com.nuhin13.allNewspaper;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by nuhin13 on 1/16/2016.
 */
public class Amardesh extends AppCompatActivity implements View.OnClickListener {
    private static WebView webView;
    private static ProgressBar webViewProgressBar;
    private static ImageView back, forward, refresh, close;

    ProgressDialog mProgress;
    private AdView ad;

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    public RelativeLayout rltv;

    public DrawerLayout drawayerlayoutforSnakbar;
    private static final String webViewUrl = "http://www.amardeshonline.com/";

    TextView name ;
    public boolean flag= true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advance);
        initViews();
        setUpWebView();
        setListeners();

        name = (TextView)findViewById(R.id.name_txt);
        name.setText("দৈনিক আমারদেশ");

        mProgress = ProgressDialog.show(this, "Loading", "অনুগ্রহ পূর্বক অপেক্ষা করুণ");
        mProgress.setCanceledOnTouchOutside(true);
        rltv =(RelativeLayout)findViewById(R.id.layout);

        if(flag==false){
            if (mProgress.isShowing()) {
                mProgress.dismiss();

                final Snackbar snackbar = Snackbar
                        .make(rltv, "Ooooooopppsss !! \nThere is no internet connection.", Snackbar.LENGTH_INDEFINITE)

                        .setAction("Close", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Snackbar snackbar1 = Snackbar.make(rltv, "Message is restored!", Snackbar.LENGTH_SHORT);
                                //  snackbar1.show();

                                Amardesh.this.finish();
                            }
                        })
                        ;

                snackbar.show();
            }
        }

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        drawayerlayoutforSnakbar =(DrawerLayout) findViewById(R.id.drawer);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){

                    case R.id.inbox:

                        Intent intent = new Intent(Amardesh.this,BanglaNews.class);
                        startActivity(intent);
                        Amardesh.this.finish();
                        return true;

                    case R.id.starred:
                        Intent intent1 = new Intent(Amardesh.this,EnglishNewPaper.class);
                        startActivity(intent1);
                        Amardesh.this.finish();
                        return true;

                    case R.id.sent_mail:
                        Intent intent2 = new Intent(Amardesh.this,OnlineNewPaper.class);
                        startActivity(intent2);
                        Amardesh.this.finish();
                        return true;
                    case R.id.drafts:
                        Intent intent3 = new Intent(Amardesh.this,SportsNewsPaper.class);
                        startActivity(intent3);
                        Amardesh.this.finish();
                        return true;
                    case R.id.allmail:
                        Intent intent4 = new Intent(Amardesh.this,TechnologyBasedNewspaper.class);
                        startActivity(intent4);
                        Amardesh.this.finish();
                        return true;
                    case R.id.trash:
                        Intent intent5 = new Intent(Amardesh.this,Local1st.class);
                        startActivity(intent5);
                        Amardesh.this.finish();
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
                        String facebookUrl = fb.getFacebookPageURL(Amardesh.this);
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


        ad = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        ad.loadAd(adRequest);
    }

    private void initViews() {
        back = (ImageView) findViewById(R.id.webviewBack);
        forward = (ImageView) findViewById(R.id.webviewForward);
        refresh = (ImageView) findViewById(R.id.webviewReload);
        close = (ImageView) findViewById(R.id.webviewClose);
        webViewProgressBar = (ProgressBar) findViewById(R.id.webViewProgressBar);
    }


    private void setUpWebView() {
        webView = (WebView) findViewById(R.id.sitesWebView);
        webView.setWebViewClient(new MyWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        LoadWebViewUrl(webViewUrl);
    }

    private void setListeners() {
        back.setOnClickListener(this);
        forward.setOnClickListener(this);
        refresh.setOnClickListener(this);
        close.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.webviewBack:
                isWebViewCanGoBack();
                break;
            case R.id.webviewForward:
                if (webView.canGoForward())
                    webView.goForward();
                break;
            case R.id.webviewReload:
                String url = webView.getUrl();
                LoadWebViewUrl(url);
                break;
            case R.id.webviewClose:
                finish();
                break;
        }
    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            refresh.setVisibility(View.GONE);
            if (!webViewProgressBar.isShown())
                webViewProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            if (mProgress.isShowing()) {
                mProgress.dismiss();
            }
            refresh.setVisibility(View.VISIBLE);
            if (webViewProgressBar.isShown())
                webViewProgressBar.setVisibility(View.GONE);
        }

       /* @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            refresh.setVisibility(View.VISIBLE);
            if (webViewProgressBar.isShown())
                webViewProgressBar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, "Unexpected error occurred.Reload page again.", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
            refresh.setVisibility(View.VISIBLE);
            if (webViewProgressBar.isShown())
                webViewProgressBar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, "Unexpected error occurred.Reload page again.", Toast.LENGTH_SHORT).show();

        }*/

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            refresh.setVisibility(View.VISIBLE);
            if (webViewProgressBar.isShown())
                webViewProgressBar.setVisibility(View.GONE);
            Toast.makeText(Amardesh.this, "Unexpected SSL error occurred.Reload page again.", Toast.LENGTH_SHORT).show();

        }

    }

    // To handle "Back" key press event for WebView to go back to previous screen.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            isWebViewCanGoBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    private void isWebViewCanGoBack() {
        if (webView.canGoBack())
            webView.goBack();
        else
            finish();
    }


    private void LoadWebViewUrl(String url) {
        if (isInternetConnected())
            webView.loadUrl(url);
        else {

            flag=false;
            refresh.setVisibility(View.VISIBLE);

            //    Toast.makeText(demo.this, "Oops!! There is no internet connection. Please enable your internet connection.", Toast.LENGTH_LONG).show();

        }
    }

    public boolean isInternetConnected() {
        // At activity startup we manually check the internet status and change
        // the text status
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;

    }

/*

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    ProgressDialog mProgress;
    private AdView ad;

    private WebView webView;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.webcontent);



        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);


        webView.loadUrl("http://www.amardeshonline.com/");
        webView.setWebViewClient(new WebViewController());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("দৈনিক আমারদেশ");

// the init state of progress dialog
        mProgress = ProgressDialog.show(this, "Loading", "অনুগ্রহ পূর্বক অপেক্ষা করুণ");

        // add a WebViewClient for WebView, which actually handles loading data from web
        webView.setWebViewClient(new WebViewClient() {
            // load url
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            // when finish loading page
            public void onPageFinished(WebView view, String url) {
                if (mProgress.isShowing()) {
                    mProgress.dismiss();
                }

            }
        });
        mProgress.setCanceledOnTouchOutside(true);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){

                    case R.id.inbox:

                        Intent intent = new Intent(Amardesh.this,BanglaNews.class);
                        startActivity(intent);
                        Amardesh.this.finish();
                        return true;

                    case R.id.starred:
                        Intent intent1 = new Intent(Amardesh.this,EnglishNewPaper.class);
                        startActivity(intent1);
                        Amardesh.this.finish();
                        return true;

                    case R.id.sent_mail:
                        Intent intent2 = new Intent(Amardesh.this,OnlineNewPaper.class);
                        startActivity(intent2);
                        Amardesh.this.finish();
                        return true;
                    case R.id.drafts:
                        Intent intent3 = new Intent(Amardesh.this,SportsNewsPaper.class);
                        startActivity(intent3);
                        Amardesh.this.finish();
                        return true;
                    case R.id.allmail:
                        Intent intent4 = new Intent(Amardesh.this,TechnologyBasedNewspaper.class);
                        startActivity(intent4);
                        Amardesh.this.finish();
                        return true;
                    case R.id.trash:
                        Intent intent5 = new Intent(Amardesh.this,Local1st.class);
                        startActivity(intent5);
                        Amardesh.this.finish();
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
                        String facebookUrl = fb.getFacebookPageURL(Amardesh.this);
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



        ad = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        ad.loadAd(adRequest);


    }

    public class WebViewController extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

   */
/* @Override
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
    }*//*


    @Override
    public void onBackPressed()
    {
        if (webView.canGoBack())
        {
            webView.goBack();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String FACEBOOK_URL = "https://www.facebook.com/Droid-Builder-1718721518341575/";
    public static String FACEBOOK_PAGE_ID = "Droid-Builder-1718721518341575";
*/


}