package org.mealtracker.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mealtracker.model.Note;
import org.mealtracker.model.dto.NoteDto;
import org.mealtracker.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class NoteController {

    private static Logger LOG = LogManager.getLogger(NoteController.class);
    @Autowired
    private NoteService noteService;

    @PostMapping("/addNote")
    public ModelAndView createNewNote(@Valid NoteDto newNote, BindingResult bindingResult){

        LOG.info("Validating new NoteDTO object  ");
        ModelMap modelMap = new ModelMap();

        if (bindingResult.hasErrors()){
            LOG.warn("Form invalid : " + newNote.toString());
            modelMap.put("formHasErrors", true);
            return new ModelAndView("redirect:/", modelMap);
        }

        noteService.save(newNote);
        modelMap.put("formHasErrors", true);
        return new ModelAndView("redirect:/", modelMap);
    }

    @RequestMapping(value = "/updateNote/{noteId}", method = RequestMethod.GET)
    public String showForm( @PathVariable(value="noteId") Long noteId, Model model){

        NoteDto noteToUpdate = noteService.findOneById(noteId);
        LOG.info("noteToUpdate.time:: " + noteToUpdate.getTime());

        model.addAttribute("note", noteToUpdate );

        return "updateForm";
    }


}

