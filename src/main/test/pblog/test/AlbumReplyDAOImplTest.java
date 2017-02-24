package pblog.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pblog.dao.AlbumReplyDAO;
import pblog.entity.AlbumReply;

public class AlbumReplyDAOImplTest {
	private ApplicationContext context = null;
	private AlbumReplyDAO adao = null;
	{
		context = new ClassPathXmlApplicationContext("beans.xml");
		adao = (AlbumReplyDAO) context.getBean("albumReplyDAO");
	}
	
	@Test
	public void addAlbumReplyTest(){
		AlbumReply albumReply=new AlbumReply();
		albumReply.setAlbumId(13);
		albumReply.setContent("ceshi");
		albumReply.setPublishTime(new Date());
		albumReply.setReceiveId(3);
		albumReply.setVisitorId(3);
		adao.addAlbumReply(albumReply);
	}
}
