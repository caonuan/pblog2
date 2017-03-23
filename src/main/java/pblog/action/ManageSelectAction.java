package pblog.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import pblog.entity.Album;
import pblog.entity.Article;
import pblog.entity.Note;
import pblog.entity.Photo;
import pblog.service.ArticleService;
import pblog.service.NoteService;
import pblog.service.PhotoService;
@Controller
@Scope("prototype")
public class ManageSelectAction extends ActionSupport implements ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4158064986601878006L;
	private HttpServletRequest request;
	private ArticleService articleService;
	private PhotoService photoService;
	private NoteService noteService;
	private List<Article> articleList;
	private List<Album> albumList;
	private List<Note> noteList;
	private int page;
	private int pageCount;

	public String manageArticle() {
		page = Integer.parseInt(request.getParameter("page"));
		pageCount = articleService.managerGetPageCount(10);
		//pageCount = pageCount % 2 == 0 ? pageCount / 2 : (pageCount / 2 + 1);
		articleList = articleService.managerGetSomeArticle(page,10,-1);
		return SUCCESS;
	}

	public String manageAlbum() {
		albumList = photoService.getAllAlbum();
		for (Album album : albumList) {
			if (album.getAlbumUrl() == null || album.getAlbumUrl().equals("")) {
				Photo selectphoto = photoService.getTopPhotoForAlbum(album.getAlbumId());
				album.setAlbumUrl(selectphoto == null ? null : selectphoto.getUrl().substring(0, selectphoto.getUrl().lastIndexOf('.'))
						+ "_t"
						+ selectphoto.getUrl().substring(
								selectphoto.getUrl().lastIndexOf('.'), selectphoto.getUrl()
										.length()));
			}
		}
		return SUCCESS;
	}

	public String manageNote() {
		noteList = noteService.getAllNote();
		return SUCCESS;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	@Resource
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public PhotoService getPhotoService() {
		return photoService;
	}

	@Resource
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

	public NoteService getNoteService() {
		return noteService;
	}

	@Resource
	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}

	public List<Note> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<Note> noteList) {
		this.noteList = noteList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

}
