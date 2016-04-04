package com.if4.fzwael.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fzwael on 3/31/2016.
 */
public class QuizHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "mathsone";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c

   /* // high score table name
    private static final String TABLE_HS = "hs";
    // high score table colums names
    private static final String HS_ID = "id";
    private static final String HS_NAME = "name";
    private static final String HS_SCORE = "score";*/

    private SQLiteDatabase dbase;
    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        /*String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_HS + " ( "
                + HS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + HS_NAME
                + " TEXT, " +  HS_SCORE + " INTEGER)";*/

        db.execSQL(sql);
//        db.execSQL(sql2);
        // TEST
        ContentValues values = new ContentValues();
       /* values.put(HS_ID,0);
        values.put(HS_NAME,"fzwael");
        values.put(HS_SCORE,55);
        dbase.insert(TABLE_HS,null,values);*/
        addQuestion();
        // db.close();
    }
    private void addQuestion() {
        Question q1 = new Question("5+2 = ?", "7", "8", "6", "7");
        this.addQuestion(q1);
        Question q2 = new Question("2+18 = ?", "18", "19", "20", "20");
        this.addQuestion(q2);
        Question q3 = new Question("10-3 = ?", "6", "7", "8", "7");
        this.addQuestion(q3);
        Question q4 = new Question("5+7 = ?", "12", "13", "14", "12");
        this.addQuestion(q4);
        Question q5 = new Question("3-1 = ?", "1", "3", "2", "2");
        this.addQuestion(q5);
        Question q6 = new Question("0+1 = ?", "1", "0", "10", "1");
        this.addQuestion(q6);
        Question q7 = new Question("9-9 = ?", "0", "9", "1", "0");
        this.addQuestion(q7);
        Question q8 = new Question("3+6 = ?", "8", "7", "9", "9");
        this.addQuestion(q8);
        Question q9 = new Question("1+5 = ?", "6", "7", "5", "6");
        this.addQuestion(q9);
        Question q10 = new Question("7-5 = ?", "3", "2", "6", "2");
        this.addQuestion(q10);
        Question q11 = new Question("7-2 = ?", "7", "6", "5", "5");
        this.addQuestion(q11);
        Question q12 = new Question("3+5 = ?", "8", "7", "5", "8");
        this.addQuestion(q12);
        Question q13 = new Question("0+6 = ?", "7", "6", "5", "6");
        this.addQuestion(q13);
        Question q14 = new Question("12-10 = ?", "1", "2", "3", "2");
        this.addQuestion(q14);
        Question q15 = new Question("12+2 = ?", "14", "15", "16", "14");
        this.addQuestion(q15);
        Question q16 = new Question("2-1 = ?", "2", "1", "0", "1");
        this.addQuestion(q16);
        Question q17 = new Question("6-6 = ?", "6", "12", "0", "0");
        this.addQuestion(q17);
        Question q18 = new Question("5-1 = ?", "4", "3", "2", "4");
        this.addQuestion(q18);
        Question q19 = new Question("4+2 = ?", "6", "7", "5", "6");
        this.addQuestion(q19);
        Question q20 = new Question("5+1 = ?", "6", "7", "5", "6");
        this.addQuestion(q20);
        Question q21 = new Question("5-4 = ?", "5", "4", "1", "1");
        this.addQuestion(q21);
        // END
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HS);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public List<Question> getAllQuestions(String url) {
        List<Question> quesList = new ArrayList<Question>();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .penaltyLog()
                .penaltyDialog()
                .build());

        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll()
                .penaltyLog()
                .build());
        JSONObject json = null;
        String str = "";
        HttpResponse response;
        HttpClient myClient = new DefaultHttpClient();
        HttpPost myConnection = new HttpPost("http://quiz-fzwael.rhcloud.com/qst.json");

        try {
            response = myClient.execute(myConnection);
            str = EntityUtils.toString(response.getEntity(), "UTF-8");

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{

            JSONArray jArray = new JSONArray(str);
            Log.d("LIST" , ""+jArray.length());
            for (int i=0 ; i< jArray.length() ; i++){
                json = jArray.getJSONObject(i);
                Question quest = new Question();
                quest.setQUESTION(json.getString("question"));
                quest.setANSWER(json.getString("answer"));
                quest.setOPTA(json.getString("opta"));
                quest.setOPTB(json.getString("optb"));
                quest.setOPTC(json.getString("optc"));
                quesList.add(quest);
                Log.d("LIST" , "ADDED ! "+i);
            }
        } catch ( JSONException e) {
            e.printStackTrace();
        }
        // return quest list
        Log.d("LIST" , ""+quesList.size());
        return quesList;
    }

/*    public List<HighScore> getHighScore(){
        List<HighScore> quesList = new ArrayList<HighScore>();
        String selectQuery = "SELECT * FROM" + TABLE_HS + "LIMIT 5";
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                HighScore highScore = new HighScore();
                highScore.setID(cursor.getInt(0));
                highScore.setName(cursor.getString(1));
                highScore.setHs(cursor.getInt(2));
                quesList.add(highScore);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }*/
}