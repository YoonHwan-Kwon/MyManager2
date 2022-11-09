package ac.baekseok.mymanager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//import ac.baekseok.mymanager2.X.fragHome;
//import ac.baekseok.mymanager2.X.fragState;
//import ac.baekseok.mymanager2.X.fragWeather;

public class CalendarActivity extends AppCompatActivity {

    public String readDay = null;
    public String str = null;
    public CalendarView calendarView;
    public Button btn_cha, btn_del, btn_save;
    public Button btn_calendar, btn_health, btn_home, btn_weather, btn_state;
    public TextView diaryTextView, textView2, textView3;
    public EditText contextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        btn_calendar = findViewById(R.id.btn_calendar);
        btn_health = findViewById(R.id.btn_health);
        btn_home = findViewById(R.id.btn_home);
        btn_weather = findViewById(R.id.btn_weather);
//        btn_state = findViewById(R.id.btn_state);

        calendarView = findViewById(R.id.calendarView);
        diaryTextView = findViewById(R.id.diaryTextView);
        btn_save = findViewById(R.id.btn_save);
        btn_del = findViewById(R.id.btn_del);
        btn_cha = findViewById(R.id.btn_cha);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        contextEditText = findViewById(R.id.contextEditText);

        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarActivity.this, HealthActivity.class);
                startActivity(intent);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });

//        btn_state.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(CalendarActivity.this, PhoneStateActivity.class);
//                startActivity(intent);
//            }
//        });


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                diaryTextView.setVisibility(View.VISIBLE);
                btn_save.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                btn_cha.setVisibility(View.INVISIBLE);
                btn_del.setVisibility(View.INVISIBLE);
                diaryTextView.setText(String.format("%d / %d / %d", year, month + 1, dayOfMonth));
                contextEditText.setText("");
                checkDay(year, month, dayOfMonth);
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDiary(readDay);
                str = contextEditText.getText().toString();
                textView2.setText(str);
                btn_save.setVisibility(View.INVISIBLE);
                btn_cha.setVisibility(View.VISIBLE);
                btn_del.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);

            }
        });
    }
    public void checkDay(int cYear, int cMonth, int cDay)
    {
        readDay = "" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";   //다이어리 내용을 각 요일별 파일로 저장 ex) 20221003.txt
//        FileInputStream fis = null;

        try
        {
            FileInputStream fis = this.openFileInput(readDay);
//            fis = openFileInput(readDay);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            str = new String(fileData);

            contextEditText.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView2.setText(str);

            btn_save.setVisibility(View.INVISIBLE);
            btn_cha.setVisibility(View.VISIBLE);
            btn_del.setVisibility(View.VISIBLE);

            btn_cha.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    contextEditText.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.INVISIBLE);
                    contextEditText.setText(str);

                    btn_save.setVisibility(View.VISIBLE);
                    btn_cha.setVisibility(View.INVISIBLE);
                    btn_del.setVisibility(View.INVISIBLE);
                    textView2.setText(contextEditText.getText());
                }

            });
            btn_del.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    textView2.setVisibility(View.INVISIBLE);
                    contextEditText.setText("");
                    contextEditText.setVisibility(View.VISIBLE);
                    btn_save.setVisibility(View.VISIBLE);
                    btn_cha.setVisibility(View.INVISIBLE);
                    btn_del.setVisibility(View.INVISIBLE);
                    removeDiary(readDay);
                }
            });
            if (textView2.getText() == null)
            {
                textView2.setVisibility(View.INVISIBLE);
                diaryTextView.setVisibility(View.VISIBLE);
                btn_save.setVisibility(View.VISIBLE);
                btn_cha.setVisibility(View.INVISIBLE);
                btn_del.setVisibility(View.INVISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void removeDiary(String readDay)     //다이어리 내용 삭제
    {
//        FileOutputStream fos;
        try
        {
            FileOutputStream fos = this.openFileOutput(readDay, Context.MODE_PRIVATE);
//            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = "";
            fos.write((content).getBytes());
            fos.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void saveDiary(String readDay)   //다이어리 내용 저장
    {
//        FileOutputStream fos;
        try
        {
//            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            FileOutputStream fos = this.openFileOutput(readDay,Context.MODE_PRIVATE);
            String content = contextEditText.getText().toString();
            fos.write((content).getBytes());
            fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}