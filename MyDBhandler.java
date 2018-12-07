package c16315146.mydit.ie.myandroidproject;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.support.annotation.Nullable;

public class MyDBhandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1; //version number
    private static final String DATABASE_NAME = "books.db"; //database name
    public static final String TABLE_BOOKS = "books"; //table name
    public static final String COLUMN_ID = "_id"; //columns
    public static final String COLUMN_BOOKNAME = "bookname";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_CATEGORY = "category";

    public MyDBhandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_BOOKS + "( "
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BOOKNAME + " TEXT ,"
                + COLUMN_AUTHOR + " TEXT ,"
                + COLUMN_CATEGORY + " TEXT " + " );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        onCreate(db);
    }
    //add row to database
    public void addBook(library book){
        ContentValues values = new ContentValues();
        values.put(COLUMN_BOOKNAME, book.get_bookname());
        values.put(COLUMN_AUTHOR, book.get_author());
        values.put(COLUMN_CATEGORY, book.get_category());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_BOOKS, null, values);
        db.close();
    }

    //Delete from database
    public void deleteBook(String bookname){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_BOOKS + " WHERE " + COLUMN_BOOKNAME + COLUMN_AUTHOR  + COLUMN_CATEGORY + " =\"" + bookname + "\";" );
    }

    //Print out from database
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_BOOKS + " WHERE 1";

        //Cursor print to a location in your results
        Cursor c = db.rawQuery(query, null);
        //move to first row
        c.moveToFirst();

        while(c.moveToNext()){
            if(c.getString(c.getColumnIndex("bookname"))!= null){
                dbString += c.getString(c.getColumnIndex("bookname"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }
}


