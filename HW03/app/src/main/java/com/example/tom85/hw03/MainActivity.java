package com.example.tom85.hw03;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private CalendarView calendarView;
    public Button button;
    private TimePickerDialog timePickerDialog;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    //代表目前時間的日曆
    final Calendar cal = Calendar.getInstance();
    int Year;
    int Month;
    int DayofMonth;
    String Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        touchCalendar();

    }

    private void initView()
    {
        calendarView = findViewById(R.id.CalendarView01);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        Intent intent = new Intent(MainActivity.this, MyBroadcastReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    }

    private void touchCalendar()
    {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                Year = year;
                Month = month;
                DayofMonth = dayOfMonth;
                Date = year + "年" + (month + 1) + "月" + dayOfMonth + "日";
                setClock();
            }
        });
    }

    private void setClock()
    {
        // Use the current time as the default values for the picker
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                cal.set(Calendar.HOUR, hourOfDay);
                cal.set(Calendar.MINUTE, minute);
                cal.set(Calendar.SECOND, 0);
                String time = hourOfDay + "點" + minute + "分";

                alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);

                textView.setText("已設置" + Date + time  + "的鬧鐘");
                button.setVisibility(View.VISIBLE);

            }
        }, hour, minute, false);

        timePickerDialog.show();
    }

    public void buttonOnClick(View view)
    {
        alarmManager.cancel(pendingIntent);
        button.setVisibility(View.INVISIBLE);
        textView.setText("已取消鬧鐘");
    }

}

