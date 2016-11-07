package com.example.irek.zadanie_rekrutacyjne;

/**
 * Created by Irek on 2016-11-03.
 */

public interface ITaskList {
    public void incrementElement(int id);

    public void resetElement(int id);

    public void deleteElement(int id);

    public void addPreviousValueToElement(int id, int previousId);

}
