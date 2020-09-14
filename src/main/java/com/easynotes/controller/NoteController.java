package com.easynotes.controller;

import com.easynotes.model.Note;
import com.easynotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteService noteService;

    // Create Multiple Notes
    @PostMapping("/notes")
    public List<Note> postNotes(@Valid @RequestBody List<Note> noteList) {
        return noteService.saveNotes(noteList);
    }

    // Create a Note
    @PostMapping("/note")
    public Note postNote (@Valid @RequestBody Note note) {
        return noteService.saveNote(note);
    }

    // Get All Notes
    @GetMapping("/notes")
    public List<Note> getNotes() {
        return noteService.findNotes();
    }

    // Get a Note
    @GetMapping("/note/{id}")
    public Note getNote (@PathVariable(value = "id") Long id) {
        return noteService.findNote(id);
    }

    @PutMapping("/notes/{id}")
    public Note putNote(@PathVariable(value = "id") Long id, @Valid @RequestBody Note noteDetails) {
        return noteService.updateNote(id, noteDetails);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote (@PathVariable(value = "id") @RequestBody Long id) {
        return noteService.removeNote(id);
    }



}
