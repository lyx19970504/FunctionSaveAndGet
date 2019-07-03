package com.example.myapplication;

public abstract class FunctionWithParamsWithoutReturn<T> extends Function{

    public FunctionWithParamsWithoutReturn(String functionName) {
        super(functionName);
    }

    public abstract void function(T t);
}
