package com.himanshuc961gmail.android_test;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graphActivity extends AppCompatActivity implements SensorEventListener {
    private Sensor mySensor;
    private SensorManager SM;

    private float x = 0;
    private float y = 0;
    private float z = 0;
    private double acc = 0;
    private int count = 0;
    private LineGraphSeries<DataPoint> series;
    private double[] data =new double[200];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
    

        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        // Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register sensor Listener
        SM.registerListener((SensorEventListener) this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
        series = new LineGraphSeries<>();
        series.appendData(new DataPoint(0, 0), true, 200);
        GraphView graph = (GraphView) findViewById(R.id.graph1);
        graph.addSeries(series);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(200);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0] ;
        y = event.values[1] ;
        z = event.values[2] ;
        acc = Math.sqrt(x*x+y*y+z*z);




            count++;
        series.appendData(new DataPoint(count, acc), true, 200);





    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
