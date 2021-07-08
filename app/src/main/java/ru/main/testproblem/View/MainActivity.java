package ru.main.testproblem.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.main.testproblem.ActivityMain2.Webview;
import ru.main.testproblem.Adapter.RecyclerViewAdapter;
import ru.main.testproblem.GetData;
import ru.main.testproblem.Model.Textmodel;
import ru.main.testproblem.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    HomePresents presenter;
    Button buttonSaveData;


    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        recyclerView = findViewById(R.id.recyclerview);
        presenter = new HomePresents(this::setText);
        presenter.getDates();

        buttonSaveData = findViewById(R.id.savedata);
        buttonSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GetData.class));
            }
        });


    }

    private void setText(List<Textmodel.Dates> dates) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(dates, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1,
                GridLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerViewAdapter.notifyDataSetChanged();

        recyclerViewAdapter.setOnItemClickListener((view, position) -> {


            Intent intent = new Intent(this, Webview.class);
//            intent.putExtra(EXTRA_CATEGORY, (Serializable) category);
            intent.putExtra(EXTRA_POSITION, position);
            startActivity(intent);
        });


    }

    private void saveData(){

    }




}