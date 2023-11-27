package com.example.weather;

import android.app.Activity;
import android.widget.TextView;




public class MainPhoto extends WeatherPhoto{
    MainPhoto(Activity activity, String yourWeather) {
        super(activity, yourWeather);
    }
    void display(String descritpion, String dt , String degree, String barometer, String wind, String humidity, String city, String seaGrndLevel) {

        TextView napis = activity.findViewById(R.id.napis);
        TextView infoMain = activity.findViewById(R.id.infoMain);
        TextView degreeMain = activity.findViewById(R.id.degreeMain);
        TextView barometerMain = activity.findViewById(R.id.barometerMain);
        TextView windMain = activity.findViewById(R.id.windMain);
        TextView cityName = activity.findViewById(R.id.cityName);
        TextView humidityMain = activity.findViewById(R.id.humidityMain);
        TextView seaGroundLevel = activity.findViewById(R.id.seaGroundLevel);

        napis.setText(descritpion);
        infoMain.setText(dt);
        degreeMain.setText(degree+"°");
        barometerMain.setText(barometer+" hPa");
        windMain.setText(wind+"km/h");
        humidityMain.setText(humidity+"%");
        cityName.setText(city);
        seaGroundLevel.setText(seaGrndLevel);

    }
}
