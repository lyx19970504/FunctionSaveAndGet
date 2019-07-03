package com.example.myapplication;

public abstract class FunctionWithParamsAndReturn<T,P> extends Function{


    public FunctionWithParamsAndReturn(String functionName) {
        super(functionName);
    }

    public abstract T function(P p);
}
