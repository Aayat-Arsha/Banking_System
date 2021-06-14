package com.aayat.bankingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private String TABLE_NAME = "user_table";
    private String TABLE_NAME1 = "transfers_table";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(6207886695,'Ahaan Singh',200000.00,'singh.ahaan@gmail.com','XXXXXXXXXXXX4321','AHS09876541')");
        db.execSQL("insert into user_table values(6235678901,'Jagdeep Kishore',879000.67,'jagdeep2606@gmail.com','XXXXXXXXXXXX5682','JAG98765438')");
        db.execSQL("insert into user_table values(9846789012,'Amit Sahani',132000.56,'sahaniamit0908@gmail.com','XXXXXXXXXXXX8917','AMS87654325')");
        db.execSQL("insert into user_table values(8841890123,'Kirti Sahay',98000.01,'kirti_sahay@gmail.com','XXXXXXXXXXXX4784','KIT76543213')");
        db.execSQL("insert into user_table values(3978901234,'Paridhi Chauhan',8800.48,'chauhan301@gmail.com','XXXXXXXXXXXX2389','CHAU65432108')");
        db.execSQL("insert into user_table values(8584012345,'Advait Sharma',9600.16,'advaitsharma@gmail.com','XXXXXXXXXXXX2559','ADV54321099')");
        db.execSQL("insert into user_table values(9890175556,'Malini Tripathi',25036.00,'malini@gmail.com','XXXXXXXXXXXX5565','MAL43210984')");
        db.execSQL("insert into user_table values(8912347567,'Vikas Duggal',88967.22,'vikas@gmail.com','XXXXXXXXXXXX5289','VKD32109879')");
        db.execSQL("insert into user_table values(9632345678,'Prem Kishore Singh',54700.46,'pksingh@gmail.com','XXXXXXXXXXXX3758','PKS21098766')");
        db.execSQL("insert into user_table values(8964567809,'Priyadarshini',44754.00,'priyadarshini@gmail.com','XXXXXXXXXXXX7860','PRD10987650')");
        db.execSQL("insert into user_table values(6204598776,'Barida Khan',654700.00,'khanbarida@gmail.com','XXXXXXXXXXXX6780','BAK10996850')");
        db.execSQL("insert into user_table values(8578669744,'Zahir Alam',7000.00,'alam1409@gmail.com','XXXXXXXXXXXX3456','ZAL10887640')");
        db.execSQL("insert into user_table values(4390876390,'Triveni Prashad Mishra',98600.00,'tpmishra@gmail.com','XXXXXXXXXXXX9210','TPM10887650')");
        db.execSQL("insert into user_table values(7979912098,'Ali Rizwan',87659.98,'rizwanali1398@gmail.com','XXXXXXXXXXXX8190','ATA10984650')");
        db.execSQL("insert into user_table values(5647890380,'Ashutosh Pandit',274633.34,'panditashutosh@gmail.com','XXXXXXXXXXXX0234','ASP10987651')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table order by NAME ASC", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}
