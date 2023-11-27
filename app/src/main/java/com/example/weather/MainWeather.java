package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather.activity.FormActivity;


public class MainWeather extends AppCompatActivity {
    TextView next;
    ImageView image;
    String val;
    TableLayout table;
    RelativeLayout writing1;
    View divider;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        divider = findViewById(R.id.divider);
        divider.setVisibility(View.GONE);

        table = findViewById(R.id.tablica);
        table.setVisibility(View.GONE);

        writing1 = findViewById(R.id.napis1);
        writing1.setVisibility(View.GONE);

        Intent intent1 = getIntent();
        val = intent1.getStringExtra("city");
        Api.name =val;

        next = findViewById(R.id.nextBtn);
        image = findViewById(R.id.image);


        next.setOnClickListener(view -> {
            Intent intent = new Intent(MainWeather.this, MainWeatherNext.class);
            intent.putExtra("city", Api.name);
            startActivity(intent);
        });
        new ApiTask().execute();

    }

    class ApiTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            Api.api();
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            displayData();
        }
    }

    void displayData() {

        if(Api.responseCode !=200){
            Toast.makeText(this, "Wrong data!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, FormActivity.class);
            startActivity(intent);
        }else {
            progressBar.setVisibility(View.GONE);
            writing1.setVisibility(View.VISIBLE);
            table.setVisibility(View.VISIBLE);
            divider.setVisibility(View.VISIBLE);
            String seaGrndLevel = "S: "+Api.tab1[9][0] + " hPa | G: "+Api.tab1[10][0]+" hPa";
            MainPhoto mainPhoto = new MainPhoto(this,Api.tab1[0][0]);
            mainPhoto.display(Api.tab1[2][0],Api.tab1[5][0],Api.tab1[4][0],Api.tab1[8][0],Api.tab1[7][0],Api.tab1[6][0],val, seaGrndLevel);
            mainPhoto.call(image);

            WeatherTime[] weatherTimes = new WeatherTime[10];
            for (int i = 1 ; i<weatherTimes.length ; i++){
                weatherTimes[i] = new WeatherTime(this,Api.tab1[0][i] ,Api.tab1[4][i], Api.tab1[11][i]);
                weatherTimes[i].display();
            }
        }

    }
}
