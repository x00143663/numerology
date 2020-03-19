package com.example.numerology;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
        private static final String TAG = "MainActivity";
        private TextView mDisplayDate;
        private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayDate = (TextView) findViewById(R.id.textView4);

        mDisplayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                 Calendar cal= Calendar.getInstance();
                 int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;

                String date = month +"/"+dayOfMonth+"/"+year;
                int nr1 = 0;
                int nr =0;

                while (year > 0) {
                    nr1 +=  year % 10;
                    year = year / 10;
                }

                while (month > 0) {
                    nr1 +=  month % 10;
                    month = month / 10;
                }

                while (dayOfMonth > 0) {
                    nr1 +=  dayOfMonth % 10;
                    dayOfMonth = dayOfMonth / 10;
                }

                while (nr1 > 0) {
                    nr +=  nr1 % 10;
                    nr1 = nr1 / 10;
                }

                mDisplayDate.setText(date+"   Your No: "+nr);



            }
        };


    }
}
