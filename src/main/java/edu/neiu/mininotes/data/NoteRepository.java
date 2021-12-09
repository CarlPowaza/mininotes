package edu.neiu.mininotes.data;

import edu.neiu.mininotes.models.Note;
import edu.neiu.mininotes.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> findAllByUser(User user);


}
