package org.mealtracker.repository;

import org.mealtracker.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day, Integer> {

}
