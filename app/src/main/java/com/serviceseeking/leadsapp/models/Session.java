package com.serviceseeking.leadsapp.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.serviceseeking.leadsapp.remote.responses.Data;
import com.google.gson.Gson;

import java.util.HashMap;

public class Session {

    private static final String EMAIL_ADDRESS = "email_address";
    private static final String ISLOGGEDIN = "is_logged_in";
    private static final int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "beam_session";
    public static String TOKEN = "";
    private SharedPreferences prefs;
    private Editor editor;

    public Session(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = prefs.edit();
        TOKEN = prefs.getString("token", "");
    }

    public Boolean isAuthorized() {
        return (prefs.getBoolean(ISLOGGEDIN, false) && !prefs.getString(EMAIL_ADDRESS, "").equals(""));
    }

    public HashMap<String, String> getSession() {
        HashMap<String, String> session = new HashMap<String, String>();
        session.put(EMAIL_ADDRESS, prefs.getString(EMAIL_ADDRESS, ""));
        return session;
    }

    public void authorize(String email, String token) {
        TOKEN = token;
        editor.putString(EMAIL_ADDRESS, email);
        editor.putString("token", token);
        editor.putBoolean(ISLOGGEDIN, true);
        editor.commit();
    }

    public void deAuthorize() {
        editor.putString("data", "");
        editor.putString("token", "");
        editor.putString(EMAIL_ADDRESS, "");
        editor.putBoolean(ISLOGGEDIN, false);
        editor.commit();
    }

    public void saveUser(Data data) {
        Gson gson = new Gson();
        String json = gson.toJson(data);
        editor.putString("data", json);
        editor.apply();
    }

    public Data retrieveUser() {
        Gson gson = new Gson();
        String json = prefs.getString("data", "");
        return gson.fromJson(json, Data.class);
    }
}
