package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FunctionManager.getInstance().addFunction(new FunctionWithoutParamsAndReturn("fun1") {
            @Override
            public void function() {
                Log.d(TAG, "function: " + "方法被调用!");
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionWithoutParamsWithReturn("fun2") {
            @Override
            public User function() {
                User user = new User();
                user.setPassword("123456");
                user.setUsername("kk");
                return user;
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionWithParamsWithoutReturn<User>("fun3") {

            @Override
            public void function(User user) {
                Log.d(TAG, "function: " +user);
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionWithParamsAndReturn<User,User>("fun4") {

            @Override
            public User function(User user) {
                user.setPassword("zxc");
                user.setUsername("zxc");
                return user;
            }
        });


        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
