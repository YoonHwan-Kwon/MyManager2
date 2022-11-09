//package ac.baekseok.mymanager2.X;
//
//import static android.content.Context.MODE_NO_LOCALIZED_COLLATORS;
//
//import android.annotation.SuppressLint;
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.provider.CalendarContract;
//import android.text.style.ForegroundColorSpan;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.CalendarView;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//
//import com.google.android.material.datepicker.MaterialCalendar;
//import com.prolificinteractive.materialcalendarview.CalendarDay;
//import com.prolificinteractive.materialcalendarview.DayViewDecorator;
//import com.prolificinteractive.materialcalendarview.DayViewFacade;
//import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
//import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
//
//import java.io.FileInputStream; //하위 디렉터리에 있는 응용프로그램 파일 읽기 모드
//import java.io.FileOutputStream; //하위 디렉터리에 있는 응용프로그램 파일 쓰기 모드
//import java.util.Calendar;
//
//import ac.baekseok.mymanager2.R;
//
//
//public class fragCalendar extends AppCompatActivity {
//
//    public String readDay = null;
//    public String str = null;
//    public CalendarView calendarView;
//    public Button btn_cha, btn_del, btn_save;
//    public TextView diaryTextView, textView2, textView3;
//    public EditText contextEditText;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.frag_calendar);
//
//
////
////        MaterialCalendarView materialCalendarView = view.findViewById(R.id.calendarView);
////        materialCalendarView.setSelectedDate(CalendarDay.today());  //날짜 선택 시 색상 변경
////        materialCalendarView.addDecorators(new SundayDecorator(), new SaturdayDecorator());
//
//
////        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
////            @Override
////            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
////
////                AlertDialog.Builder builder = new AlertDialog.Builder(this);    //다이얼로그 Builder객체 생성
////
////                builder.setTitle("")
////
////                LayoutInflater inflater = getLayoutInflater();
////                View view inflater.inflate(R.layout.calendar_dialog_basic, null);
////
////                builder.setView(view);
////            }
////        });
//
//
//        calendarView = findViewById(R.id.calendarView);
//        diaryTextView = findViewById(R.id.diaryTextView);
//        btn_save = findViewById(R.id.btn_save);
//        btn_del = findViewById(R.id.btn_del);
//        btn_cha = findViewById(R.id.btn_cha);
//        textView2 = findViewById(R.id.textView2);
//        textView3 = findViewById(R.id.textView3);
//        contextEditText = findViewById(R.id.contextEditText);
//
//
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
//                diaryTextView.setVisibility(View.VISIBLE);
//                btn_save.setVisibility(View.VISIBLE);
//                contextEditText.setVisibility(View.VISIBLE);
//                textView2.setVisibility(View.INVISIBLE);
//                btn_cha.setVisibility(View.INVISIBLE);
//                btn_del.setVisibility(View.INVISIBLE);
//                diaryTextView.setText(String.format("%d / %d / %d", year, month + 1, dayOfMonth));
//                contextEditText.setText("");
//                checkDay(year, month, dayOfMonth);
//            }
//        });
//
//        btn_save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                saveDiary(readDay);
//                str = contextEditText.getText().toString();
//                textView2.setText(str);
//                btn_save.setVisibility(View.INVISIBLE);
//                btn_cha.setVisibility(View.VISIBLE);
//                btn_del.setVisibility(View.VISIBLE);
//                contextEditText.setVisibility(View.INVISIBLE);
//                textView2.setVisibility(View.VISIBLE);
//
//            }
//        });
//
////        return view;
//    }
//
//
//
//    public void checkDay(int cYear, int cMonth, int cDay)
//    {
//        readDay = "" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";   //다이어리 내용을 각 요일별 파일로 저장 ex) 20221003.txt
////        FileInputStream fis = null;
//
//        try
//        {
//            FileInputStream fis = this.openFileInput(readDay);
////            fis = openFileInput(readDay);
//
//            byte[] fileData = new byte[fis.available()];
//            fis.read(fileData);
//            fis.close();
//
//            str = new String(fileData);
//
//            contextEditText.setVisibility(View.INVISIBLE);
//            textView2.setVisibility(View.VISIBLE);
//            textView2.setText(str);
//
//            btn_save.setVisibility(View.INVISIBLE);
//            btn_cha.setVisibility(View.VISIBLE);
//            btn_del.setVisibility(View.VISIBLE);
//
//            btn_cha.setOnClickListener(new View.OnClickListener()
//            {
//                @Override
//                public void onClick(View view)
//                {
//                    contextEditText.setVisibility(View.VISIBLE);
//                    textView2.setVisibility(View.INVISIBLE);
//                    contextEditText.setText(str);
//
//                    btn_save.setVisibility(View.VISIBLE);
//                    btn_cha.setVisibility(View.INVISIBLE);
//                    btn_del.setVisibility(View.INVISIBLE);
//                    textView2.setText(contextEditText.getText());
//                }
//
//            });
//            btn_del.setOnClickListener(new View.OnClickListener()
//            {
//                @Override
//                public void onClick(View view)
//                {
//                    textView2.setVisibility(View.INVISIBLE);
//                    contextEditText.setText("");
//                    contextEditText.setVisibility(View.VISIBLE);
//                    btn_save.setVisibility(View.VISIBLE);
//                    btn_cha.setVisibility(View.INVISIBLE);
//                    btn_del.setVisibility(View.INVISIBLE);
//                    removeDiary(readDay);
//                }
//            });
//            if (textView2.getText() == null)
//            {
//                textView2.setVisibility(View.INVISIBLE);
//                diaryTextView.setVisibility(View.VISIBLE);
//                btn_save.setVisibility(View.VISIBLE);
//                btn_cha.setVisibility(View.INVISIBLE);
//                btn_del.setVisibility(View.INVISIBLE);
//                contextEditText.setVisibility(View.VISIBLE);
//            }
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    @SuppressLint("WrongConstant")
//    public void removeDiary(String readDay)     //다이어리 내용 삭제
//    {
////        FileOutputStream fos;
//        try
//        {
//            FileOutputStream fos = this.openFileOutput(readDay,Context.MODE_PRIVATE);
////            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
//            String content = "";
//            fos.write((content).getBytes());
//            fos.close();
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    @SuppressLint("WrongConstant")
//    public void saveDiary(String readDay)   //다이어리 내용 저장
//    {
////        FileOutputStream fos;
//        try
//        {
////            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
//            FileOutputStream fos = this.openFileOutput(readDay,Context.MODE_PRIVATE);
//            String content = contextEditText.getText().toString();
//            fos.write((content).getBytes());
//            fos.close();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//}
