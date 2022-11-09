package ac.baekseok.mymanager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Health_MystateActivity extends FragmentActivity {

    private Button btn_back, btn_save;
    private EditText edt_age, edt_height, edt_weight, edt_pill;
    private TextView tv_bmi, tv_result;
    String age, bmi_height, bmi_weight, temp;
    String shared = "file";
    Double bmi2, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_mystate);

        btn_back = findViewById(R.id.btn_back);
        btn_save = findViewById(R.id.btn_save);
        edt_age = findViewById(R.id.edt_age);
        edt_height = findViewById(R.id.edt_height);
        edt_weight = findViewById(R.id.edt_weight);
        edt_pill = findViewById(R.id.edt_pill);
        tv_bmi = findViewById(R.id.tv_bmi);
        tv_result = findViewById(R.id.tv_result);

//        test();

        //저장된 데이터 값 호출
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String age = sharedPreferences.getString("age", "");
        String height = sharedPreferences.getString("height", "");
        String weight = sharedPreferences.getString("weight", "");
        String pill= sharedPreferences.getString("pill", "");
        String bmi= sharedPreferences.getString("bmi", "");
        String result= sharedPreferences.getString("result", "");
        edt_age.setText(age);
        edt_height.setText(height);
        edt_weight.setText(weight);
        edt_pill.setText(pill);
        tv_bmi.setText(bmi);
        tv_result.setText(result);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //엑티비티 -> 프래그먼트 화면전환
                Intent intent = new Intent(Health_MystateActivity.this, HealthActivity.class);
                startActivity(intent);
            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                bmi_set();
                bmi_result();

                bmi_weight = edt_weight.getText().toString();
                bmi_height = edt_height.getText().toString();
                bmi2 = Double.parseDouble(bmi_weight)/Double.parseDouble(bmi_height)/Double.parseDouble(bmi_height)*10000;
                temp = String.format("%.2f",bmi2);
                tv_bmi.setText(temp);

                Intent intent = new Intent(Health_MystateActivity.this, HealthActivity.class);
                intent.putExtra("putWeight",edt_weight.getText().toString());
                intent.putExtra("putHeight",edt_height.getText().toString());
                intent.putExtra("putbmi", tv_bmi.getText().toString());
                startActivity(intent);
            }
        });


    }

    //bmi 계산
//    public void bmi_set(){
//        weight = edt_weight.getText().toString();
//        height = edt_height.getText().toString();
//        bmi = Double.parseDouble(weight)/Double.parseDouble(height)/Double.parseDouble(height)*10000;
//        temp = String.format("%.2f",bmi);
//        tv_bmi.setText(temp);
//    }

    //내 상태 값 저장 및 유지
    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String age = edt_age.getText().toString();
        String weight = edt_weight.getText().toString();
        String height = edt_height.getText().toString();
        String pill = edt_pill.getText().toString();
        String bmi= tv_bmi.getText().toString();
        String result = tv_result.getText().toString();

        editor.putString("age", age);
        editor.putString("weight", weight);
        editor.putString("height", height);
        editor.putString("pill", pill);
        editor.putString("bmi", bmi);
        editor.putString("result", result);
        editor.commit();
    }

//    public void test(){
//        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
//        String age = sharedPreferences.getString("age", "");
//        String height = sharedPreferences.getString("height", "");
//        String weight = sharedPreferences.getString("weight", "");
//        String pill= sharedPreferences.getString("pill", "");
//        String bmi= sharedPreferences.getString("bmi", "");
//        String result= sharedPreferences.getString("result", "");
//        edt_age.setText(age);
//        edt_height.setText(height);
//        edt_weight.setText(weight);
//        edt_pill.setText(pill);
//        tv_bmi.setText(bmi);
//        tv_result.setText(result);
//    }
    // BMI 지수에 따른 결과값
    private void bmi_result() {
        result = bmi2;

        if (result < 18.5) {
            tv_result.setText("저체중입니다.");
        }
        else if(result > 18.5 & result < 22.9) {
            tv_result.setText("정상입니다.");
        }
        else if(result > 23 & result < 24.9) {
            tv_result.setText("과체중입니다.");
        }
        else if(result > 25 & result < 34.9) {
            tv_result.setText("비만입니다.");
        }
        else {
            tv_result.setText("고도비만입니다.");
        }

    }


}