package ac.baekseok.mymanager2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PhoneStateActivity extends AppCompatActivity {

    public Button btn_calendar, btn_health, btn_home, btn_weather, btn_state;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonestate);

        btn_calendar = findViewById(R.id.btn_calendar);
        btn_health = findViewById(R.id.btn_health);
        btn_home = findViewById(R.id.btn_home);
        btn_weather = findViewById(R.id.btn_weather);
        btn_state = findViewById(R.id.btn_state);

        textView = findViewById(R.id.textView4);

        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhoneStateActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhoneStateActivity.this, HealthActivity.class);
                startActivity(intent);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhoneStateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhoneStateActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });

        btn_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhoneStateActivity.this, PhoneStateActivity.class);
                startActivity(intent);
            }
        });

    }


}