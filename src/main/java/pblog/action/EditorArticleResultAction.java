package pblog.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import pblog.service.ArticleService;

@Controller
@Scope("prototype")
public class EditorArticleResultAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9049129080220939892L;
	private int articleId;
	private String title;
	private int blogClassId;
	private String content;
	private int topPost;
	private int hidden;

	private ArticleService articleService;

	public String addArticle() throws Exception {
		String result = articleService.addArticle(title, blogClassId, content,
				topPost, hidden);
		return result;
	}

	public String editorArticle() throws Exception {
		String result = articleService.updateArticle(articleId, title, blogClassId,
				content, topPost, hidden);
		return result;
	}

	public String deleteArticle() {
		String result = articleService.deleteArticle(articleId);
		return result;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBlogClassId() {
		return blogClassId;
	}

	public void setBlogClassId(int blogClassId) {
		this.blogClassId = blogClassId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	@Resource
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
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
