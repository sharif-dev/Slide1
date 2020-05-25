package com.example.slide1;

import javax.xml.transform.Source;

public class Movie
{
    static class Builder
    {
        String title;
        Builder withTitle(String title)
        {
            this.title = title;
            return this;
        }
        Movie build()
        {
            return new Movie(title);
        }
    }

    private Movie(String title)
    {
        System.out.println("Done!");
    }
}
