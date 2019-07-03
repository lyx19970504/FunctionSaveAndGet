package com.example.myapplication;

import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class FunctionManager {

    private static final String TAG = "FunctionManager";

    private static FunctionManager functionManager;
    private Map<String,FunctionWithoutParamsAndReturn> functionMap;
    private Map<String,FunctionWithoutParamsWithReturn> functionRMap;
    private Map<String,FunctionWithParamsAndReturn> functionPARMap;
    private Map<String,FunctionWithParamsWithoutReturn> functionPMap;

    public static FunctionManager getInstance(){
        if(functionManager == null){
            functionManager = new FunctionManager();
        }
        return functionManager;
    }

    public FunctionManager(){
        functionMap = new HashMap<>();
        functionRMap = new HashMap<>();
        functionPARMap = new HashMap<>();
        functionPMap = new HashMap<>();
    }

    public void addFunction(Function function){
        if(function == null){
            return;
        }

        //不带参数，返回值方法的添加
        if(function instanceof FunctionWithoutParamsAndReturn){
            functionMap.put(function.FunctionName, (FunctionWithoutParamsAndReturn) function);
        }
        //不带参数有返回值的方法添加
        else if(function instanceof FunctionWithoutParamsWithReturn){
            functionRMap.put(function.FunctionName, (FunctionWithoutParamsWithReturn) function);
        }
        //带参数无返回值的方法添加
        else if(function instanceof FunctionWithParamsWithoutReturn){
            functionPMap.put(function.FunctionName,(FunctionWithParamsWithoutReturn) function);
        }
        //带参数带返回值的方法添加
        else if(function instanceof FunctionWithParamsAndReturn){
            functionPARMap.put(function.FunctionName,(FunctionWithParamsAndReturn) function);
        }
    }


    //不带参数，返回值方法的调用
    public void invoke(String functionName){
        if(TextUtils.isEmpty(functionName)){
            return;
        }
        FunctionWithoutParamsAndReturn function = functionMap.get(functionName);
        if(function == null){
            Log.d(TAG, "invoke: " +"数据源中没有这个方法!");
            return;
        }
        function.function();
    }

    //不带参数有返回值的方法调用
    public <T> T invoke(String functionName,Class<T> t){
        if(TextUtils.isEmpty(functionName)){
            return null;
        }
        FunctionWithoutParamsWithReturn function = functionRMap.get(functionName);
        if(function == null){
            Log.d(TAG, "invoke: " +"数据源中没有这个方法!");
            return null;
        }
        if(t != null){
            return t.cast(function.function());
        }
        return null;
    }

    //带参数无返回值的方法调用
    public <P> void invoke(String functionName,P p){
        if(TextUtils.isEmpty(functionName)){
            return;
        }
        FunctionWithParamsWithoutReturn function = functionPMap.get(functionName);
        if(function == null){
            Log.d(TAG, "invoke: " +"数据源中没有这个方法!");
            return;
        }
        if(p != null){
            function.function(p);
        }
    }

    //带参数带返回值的方法调用
    public <T,P> T invoke(String functionName,P p,Class<T> t){
        if(TextUtils.isEmpty(functionName)){
            return null;
        }
        FunctionWithParamsAndReturn function = functionPARMap.get(functionName);
        if(function == null){
            Log.d(TAG, "invoke: " +"数据源中没有这个方法!");
            return null;
        }
        if(p != null && t != null){
            return t.cast(function.function(p));
        }
        return null;
    }
}
