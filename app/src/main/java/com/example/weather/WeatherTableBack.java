package com.example.weather;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;




public class WeatherTableBack extends WeatherPhoto{
    Context context;
    String yourDay;
    String yourWeather;
    String degree1;
    String degree2;
    Activity activity;

    WeatherTableBack(Context context, Activity activity, String yourDay, String yourWeather, String degree1, String degree2){
        super(activity, yourWeather);
        this.context = context;
        this.activity = activity;
        this.yourDay = yourDay;
        this.yourWeather=yourWeather;
        this.degree1=degree1;
        this.degree2=degree2;
    }

    void wyswietl(){

        TableLayout tableLayoutPogoda2 = activity.findViewById(R.id.tableLayoutPogoda2);
        TableRow row = new TableRow(activity);

        TextView day = new TextView(activity);
        day.setText(yourDay);
        day.setTextSize(18); // Rozmiar tekstu
        day.setTextColor(Color.WHITE); // Kolor tekstu
        day.setTypeface(null, Typeface.BOLD);

        TableRow.LayoutParams dayParams = new TableRow.LayoutParams(
                TableRow.MarginLayoutParams.WRAP_CONTENT, TableRow.MarginLayoutParams.WRAP_CONTENT);

        dayParams.setMarginStart(10);
        dayParams.setMarginEnd(50);
        dayParams.gravity= Gravity.CENTER_VERTICAL;
        day.setLayoutParams(dayParams);

        TextView weather = new TextView(activity);
        weather.setText(yourWeather);
        weather.setTextSize(18);
        weather.setTextColor(Color.WHITE);

        TableRow.LayoutParams weatherParams = new TableRow.LayoutParams(
                TableRow.MarginLayoutParams.WRAP_CONTENT, TableRow.MarginLayoutParams.WRAP_CONTENT);

        weatherParams.setMarginStart(20);
        weatherParams.setMarginEnd(20);
        weatherParams.gravity=Gravity.CENTER_VERTICAL;
        weather.setLayoutParams(weatherParams);

        TextView weatherDegree1 = new TextView(activity);
        weatherDegree1.setText(degree1+"°");
        weatherDegree1.setTextSize(18);
        weatherDegree1.setTextColor(Color.WHITE);
        weatherDegree1.setTypeface(null, Typeface.BOLD);

        TableRow.LayoutParams weatherDegreeParams = new TableRow.LayoutParams(
                TableRow.MarginLayoutParams.WRAP_CONTENT, TableRow.MarginLayoutParams.WRAP_CONTENT);

        weatherDegreeParams.gravity=Gravity.CENTER_VERTICAL;
        weatherDegreeParams.setMarginStart(90);
        weatherDegreeParams.setMarginEnd(50);
        weatherDegree1.setLayoutParams(weatherDegreeParams);

        TextView weatherDegree2 = new TextView(activity);
        weatherDegree2.setText(degree2+"°");
        weatherDegree2.setTextSize(18);
        weatherDegree2.setTextColor(Color.LTGRAY);
        weatherDegree2.setTypeface(null, Typeface.BOLD);
        weatherDegree2.setLayoutParams(weatherParams);

        ImageView weatherPhoto = new ImageView(activity);
        call(weatherPhoto);

        TableRow.LayoutParams imageParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
        );
        imageParams.gravity = Gravity.CENTER_VERTICAL;
        weatherPhoto.setLayoutParams(imageParams);

        row.setMinimumWidth(223);
        row.setMinimumHeight(260);
        row.addView(day);
        row.addView(weatherPhoto);
        row.addView(weather);
        row.addView(weatherDegree1);
        row.addView(weatherDegree2);
        tableLayoutPogoda2.addView(row);
    }
}
