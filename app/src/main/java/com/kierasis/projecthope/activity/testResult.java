package com.kierasis.projecthope.activity;

import static com.kierasis.projecthope.activity.MainActivity.PinakaMainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kierasis.projecthope.R;
import com.kierasis.projecthope.dbhelper.DBHelper;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class testResult extends AppCompatActivity {
    TextView score_text, depression_text;
    ImageView btn_close, btn_back;
    RelativeLayout testRelative;
    DBHelper DB;

    HtmlTextView depression_description;
    String from;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);

        Intent intent = getIntent();
        from=intent.getStringExtra("from");
        int total_score = intent.getIntExtra("total_score",0);

        if(from.equals("test")) {
            DB = new DBHelper(this);
            String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

            Boolean checkinsertdata = DB.insertTestResult(currentDate, String.valueOf(total_score), "1");
            if (checkinsertdata) {
                Log.d("DB", "Save Successfully");
            } else {
                Log.d("DB", "Saving error");
            }
        }

        Log.d("testResult", String.valueOf(total_score));
        score_text = findViewById(R.id.score_text);
        score_text.setText(String.valueOf(total_score));
        depression_text = findViewById(R.id.depression_text);
        depression_description = findViewById(R.id.description);
        testRelative = findViewById(R.id.testRelative);
        btn = findViewById(R.id.btn_causeSolution);
        if(total_score<=4){
            depression_text.setText("Normal");
            testRelative.setBackgroundColor(Color.parseColor("#FFCF26"));
            btn.setVisibility(View.GONE);
        }else if(total_score<=9){
            depression_text.setText("Mild Depression");
            testRelative.setBackgroundColor(Color.parseColor("#00BDAC"));
            depression_description.setHtml("<p><span style=\"white-space:pre\">\t</span>A person with mild depression will have a low mood and other symptoms of depression, but the symptoms will be less intense.</p><p><span style=\"white-space:pre\">\t</span>Changes in mood that last for or more may be a sign of depression, and they are a matter of concern. Early intervention can help prevent more serious complications from arising. Many people with mild depression can manage these distressing symptoms, but they may have a minor effect on their social and work life. Although other people may not notice symptoms of mild depression in an individual, they can take a toll on the person experiencing them.</p><p><span style=\"white-space:pre\">\t</span>Mild symptoms can also occur between relapses or as warning signs of more severe depression.</p><p><span style=\"white-space:pre\">\t</span>A person who experiences new or worsening symptoms should seek medical help.</p><p><span style=\"white-space:pre\">\t</span>People with mild depression can ask their doctor about medication, but they may prefer to start with lifestyle alterations.</p>");
        }else if(total_score<=14){
            depression_text.setText("Moderate Depression");
            testRelative.setBackgroundColor(Color.parseColor("#9196ce"));
            depression_description.setHtml("<p><span style=\"white-space: pre;\">\t</span>People with moderate depression are more likely to experience primary symptoms of low mood, sleep difficulties, weight or appetite changes, and increased/slowed psychomotor activity. Someone with moderate depression may experience symptoms that are more serious in terms of severity and duration than someone with mild depression. They may also experience more symptoms than a person with mild depression does.<br></p>");
        }else if(total_score<=19){
            depression_text.setText("Moderately Severe Depression");
            testRelative.setBackgroundColor(Color.parseColor("#fe5561"));
            depression_description.setHtml("<p><span style=\"white-space: pre;\">\t</span>Moderately severe depression is marked by two main symptoms: persistent low mood and decreased interest in activities. Such symptoms may vary in intensity and duration in someone with moderate depression. They may experience some of these symptoms some weeks, but not others.\n" +
                    "</p><p><span style=\"white-space: pre;\">\t</span>Where people with mild depression may be able to carry out their normal daily activities without much impairment, the symptoms of moderate depression are serious enough to create problems with work and home life. People with moderately severe depression may struggle to complete daily tasks or feel fatigued and unmotivated. At work, they may struggle to concentrate on projects. Symptoms can also lead to problems in social relationships as well.<br></p>");
        }else if(total_score<=30){
            depression_text.setText("Severe Depression");
            testRelative.setBackgroundColor(Color.parseColor("#98777a"));
            depression_description.setHtml("<p><span style=\"white-space: pre;\">\t</span>Severe (major) depression is classified as having the symptoms of mild to moderate depression, but the symptoms are severe and noticeable, even to your loved ones.\n" +
                    "</p><p><span style=\"white-space: pre;\">\t</span>Episodes of major depression last an average of six months or longer. Sometimes severe depression can go away after a while, but it can also be recurrent for some people.\n" +
                    "</p><p><span style=\"white-space: pre;\">\t</span>Diagnosis is especially crucial in severe depression, and it may even be time-sensitive.<br></p>");
        }

        btn_close = findViewById(R.id.btn_close);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(testResult.this, causeAndSolution.class);
                intent.putExtra("total_score",total_score);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(from.equals("test")){
            Intent intent = new Intent(testResult.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        super.onBackPressed();
    }
}