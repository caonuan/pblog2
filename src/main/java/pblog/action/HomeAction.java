package pblog.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import pblog.entity.Album;
import pblog.entity.Article;
import pblog.entity.BlogClass;
import pblog.entity.Note;
import pblog.entity.Photo;
import pblog.entity.Visitor;
import pblog.service.ArticleService;
import pblog.service.NoteService;
import pblog.service.PhotoService;
import pblog.service.VisitorService;

@Controller
@Scope("prototype")
public class HomeAction extends BasicAction implements ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8288463644204570321L;

	private List<Article> articleList; // 里面存储的是5个最新的博客
	private List<Photo> photoList; // 里面存储的是5个最新的图片
	private List<Album> albumlist;
	private List<Note> noteList;
	private Map<Integer, BlogClass> blogClassMap;
	private Map<Integer, List<Photo>> photoMap;
	private Map<Integer, Visitor> visitorMap;
	private PhotoService photoService;
	private ArticleService articlService;
	private NoteService noteService;
	private VisitorService visitorService;
	private HttpSession session;
	private Visitor visitor;

	@Override
	public String execute() throws Exception {
		photoList = photoService.getTopFivePhoto();
		albumlist = photoService.getAllAlbum();
		articleList = articlService.getSomeArticle(1,5,-1);
		List<BlogClass> blogClassList = articlService.getAllBlogClass();
		blogClassMap=new HashMap<>();
		for (BlogClass blogClass : blogClassList) {
			blogClassMap.put(blogClass.getBlogClassId(), blogClass);
		}
		for (Article article : articleList) {
			// 由于ckeditor自动保存的路径是绝对路径，这样项目名就被绝对路径去掉了，导致读不出图片，故去掉最前面的"/"
			article.setContent(article.getContent().replaceAll("src=\"/", "src=\""));
		}
		photoMap = new HashMap<>();
		for (Album album : albumlist) {
			List<Photo> list = photoService.getTopThreePhoto(album.getAlbumId());
			photoMap.put(album.getAlbumId(), list);
		}
		noteList = noteService.getAllNote();
		visitorMap = noteService.getVisitorMapByNoteList(noteList);
		visitor = (Visitor) session.getAttribute("visitor");
		return super.execute();
	}

	public ArticleService getArticlService() {
		return articlService;
	}

	@Resource
	public void setArticlService(ArticleService articlService) {
		this.articlService = articlService;
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

	public VisitorService getVisitorService() {
		return visitorService;
	}

	@Resource
	public void setVisitorService(VisitorService visitorService) {
		this.visitorService = visitorService;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public List<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}

	public List<Album> getAlbumlist() {
		return albumlist;
	}

	public void setAlbumlist(List<Album> albumlist) {
		this.albumlist = albumlist;
	}

	public Map<Integer, List<Photo>> getPhotoMap() {
		return photoMap;
	}

	public void setPhotoMap(Map<Integer, List<Photo>> photoMap) {
		this.photoMap = photoMap;
	}

	public List<Note> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<Note> noteList) {
		this.noteList = noteList;
	}

	public Map<Integer, Visitor> getVisitorMap() {
		return visitorMap;
	}

	public void setVisitorMap(Map<Integer, Visitor> visitorMap) {
		this.visitorMap = visitorMap;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public Map<Integer, BlogClass> getBlogClassMap() {
		return blogClassMap;
	}

	public void setBlogClassMap(Map<Integer, BlogClass> blogClassMap) {
		this.blogClassMap = blogClassMap;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		session = request.getSession();
	}
}
