package org.mealtracker.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mealtracker.model.Note;
import org.mealtracker.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class NoteServiceImpl  implements  NoteService{

    private static Logger LOG = LogManager.getLogger(NoteServiceImpl.class);

    @Autowired
    NoteRepository noteRepository;

    @Override
    public void save(Note note) {
        note.setDate(LocalDate.now());
        note.setTime(LocalTime.now());
        note.setUserId(1l);

        LOG.info("Saving note " + note);

        noteRepository.save(note);
    }
}
