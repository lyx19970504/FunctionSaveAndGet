package com.example.myapplication;

public abstract class FunctionWithoutParamsWithReturn extends Function{

    public FunctionWithoutParamsWithReturn(String functionName) {
        super(functionName);
    }

    public abstract <T> T function();
}
