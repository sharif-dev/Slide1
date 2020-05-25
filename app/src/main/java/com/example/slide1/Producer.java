package com.example.slide1;

import android.util.Log;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable
{
    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            queue.put("1");
            Log.i(MainActivity.TAG, "Producer ]] >> 1");
            Thread.sleep(1000);
            queue.put("2");
            Log.i(MainActivity.TAG, "Producer ]] >> 2");
            Thread.sleep(1000);
            queue.put("3");
            Log.i(MainActivity.TAG, "Producer ]] >> 3");
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }
}
