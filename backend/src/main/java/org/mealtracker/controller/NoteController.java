package org.mealtracker.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mealtracker.model.Note;
import org.mealtracker.model.dto.NoteDto;
import org.mealtracker.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {

    private static Logger LOG = LogManager.getLogger(NoteController.class);
    @Autowired
    private NoteService noteService;

    @PostMapping("/addNote")
    public String createNewNote(@ModelAttribute Note newNote){

        LOG.info("Adding new note id :: " + newNote.getId() );

        noteService.save(newNote);

        return "redirect:/";

    }

    @RequestMapping(value = "/updateNote/{noteId}", method = RequestMethod.GET)
    public String showForm( @PathVariable(value="noteId") Long noteId, Model model){

        NoteDto noteToUpdate = noteService.findOneById(noteId);
        LOG.info("noteToUpdae :: " + noteToUpdate);

        model.addAttribute("note time", noteToUpdate.getTime() );

        return "updateForm";
    }

}

