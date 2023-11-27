package com.example.weather.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weather.MainWeather;
import com.example.weather.R;


public class FormActivity extends AppCompatActivity {
    EditText city;
    EditText country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_activity);

        Button buttonActivity = findViewById(R.id.buttonActivity);
        city = findViewById(R.id.city);
        country = findViewById(R.id.country);

        buttonActivity.setOnClickListener(view -> {
            String value = String.valueOf(city.getText());
            String value2 = String.valueOf(country.getText());
            if(value.isEmpty() || value2.isEmpty()){
                Toast.makeText(this, "type city or country!", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(this, MainWeather.class);
                intent.putExtra("city", value);
                intent.putExtra("country", value2);
                startActivity(intent);
            }
        });
    }
}
