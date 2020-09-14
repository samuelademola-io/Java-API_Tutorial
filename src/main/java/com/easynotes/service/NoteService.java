package com.easynotes.service;

import com.easynotes.repository.NoteRepository;
import com.easynotes.exception.ResourceNotFoundException;
import com.easynotes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    // To Save a Note
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    // To Save Multiple Notes
    public List<Note> saveNotes(List<Note> noteList) {
        return noteRepository.saveAll(noteList);
    }

    // Get Note by ID
    public Note findNote (Long id) { return noteRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Note", "id", id));
    }

    // Get All Notes
    public List<Note> findNotes() {
        return noteRepository.findAll();
    }

    // Update Note by Id
    public Note updateNote(Long id, Note noteDetails ) {
        Note note = noteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Note", "id", id));
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note changedNote = noteRepository.save(note);
        return changedNote;
    }

    public ResponseEntity<?> removeNote(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Note", "id", id));
        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }
}
