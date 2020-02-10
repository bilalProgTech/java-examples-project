package com.example.hungundbilal.saviourplacesaroundme;

/**
 * Created by hungundbilal on 12/7/17.
 */
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManagement
{
    SharedPreferences pref;

    Editor editor;

    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "SessionData";

    private static final String IS_LOGIN = "isLoggedIn";

    public static final String KEY_PW = "pw";

    public static final String KEY_EMAIL = "email";

    public SessionManagement(Context context)
    {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String email, String pw)
    {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_PW, pw);
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }
    public void checkLogin()
    {
        if(!this.isLoggedIn())
        {
            Intent i = new Intent(_context, SaviourLoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }

    }

    public HashMap<String, String> getUserDetails()
    {
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_PW, pref.getString(KEY_PW, null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        return user;
    }

    public void logoutUser()
    {
        editor.clear();
        editor.commit();
        Intent i = new Intent(_context, SaviourLoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    public boolean isLoggedIn()
    {
        return pref.getBoolean(IS_LOGIN, false);
    }
}
