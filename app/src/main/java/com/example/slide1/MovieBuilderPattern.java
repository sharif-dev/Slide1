package com.example.slide1;

public class MovieBuilderPattern
{
    private String title;
    static class Builder
    {
        String title;
        Builder withTitle(String title)
        {
            this.title = title;
            return this;
        }
        MovieBuilderPattern build()
        {
            MovieBuilderPattern movie = new MovieBuilderPattern();
            movie.title = this.title;
            return movie;
        }
    }

    private MovieBuilderPattern()
    {

    }
}
