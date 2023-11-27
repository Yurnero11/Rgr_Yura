package com.example.weather;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;



public class WeatherTime extends WeatherPhoto {
    String degrees;
    String times;
    WeatherTime(Activity activity, String yourWeather, String degrees, String times) {
        super(activity, yourWeather);
        this.degrees =degrees;
        this.times = times;
    }
    void display() {
        TableRow timeWeather1 = activity.findViewById(R.id.timeWeather);
        LinearLayout timeLayout = new LinearLayout(activity);
        int orientation = activity.getResources().getConfiguration().orientation;

        timeLayout.setOrientation(LinearLayout.VERTICAL);
        timeLayout.setBackgroundResource(R.drawable.radius);

        LinearLayout.LayoutParams timeParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        );

        timeParams.gravity = Gravity.CENTER;
        LinearLayout.LayoutParams timetime = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        );
        timetime.gravity=Gravity.CENTER;
        TextView timeget = new TextView(activity);
        timeget.setText(R.string.time);
        timeget.setTypeface(null, Typeface.BOLD);
        timeget.setGravity(Gravity.CENTER);
        timeget.setTextColor(Color.WHITE);
        timeget.setLayoutParams(timetime);

        TextView time = new TextView(activity);
        time.setText(times);

        time.setTextColor(Color.WHITE);
        time.setLayoutParams(timeParams);

        ImageView icon = new ImageView(activity);
        call(icon);
        LinearLayout.LayoutParams degreeParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        );

        degreeParams.gravity = Gravity.CENTER;

        TextView degree = new TextView(activity);
        degree.setText(degrees+"°");

        degree.setTypeface(null, Typeface.BOLD);
        degree.setTextColor(Color.LTGRAY);
        degree.setLayoutParams(degreeParams);


        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Tryb pionowy
            timeLayout.setMinimumHeight(650);
            timeLayout.setMinimumWidth(328);
            timeParams.bottomMargin = 32;
            timeParams.topMargin=6;
            timetime.topMargin=95;
            timetime.bottomMargin=12;
            timeget.setTextSize(18);
            time.setTextSize(36);
            degreeParams.topMargin = 32;
            degree.setTextSize(32);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Tryb poziomy
            timeLayout.setMinimumHeight(500);
            timeLayout.setMinimumWidth(277);
            timeParams.bottomMargin = 49;
            timeParams.topMargin=6;
            timetime.topMargin=95;
            timetime.bottomMargin=0;
            timeget.setTextSize(12);
            time.setTextSize(19);
            degreeParams.topMargin = 32;
            degreeParams.bottomMargin=32;
            degree.setTextSize(22);
        }

        timeLayout.addView(timeget);
        timeLayout.addView(time);
        timeLayout.addView(icon);
        timeLayout.addView(degree);
        timeWeather1.addView(timeLayout);
        TextView textView1 = new TextView(activity);
        textView1.setText("   ");
        timeWeather1.addView(textView1);
    }
}
