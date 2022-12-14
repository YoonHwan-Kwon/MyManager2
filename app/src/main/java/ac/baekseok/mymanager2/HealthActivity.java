package ac.baekseok.mymanager2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//import ac.baekseok.mymanager2.X.fragHome;
//import ac.baekseok.mymanager2.X.fragState;
//import ac.baekseok.mymanager2.X.fragWeather;

public class HealthActivity extends AppCompatActivity {

    public Button btn_mystate, btn_alarm;
    public TextView tv_mystate, tv_wet, tv_aee, tv_pill;
    public Button btn_calendar, btn_health, btn_home, btn_weather, btn_state;
    String shared = "file";
    List<String> mSelectedItems;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        btn_calendar = findViewById(R.id.btn_calendar);
        btn_health = findViewById(R.id.btn_health);
        btn_home = findViewById(R.id.btn_home);
        btn_weather = findViewById(R.id.btn_weather);
//        btn_state = findViewById(R.id.btn_state);

        btn_mystate = findViewById(R.id.btn_mystate);
        btn_alarm = findViewById(R.id.btn_alarm);
        tv_mystate = findViewById(R.id.tv_mystate);
        tv_wet = findViewById(R.id.tv_wet);
        tv_aee = findViewById(R.id.tv_aee);
        tv_pill = findViewById(R.id.tv_pill);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String result= sharedPreferences.getString("result", "");
        String pill= sharedPreferences.getString("pill", "");
        String bmi= sharedPreferences.getString("bmi", "");

        tv_mystate.setText(result);
        tv_pill.setText(pill);

//        Intent intent = getIntent();
//        String weight = intent.getStringExtra("putWeight");
//        String height = intent.getStringExtra("putHeight");
//        String bmi2 = intent.getStringExtra("putbmi");
//        Double bmi = Double.parseDouble(weight)/Double.parseDouble(height)/Double.parseDouble(height)*10000;
//        String temp = String.format("%.2f",bmi);
//        Double bmiresult = Double.parseDouble(temp);

//        String bmi3 = Double.toString(bmi2);
//        tv_aee.setText(bmi);

        Double doubleBmi = Double.parseDouble(bmi); //String -> Double ????????????
        if (doubleBmi < 18.5){    //?????????
            tv_wet.setText("??????, ?????????, ?????????, ?????????");
        }
        else if (doubleBmi > 18.5 & doubleBmi < 22.9){  //??????
            tv_wet.setText("??????, ?????????, ?????????");
            tv_aee.setText("?????????");
        }
        else if (doubleBmi > 23 & doubleBmi < 24.9) {   //?????????
            tv_wet.setText("??????, ?????????");
            tv_aee.setText("?????????, ???????????????");
        }
        else if (doubleBmi >25 & doubleBmi < 34.9){  //??????
            tv_wet.setText("?????????");
            tv_aee.setText("?????????, ???????????????, ?????????");
        }
        else {    //????????????
            tv_aee.setText("?????????, ???????????????, ?????????, ???????????????");
        }


        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthActivity.this, HealthActivity.class);
                startActivity(intent);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });

//        btn_state.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HealthActivity.this, PhoneStateActivity.class);
//                startActivity(intent);
//            }
//        });


        btn_mystate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthActivity.this, Health_MystateActivity.class);
                startActivity(intent);
            }
        });

        //????????????  8???, 12???, 18???
        btn_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    public void showDialog(){
        mSelectedItems = new ArrayList<>();
        builder = new AlertDialog.Builder(HealthActivity.this);
        builder.setTitle("????????? ????????? ???????????????.");

        //???????????????
        builder.setMultiChoiceItems(R.array.TIME, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                String[] items = getResources().getStringArray(R.array.TIME);

                if (isChecked){
                    mSelectedItems.add(items[which]);
                }else if (mSelectedItems.contains(items[which])){
                    mSelectedItems.remove(items[which]);
                }
            }
        });

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String final_selection = "";

                for (String item : mSelectedItems){
                    final_selection = final_selection + "\n" + item;
                }

                Toast.makeText(getApplicationContext(),"????????? ?????????" + final_selection + " ?????????.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }




    //    private void bmi_result() {
//
//        result = bmi;
//
//        if (result < 18.5) {
//            tv_mystate.setText("??????????????????.");
//        }
//        else if(result > 18.5 & bmi < 22.9) {
//            tv_mystate.setText("???????????????.");
//        }
//        else if(result > 23 & bmi < 24.9) {
//            tv_mystate.setText("??????????????????.");
//        }
//        else if(result > 25 & bmi < 34.9) {
//            tv_mystate.setText("???????????????.");
//        }
//        else {
//            tv_mystate.setText("?????? ???????????????.");
//        }
//
//
//    }
//    private void mystate(){
//        if (result == "??????????????????."){
//            tv_wet.setText("??????, ?????????, ?????????, ?????????");
//        }
//        else if (result == "???????????????."){
//            tv_wet.setText("??????, ?????????, ?????????");
//            tv_aee.setText("?????????");
//        }
//        else if (mystate == "??????????????????."){
//            tv_wet.setText("??????, ?????????");
//            tv_aee.setText("?????????, ???????????????");
//        }
//        else if (mystate == "???????????????."){
//            tv_wet.setText("?????????");
//            tv_aee.setText("?????????, ???????????????, ?????????");
//        }
//        else if (mystate == "?????????????????????."){
//            tv_aee.setText("?????????, ???????????????, ?????????, ???????????????");
//        }
//    }
}