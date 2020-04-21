package com.example.numerology;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import com.android.volley.RequestQueue;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

        private String SERVICE_URI_base = "https://nums20200403095643.azurewebsites.net/api/Nums/";
        private  String TAG = "MainActivity";
        private TextView mDisplayDate;
     //   private TextView nDisplayDate;
        private TextView outputTextView;
        private DatePickerDialog.OnDateSetListener mDateSetListener;
        private Button mButton;
        private  Button lButton;
        private RadioButton rButton;
        int nr;

    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rButton = (RadioButton)  findViewById(R.id.radioButton);

        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //require to import the RadioButton class
                RadioButton rButton = (RadioButton) findViewById(R.id.radioButton);


                //is the current radio button now checked?
                boolean  checked = ((RadioButton) v).isChecked();

                //now check which radio button is selected
                //android switch statement

                if(checked)
                    //if windows phone programming book is selected
                    //set the checked radio button's text style bold italic
                    openActivity2();

            }
        });
        lButton = (Button) findViewById(R.id.button3);


        mDisplayDate = (TextView) findViewById(R.id.textView4);

         outputTextView = (TextView) findViewById(R.id.textView3);
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
                nr =0;

                nr = month % 10; //crunching numbers of date down to single digit
                month /= 10;
                nr += month % 10;
                month /= 10;
                nr += dayOfMonth % 10;
                dayOfMonth /= 10;
                nr += dayOfMonth % 10;
                dayOfMonth /= 10;
                nr += year % 10;
                year /= 10;
                nr += year %10;
                year /= 10;
                nr += year % 10;
                year /= 10;
                nr += year %10;
                year /= 10;
                nr1 = nr/10;
                nr %= 10;
                nr += nr1;
                if (nr ==10){nr = 1;}

                mDisplayDate.setText(date +" Your no is: "+nr);
                Log.d(TAG, "Making request");
            }
        };


       mButton = findViewById(R.id.button2);
       mButton.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view)
           {

              callService(nr);
               Toast.makeText(MainActivity.this, "Request submit " + nr, Toast.LENGTH_SHORT).show();
            }
       });
       lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = (String) outputTextView.getText().toString();
                String shareSub = "My life number meaning";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
       });

    }

  public void callService(int nr)
    {

        try
        {
            // make a string request (JSON request an alternative)
            RequestQueue queue = Volley.newRequestQueue(this);
            Log.d(TAG, "Making request");
            try

            {

                String SERVICE_URI="";
                if (nr==1) {
                 SERVICE_URI = SERVICE_URI_base + "a";
                }
                if (nr==2) {
                     SERVICE_URI = SERVICE_URI_base + "b";
                }
                if (nr==3) {
                    SERVICE_URI = SERVICE_URI_base + "c";
                }
                if (nr==4) {
                    SERVICE_URI = SERVICE_URI_base + "d";
                }
                if (nr==5) {
                     SERVICE_URI = SERVICE_URI_base + "e";
                }
                if (nr==6) {
                    SERVICE_URI = SERVICE_URI_base + "f";
                }
                if (nr==7) {
                    SERVICE_URI = SERVICE_URI_base + "g";
                }
                if (nr==8) {
                    SERVICE_URI = SERVICE_URI_base + "h";
                }
                if (nr==9) {
                    SERVICE_URI = SERVICE_URI_base + "i";
                }

                StringRequest strObjRequest = new StringRequest(Request.Method.GET, SERVICE_URI,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                // parse resulting string containing JSON to Greeting object
                                Message msg = new Gson().fromJson(response, Message.class);
                                outputTextView.setText(msg.toString());
                                outputTextView.setMovementMethod(new ScrollingMovementMethod());
                                Log.d(TAG, "Displaying data" + msg.toString());
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                             outputTextView.setText("\t\tError!\n\t Please check:\n\t -you select date of birth\n\t -you have internet connection\n\t and try again!");
                                Log.d(TAG, "Error*:" + error.toString());
                            }
                        });
                queue.add(strObjRequest);           // can have multiple in a queue, and can cancel
            }
            catch (Exception e1)
            {
                Log.d(TAG, e1.toString());
                outputTextView.setText(e1.toString());

            }
        }
        catch (Exception e2)
        {
            Log.d(TAG, e2.toString());
            outputTextView.setText(e2.toString());
        }
    }
    public void openActivity2()
    {
        Intent intent = new  Intent(this, Main2Activity.class);
        startActivity(intent);
    }

}
