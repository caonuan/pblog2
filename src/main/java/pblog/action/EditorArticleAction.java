package pblog.action;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pblog.entity.Article;
import pblog.entity.BlogClass;
import pblog.service.ArticleService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Scope("prototype")
public class EditorArticleAction extends BasicAction
		implements ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2164549164330789130L;
	private HttpServletRequest request;
	private ArticleService articleService;
	private int articleId;
	private String title;
	private int thisBlogClassId;
	private String content;
	private List<BlogClass> classList;
	private int topPost;
	private int hidden;

	public String updateArticle() throws Exception {
		articleId = Integer.parseInt(request.getParameter("articleId"));
		Article article = articleService.getOneArticle(articleId);
		title = article.getTitle();
		thisBlogClassId = article.getBlogClassId();
		content = article.getContent();
		// 由于ckeditor自动保存的路径是绝对路径，这样项目名就被绝对路径去掉了，导致读不出图片，故去掉最前面的"/"
		content = content.replaceAll("src=\"/", "src=\"");
		// System.out.println(content);
		classList = articleService.getAllBlogClass();
		topPost = article.getTopPost();
		hidden = article.getHidden();
		return super.execute();
	}

	public String createArticle() throws Exception {
		classList = articleService.getAllBlogClass();
		return super.execute();
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	@Resource
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getThisBlogClassId() {
		return thisBlogClassId;
	}

	public void setThisBlogClassId(int thisBlogClassId) {
		this.thisBlogClassId = thisBlogClassId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<BlogClass> getClassList() {
		return classList;
	}

	public void setClassList(List<BlogClass> classList) {
		this.classList = classList;
	}

	public int getTopPost() {
		return topPost;
	}

	public void setTopPost(int topPost) {
		this.topPost = topPost;
	}

	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}

}
