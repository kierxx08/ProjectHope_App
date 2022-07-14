package com.kierasis.projecthope.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kierasis.projecthope.R;
import com.kierasis.projecthope.dbhelper.DBHelper;
import com.kierasis.projecthope.dbhelper.DatabaseHelper;

public class test extends AppCompatActivity {
    public static Activity TestPage;
    Chip chip_una, chip_dalawa, chip_tatlo, chip_apat;
    FloatingActionButton btn_next, btn_submit;
    TextView test_page, question;
    ImageView btn_close, btn_back;

    DatabaseHelper DB;

    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TestPage = this;

        Intent intent = getIntent();
        int page = intent.getIntExtra("page",1);
        int total_score = intent.getIntExtra("total_score",0);
        score = 0;

        Log.d("Total Score: ", String.valueOf(total_score));

        btn_back = findViewById(R.id.btn_back);
        btn_close = findViewById(R.id.btn_close);

        btn_next = findViewById(R.id.btn_next);
        btn_submit = findViewById(R.id.btn_submit);

        if(page==9){
            btn_next.setVisibility(View.GONE);
            btn_submit.setVisibility(View.VISIBLE);
        }

        test_page = findViewById(R.id.test_page);
        test_page.setText("Question "+page+" of 9");

        question = findViewById(R.id.test_question);

        DatabaseHelper DB = new DatabaseHelper(test.this,"ProjectHope.db",1);
        Cursor res = DB.view_quiz("1");
        int count = 0;
        while (res.moveToNext()){
            if(count==page-1){
                question.setText(res.getString(1));
            }
            count += 1;
        }



        chip_una = findViewById(R.id.chip_una);
        chip_dalawa = findViewById(R.id.chip_dalawa);
        chip_tatlo = findViewById(R.id.chip_tatlo);
        chip_apat = findViewById(R.id.chip_apat);

        chip_una.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chip_una.isChecked()) {
                    score = 0;
                    chip_una.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#d1643d")));
                    if(chip_dalawa.isChecked() || chip_tatlo.isChecked() || chip_apat.isChecked()){
                        chip_dalawa.setChecked(false);
                        chip_dalawa.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                        chip_tatlo.setChecked(false);
                        chip_tatlo.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                        chip_apat.setChecked(false);
                        chip_apat.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                    }
                }else{
                    score = 0;
                    chip_una.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                }
            }
        });

        chip_dalawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chip_dalawa.isChecked()) {
                    score = 1;
                    chip_dalawa.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#d1643d")));
                    if(chip_una.isChecked() || chip_tatlo.isChecked() || chip_apat.isChecked()){
                        chip_una.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                        chip_una.setChecked(false);
                        chip_tatlo.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                        chip_tatlo.setChecked(false);
                        chip_apat.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                        chip_apat.setChecked(false);
                    }
                }else{
                    score = 0;
                    chip_dalawa.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                }
            }
        });

        chip_tatlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chip_tatlo.isChecked()) {
                    score = 2;
                    chip_tatlo.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#d1643d")));
                    if(chip_una.isChecked() || chip_dalawa.isChecked() || chip_apat.isChecked()){
                        chip_una.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                        chip_una.setChecked(false);
                        chip_dalawa.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                        chip_dalawa.setChecked(false);
                        chip_apat.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                        chip_apat.setChecked(false);
                    }
                }else{
                    score = 0;
                    chip_tatlo.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                }
            }
        });

        chip_apat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chip_apat.isChecked()) {
                    score = 3;
                    chip_apat.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#d1643d")));
                    if(chip_una.isChecked() || chip_dalawa.isChecked() || chip_tatlo.isChecked()){
                        chip_una.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                        chip_una.setChecked(false);
                        chip_dalawa.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                        chip_dalawa.setChecked(false);
                        chip_tatlo.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                        chip_tatlo.setChecked(false);
                    }
                }else{
                    score = 0;
                    chip_apat.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                }
            }
        });



        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(test.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(test.this, test.class);
                intent.putExtra("page",page+1);
                intent.putExtra("total_score",total_score+score);
                startActivity(intent);
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(test.this, testResult.class);
                intent.putExtra("from","test");
                intent.putExtra("total_score",total_score+score);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
}