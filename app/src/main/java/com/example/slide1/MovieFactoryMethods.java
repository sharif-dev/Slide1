package com.example.slide1;

public class MovieFactoryMethods
{
    private String title;
    public static MovieFactoryMethods create(String title)
    {
        MovieFactoryMethods movie = new MovieFactoryMethods();
        movie.title = title;
        return movie;
    }
}
