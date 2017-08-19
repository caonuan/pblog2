package pblog.service;

import pblog.entity.Article;
import pblog.entity.BlogClass;

import java.util.List;

public interface ArticleService {
	/**
	 * 
	 * @param title
	 * @param blogClass
	 * @param content
	 * @return
	 */
	public String addArticle(String title, int blogClassId, String content,int topPost,int hidden);

	/**
	 * 更新文章时，要将updateDate设置为系统当前值。
	 * 
	 * @param title
	 * @param blogClass
	 * @param content
	 * @return
	 */
	public String updateArticle(int articleId, String title, int blogClassId, String content,int topPost,int hidden);

	/**
	 * 获取一定数量与位置的博文。按时间新->旧排序
	 * @param page 第几页
	 * @param size 每页数量
	 * @param firstResult 开始的位置。为-1时默认为（页数-1）*每页数量
	 * @return
	 */
	public List<Article> getSomeArticle(int page,int size,int firstResult);
	
	/**
	 * 通过博文类型分页获取博文
	 * @param blogClassId
	 * @param page
	 * @param ifShowHidden 是否显示隐藏博文
	 * @return
	 */
	public List<Article> getAritleByClassAndPage(int blogClassId,int page,boolean ifShowHidden);

	/**
	 * 管理员浏览时，1个page内十条信息，相当于调用dao内函数时传参为这里的page*2
	 * 
	 * @param page
	 * @return
	 */
	public List<Article> managerGetSomeArticle(int page,int size,int firstResult);

	public Article getOneArticle(int articleId);

	/**
	 * 删除日志时，顺带删除该日志的所有评论和相关照片
	 * 
	 * @param articleId
	 * @return
	 */
	public String deleteArticle(int articleId);

	/**
	 * 先不实现
	 */
	public String saveReadCount(Article article);

	/**
	 * 中转一下页数
	 * 
	 * @param page
	 * @return页数
	 */
	public int getPageCount(int size);
	
	public int managerGetPageCount(int size);
	
	/**
	 * 按类别取博文，计算页数
	 * 
	 * @param page
	 * @param ifShowHidden 是否显示隐藏博文
	 * @return页数
	 */
	public int getPageCountForClass(int blogClassId,boolean ifShowHidden);
	
	public List<BlogClass> getAllBlogClass();

	public BlogClass getBlogClassById(int blogClassId);

	public List<Object[]> getAllMonthsWhichHaveArticle();
	
	public List<Article> getArticlesByTime(String time);
	
	public List<Article> getTopPostedArticle();
}
