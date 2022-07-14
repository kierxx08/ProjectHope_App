package com.kierasis.projecthope.activity;

import static com.kierasis.projecthope.activity.MainActivity.PinakaMainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kierasis.projecthope.R;
import com.kierasis.projecthope.dbhelper.DBHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class setFeeling extends AppCompatActivity {

    ArrayList<String> Selected;
    Chip great, good, okay, bad, awful;
    ImageView btn_close,img_reaction;
    RelativeLayout relativeLayout;
    FloatingActionButton btn_submit;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_feeling);

        DB = new DBHelper(this);

        Selected=new ArrayList<>();
        relativeLayout = findViewById(R.id.feelingRelative);
        btn_close = findViewById(R.id.btn_close);
        img_reaction = findViewById(R.id.feel_image);
        great = findViewById(R.id.chip_great);
        good = findViewById(R.id.chip_good);
        okay = findViewById(R.id.chip_okay);
        bad = findViewById(R.id.chip_bad);
        awful = findViewById(R.id.chip_awful);
        btn_submit = findViewById(R.id.btn_submit);

        great.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(great.isChecked() && SelectedInterestEnough()){
                    Selected.add("Great");
                    great.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#d1643d")));
                    setImageReaction("Great");
                }else {
                    great.setChecked(false);
                    Selected.remove("Great");
                    great.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                    setImageReaction("");
                }
            }
        });

        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(good.isChecked() && SelectedInterestEnough()){
                    Selected.add("Good");
                    good.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#d1643d")));
                    setImageReaction("Good");
                }else {
                    good.setChecked(false);
                    Selected.remove("Good");
                    good.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                    setImageReaction("");
                }
            }
        });

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(okay.isChecked() && SelectedInterestEnough()){
                    Selected.add("Okay");
                    okay.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#d1643d")));
                    setImageReaction("Okay");
                }else {
                    okay.setChecked(false);
                    Selected.remove("Okay");
                    okay.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                    setImageReaction("");
                }
            }
        });

        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bad.isChecked() && SelectedInterestEnough()){
                    Selected.add("Bad");
                    bad.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#d1643d")));
                    setImageReaction("Bad");
                }else {
                    bad.setChecked(false);
                    Selected.remove("Bad");
                    bad.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                    setImageReaction("");
                }
            }
        });

        awful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awful.isChecked() && SelectedInterestEnough()){
                    Selected.add("Awful");
                    awful.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#d1643d")));
                    setImageReaction("Awful");
                }else {
                    awful.setChecked(false);
                    Selected.remove("Awful");
                    awful.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.chip_normal)));
                    setImageReaction("");
                }
            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Selected.size()==1){
                    Log.d("Tag","SelectedInterest index: " + 0 + " Value: " +Selected.get(0));
                    String feeling = Selected.get(0);
                    String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
                    Boolean checkinsertdata = DB.insertfeeling(currentDate,feeling);
                    if(checkinsertdata) {
                        PinakaMainActivity.finish();
                        startActivity(new Intent(setFeeling.this, MainActivity.class));
                        finish();
                        Toast.makeText(setFeeling.this,"Save Success",Toast.LENGTH_SHORT).show();
                    }
                    /*
                    Intent intent = new Intent(setFeeling.this, setFeeling.class);
                    intent.putExtra("page",1);
                    startActivity(intent);
                     */

                }else{
                    Toast.makeText(setFeeling.this,"Select your Feeling",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setImageReaction(String reaction) {
        if(reaction.equals("Great")){
            img_reaction.setImageResource(R.drawable.img_greatreaction);
            relativeLayout.setBackgroundColor(Color.parseColor("#FFCF26"));
        }else if(reaction.equals("Good")){
            img_reaction.setImageResource(R.drawable.img_goodreaction);
            relativeLayout.setBackgroundColor(Color.parseColor("#00BDAC"));
        }else if(reaction.equals("Okay")){
            img_reaction.setImageResource(R.drawable.img_okayreaction);
            relativeLayout.setBackgroundColor(Color.parseColor("#9196ce"));
        }else if(reaction.equals("Bad")){
            img_reaction.setImageResource(R.drawable.img_badreaction);
            relativeLayout.setBackgroundColor(Color.parseColor("#fe5561"));
        }else if(reaction.equals("Awful")){
            img_reaction.setImageResource(R.drawable.img_awfulreaction);
            relativeLayout.setBackgroundColor(Color.parseColor("#98777a"));
        }else{
            if(Selected.size()!=1) {
                img_reaction.setImageResource(R.drawable.img_noreaction);
                relativeLayout.setBackgroundColor(Color.parseColor("#F0F0F0"));
            }
        }

    }

    public boolean SelectedInterestEnough(){
        if(Selected.size()<1){
            return true;
        }else{
            Toast.makeText(setFeeling.this,"Choose 1 Feeling Only",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}