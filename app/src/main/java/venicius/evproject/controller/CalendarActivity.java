package venicius.evproject.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import venicius.evproject.R;
import venicius.evproject.model.BancoControllerDatas;
import venicius.evproject.model.CriaBancoDatas;

public class CalendarActivity extends AppCompatActivity {

    Intent intentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        this.getSupportActionBar().hide();
        CalendarView mCalendar = (CalendarView) findViewById(R.id.calendarView);
        intentMain = new Intent(this,MainActivity.class);

        List<EventDay> events = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        mCalendar.showCurrentMonthPage();

        SharedPreferences sharedPref = this.getSharedPreferences(
                "venicius.evp.PREFERENCE_FILE_KEY",
                Context.MODE_PRIVATE);

        boolean flagSeq = sharedPref.getBoolean("banco", false);



        TextView txGeral = (TextView) findViewById(R.id.contagemGeral);
        TextView tx15 = (TextView) findViewById(R.id.contagem15);

        if(flagSeq) {

            final BancoControllerDatas crud = new BancoControllerDatas(getBaseContext());
            //crud.deletaLinhas();

            Cursor cursor;
            cursor = crud.carregaDados();
            cursor.moveToFirst();
            String dia;

            boolean flagCursor = true;

            while (flagCursor) {

                if (cursor.isLast()) {
                    flagCursor = false;
                    mCalendar.setEvents(events);
                }

                dia = cursor.getString(cursor.getColumnIndexOrThrow(CriaBancoDatas.DIA));
                calendar = null;
                calendar = new GregorianCalendar();
                calendar.set(Integer.parseInt(dia.substring(0, 4)), (Integer.parseInt(dia.substring(5, 7))) - 1, Integer.parseInt(dia.substring(8, 10)));
                events.add(new EventDay(calendar, R.drawable.check));
                cursor.moveToNext();
            }

            txGeral.setText(crud.contagemGeral() + " dia(s) completo(s).");
            tx15.setText(crud.contagem15() + " dia(s) completo(s).");
        }



        Button btVoltar = findViewById(R.id.btnVoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentMain);
            }
        });




    }

}
