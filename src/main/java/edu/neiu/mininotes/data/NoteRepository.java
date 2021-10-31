package edu.neiu.mininotes.data;

import edu.neiu.mininotes.models.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {

    
}
