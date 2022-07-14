package com.kierasis.projecthope.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kierasis.projecthope.R;
import com.kierasis.projecthope.adapters.adapter_feel;
import com.kierasis.projecthope.dbhelper.DBHelper;
import com.kierasis.projecthope.models.adapterExt_feel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  adapter_feel.OnFeelListener{
    public static Activity PinakaMainActivity;
    public SharedPreferences device_info, user_info;
    private long backPressedTime;
    private Toast backToast;
    TextView greeting;
    RecyclerView recyclerView;
    List<adapterExt_feel> cases;
    adapter_feel adapter;

    DBHelper DB;

    CardView test, records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PinakaMainActivity = this;

        user_info = getSharedPreferences("user-info", Context.MODE_PRIVATE);

        greeting = findViewById(R.id.greeting);
        greeting.setText("Hi! "+user_info.getString("user_fname","")+". How are you today ?");


        recyclerView = findViewById(R.id.featured_recycler);
        cases = new ArrayList<>();

        adapterExt_feel feels = new adapterExt_feel();
        feels.setString_00("ADD");
        feels.setString_01("Sample");
        cases.add(feels);

        DB = new DBHelper(this);
        Cursor res = DB.view_feelings();


            while (res.moveToNext()) {
                String date = res.getString(0);
                SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String str_month = null;
                String str_day = null;

                adapterExt_feel feels2 = new adapterExt_feel();
                feels2.setString_00("");

                try {
                    Date newDate = spf.parse(date);
                    SimpleDateFormat spf_month = new SimpleDateFormat("LLL");
                    str_month = spf_month.format(newDate);

                    SimpleDateFormat spf_day = new SimpleDateFormat("dd");
                    str_day = spf_day.format(newDate);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                //feels2.setString_00(res.getString(1));
                feels2.setString_01(res.getString(1));
                feels2.setString_02(str_month);
                feels2.setString_03(str_day);
                cases.add(feels2);
            }

        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        adapter = new adapter_feel(MainActivity.this,cases,MainActivity.this);
        recyclerView.setAdapter(adapter);

        test = findViewById(R.id.test_cv);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, test.class));
            }
        });

        records = findViewById(R.id.records_cv);
        records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, viewRecords.class));
            }
        });
    }

    @Override
    public void onFeelClick(int position) {

        Log.d("tag","onFeelClick: "+ cases.get(position).getString_00());
        if(cases.get(position).getString_00().equals("ADD")){
            Intent intent = new Intent(MainActivity.this, setFeeling.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 >System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(),"Press back again to exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}