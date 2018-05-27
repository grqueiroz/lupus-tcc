package com.example.grqueiroz.lupus_tcc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

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
    private static final String USER_TABLE_NAME ="user";
    private static final String LOGGED_TABLE_NAME ="logged";
    //Creating mycontacts Columns
    private static final String User_id="id";
    private static final String User_shaid="sha_id";
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
        String CreateUserTable="CREATE TABLE " + USER_TABLE_NAME + " (" + User_id
                + " INTEGER PRIMARY KEY, " + User_shaid + " TEXT, " + User_name + " TEXT, " + User_type + " TEXT, " + User_gender + " TEXT, " + User_age + " TEXT " +")";
        db.execSQL(CreateUserTable);

        String CreateLoggedTable="CREATE TABLE " + LOGGED_TABLE_NAME + " (" + User_id
                + " INTEGER PRIMARY KEY, " + User_shaid + " TEXT, " + User_name + " TEXT, " + User_type + " TEXT, " + User_gender + " TEXT, " + User_age + " TEXT " +")";
        db.execSQL(CreateLoggedTable);
    }
    //Upgrading the Db
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + LOGGED_TABLE_NAME);
        //create the table again
        onCreate(db);
    }
    //Add new User by calling this method
    public void addUser(User user) {
        // getting db instance for writing the user
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(User_shaid,user.getShaid());
        cv.put(User_name,user.getName());
        cv.put(User_type,user.getType());
        cv.put(User_age,user.getAge());
        cv.put(User_gender,user.getGender());
        //inserting row
        db.insert(USER_TABLE_NAME, null, cv);
        //close the database to avoid any leak
        db.close();
    }

    public int checkUser(String name) {
        int id=-1;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT id FROM user WHERE name=?",new String[]{name});
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            id=cursor.getInt(0);
            cursor.close();
        }
        return id;
    }

    public String[] getAllUsers(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select " + User_name + " from user", null);
        ArrayList<String> allusers = new ArrayList<String>();
        if(cursor.moveToFirst()){
            do{
                String word = cursor.getString(cursor.getColumnIndexOrThrow(User_name));
                allusers.add(word);
            }while(cursor.moveToNext());
        }
        cursor.close();

        String[] listUsers = new String[allusers.size()];
        listUsers = allusers.toArray(listUsers);

        return listUsers;
    }

    public void cleanAllUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(USER_TABLE_NAME, "", null);
    }

    public void userLogout(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(LOGGED_TABLE_NAME, "", null);
    }

    public void userLogin(User user) {
        userLogout();

        // getting db instance for writing the user
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(User_shaid,user.getShaid());
        cv.put(User_name,user.getName());
        cv.put(User_type,user.getType());
        cv.put(User_age,user.getAge());
        cv.put(User_gender,user.getGender());
        //inserting row
        db.insert(LOGGED_TABLE_NAME, null, cv);
        //close the database to avoid any leak
        db.close();
    }
}
