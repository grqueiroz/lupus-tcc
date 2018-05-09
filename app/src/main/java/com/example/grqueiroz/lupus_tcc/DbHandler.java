package com.example.grqueiroz.lupus_tcc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Gabriele on 18/03/2018.
 */

public class DbHandler extends SQLiteOpenHelper{
    //all constants as they are static and final(Db=Database)
    //Db Version
    private static final int Db_Version=1;
    //Db Name
    private static final String Db_Name="users";
    //table name
    private static final String Table_Name="user";
    //Creating mycontacts Columns
    private static final String User_id="id";
    private static final String User_shaid="id";
    private static final String User_name="name";
    private static final String User_age="age";
    private static final String User_type="user_type";
    private static final String User_gender="gender";

    //constructor here
    public DbHandler(Context context)
    {
        super(context,Db_Name,null,Db_Version);
    }
    //creating table
    @Override
    public void onCreate(SQLiteDatabase db) {
        // writing command for sqlite to create table with required columns
        String Create_Table="CREATE TABLE " + Table_Name + "(" + User_id
                + " INTEGER PRIMARY KEY," + User_shaid + " TEXT" + User_name + " TEXT" + User_type + " TEXT" + User_gender + " TEXT" + User_age + " TEXT" +")";
        db.execSQL(Create_Table);
    }
    //Upgrading the Db
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        //create the table again
        onCreate(db);
    }
    //Add new User by calling this method
    public void addUser(User usr)
    {
        // getting db instance for writing the user
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(User_shaid,usr.getShaid());
        cv.put(User_name,usr.getName());
        cv.put(User_type,usr.getType());
        cv.put(User_age,usr.getAge());
        cv.put(User_gender,usr.getGender());
        //inserting row
        db.insert(Table_Name, null, cv);
        //close the database to avoid any leak
        db.close();
    }
    public int checkUser(User us)
    {
        int id=-1;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT id FROM user WHERE name=?",new String[]{us.getName()});
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            id=cursor.getInt(0);
            cursor.close();
        }
        return id;
    }

    public String[] getAllUsers(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * in User_name from user", null);
        ArrayList<String> allusers = new ArrayList<String>();
        if(cursor.moveToFirst()){
            do{
                String word = cursor.getString(cursor.getColumnIndexOrThrow("user"));
                allusers.add(word);
            }while(cursor.moveToNext());
        }
        cursor.close();

        String[] listUsers = new String[allusers.size()];
        listUsers = allusers.toArray(listUsers);

        return listUsers;
    }
}
