package com.ovais.quizsqlitetry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="task.db";
    public static final String TABLE_TASKS="Tasks";
    public static final String COLOUMN_ID="id";
    public static final String COLOUMN_TASKS="task_name";


    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_TASKS+"("+COLOUMN_ID+ " INTEGER PRIMARY KEY " +
                " AUTOINCREMENT,"+COLOUMN_TASKS+ " TEXT "+ ");";
        db.execSQL(query);
    }
    public void addTask(Tasks tasks){
        ContentValues values=new ContentValues();
        values.put(COLOUMN_TASKS,tasks.getTask());
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.insert(TABLE_TASKS,null,values);
        sqLiteDatabase.close();

    }
    public void removeTask(String taskname){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM "+TABLE_TASKS+" WHERE "+ COLOUMN_TASKS+"=\""+taskname+"\";");

    }
    public String databaseToString(){
        String dbString="";
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_TASKS +" WHERE 1";
        Cursor c=sqLiteDatabase.rawQuery(query,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("task_name"))!=null){
                dbString+=c.getString(c.getColumnIndex("task_name"));
                dbString+="\n";

            }
            c.moveToNext();

        }
        sqLiteDatabase.close();
        return dbString;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TASKS);
        onCreate(db);

    }
}
