package pblog.service.impl;

import org.springframework.stereotype.Service;
import pblog.dao.NoteDAO;
import pblog.entity.Note;
import pblog.entity.Visitor;
import pblog.service.NoteService;
import pblog.service.VisitorService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("noteService")
public  class NoteServiceImpl implements NoteService{
	private NoteDAO noteDAO;
	private VisitorService visitorService;

	public NoteDAO getNoteDAO() {
		return noteDAO;
	}
	@Resource
	public void setNoteDAO(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}

	public VisitorService getVisitorService() {
		return visitorService;
	}
	@Resource
	public void setVisitorService(VisitorService visitorService) {
		this.visitorService = visitorService;
	}

	@Override
	public String addNote(String content, int visitorId, int receiveId,Integer receiveNoteId) {
		Note note = new Note();
		note.setContent(content);
		note.setVisitorId(visitorId);
		note.setReceiveId(receiveId);
		note.setPublishDate(new Date());
		note.setReceiveNoteId(receiveNoteId);
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

	@Override
	public Map<Integer, Visitor> getVisitorMapByNoteList(List<Note> noteList) {
		Map<Integer, Visitor> visitorMap=new HashMap<>();
		for (Note note : noteList) {
			Visitor visitor = null;
			if (!visitorMap.containsKey(note.getReceiveId())) {
				visitor = visitorService.getVisitorById(note.getReceiveId());
				visitorMap.put(note.getReceiveId(), visitor);
			}
			if (!visitorMap.containsKey(note.getVisitorId())) {
				visitor = visitorService.getVisitorById(note.getVisitorId());
				visitorMap.put(note.getVisitorId(), visitor);
			}
		}
		return visitorMap;
	}


}
