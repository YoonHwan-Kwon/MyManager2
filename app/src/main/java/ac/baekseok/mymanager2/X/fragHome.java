//package ac.baekseok.mymanager2.X;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import ac.baekseok.mymanager2.InfoActivity;
//import ac.baekseok.mymanager2.R;
//
//public class fragHome extends Fragment {
//    private View view;
//
//    private Button btn_info;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.frag_home, container, false);
//
//        btn_info = view.findViewById(R.id.btn_info);
//
//        btn_info.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {    //info화면으로 전환
//                Intent intent = new Intent(getActivity(), InfoActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        return view;
//
//    }
//
//
//}
