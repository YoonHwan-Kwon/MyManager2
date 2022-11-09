//package ac.baekseok.mymanager2.X;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import ac.baekseok.mymanager2.Health_MystateActivity;
//import ac.baekseok.mymanager2.R;
//
//public class fragHealth extends AppCompatActivity {
//
//    public Button btn_mystate, btn_alarm;
//    public TextView tv_mystate, tv_wet, tv_aee, tv_pill;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.frag_health);
//
//        btn_mystate = findViewById(R.id.btn_mystate);
//        btn_alarm = findViewById(R.id.btn_alarm);
//        tv_mystate = findViewById(R.id.tv_mystate);
//        tv_wet = findViewById(R.id.tv_wet);
//        tv_aee = findViewById(R.id.tv_aee);
//        tv_pill = findViewById(R.id.tv_pill);
//
//
//        btn_mystate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(fragHealth.this, Health_MystateActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//
//    }
//}
