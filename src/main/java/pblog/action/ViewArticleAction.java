package pblog.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import pblog.entity.Article;
import pblog.entity.BlogClass;
import pblog.service.ArticleService;
import pblog.service.SearchService;
import pblog.util.HtmlParser;

/**
 * 获得博文列表的action
 * @author Caonuan
 *
 */
@Controller
@Scope("prototype")
public class ViewArticleAction extends ActionSupport {

	private static final long serialVersionUID = 6431374288194075322L;
	private int pageNow;
	private int pageCount;
	private List<Article> articleList;
	private ArticleService articleService;
	private SearchService searchService;
	private List<BlogClass> blogClassList;
	private String keyWord;
	private int blogClassId;
	private List<Object[]> timeList;
	private String time;

	@Override
	public String execute() throws Exception {
		pageCount = articleService.getPageCount(10);
		articleList=articleService.getTopPostedArticle();
		articleList.addAll( articleService.getSomeArticle(pageNow,10,-1));
		for (Article article : articleList) {
			String replaceContent = HtmlParser.getPTagContent(article.getContent());
			article.setContent(replaceContent);
		}
		blogClassList = articleService.getAllBlogClass();
		timeList = articleService.getAllMonthsWhichHaveArticle();
		return super.execute();
	}

	public String searchArticle() {
		pageCount = searchService.getArticleCountByKeyWord(keyWord);
		articleList = searchService.getArticleByKeyWord(keyWord, pageNow);
		for (Article article : articleList) {
			String replaceContent = HtmlParser.getPTagContent(article.getContent());
			article.setContent(replaceContent);
		}
		blogClassList = articleService.getAllBlogClass();
		timeList = articleService.getAllMonthsWhichHaveArticle();
		return SUCCESS;
	}

	public String viewArticleByBlogClass() {
		pageCount = articleService.getPageCountForClass(blogClassId);
		articleList = articleService.getAritleByClassAndPage(blogClassId, pageNow);
		for (Article article : articleList) {
			String replaceContent = HtmlParser.getPTagContent(article.getContent());
			article.setContent(replaceContent);
		}
		blogClassList = articleService.getAllBlogClass();
		timeList = articleService.getAllMonthsWhichHaveArticle();
		return SUCCESS;
	}

	public String viewArticleByTime() {
		articleList = articleService.getArticlesByTime(time);
		for (Article article : articleList) {
			String replaceContent = HtmlParser.getPTagContent(article.getContent());
			article.setContent(replaceContent);
		}
		blogClassList = articleService.getAllBlogClass();
		timeList = articleService.getAllMonthsWhichHaveArticle();
		return SUCCESS;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	@Resource
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public List<BlogClass> getBlogClassList() {
		return blogClassList;
	}

	public void setBlogClassList(List<BlogClass> blogClassList) {
		this.blogClassList = blogClassList;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public SearchService getSearchService() {
		return searchService;
	}

	@Resource
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	public int getBlogClassId() {
		return blogClassId;
	}

	public void setBlogClassId(int blogClassId) {
		this.blogClassId = blogClassId;
	}

	public List<Object[]> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<Object[]> timeList) {
		this.timeList = timeList;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
