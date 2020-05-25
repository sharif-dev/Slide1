package com.example.slide1;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

public class Waiter implements Runnable
{
    private Message message;
    final CountDownLatch latch;

    public Waiter(Message m, CountDownLatch latch)
    {
        this.message = m;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        String name = Thread.currentThread().getName();
        synchronized (message)
        {
            try
            {
                Log.i(MainActivity.TAG, "WaitNotifyTest.Waiter ]] >> time:"
                        + System.currentTimeMillis());
                message.wait();
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
            Log.i(MainActivity.TAG, "WaitNotifyTest.Waiter ]] >> name:"
                    + name + " processed: " + message.getMsg());
            this.latch.countDown();
        }
    }
}
