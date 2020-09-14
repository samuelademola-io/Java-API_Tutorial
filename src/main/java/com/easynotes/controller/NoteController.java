package com.easynotes.controller;

import com.easynotes.model.Note;
import com.easynotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    NoteService noteService;

    @PostMapping("/addNote")
    public Note addNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    public List<Note> addNotes(@RequestBody List<Note> noteList) {
        return noteService.saveNotes(noteList);
    }

    @GetMapping("/notes")
    public List<Note> findAllNote() {
        return noteService.getAllNotes();
    }



}
