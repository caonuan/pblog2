package pblog.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pblog.dao.NoteDAO;
import pblog.entity.Note;
import pblog.service.NoteService;

@Service("noteService")
public  class NoteServiceImpl implements NoteService{
	private NoteDAO noteDAO;

	public NoteDAO getNoteDAO() {
		return noteDAO;
	}
	@Resource
	public void setNoteDAO(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}


	@Override
	public String addNote(String content, int visitorId, int receiveId) {
		Note note = new Note();
		note.setContent(content);
		note.setVisitorId(visitorId);
		note.setReceiveId(receiveId);
		note.setPublishDate(new Date());
		if (noteDAO.addNote(note) == true) {
			return "success";
		}
		return "error";
	}


	@Override
	public String deleteNote(int noteId) {
		if (noteDAO.deleteNote(noteId) == true) {
			return "success";
		}
		return "error";
	}

	@Override
	public Note getNoteById(int noteId) {
		return noteDAO.getNoteById(noteId);	
	}
	@Override
	public List<Note> getAllNote() {
		return noteDAO.getAllNote();
	}
	

}
