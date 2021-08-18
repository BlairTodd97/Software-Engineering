package souschef.app.base.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import souschef.app.base.UserRepository;
import souschef.app.base.dtos.Note;
import souschef.app.base.dtos.UserDTO;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/data/notes")
public class NoteController {

    private UserRepository userRepository;

    public NoteController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/{token}")
    ResponseEntity<?> userNotes(@PathVariable String token) {
        Optional<UserDTO> user = userRepository.findUserByToken(token);
        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get().getNotes());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{token}/{search}")
    ResponseEntity<?> getNote(@PathVariable String token, @PathVariable String search) {
        Optional<UserDTO> user = userRepository.findUserByToken(token);
        if (user.isPresent()) {
            Set<Note> usersNotes = user.get().getNotes();
            List<Note> matchedNotes = new ArrayList<>();
            boolean foundNotes = false;
            for (Note note : usersNotes) {
                if (note.getNoteContent().contains(search) || note.getTitle().contains(search)) {
                    matchedNotes.add(note);
                    foundNotes = true;
                }
            }
            if (foundNotes) {
                return ResponseEntity.ok(matchedNotes);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{token}")
    ResponseEntity<?> createNote(@PathVariable String token, @Validated @RequestBody Note note) {
        Optional<UserDTO> user = userRepository.findUserByToken(token);
        if(user.isPresent()){
            UserDTO foundUser = user.get();
            Note newNote = new Note(note.getTitle(), note.getNoteContent());
            foundUser.getNotes().add(newNote);
            log.info("Request to create note: {}", newNote);
            userRepository.save(foundUser);
            return ResponseEntity.ok().body(newNote);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{token}/{title}")
    ResponseEntity<?> updateNote(@PathVariable String token, @PathVariable String title, @Validated @RequestBody Note note){
        log.info("Request to update note: {}", note);
        Optional<UserDTO> user = userRepository.findUserByToken(token);
        if(user.isPresent()){
            UserDTO foundUser = user.get();
            for(Note replaceNote: foundUser.getNotes()){
                if(replaceNote.getTitle().equals(title)){
                    foundUser.getNotes().remove(replaceNote);
                    Note newNote = new Note(note.getTitle(), note.getNoteContent());
                    foundUser.getNotes().add(newNote);
                    userRepository.save(foundUser);
                    return ResponseEntity.ok().body(newNote);
                } else {
                    return ResponseEntity.notFound().build();
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{token}")
    public ResponseEntity<?> deleteNote(@PathVariable String token, @Validated @RequestBody Note note){
        log.info("Request to delete note: {}", note);
        Optional<UserDTO> user = userRepository.findUserByToken(token);
        String search = note.getTitle();
        if(user.isPresent()){
            UserDTO foundUser = user.get();
            for(Note deleteNote: foundUser.getNotes()){
                if(deleteNote.getTitle().equals(search)){
                    foundUser.getNotes().remove(deleteNote);
                    userRepository.save(foundUser);
                    return ResponseEntity.ok().build();
                } else {
                    return ResponseEntity.notFound().build();
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
