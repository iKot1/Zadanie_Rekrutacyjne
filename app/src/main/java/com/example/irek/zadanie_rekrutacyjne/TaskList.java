package com.example.irek.zadanie_rekrutacyjne;


/**
 * Created by Irek on 2016-11-03.
 */

public class TaskList extends Data implements ITaskList {
    Data data = new Data();

    @Override
    public void incrementElement(int id) {
        List.get(id).incrementCounter();
    }

    @Override
    public void resetElement(int id) {
        List.get(id).resetCounter();
    }

    @Override
    public void deleteElement(int id) {
        data.deleteElement(id);
    }

//    @Override
//    public void addElement() {
//        data.addElement();
//    }

    @Override
    public void addPreviousValueToElement(int id) {
        int currentValue= Integer.valueOf(List.get(id).getCounter());
        List.get(id).setCounter(currentValue+lastValue);
    }
}
