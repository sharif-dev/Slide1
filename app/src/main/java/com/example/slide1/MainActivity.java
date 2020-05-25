package com.example.slide1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity
{
    protected static final String TAG = "prj1-thread";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Builder Pattern Example
        MovieBuilderPattern matrix = new MovieBuilderPattern.Builder().withTitle("The Matrix").build();
        MovieBuilderPattern venom = new MovieBuilderPattern.Builder().withTitle("The Venom").build();
        //Factory Methods Example
        MovieFactoryMethods daredevil = MovieFactoryMethods.create("Daredevil");
        MovieFactoryMethods inception = MovieFactoryMethods.create("Inception");
        //String Builder Example
        String[] list = new String[]{"A", "C", "D", "F"};
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for( String str : list)
        {
            sb.append(prefix);
            prefix = ",";
            sb.append(str);
        }
        System.out.println(sb);
        //Multithreading: Types Of Thread Implementation
        ThreadSubclass();
        ThreadRunnable();
        AnonymousRunnable();
        LambdaRunnable();
        //Multithreading: Race Condition
        RaceCondition();
        SynchronizedThread();
        //Multithreading: ThreadLocal
        ThreadLocalExampleMethod();
        //Multithreading: Wait, Notify & NotifyAll
        WaitNotifyTest();
    }

    void ThreadSubclass()
    {
        Log.i(TAG, "ThreadSubclass, Main Thread ]]>>" +
                " pid: " + android.os.Process.myPid()+
                " tid: " + android.os.Process.myTid()+
                " id: " + Thread.currentThread().getId());
        MyThread myThread = new MyThread();
        myThread.start();
        Log.i(TAG, "ThreadSubclass, Main Thread ]]>>" +
                " pid: " + android.os.Process.myPid()+
                " tid: " + android.os.Process.myTid()+
                " id: " + Thread.currentThread().getId());
    }

    void ThreadRunnable()
    {
        Log.i(TAG, "ThreadRunnable, Main Thread ]]>>" +
                " pid: " + android.os.Process.myPid()+
                " tid: " + android.os.Process.myTid()+
                " id: " + Thread.currentThread().getId());
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        Log.i(TAG, "ThreadRunnable, Main Thread ]]>>" +
                " pid: " + android.os.Process.myPid()+
                " tid: " + android.os.Process.myTid()+
                " id: " + Thread.currentThread().getId());
    }

    void AnonymousRunnable()
    {
        Log.i(TAG, "AnonymousRunnable, Main Thread ]]>>" +
                " pid: " + android.os.Process.myPid()+
                " tid: " + android.os.Process.myTid()+
                " id: " + Thread.currentThread().getId());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(MainActivity.TAG, "AnonymousRunnable ]]>>" +
                        " pid: " + android.os.Process.myPid()+
                        " tid: " + android.os.Process.myTid()+
                        " id: " + Thread.currentThread().getId());
            }
        });
        thread.start();
        Log.i(TAG, "AnonymousRunnable, Main Thread ]]>>" +
                " pid: " + android.os.Process.myPid()+
                " tid: " + android.os.Process.myTid()+
                " id: " + Thread.currentThread().getId());
    }

    void LambdaRunnable()
    {
        Log.i(TAG, "LambdaRunnable, Main Thread ]]>>" +
                " pid: " + android.os.Process.myPid()+
                " tid: " + android.os.Process.myTid()+
                " id: " + Thread.currentThread().getId());
        Runnable lambda = () -> Log.i(MainActivity.TAG, "LambdaRunnable ]]>>" +
                " pid: " + android.os.Process.myPid()+
                " tid: " + android.os.Process.myTid()+
                " id: " + Thread.currentThread().getId());
        Thread thread = new Thread(lambda);
        thread.start();
        Log.i(TAG, "LambdaRunnable, Main Thread ]]>>" +
                " pid: " + android.os.Process.myPid()+
                " tid: " + android.os.Process.myTid()+
                " id: " + Thread.currentThread().getId());
    }

    void RaceCondition()
    {
        Counter c = new Counter();
        Thread thread1 = new Thread(() -> c.doWork());
        Thread thread2 = new Thread(() -> c.doWork());
        thread1.start();
        thread2.start();
        Log.i(TAG, "RaceCondition ]] >> " + " count: " + c.count);
    }

    void SynchronizedThread()
    {
        Counter c = new Counter();
        Thread thread1 = new Thread(() -> c.safeDoWork());
        Thread thread2 = new Thread(() -> c.safeDoWork());
        thread1.start();
        thread2.start();
        try
        {
            thread1.join();
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        try
        {
            thread2.join();
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        Log.i(TAG, "SynchronizedThread ]] >> " + " count: " + c.count);
    }

    void ThreadLocalExampleMethod()
    {
        ThreadLocalExample sharedInstance = new ThreadLocalExample();
        Thread thread1 = new Thread(() -> sharedInstance.doWork());
        Thread thread2 = new Thread(() -> sharedInstance.doWork());
        thread1.start();
        thread2.start();
        try
        {
            thread1.join();
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        try
        {
            thread2.join();
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        Log.i(TAG, "ThreadLocalExampleMethod ]] >> " + sharedInstance.getValue());
    }

    void WaitNotifyTest()
    {
        final CountDownLatch latch = new CountDownLatch(2);

        Message message = new Message("process it");

        Waiter waiter1 = new Waiter(message, latch);
        new Thread(waiter1, "waiter1").start();

        Waiter waiter2 = new Waiter(message, latch);
        new Thread(waiter2, "waiter2").start();

        Notifier notifier = new Notifier(message, latch);
        new Thread(notifier, "notifier1").start();

        try
        {
            latch.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        Log.i(TAG, "WaitNotifyTest ]] >> end");
    }
}
