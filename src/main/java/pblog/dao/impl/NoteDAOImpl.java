package pblog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import pblog.dao.NoteDAO;
import pblog.entity.Note;

@Component("noteDAO")
public class NoteDAOImpl implements NoteDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean addNote(Note note) {
		hibernateTemplate.save(note);
		return true;
	}

	@Override
	public boolean deleteNote(int noteId) {
		Note note = hibernateTemplate.get(Note.class, noteId);
		hibernateTemplate.delete(note);
		return true;
	}

	@Override
	public List<Note> getAllNote() {
		List<Note> list = (List<Note>) hibernateTemplate.find("from pblog.entity.Note where receiveNoteId is null order by publishDate desc");
		return list;
	}

	@Override
	public Note getNoteById(int noteId) {
		Note note=hibernateTemplate.get(Note.class, noteId);
		return note;
	}

}
