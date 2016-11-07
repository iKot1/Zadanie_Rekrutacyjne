package com.example.irek.zadanie_rekrutacyjne;


/**
 * Created by Irek on 2016-11-03.
 */

public class TaskList extends Data implements ITaskList {

    @Override
    public void incrementElement(int id) {
        List.get( id ).incrementCounter();
    }

    @Override
    public void resetElement(int id) {
        List.get( id ).resetCounter();
    }

    @Override
    public void deleteElement(int id) {
        List.remove( id );
    }


    @Override
    public void addPreviousValueToElement(int id, int previousId) {
        if (previousId == -1) {
            lastValue = 0;
        } else {
            lastValue = Integer.valueOf( List.get( previousId ).getCounter() );
        }

        int currentValue = Integer.valueOf( List.get( id ).getCounter() );
        List.get( id ).setCounter( currentValue + lastValue );
    }
}
