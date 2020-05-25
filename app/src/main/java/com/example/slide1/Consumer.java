package com.example.slide1;

import android.util.Log;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable
{
    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            Log.i(MainActivity.TAG, "Consumer ]] >> " + queue.take());
            Log.i(MainActivity.TAG, "Consumer ]] >> " + queue.take());
            Log.i(MainActivity.TAG, "Consumer ]] >> " + queue.take());
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }
}
