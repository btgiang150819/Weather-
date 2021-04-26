package com.example.wheather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    RecyclerView list1, list2;
    ArrayList<Time> timeArrayList;
    ArrayList<Date> dateArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeArrayList = new ArrayList<>();
        dateArrayList = new ArrayList<>();
        Anhxa();
        TimeAdapter timeAdapter = new TimeAdapter(MainActivity.this, R.layout.time_line, timeArrayList);
        list1.setAdapter(timeAdapter);
        list1.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        DateAdapter dateAdapter = new DateAdapter(this, R.layout.day_line, dateArrayList);
        list2.setAdapter(dateAdapter);
        list2.setLayoutManager(new LinearLayoutManager(this));

        dateAdapter.setOnItemClickRecyclerView(new OnClickWeather() {

            @Override
            public void onclick( int position) {
                dateArrayList.remove(position);
                dateAdapter.notifyItemRemoved(position);
            }
        });
    }

    private void Anhxa(){
        list1 = findViewById(R.id.list1);
        list2 = findViewById(R.id.list2);
        Calendar c = Calendar.getInstance();
        int temp = c.get(Calendar.HOUR_OF_DAY);
        //khoi tao mang 1
        timeArrayList.add(new Time(temp++, R.drawable.ic_cloudy, -5));
        timeArrayList.add(new Time(temp++, R.drawable.ic_weather, -5));
        timeArrayList.add(new Time(temp++, R.drawable.ic_rain, -5));
        timeArrayList.add(new Time(temp++, R.drawable.ic_cloudy, -5));
        timeArrayList.add(new Time(temp++, R.drawable.ic_storm, -5));
        timeArrayList.add(new Time(temp++, R.drawable.ic_storm, -5));
        timeArrayList.add(new Time(temp++, R.drawable.ic_weather, -5));
        timeArrayList.add(new Time(temp, R.drawable.ic_weather, -5));
        int count = c.get(Calendar.DAY_OF_MONTH);
        //khoi tao mang 2
        dateArrayList.add(new Date("Monday", String.valueOf(count++), "November", R.drawable.ic_weather, 2, -1));
        dateArrayList.add(new Date("Tuesday", String.valueOf(count++), "November", R.drawable.ic_rain, 3, 5));
        dateArrayList.add(new Date("Wednesday", String.valueOf(count++), "November", R.drawable.ic_storm, 10, 11));
        dateArrayList.add(new Date("Thursday", String.valueOf(count++), "November", R.drawable.ic_cloudy, 6, -8));
        dateArrayList.add(new Date("Friday", String.valueOf(count++), "November", R.drawable.ic_rain, 3, 5));
        dateArrayList.add(new Date("Saturday", String.valueOf(count++), "November", R.drawable.ic_storm, 10, 11));
        dateArrayList.add(new Date("Sunday", String.valueOf(count++), "November", R.drawable.ic_weather, 2, -1));
        dateArrayList.add(new Date("Monday", String.valueOf(count++), "November", R.drawable.ic_rain, 3, 5));
        dateArrayList.add(new Date("Tuesday", String.valueOf(count), "November", R.drawable.ic_storm, 10, 11));

    }
}