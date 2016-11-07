package com.example.irek.zadanie_rekrutacyjne;



import java.util.Random;

/**
 * Created by Irek on 2016-11-03.
 */

public class Element {
    private String color;
    private int counter;

    public Element() {

        String randomColor;
        Random r = new Random();
        int a = r.nextInt( 2 );

        if (a % 2 == 0) {
            randomColor = "RED";
        } else {
            randomColor = "BLUE";
        }

        setColor( randomColor );
        setCounter( 0 );

    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCounter() {
        return String.valueOf( counter );
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void incrementCounter() {
        counter++;
    }

    public void resetCounter() {
        counter = 0;
    }

}
