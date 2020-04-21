package com.example.numerology;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {
    private String SERVICE_URI_base = "https://nums20200403095643.azurewebsites.net/api/Nums/";
    private  String TAG = "Main2Activity";
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewResult = (TextView) findViewById(R.id.textView5);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://nums20200403095643.azurewebsites.net/api/Nums/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NumerologyApi numerologyApi = retrofit.create(NumerologyApi.class);

        Call<List<Post>> call = numerologyApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, retrofit2.Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                   // content += "ID: " + post.getId() + "\n";
                    content += "\t\tLife Path Number: " + post.getNumber() + "\n";
                  //  content += "Letter: " + post.getLetter() + "\n";
                    content +="\t" + post.getText() + "\n\n";

                    textViewResult.append(content);
                }
            }


            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

}
