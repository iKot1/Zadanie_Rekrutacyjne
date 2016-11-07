package com.example.irek.zadanie_rekrutacyjne;


import java.util.ArrayList;

/**
 * Created by Irek on 2016-11-03.
 */

public class Data{

    private Element element;
    protected ArrayList<Element> List = new ArrayList<Element>();
    protected int lastValue = 0;

    public void addElement() {
        element = new Element();
        List.add( element );
    }

    public int size() {
        return List.size();
    }

}
