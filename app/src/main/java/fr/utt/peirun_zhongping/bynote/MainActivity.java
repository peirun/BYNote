package fr.utt.peirun_zhongping.bynote;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button textbtn, imgbtn, videobtn;
    private ListView lv;
    private Intent i;
    private NoteDB noteDB;
    private SQLiteDatabase dbReader;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        lv = (ListView) findViewById(R.id.list);
        textbtn = (Button) findViewById(R.id.text);
        imgbtn = (Button) findViewById(R.id.img);
        videobtn = (Button) findViewById(R.id.video);
        textbtn.setOnClickListener(this);
        imgbtn.setOnClickListener(this);
        videobtn.setOnClickListener(this);
        noteDB = new NoteDB(this);
        dbReader = noteDB.getReadableDatabase();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                cursor.moveToPosition(position);

                i.putExtra(noteDB.getID(),
                        cursor.getInt(cursor.getColumnIndex(noteDB.getID())));
                i.putExtra(noteDB.getCONTENT(), cursor.getString(cursor
                        .getColumnIndex(noteDB.getCONTENT())));
                i.putExtra(noteDB.getTIME(),
                        cursor.getString(cursor.getColumnIndex(noteDB.getTIME())));
                i.putExtra(noteDB.getPATH(),
                        cursor.getString(cursor.getColumnIndex(noteDB.getPATH())));
                i.putExtra(noteDB.getVIDEO(),
                        cursor.getString(cursor.getColumnIndex(noteDB.getVIDEO())));
                startActivity(i);
            }
        });
    }

    public void onClick(View v) {
        i = new Intent(this, AddContent.class);
        switch (v.getId()) {
            case R.id.text:
                Log.d("yu", "test for click");
                i.putExtra("flag", "text");
                startActivity(i);
                break;

            case R.id.img:
                i.putExtra("flag", "image");
                startActivity(i);
                break;

            case R.id.video:
                i.putExtra("flag", "video");
                startActivity(i);
                break;
        }
    }
}
