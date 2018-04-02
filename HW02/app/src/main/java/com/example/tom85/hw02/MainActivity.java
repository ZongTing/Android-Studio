package com.example.tom85.hw02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<Food> mFoodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        processController();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void processController() {
        Food food1 = new Food(1, "臭豆腐", "高雄");
        Food food2 = new Food(2, "鴨血", "台南");
        Food food3 = new Food(3, "花生冰", "台中");
        Food food4 = new Food(4, "章魚燒", "嘉義");

        mFoodList.add(food1);
        mFoodList.add(food2);
        mFoodList.add(food3);
        mFoodList.add(food4);

        MainAdapter mainAdapter = new MainAdapter(mFoodList);
        mRecyclerView.setAdapter(mainAdapter);
        mainAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.i("被點擊的食物名稱", mFoodList.get(position).name);

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("FOOD_ID", mFoodList.get(position).id);
                bundle.putString("FOOD_NAME", mFoodList.get(position).name);
                bundle.putString("FOOD_ADDRESS", mFoodList.get(position).address);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
