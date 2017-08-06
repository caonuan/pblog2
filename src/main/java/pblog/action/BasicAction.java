package pblog.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by caonuan on 2017/8/6.
 */
public class BasicAction extends ActionSupport {
    private String basic_url = "http://www.我是你爷爷.top";
    private String home_page = "home";
    private String article_page = "article/";
    private String album_page = "album/";
    private String note_page = "note/";
    private String manage_page = "manage/";

    public String getBasic_url() {
        return basic_url;
    }

    public void setBasic_url(String basic_url) {
        this.basic_url = basic_url;
    }

    public String getHome_page() {
        return home_page;
    }

    public void setHome_page(String home_page) {
        this.home_page = home_page;
    }

    public String getArticle_page() {
        return article_page;
    }

    public void setArticle_page(String article_page) {
        this.article_page = article_page;
    }

    public String getAlbum_page() {
        return album_page;
    }

    public void setAlbum_page(String album_page) {
        this.album_page = album_page;
    }

    public String getNote_page() {
        return note_page;
    }

    public void setNote_page(String note_page) {
        this.note_page = note_page;
    }

    public String getManage_page() {
        return manage_page;
    }

    public void setManage_page(String manage_page) {
        this.manage_page = manage_page;
    }
}
