package com.vava.java8;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by vasantas on 9/7/2016.
 */
public class ForkJoinCalculator extends RecursiveTask<Long>{
    static AtomicLong counter = new AtomicLong(0);
    private long[] data;
    private int start;
    private int end;
    public ForkJoinCalculator(long[] collect, int start, int end) {
        this.counter.incrementAndGet();
        data = collect;
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        long[] array = LongStream.range(1000, 4000000L).toArray();
        System.out.println(array.length);
        ForkJoinCalculator cal = new ForkJoinCalculator(array, 0, array.length);
        cal.fork();
        System.out.println(cal.join());
        System.out.println(counter.get());
    }

    @Override
    protected Long compute() {
        if(end - start < 1000) {
            return calDirect();
        }else {
            int mid = (start + end) / 2;
            ForkJoinCalculator first = new ForkJoinCalculator(this.data, start, mid);
            ForkJoinCalculator sec = new ForkJoinCalculator(this.data, mid, end);
            first.fork();
            sec.fork();
            return first.join()+ sec.join();
        }
    }

    private long calDirect() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += data[i];
        }
        return sum;
    }
}
