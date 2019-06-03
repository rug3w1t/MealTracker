package org.mealtracker.service;

import org.mealtracker.model.Note;
import org.mealtracker.model.dto.NoteDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface NoteService {

    void save(Note note);
    List<Note> findAll();
    NoteDto findOneById(Long id);
    List<NoteDto> findAllForUser(Long userId);

    Map<String, List<NoteDto>> findAllForUserAndGroupByDates(Long userId);
}
