package venicius.evproject.controller;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import venicius.evproject.R;
import venicius.evproject.model.BancoController;
import venicius.evproject.model.BancoControllerDatas;
import venicius.evproject.model.CriaBanco;
import venicius.evproject.model.CriaBancoDatas;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        this.getSupportActionBar().hide();
        CalendarView mCalendar = (CalendarView) findViewById(R.id.calendarView);

        List<EventDay> events = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        mCalendar.showCurrentMonthPage();


        final BancoControllerDatas crud = new BancoControllerDatas(getBaseContext());
        Cursor cursor;
        cursor = crud.carregaDados();
        cursor.moveToFirst();
        String dia;


        boolean flagCursor=true;
        while (flagCursor){

            if (cursor.isLast()){
                flagCursor = false;
            }

            dia = cursor.getString(cursor.getColumnIndexOrThrow(CriaBancoDatas.DIA));

            Log.d("TEste",dia);

            calendar = null;
            calendar = new GregorianCalendar();

            calendar.set(Integer.parseInt(dia.substring(0,4)),(Integer.parseInt(dia.substring(5,7)))-1,Integer.parseInt(dia.substring(8,10)));

           Log.d("teste",dia.substring(0,4));
            Log.d("teste",dia.substring(5,7));
            Log.d("teste",dia.substring(8,10));

            events.add( new EventDay(calendar, R.drawable.check_outline));

           cursor.moveToNext();
        }

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
