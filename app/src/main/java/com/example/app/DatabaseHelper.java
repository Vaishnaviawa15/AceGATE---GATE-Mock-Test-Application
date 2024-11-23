package com.example.app;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Existing constants for answers
    public static final String DATABASE_NAME = "user_data.db"; // Changed to a more general name
    public static final String TABLE_ANSWERS = "answers";
    public static final String COL_ID = "id";
    public static final String COL_QUESTION = "question";
    public static final String COL_ANSWER = "answer";

    // New constants for user data
    public static final String TABLE_USERS = "users";
    public static final String COL_FIRSTNAME = "firstname";
    public static final String COL_LASTNAME = "lastname";
    public static final String COL_USERNAME = "username";
    public static final String COL_EMAIL = "email";
    public static final String COL_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the answers table
        String createAnswersTable = "CREATE TABLE " + TABLE_ANSWERS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_QUESTION + " TEXT, " +
                COL_ANSWER + " TEXT)";
        db.execSQL(createAnswersTable);

        // Create the users table
        String createUsersTable = "CREATE TABLE " + TABLE_USERS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_FIRSTNAME + " TEXT, " +
                COL_LASTNAME + " TEXT, " +
                COL_USERNAME + " TEXT, " +
                COL_EMAIL + " TEXT, " +
                COL_PASSWORD + " TEXT)";
        db.execSQL(createUsersTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Existing methods for answers
    public boolean insertAnswer(String question, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_QUESTION, question);
        contentValues.put(COL_ANSWER, answer);
        long result = db.insert(TABLE_ANSWERS, null, contentValues);
        return result != -1; // Returns true if insert was successful
    }

    public Cursor getAllAnswers() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_ANSWERS, null);
    }

    public void clearAnswers() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ANSWERS);
    }

    // New method to insert user data
    public boolean insertUser (String firstname, String lastname, String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FIRSTNAME, firstname);
        contentValues.put(COL_LASTNAME, lastname);
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_USERS, null, contentValues);
        return result != -1; // Returns true if insert was successful
    }
}