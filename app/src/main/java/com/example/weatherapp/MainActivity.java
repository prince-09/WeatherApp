package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText cityname;
    TextView mintemp,maxtemp,temp,weather;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityname=findViewById(R.id.cityname);
        maxtemp=findViewById(R.id.maxtemparauter);
        mintemp=findViewById(R.id.mintemperature);
        weather=findViewById(R.id.weathercast);
        temp=findViewById(R.id.temperature);
        go=findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("clicked","true"+" "+cityname.getText().toString());
                Call<Stream> call=APIClient.getInstance().getApi().getWeather(cityname.getText().toString(),"6eef6e4d32741b61f84430ba292b8fc3");
                call.enqueue(new Callback<Stream>() {
                    @Override
                    public void onResponse(Call<Stream> call, Response<Stream> response) {
                        Log.i("success",response.isSuccessful()+"  "+response.raw().toString());
                        if(response.isSuccessful()&&response.body()!=null){
                            maxtemp.setText((int)(response.body().getTemp().getTemp_max()-273)+" C");
                            mintemp.setText((int)(response.body().getTemp().getTemp_min()-273)+" C");
                            temp.setText((int)(response.body().getTemp().getTemp()-273)+" C");
                            weather.setText(response.body().getWeaher().get(0).getMain());
                        }else{
                            Toast.makeText(getApplicationContext(),"Please enter a valid city",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Stream> call, Throwable t) {
                        Log.i("fail",t.toString());
                    }
                });
            }
        });

    }
}
