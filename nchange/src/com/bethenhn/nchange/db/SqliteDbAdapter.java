package com.bethenhn.nchange.db;

import com.bethenhn.nchange.R;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqliteDbAdapter {

	private static final String DEBUG_TAG = "EVENTLIST_DB_ADAPTER";
	private DatabaseHelper dbHelper;
	private SQLiteDatabase mDb;
	private Context context;
	private static final String DATABASE_NAME = "lemona";
	private static final int DATABASE_VERSION = 1;
	
	private static final String SQL_CREATE_PARTICIPANT = "CREATE TABLE participant ("+
			"			participant_no INTEGER primary key autoincrement,"+
			"			name VARCHAR(15) NOT NULL,"
			+"			logo_id INTEGER"
			+"		);";

	private static final String SQL_CREATE_EVENT ="	CREATE TABLE event ("
				+"		event_no INTEGER primary key autoincrement,"
				+"		title TEXT NOT NULL,"
				+"		image_id INTEGER,"
				+"		duration_start TEXT NOT NULL,"
				+"		duration_end TEXT NOT NULL,"
				+"		participant_no INTEGER, "
				+"		FOREIGN KEY(participant_no) REFERENCES participant(participant_no)"

				+"	 );";


	private static final String SQL_CREATE_EVENTDETAIL="	CREATE TABLE eventdetail ("
				+"		eventdetail_no INTEGER primary key autoincrement,"
				+"		event_no INTEGER,"
				+"		slogan TEXT,"
				+"		image_id INTEGER,"
				+"		barcode_id INTEGER,"
				+"		description TEXT,"
				+"		FOREIGN KEY(event_no) REFERENCES event(event_no)"
				+"	);";
					 
	private static final String SQL_CREATE_USERINFO="	CREATE TABLE userinfo ("
				+"		name TEXT,"
				+"		barcode_id INTEGER,"
				+"		point INTEGER"
				+"	);";
	
	private class DatabaseHelper extends SQLiteOpenHelper {
		
		DatabaseHelper (Context context ) {
			super(context, DATABASE_NAME , null, DATABASE_VERSION);
			
			
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			
			db.execSQL(SQL_CREATE_PARTICIPANT); 
			db.execSQL(SQL_CREATE_EVENT); 
			db.execSQL(SQL_CREATE_EVENTDETAIL); 
			db.execSQL(SQL_CREATE_USERINFO); 
			Log.d(DEBUG_TAG , "tables are created.");
			
			//insert sample data
			db.execSQL("insert into participant(name) values ('GS25')");
			db.execSQL("insert into participant(name) values ('7-ELEVEN')");
			db.execSQL("insert into participant(name) values ('CU')");
			
			db.execSQL("insert into event(title, image_id, duration_start, duration_end, participant_no) values ('오늘은 스타벅스가 쏜다!','"+R.drawable.sewoo+"','2013.03.02','2013.04.02','1')");
			db.execSQL("insert into event(title, image_id, duration_start, duration_end, participant_no) values ('바나나맛 우유가 400원!','"+R.drawable.sewoo+"','2013.01.05','2013.01.08','2')");
			db.execSQL("insert into event(title, image_id, duration_start, duration_end, participant_no) values ('롯데와 함께하는 시원한...','"+R.drawable.sewoo+"','2013.02.20','2013.03.08','1')");
			
		}
	
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			 Log.d(DEBUG_TAG, "old: " + oldVersion + "-> new : " + newVersion + " upgrade. "); 

            db.execSQL("DROP TABLE IF EXISTS event"); 
            db.execSQL("DROP TABLE IF EXISTS eventdetail"); 
            db.execSQL("DROP TABLE IF EXISTS userinfo");
            db.execSQL("DROP TABLE IF EXISTS participant"); 
          
            onCreate(db); 
			
		}
	
	}	
	
	  public SqliteDbAdapter(Context ctx) { 

	        this.context = ctx; 

	    } 

	   
	 
	    public SqliteDbAdapter open() throws SQLException { 

	        dbHelper = new DatabaseHelper(context); 

	        mDb = dbHelper.getWritableDatabase(); 
	        
	        return this; 

	    } 

	   
	 
	    public void close() { 

	        dbHelper.close(); 

	    } 
	    
	    public SQLiteDatabase GetDB() {
	    	
	    	return mDb;
	    }
	

}
