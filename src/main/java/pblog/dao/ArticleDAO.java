package pblog.dao;

import java.util.List;

import pblog.entity.Article;
import pblog.entity.BlogClass;

public interface ArticleDAO {
	/**
	 * 通过文章id查找文章
	 * @param articleId
	 * @return
	 */
	public Article getArticleById(int articleId);
	
	/**
	 * 分页获取该页的博文。一页5个博文
	 * 已修改，现在是10个
	 * 又修改了，现在是可以自定义
	 * @param page 第几页
	 * @param size 每页数量
	 * @param firstResult 开始位置
	 * @return 博文list
	 */
	public List<Article> getArticleByPage(int page,int size,int firstResult);
	
	public List<Article> managerGetArticleByPage(final int page,final int size,int firstResult);
	
	/**
	 * 获取博文总数
	 * @return 博文的总页数
	 */
	public int getArticleCount();
	
	public int managerGetArticleCount();
	
	/**
	 * 关键字检索
	 * 看似很难，大家一起讨论再写吧
	 * 写完了，但中文分词还有点问题
	 * @param keyWord 
	 * @return
	 */
	public List<Article> getArticleByKeyWord(String keyWord,int pageNow);
	
	public int getArticleCountByKeyWord(String keyWord);
	
	/**
	 * 通过博文类型分页获取博文
	 * @param blogClass
	 * @param page
	 * @return
	 */
	public List<Article> getAritleByClassAndPage(int blogClassId,int page);
	
	/**
	 * 获取某类博文的总页数。
	 * @return 某类博文总页数
	 * @param blogClass 博文类型
	 */
	public int getPageCountForClass(int blogClassId);
	
	/**
	 * 添加博客
	 * @param article
	 * @return
	 */
	public boolean addArticle(Article article);
	
	/**
	 * 通过博文id删除博文,同时删除评论
	 * @param articleId
	 * @return
	 */
	public boolean deleteArticleById(int articleId);
	
	/**
	 * 更新博文。通过id找到原博文数据，将数据的content内容替换，并且更新updateDate字段
	 * @param article
	 * @return 是否成功
	 */
	public boolean updateArticle(Article article);
	
	public List<BlogClass> getAllBlogClass();
	
	/**
	 * 通过id查找blog
	 * @return
	 */
	public BlogClass getBlogClassByBlogClassId(int blogClassId);
	
	/**
	 * 获取时间索引
	 * @return 返回值为所有写了博文的月份信息，第一个值为时间（精确到月）,第二个值为这个月的文章数
	 */
	public List<Object[]> getAllMonthsWhichHaveArticle();
	
	/**
	 * 通过时间获取这个月内创建的所有博文
	 * @param time
	 * @return
	 */
	public List<Article> getArticlesByTime(String time);
	
	/**
	 * 获取置顶博文
	 * @return
	 */
	public List<Article> getTopPostedArticle();
}
