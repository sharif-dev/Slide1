package com.example.slide1;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

public class Notifier implements Runnable
{
    private Message message;
    final CountDownLatch latch;

    public Notifier(Message m, CountDownLatch latch)
    {
        this.message = m;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        String name = Thread.currentThread().getName();
        Log.i(MainActivity.TAG, "WaitNotifyTest.Notifier ]] >> started");
        try
        {
            Thread.sleep(1000);
            synchronized (message)
            {
                message.setMsg(name + " Notifier work done");
                message.notifyAll();
            }
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        this.latch.countDown();
    }
}
