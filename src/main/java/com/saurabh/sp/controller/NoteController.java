package com.saurabh.sp.controller;

import org.springframework.web.bind.annotation.*;

import com.saurabh.sp.repo.NoteRepository;
import com.saurabh.sp.security.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import com.saurabh.sp.model.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class NoteController {
    
	@Autowired
	private NoteRepository noteRepository;
	
	/* ================ TO GET LIST OF ALL NOTES ========================== */
	@GetMapping("/notes")
	private ResponseEntity<List<NoteDTO>> getAllNotes(){
		 List<NoteDtls> notes = noteRepository.findAll();
		    List<NoteDTO> dtos = convertToDTOList(notes);

		    return ResponseEntity.ok(dtos);
	}
	
    private List<NoteDTO> convertToDTOList(List<NoteDtls> notes) {
        return notes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
 
    /* ================== CONVERTING NOTEDTLS TO NOTEDTO ======================= */
    private NoteDTO convertToDTO(NoteDtls note) {
        NoteDTO dto = new NoteDTO();
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());

        return dto;
    }
	
    /* ==================== TO SAVE A NEW NOTE ==================== */
	@PostMapping("/notes")
	private ResponseEntity<String> createNotes(@RequestBody NoteDtls noteDtls){
		 NoteDtls note = new NoteDtls();
		 
		 note.setTitle(noteDtls.getTitle());
		 note.setContent(noteDtls.getContent());
		 
		 noteRepository.save(note);
		 
		 return ResponseEntity.ok("Notes saved Successfully");
	}
	
	/* ======================== GETTING THE PARTICULAR NOTE THROUGH ID ================= */
	@GetMapping("/notes/{id}")
	private ResponseEntity<NoteDTO> getNoteById(@PathVariable int id){
		NoteDtls note = noteRepository.getById(id);
		NoteDTO dto = convertToDTO(note);
		
		return ResponseEntity.ok(dto);
	}
	
	/* ====================== UPDATING THE EXISTING NOTE ======================== */
	@PutMapping("/notes/{id}")
	private ResponseEntity<NoteDTO> updateNote(@PathVariable int id, @RequestBody NoteDtls noteDtls){
		  NoteDtls note = noteRepository.getById(id);
		  
		  if(noteDtls.getTitle() != null) {
			  note.setTitle(noteDtls.getTitle());
		  }
		  
		  if(noteDtls.getContent() != null) {
			  note.setContent(noteDtls.getContent());
		  }
		  
		  noteRepository.save(note);
		  
		  NoteDTO dto = convertToDTO(note);
		  
		  return ResponseEntity.ok(dto);
	}
	
	/* ============================ DELETING A PARTICULAR NOTE =========================== */
	@DeleteMapping("/notes/{id}")
	private ResponseEntity<String> deleteNote(@PathVariable int id){
		 noteRepository.deleteById(id);
		 
		 return ResponseEntity.ok("Notes deleted successfully");
	}
	
	/* =============== SEARCHING A NOTES BASED ON THE GIVEN WORDS ==================== */
	@GetMapping("/search/{query}")
	private ResponseEntity<List<NoteDTO>> search(@PathVariable String query){
		 
		List<NoteDtls> notes = noteRepository.searchNotes(query);
		
	    List<NoteDTO> dtos = convertToDTOList(notes);

	    return ResponseEntity.ok(dtos);		
	}
	
	
	/* ======================== SHARING OF NOTE ========================= */
	@PostMapping("/notes/{id}")
	private ResponseEntity<String> share(@PathVariable int id) {
		NoteDtls note = noteRepository.getById(id);
		
		if(note.getTitle() != null) {
			note.setTitle(note.getTitle());
		}
		
		if(note.getContent() != null) {
			note.setContent(note.getContent());
		} 
		
		return ResponseEntity.ok("Notes Shared Successfully");
	}
}
