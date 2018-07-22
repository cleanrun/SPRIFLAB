package com.telkomuniversity.iflab.spriflab.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.telkomuniversity.iflab.spriflab.Model.BookingInfo;
import com.telkomuniversity.iflab.spriflab.R;
import com.telkomuniversity.iflab.spriflab.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class TabelActivity extends AppCompatActivity {
    private RecyclerView rv;
    private RecyclerViewAdapter rvAdapter;
    private ArrayList<BookingInfo> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel);

        listData = new ArrayList<>();

        rvAdapter = new RecyclerViewAdapter(this, initData());

        rv = findViewById(R.id.rvListDataBooking);
        rv.setHasFixedSize(true);
        rv.setAdapter(rvAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        setTitle("Booking list");
    }

    // Toast.makeText(TabelActivity.this, "Clicked", Toast.LENGTH_SHORT).show();


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
