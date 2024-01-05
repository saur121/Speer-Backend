package com.saurabh.sp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saurabh.sp.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface NoteRepository extends JpaRepository<NoteDtls, Integer> {
      

    @Query(value = "SELECT * FROM Note_Dtls WHERE (title LIKE %:query% OR content LIKE %:query%)", nativeQuery = true)
    List<NoteDtls> searchNotes(@Param("query") String query);
	
}
