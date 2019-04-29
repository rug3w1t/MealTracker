package org.mealtracker.service;

import org.mealtracker.model.Day;

import java.util.List;

public interface DayService {

    void save(Day day);
    List<Day> findAll();

}
