package pblog.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pblog.entity.Article;
import pblog.entity.BlogClass;
import pblog.service.ArticleService;
import pblog.service.SearchService;
import pblog.util.HtmlParser;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 获得博文列表的action
 * @author Caonuan
 *
 */
@Controller
@Scope("prototype")
public class ViewArticleAction extends BasicAction{

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
	//当前访问的路径与参数。用于翻页链接用
	private String url;
	private String params;

	@Override
	public String execute() throws Exception {
		//获取当前访问的url路径，并去掉前面的/(jsp界面中basepath有'/')
		url=ServletActionContext.getRequest().getRequestURI();
		url=url.substring(1);
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
		//获取当前访问的url路径，并去掉前面的/(jsp界面中basepath有'/')
		url=ServletActionContext.getRequest().getRequestURI();
		url=url.substring(1);
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
		//获取当前访问的url路径，并去掉前面的/(jsp界面中basepath有'/')
		HttpServletRequest request= ServletActionContext.getRequest();
		url=request.getRequestURI();
		params="&blogClassId="+blogClassId;
		url=url.substring(1);
		boolean ifShowHidden=false;
		if(ServletActionContext.getRequest().getSession().getAttribute("manager")!=null)
			ifShowHidden=true;
		pageCount = articleService.getPageCountForClass(blogClassId,ifShowHidden);
		articleList = articleService.getAritleByClassAndPage(blogClassId, pageNow,ifShowHidden);
		for (Article article : articleList) {
			String replaceContent = HtmlParser.getPTagContent(article.getContent());
			article.setContent(replaceContent);
		}
		blogClassList = articleService.getAllBlogClass();
		timeList = articleService.getAllMonthsWhichHaveArticle();
		return SUCCESS;
	}

	public String viewArticleByTime() {
		//获取当前访问的url路径，并去掉前面的/(jsp界面中basepath有'/')
		url=ServletActionContext.getRequest().getRequestURI();
		url=url.substring(1);
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}
