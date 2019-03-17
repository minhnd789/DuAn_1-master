package com.cao.nang.duan.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ConnectDB extends SQLiteOpenHelper {

    public ConnectDB(Context context) {
        super(context,"thuvienthuoc.sql" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Query.create_TABLE_DRUG_LIST);
        db.execSQL(Query.create_TABLE_CATEGORY_DRUG);
        db.execSQL(Query.create_TABLE_DRUG);
        db.execSQL(Query.create_TABLE_SICK_LIST);
        db.execSQL(Query.create_TABLE_FIND_HOSPITAL);
        db.execSQL(Query.create_TABLE_HOSPITAL);
        Log.e("","chay thanh cong");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ Query.TABLE_DRUG_LIST);
        db.execSQL("drop table if exists "+ Query.TABLE_CATEGORY_DRUG);
        db.execSQL("drop table if exists "+ Query.TABLE_DRUG);
        db.execSQL("drop table if exists "+ Query.TABLE_SICK_LIST);
        db.execSQL("drop table if exists "+ Query.TABLE_FIND_HOSPITAL);
        db.execSQL("drop table if exists "+ Query.TABLE_HOSPITAL);
        onCreate(db);
    }
}
