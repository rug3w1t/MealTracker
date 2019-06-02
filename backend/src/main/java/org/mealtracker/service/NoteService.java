package org.mealtracker.service;

import org.mealtracker.model.Note;

import java.util.List;

public interface NoteService {

    void save(Note note);
    List<Note> findAll();
}
