package ac.baekseok.mymanager2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//import ac.baekseok.mymanager2.X.fragHome;
//import ac.baekseok.mymanager2.X.fragState;
//import ac.baekseok.mymanager2.X.fragWeather;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

//    private BottomNavigationView bottomNavigationView;  //하단바
//    private FragmentManager fm;
//    private FragmentTransaction ft;
//    private fragCalendar fragCalendar;
//    private fragHealth fragHealth;
//    private fragHome fragHome;
//    private fragWeather fragWeather;
//    private fragState fragState;

    Button btn_calendar, btn_health, btn_home, btn_weather, btn_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();

        btn_calendar = findViewById(R.id.btn_calendar);
        btn_health = findViewById(R.id.btn_health);
        btn_home = findViewById(R.id.btn_home);
        btn_weather = findViewById(R.id.btn_weather);
//        btn_state = findViewById(R.id.btn_state);

        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HealthActivity.class);
                startActivity(intent);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });

//        btn_state.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, PhoneStateActivity.class);
//                startActivity(intent);
//            }
//        });

//        bottomNavigationView = findViewById(R.id.bottomNavi);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.action_calendar:
//                        setFrag(0);
//                        break;
//                    case R.id.action_health:
//                        setFrag(1);
//                        break;
//                    case R.id.action_home:
//                        setFrag(2);
//                        break;
//                    case R.id.action_weather:
//                        setFrag(3);
//                        break;
//                    case R.id.action_state:
//                        setFrag(4);
//                        break;
//                }
//                return true;
//            }
//        });
//        fragCalendar = new fragCalendar();
//        fragHealth = new fragHealth();
//        fragHome = new fragHome();
//        fragWeather = new fragWeather();
//        fragState = new fragState();
//
//        //첫 프래그먼트 화면 지정(홈 화면으로 지정)
////        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }
    //프래그먼트 교체가 일어나는 실행문
//    private void setFrag(int n) {
//        fm = getSupportFragmentManager();
//        ft = fm.beginTransaction();
//        switch (n){
//            case 0:
//                ft.replace(R.id.main_frame,fragCalendar);
//                ft.commit();
//                break;
//            case 1:
//                ft.replace(R.id.main_frame,fragHealth);
//                ft.commit();
//                break;
//            case 2:
//                ft.replace(R.id.main_frame,fragHome);
//                ft.commit();
//                break;
//            case 3:
//                ft.replace(R.id.main_frame,fragWeather);
//                ft.commit();
//                break;
//            case 4:
//                ft.replace(R.id.main_frame,fragState);
//                ft.commit();
//                break;
//        }
//    }

}