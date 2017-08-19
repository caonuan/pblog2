package pblog.service;

import pblog.entity.Album;
import pblog.entity.Article;

import java.util.List;

public interface SearchService {
	/**
	 * 关键字检索。暂不实现
	 * @param keyWord
	 */
	public List<Article> getArticleByKeyWord(String keyWord,int pageNow);
	
	public int getArticleCountByKeyWord(String keyWord);
	
	/**
	 * 关键字检索。暂不实现
	 * @param keyWord
	 */
	public List<Album> getPhotoByKeyWord(String keyWord);
}
