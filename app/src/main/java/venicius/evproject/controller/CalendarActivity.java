package venicius.evproject.controller;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;



import venicius.evproject.R;

public class CalendarActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        this.getSupportActionBar().hide();

        CalendarView mCalendar = (CalendarView) findViewById(R.id.calendarView);



    }
}
