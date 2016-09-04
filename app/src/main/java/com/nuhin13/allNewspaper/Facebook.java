package com.nuhin13.allNewspaper;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by nuhin13 on 1/18/2016.
 */
public class Facebook  {


    public static String FACEBOOK_URL = "https://www.facebook.com/Droid-Builder-1718721518341575/";
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
    }

}
