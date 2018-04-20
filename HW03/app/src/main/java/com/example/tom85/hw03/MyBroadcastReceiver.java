package com.example.tom85.hw03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver{

    // 接收廣播後執行這個方法
    // 第一個參數Context物件，用來顯示訊息框、啟動服務
    // 第二個參數是發出廣播事件的Intent物件，可以包含資料
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "起床！", Toast.LENGTH_SHORT).show();
        Log.i("Test", "HI");
        /*
        // 讀取包含在Intent物件中的資料
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", -1);

        // 因為這不是Activity元件，需要使用Context物件的時候，
        // 不可以使用「this」，要使用參數提供的Context物件
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();*/
    }
}
