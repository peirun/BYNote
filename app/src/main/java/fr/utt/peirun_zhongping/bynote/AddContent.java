package fr.utt.peirun_zhongping.bynote;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

import java.io.File;

public class AddContent extends AppCompatActivity {

    private String val;
    private Button savebtn, deletebtn;
    private EditText ettext;
    private ImageView c_img;
    private VideoView v_video;
    private NoteDB noteDB;
    private SQLiteDatabase dbWriter;
    private File phoneFile, videoFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        val = getIntent().getStringExtra("flag");
    }


}
