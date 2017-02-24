package pblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pblog.dao.ArticleDAO;
import pblog.entity.Album;
import pblog.entity.Article;
import pblog.service.SearchService;
@Service("searchService")
public class SearchServiceImpl implements SearchService {

	@Autowired
	private ArticleDAO articleDAO;
	
	@Override
	public List<Article> getArticleByKeyWord(String keyWord,int pageNow) {
		return articleDAO.getArticleByKeyWord(keyWord,pageNow);
	}
	
	@Override
	public int getArticleCountByKeyWord(String keyWord) {
		return articleDAO.getArticleCountByKeyWord(keyWord);
	}

	@Override
	public List<Album> getPhotoByKeyWord(String keyWord) {
		return null;
	}

}
