package ac.baekseok.mymanager2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WeatherActivity extends AppCompatActivity {

    public Button btn_calendar, btn_health, btn_home, btn_weather, btn_state;
    TextView dateVeiw;
    TextView cityView;
    TextView weatherView;
    TextView tempView;

    static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        btn_calendar = findViewById(R.id.btn_calendar);
        btn_health = findViewById(R.id.btn_health);
        btn_home = findViewById(R.id.btn_home);
        btn_weather = findViewById(R.id.btn_weather);
//        btn_state = findViewById(R.id.btn_state);

        dateVeiw = findViewById(R.id.dateView);

        cityView = findViewById(R.id.cityView);
        weatherView = findViewById(R.id.weatherView);
        tempView = findViewById(R.id.tempView);


        ImageButton button = findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CurrentCall();
            }
        });
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeatherActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeatherActivity.this, HealthActivity.class);
                startActivity(intent);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeatherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeatherActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });

//        btn_state.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(WeatherActivity.this, PhoneStateActivity.class);
//                startActivity(intent);
//            }
//        });

    }


    private void CurrentCall() {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=cheonan&appid=6b3feb8c4f4cd07d54d0d2605f3eb2a3";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @SuppressLint("setText18n")
            @Override
            public void onResponse(String response) {
                try {

                    //?????? ??????(???,???,???,???,???,???) ???????????? Date??? ??????????????? String ???????????? ??????
                    long now = System.currentTimeMillis();
                    Date date = new Date(now);

                    SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");
                    String getDay = simpleDateFormatDay.format(date);
                    String getTime = simpleDateFormatTime.format(date);

                    //getDate??? ??????, ????????? ?????? ???, dateView ??????
                    String getDate = getDay + "\n" + getTime;
                    dateVeiw.setText(getDate);

                    //api??? ?????? ?????? jsonobject??? ????????? ?????? ??????
                    JSONObject jsonObject = new JSONObject(response);

                    //?????? ?????? ??????
                    String city = jsonObject.getString("name");
                    cityView.setText(city);

                    //??????
                    JSONArray weatherJson = jsonObject.getJSONArray("weather");
                    JSONObject weatherObj = weatherJson.getJSONObject(0);

                    String weather = weatherObj.getString("description");
                    weatherView.setText(weather);

                    //??????
                    JSONObject tempK = new JSONObject(jsonObject.getString("main"));
                    //?????? ?????? -> ??????
                    double tempDo = (Math.round((tempK.getDouble("temp")-273.15)*10)/10.0);
                    tempView.setText(tempDo + "??C");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
//            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String,String>();

                return params;
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);
    }
}