package com.example.checksensoravailability;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    SensorManager sensorManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv1=(TextView) findViewById(R.id.sensor1);
        tv2=(TextView) findViewById(R.id.sensor2);
        tv3=(TextView) findViewById(R.id.sensor3);
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)!=null)
        {
            tv1.setText("THIS device light sensor");
        }
        else {
            tv1.setText("this device has not light sensor");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_HEART_BEAT)!=null)
        {
            tv2.setText("this device has heartbeat");
        }
        else {
            tv2.setText("this device has not heart beat");
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)!=null)
        {
            tv3.setText("this device has proximity");
        }
        else {
            tv3.setText("this device has not priximity");
        }
    }
}