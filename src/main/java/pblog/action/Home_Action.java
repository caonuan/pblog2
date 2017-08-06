package pblog.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

import pblog.entity.Album;
import pblog.entity.Article;
import pblog.entity.Photo;
import pblog.service.ArticleService;
import pblog.service.PhotoService;


public class Home_Action extends BasicAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -633458106031765658L;

	private Album album;
	
	private List<Article> articleList; 	//里面存储的是3个最新的博客
	private List<Photo> photoList;		//里面存储的是5个最新的图片
	private List<Photo> phtList;		//里面存储的是一个相册中的所有图片
	private ArticleService articlService;
	private PhotoService photoService;
	private List<Album> albumlist;
	/**
	 * 用来获取最新的三篇博客
	 * @return
	 */
	public String show(){
		
		articleList=articlService.getSomeArticle(1,5,-1);
		photoList=photoService.getTopFivePhoto();
		phtList=photoService.getAlbumPhoto(2);
		albumlist=photoService.getAllAlbum();		
		return SUCCESS;
	}
	
	public String showAllInOne(){
		phtList=photoService.getAlbumPhoto(album.getAlbumId());
		return SUCCESS;
	}
	
	
	public ArticleService getAtrser() {
		return articlService;
	}
	@Resource
	public void setAtrser(ArticleService articleService) {
		this.articlService = articleService;
	}

	public PhotoService getPhotoService() {
		return photoService;
	}
	@Resource
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}
	
	public List<Photo> getPhotoList() {
		return photoList;
	}
	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public List<Photo> getPhtList() {
		return phtList;
	}

	public void setPhtList(List<Photo> phtList) {
		this.phtList = phtList;
	}

	public Album getAlbum() {
		return album;
	}
	@Resource
	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<Album> getAlbumlist() {
		return albumlist;
	}

	public void setAlbumlist(List<Album> albumlist) {
		this.albumlist = albumlist;
	}

}
