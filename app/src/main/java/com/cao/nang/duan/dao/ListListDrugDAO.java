package com.cao.nang.duan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cao.nang.duan.R;
import com.cao.nang.duan.database.ConnectDB;
import com.cao.nang.duan.database.Query;
import com.cao.nang.duan.model.ListListDrug;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListListDrugDAO {
    ConnectDB connectDB;

    public ListListDrugDAO(Context context) {
        connectDB = new ConnectDB(context);
    }
 // phương thức thêm danh mục thuốc
    public void insertAllListListDrug(Context context) {
        SQLiteDatabase sqLiteDatabase = connectDB.getWritableDatabase();
        Scanner scanner = new Scanner(context.getResources().openRawResource(R.raw.student));

        sqLiteDatabase.beginTransaction();
        String line;
        while (scanner.hasNextLine() && ((line = scanner.nextLine()) != null)) {
            String[] values = line.split(",");
            if (values.length != 1)
                continue;

            for (int i = 0; i < values.length; i++)
                values[i] = values[i].replace("\"", "");

            ContentValues cv = new ContentValues();
            cv.put(Query.DRUG_LIST, values[0]);

            sqLiteDatabase.insert(Query.TABLE_DRUG_LIST, null, cv);
        }

        sqLiteDatabase.setTransactionSuccessful();

    }
    //lấy danh sách danh mục thuốc
    public List<ListListDrug> getAllstudent(){
        List<ListListDrug> list = new ArrayList<>();

        String query = "select * from "+Query.TABLE_DRUG_LIST; //truy vấn bảng danh mục thuốc
        SQLiteDatabase db = connectDB.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c != null){
            if(c.getCount() > 0){
                while (c.moveToNext()){
                    String listlistdrug = c.getString(0);// lấy dữ liệu

                    ListListDrug listListDrug=new ListListDrug(listlistdrug); //thêm dự liệu database vào đối tượng
                    list.add(listListDrug);
                }
                c.close();
                db.close();
            }
        }

        return list;
    }
}
