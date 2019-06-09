package org.mealtracker.utils;

import org.mealtracker.model.Note;
import org.mealtracker.model.dto.NoteDto;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class NoteConverter {


    public static  Note convertFromDTO(NoteDto noteDto)  throws EssentialFieldMissing{

        Note note = new Note();

        String type = noteDto.getMealType();
        if (! StringUtils.isEmpty(type) ){
            note.setMealType(type);
        }

        String description = noteDto.getDescription();

        if ( ! StringUtils.isEmpty(description)){
            note.setDescription(description);
        }else {
            throw  new EssentialFieldMissing("Description cannot be null or empty");
        }

        return note;
    }



    public static NoteDto convertFromDao(Note note) throws EssentialFieldMissing {

        String [] noteFields = getFormatedNoteFields(note);
        NoteDto noteDto = new NoteDto(noteFields[0], noteFields[1],noteFields[2],noteFields[3],noteFields[4]);
        return noteDto;

    }

    private static String[] getFormatedNoteFields(Note note) throws EssentialFieldMissing {
        Long id = note.getId();
        String mealType = note.getMealType();
        LocalTime time = note.getTime();
        String description = note.getDescription();
        LocalDate date = note.getDate();

        if (id == null || date == null || mealType == null){
            throw  new EssentialFieldMissing("One or more of required field is missing : id=" + id + " date="+date+" mealType"+mealType);
        }
        String idValue = note.getId().toString();
        String stringTime="";
        if (time != null){
            stringTime = time.format(DateTimeFormatter.ofPattern("HH:mm"));

        }

        String stringDate = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));

        return new String[] {idValue, mealType, stringTime, description, stringDate};

    }


    /**
     * For now it only works when field types of both objects are same;
     * @param notes
     * @return
     */
    public static List<NoteDto> convertEntityToDto(List<Note> notes){

        List<NoteDto> noteDtos = new ArrayList<>();

        notes.forEach(note -> {
            NoteDto noteDto = new NoteDto();
            BeanUtils.copyProperties(note, noteDto);
            noteDtos.add(noteDto);
        });
        return noteDtos;
    }

    public static class EssentialFieldMissing extends Exception {
        public EssentialFieldMissing(String errorMessage) {
            super(errorMessage);
        }
    }

}
