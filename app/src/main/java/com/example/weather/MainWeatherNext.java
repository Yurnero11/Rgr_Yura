package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;


public class MainWeatherNext extends AppCompatActivity {
    LinearLayout back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather2);


        WeatherTableBack[] weathers = new WeatherTableBack[5];
        WeatherTommorow weatherTommorow = new WeatherTommorow(this, Api.table[5][0],Api.table[0][0],Api.table[4][0]);
        weatherTommorow.call(Api.table[8][0],Api.table[7][0],Api.table[6][0],Api.table[9][0],Api.table[2][0]);

        for(int i = 1 ; i < 4 ; i++){
            weathers[i] = new WeatherTableBack(this,this,Api.table[5][i],Api.table[0][i],Api.table[4][i],Api.tab1[3][i+3]);
            weathers[i].wyswietl();
        }

        back = findViewById(R.id.back);
        back.setOnClickListener(view ->  onBackPressed());
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}