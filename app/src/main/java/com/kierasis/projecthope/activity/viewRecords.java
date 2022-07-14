package com.kierasis.projecthope.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.kierasis.projecthope.R;
import com.kierasis.projecthope.adapters.adapter_date;
import com.kierasis.projecthope.adapters.adapter_date;
import com.kierasis.projecthope.dbhelper.DBHelper;
import com.kierasis.projecthope.models.adapterExt_feel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class viewRecords extends AppCompatActivity implements adapter_date.OnDateListener{

    RecyclerView recyclerView;
    List<adapterExt_feel> cases;
    adapter_date adapter;

    DBHelper DB;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);


        recyclerView = findViewById(R.id.date_rv);
        cases = new ArrayList<>();

        DB = new DBHelper(this);
        Cursor res = DB.view_records();


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


        recyclerView.setLayoutManager(new LinearLayoutManager(viewRecords.this));
        adapter = new adapter_date(viewRecords.this,cases,viewRecords.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDateClick(int position) {
        Intent intent = new Intent(viewRecords.this, testResult.class);
        intent.putExtra("from","records");
        intent.putExtra("total_score",Integer.parseInt(cases.get(position).getString_01()));
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        
    }
}