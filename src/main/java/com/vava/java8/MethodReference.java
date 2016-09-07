package com.vava.java8;

import java.nio.file.Files;

/**
 * Created by vasantas on 9/2/2016.
 */
public class MethodReference {
    public static void main(String[] args) {
        MethodReference ref  = new MethodReference();
        ref.main();
    }
    public void main() {
       /* this.delegate(new Printer() {
            @Override
            public void printSomething(String something) {
                System.out.println(something);
            }
        }, "Anonymous class");
        this.delegate( (String x) -> {System.out.println(x);}, "lambda express");*/
        //this.delegate(() -> {new InstanceMethod().printSomethingImpl();} );

        //this.delegate(() -> {new InstanceMethod().printSomethingImpl();} );
        InstanceMethod m = new InstanceMethod();
        this.delegate( InstanceMethod::printSomethingImpl);

        //this.delegate(String::length, "Method ref");
    }

   /* public void delegate(Printer p, String x){
        p.printSomething(x);
    }
*/
    public void delegate(SPPrinter p/*, InstanceMethod m*/){
        p.printSomething( "" );
    }

   /* public void delegate(StringToInt x, String val){
        System.out.println(x.map(val));
    }
*/

    @FunctionalInterface
    public interface SPPrinter {
        void printSomething(String s);
    }

    /*@FunctionalInterface
    public interface Printer {
        void printSomething(String something);
    }*/

   /* @FunctionalInterface
    public interface StringToInt {
        int map(String something);
    }*/

}

