package com.example.slide1;

public class Counter
{
    protected long count = 0;
    public void doWork()
    {
        for( int i = 0; i < 100000; i++)
        {
            this.count = this.count + 1;
        }
    }
    public void safeDoWork()
    {
        synchronized (this)
        {
            for( int i = 0; i < 100000; i++)
            {
                this.count = this.count + 1;
            }
        }
    }
}
