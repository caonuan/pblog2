package pblog.dao;

import java.util.List;

import pblog.entity.Note;

public interface NoteDAO {
	/**
	 * 添加留言
	 * @param note
	 * @return
	 */
	public boolean addNote(Note note);
	
	/**
	 * 删除留言
	 * @param noteId
	 * @return
	 */
	public boolean deleteNote(int noteId);
	
	/**
	 * 获取所有留言
	 * @return
	 */
	public List<Note> getAllNote();
	
	public Note getNoteById(int noteId);
}
