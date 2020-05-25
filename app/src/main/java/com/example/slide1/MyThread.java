package com.example.slide1;

import android.util.Log;

public class MyThread extends Thread
{
    public void run()
    {
        Log.i(MainActivity.TAG, "MyThread ]]>>" +
                " pid: " + android.os.Process.myPid()+
                " tid: " + android.os.Process.myTid()+
                " id: " + Thread.currentThread().getId());
    }
}
