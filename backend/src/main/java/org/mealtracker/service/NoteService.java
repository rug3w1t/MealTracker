package org.mealtracker.service;

import org.mealtracker.model.Note;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface NoteService {

    void save(Note note);
    List<Note> findAll();
    List<Note> findAllForUser(Long userId);

    Map<LocalDate, List<Note>> findAllForUserAndGroupByDates(Long userId);
}
