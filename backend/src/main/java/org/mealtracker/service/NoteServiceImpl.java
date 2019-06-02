package org.mealtracker.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mealtracker.model.Note;
import org.mealtracker.model.User;
import org.mealtracker.repository.NoteRepository;
import org.mealtracker.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl  implements  NoteService{

    private static Logger LOG = LogManager.getLogger(NoteServiceImpl.class);

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserService userService;


    @Override
    public void save(Note note) {
        note.setDate(LocalDate.now());
        note.setTime(LocalTime.now());

        User user = userService.getOne(1L);
        if (user !=null){
            note.setUser(userService.getOne(1L));
        }else {
            LOG.error("User wasn't found ");
        }

        LOG.info("Saving note " + note);

        noteRepository.save(note);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public List<Note> findAllForUser(Long userId) {
        return noteRepository.findAllForUserId(userId);
    }

    @Override
    public Map<LocalDate, List<Note>> findAllForUserAndGroupByDates(Long userId) {

        List<Note> allNotesForUser = findAllForUser(userId);
        Map<LocalDate, List<Note>> notesGroupedByDate = allNotesForUser.stream()
                .collect(Collectors.groupingBy(Note::getDate, Collectors.toList()));



        return  notesGroupedByDate;

    }


}
