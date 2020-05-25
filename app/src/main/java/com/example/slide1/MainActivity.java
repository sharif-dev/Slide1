package com.example.slide1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

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
    }
}
