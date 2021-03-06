package com.telkomuniversity.iflab.spriflab.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.telkomuniversity.iflab.spriflab.Model.BookingInfo;
import com.telkomuniversity.iflab.spriflab.R;
import com.telkomuniversity.iflab.spriflab.Adapter.RecyclerViewAdminAdapter;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    private RecyclerView rv;
    private RecyclerViewAdminAdapter rvAdapter;
    private ArrayList<BookingInfo> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        listData = new ArrayList<>();

        rvAdapter = new RecyclerViewAdminAdapter(this, initData());

        rv = findViewById(R.id.rvListDataAdmin);
        rv.setHasFixedSize(true);
        rv.setAdapter(rvAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }

    private ArrayList<BookingInfo> initData(){
        // data belom dikoneksi ke database
        // arraylist masih pake data dummy
        // belom bisa update data

        listData.add(new BookingInfo("1301154278", "2018-05-15", "2018-05-16", "Muhammad Marchell",
                "Cijambe", "IFLAB1", "083820862695", "Jordan Peterson", "Xbox User Los Angeles",
                "Forza Cup", "18:00:00", "20:00:00", "forza.jpg", "ACCEPTED"));

        return listData;
    }
}
