package venicius.evproject.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import venicius.evproject.R;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        this.getSupportActionBar().hide();
        CalendarView mCalendar = (CalendarView) findViewById(R.id.calendarView);
        List<EventDay> events = new ArrayList<>();
        Calendar calendar1 = new GregorianCalendar();
        Calendar calendar2 = new GregorianCalendar();
        calendar1.set(2019,1,10);
        mCalendar.showCurrentMonthPage();

        events.add(0,new EventDay(calendar1, R.drawable.close_outline));

        calendar1=null;
        calendar1=new GregorianCalendar();

        calendar1.set(2019,1,11);

        events.add(1,new EventDay(calendar1, R.drawable.check_outline));



        mCalendar.setEvents(events);


    }

    public long getLongAsDate(int year, int month, int date) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH, date);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTimeInMillis();
    }


}
