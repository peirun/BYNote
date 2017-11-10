package fr.utt.peirun_zhongping.bynote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by PEIRUN on 11/10/2017.
 */

public class NoteDB extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "notes";
    private static final String CONTENT = "content";
    private static final String PATH = "path";
    private static final String VIDEO = "video";
    private static final String ID = "_id";
    private static final String TIME = "time";

    public NoteDB(Context context) {
        super(context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" + ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + CONTENT
                + " TEXT NOT NULL," + PATH + " TEXT NOT NULL," + VIDEO
                + " TEXT NOT NULL," + TIME + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
