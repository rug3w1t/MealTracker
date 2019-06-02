package org.mealtracker.repository;

import org.mealtracker.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query(value = "SELECT * FROM notes n WHERE n.user_id=?1", nativeQuery = true)
    List<Note> findAllForUserId(Long id);
}
