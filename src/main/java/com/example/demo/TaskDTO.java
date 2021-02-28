package com.example.demo;

import java.io.Serializable;


public class TaskDTO implements Serializable {

    public long calculatedResult;

    public long getCalculatedResult() {
        return calculatedResult;
    }

    public void setCalculatedResult(long calculatedResult) {
        this.calculatedResult = calculatedResult;
    }
}