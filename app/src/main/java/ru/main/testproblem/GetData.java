package ru.main.testproblem;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.main.testproblem.Model.UserModel;

public class  GetData extends AppCompatActivity {


    TextView textView;
    RecyclerView recyclerview;

    private List<UserModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);
        recyclerview = findViewById(R.id.recyclerview);

//        textView = findViewById(R.id.textView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();

    }

    private void getData() {
        list = new ArrayList<>();
        list = DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData();
//        textView.setText(list);

//        recyclerview.setAdapter(new UserAdapter(getApplicationContext(), list, new UserAdapter.DeleteItemClicklistner() {
//            @Override
//            public void onItemDelete(int position, int id) {
////                DatabaseClass.getDatabase(getApplicationContext()).getDao().deleteData(id);
//                getAllData();
//            }
//        }));


    }
}