package com.example.maya.pillwell;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Helperdb extends SQLiteOpenHelper{
    public static final int database_version = 1;
    public static final String database_name = "pillwell.db";

    public final static String table_reminders = "Reminders";
    private static final String key_id = "rem_id";
    public final static String title ="rem_title";
    public final static String date="rem_date";
    public final static String time="rem_time";
    public final static String type="rem_type";
    public final static String repeat ="rem_repeat";
    public final static String repeat_type="rem_repeat_type";



    public Helperdb(Context context) {
        super(context, database_name, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String temp="CREATE TABLE  "+table_reminders;
        temp+=" ( "+key_id+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        temp+=title+" TEXT, ";
        temp+=date+" TEXT, ";
        temp+=time+" TEXT, ";
        temp+=type+" TEXT, ";
        temp+=repeat+" INTEGER, ";
        temp+=repeat_type+" TEXT);";
        db.execSQL(temp);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String strDelete=   "DROP TABLE IF EXISTS "   +table_reminders;
        db.execSQL(strDelete);
        onCreate(db);
    }
}
