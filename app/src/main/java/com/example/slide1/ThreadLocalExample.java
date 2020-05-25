package com.example.slide1;

import android.content.Intent;

public class ThreadLocalExample
{
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    void doWork()
    {
        threadLocal.set((int) (Math.random() * 100D));
        try
        {
            Thread.sleep(2000);
        }
        catch ( InterruptedException e )
        {

        }
    }

    Integer getValue()
    {
        return threadLocal.get();
    }
}
