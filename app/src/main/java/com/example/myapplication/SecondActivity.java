package com.example.myapplication;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FunctionManager.getInstance().invoke("fun1");
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = FunctionManager.getInstance().invoke("fun2",User.class);
                Log.d(TAG, "onClick: " + user);
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUsername("aa");
                user.setPassword("123456");
                FunctionManager.getInstance().invoke("fun3",user);
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUsername("aa");
                user.setPassword("123456");
                User userReturn = FunctionManager.getInstance().invoke("fun4",user,User.class);
                Log.d(TAG, "onClick: " + userReturn);
            }
        });
    }
}
