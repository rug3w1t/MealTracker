package org.mealtracker.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mealtracker.model.Note;
import org.mealtracker.model.User;
import org.mealtracker.model.dto.NoteDto;
import org.mealtracker.repository.NoteRepository;
import org.mealtracker.service.user.UserService;
import org.mealtracker.utils.NoteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl  implements  NoteService{

    private static Logger LOG = LogManager.getLogger(NoteServiceImpl.class);

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserService userService;


    @Override
    public boolean save(NoteDto noteDto) {

        // format to DAO
        Note note = null;
        try {
            note = NoteConverter.convertFromDTO(noteDto);
        } catch (NoteConverter.EssentialFieldMissing essentialFieldMissing) {
            essentialFieldMissing.printStackTrace();
            return false;
        }

        // assign user to DAO
        User user = userService.getOne(1L);
        if (user !=null){
            note.setUser(userService.getOne(1L));
        }else {
            LOG.error("User wasn't found ");
        }
        // assign present date to DAO
        note.setDate(LocalDate.now());
        // assgin presetn time to DAO
        note.setTime(LocalTime.now());

        LOG.info("Saving note " + note.toString());


        noteRepository.save(note);
        return true;
    }

    @Override
    public List<Note> findAll() {

        return noteRepository.findAll();
    }

    @Override
    public NoteDto findOneById(Long id) {
        Note note = noteRepository.findOneById(id);
        if (note == null){
            throw new NoSuchElementException();
        }

        NoteDto noteDto = null;
        try {
            noteDto = NoteConverter.convertFromDao(note);
        } catch (NoteConverter.EssentialFieldMissing essentialFieldMissing) {
            essentialFieldMissing.getMessage();
        }

        return noteDto;
    }

    @Override
    public List<NoteDto> findAllForUser(Long userId) {

        List<Note> notes = noteRepository.findAllForUserId(userId);
        List<NoteDto> notesDtoList= new ArrayList<>();
        notes.forEach(note -> {
            NoteDto noteDto = null;
            //BeanUtils.copyProperties(note, noteDto);
            try {
                  noteDto = NoteConverter.convertFromDao(note);
            } catch (NoteConverter.EssentialFieldMissing essentialFieldMissing) {
                essentialFieldMissing.getMessage();
            }

            if(noteDto != null ){
                notesDtoList.add(noteDto);
            }

        });
        return notesDtoList;
    }

    @Override
    public Map<String, List<NoteDto>> findAllForUserAndGroupByDates(Long userId) {

        List<NoteDto> allNotesForUser = findAllForUser(userId);

        Map<String, List<NoteDto>> notesGroupedByDate = allNotesForUser.stream()
                .collect(Collectors.groupingBy(NoteDto::getDate, Collectors.toList()));

        return  notesGroupedByDate;

    }




}
