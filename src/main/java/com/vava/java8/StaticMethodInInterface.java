package com.vava.java8;

/**
 * Created by vasantas on 9/2/2016.
 */
public interface StaticMethodInInterface {
    public static String printSomethingImpl(String x){
        System.out.println(x);
        return x;
    }
}
