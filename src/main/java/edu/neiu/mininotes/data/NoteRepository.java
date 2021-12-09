package edu.neiu.mininotes.data;

import edu.neiu.mininotes.models.Note;
import edu.neiu.mininotes.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> findAllByUser(User user);
    
}
