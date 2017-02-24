package pblog.service;

import java.util.List;

import pblog.entity.Note;

public interface NoteService {
	public String addNote(String content, int visitorId, int receiveId);

	public String deleteNote(int noteId);

	public Note getNoteById(int noteId);
	
	public List<Note> getAllNote();
}
