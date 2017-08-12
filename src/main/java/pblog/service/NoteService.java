package pblog.service;

import java.util.List;
import java.util.Map;

import pblog.entity.Note;
import pblog.entity.Visitor;

public interface NoteService {
	public String addNote(String content, int visitorId, int receiveId,Integer receiveNoteId);

	public String deleteNote(int noteId);

	public Note getNoteById(int noteId);
	
	public List<Note> getAllNote();

	public Map<Integer,Visitor> getVisitorMapByNoteList(List<Note> noteList);
}
