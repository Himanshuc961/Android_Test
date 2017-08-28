package com.himanshuc961gmail.android_test;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView light ,xText, yText, zText,gxText,gyText,gzText,mxText,myText,mzText;
    private Sensor mySensor,mySensor2,mySensor3,mySensor4;
    private SensorManager SM;
    private float x = 0;
    private float y = 0;
    private float z = 0;
    private float gx = 0;
    private float gy = 0;
    private float gz = 0;
    private float mx = 0;
    private float my = 0;
    private float mz = 0;
    private float li = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mySensor2 = SM.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mySensor3 = SM.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mySensor4 = SM.getDefaultSensor(Sensor.TYPE_LIGHT);
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
        SM.registerListener(this, mySensor2, SensorManager.SENSOR_DELAY_NORMAL);
        SM.registerListener(this, mySensor3, SensorManager.SENSOR_DELAY_NORMAL);
        SM.registerListener(this, mySensor4, SensorManager.SENSOR_DELAY_NORMAL);

        light = (TextView)findViewById(R.id.light);
        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);
        gxText = (TextView)findViewById(R.id.gxText);
        mxText = (TextView)findViewById(R.id.mxText);
        myText = (TextView)findViewById(R.id.myText);
        mzText = (TextView)findViewById(R.id.mz_Text);
    }
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }
    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];
        }
        if( event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            gx = event.values[0];
            gy = event.values[1];
            gz = event.values[2];
        }
        if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            mx = event.values[0];
            my = event.values[1];
            mz = event.values[2];
        }
        if(event.sensor.getType() == Sensor.TYPE_LIGHT) {
            li = event.values[0];

        }
        light.setText("Light: " + x);
        xText.setText("Acc_X: " + x);
        yText.setText("Acc_Y: " + y);
        zText.setText("Acc_Z: " + z);
        gxText.setText("Gyro: " + gx);
        //gxText.setText("Gy: " + gy);
        //gxText.setText("Gz: " + gz);
        mxText.setText("Mag_X: " + mx);
        myText.setText("Mag_Y: " + my);
        mzText.setText("Mag_Z: " + mz);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
