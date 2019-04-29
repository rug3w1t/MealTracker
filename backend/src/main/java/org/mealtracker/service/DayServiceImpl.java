package org.mealtracker.service;

import org.mealtracker.model.Day;
import org.mealtracker.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private DayRepository repository;

    @Override
    public void save(Day day) {
        repository.save(day);
    }
}
