package pblog.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pblog.dao.PhotoDAO;
import pblog.entity.Photo;

public class PhotoDAOImplTest {
	private ApplicationContext context = null;
	private PhotoDAO pdao = null;
	{
		context = new ClassPathXmlApplicationContext("beans.xml");
		pdao = (PhotoDAO) context.getBean("photoDAO");

	}
	
	@Test
	public void addPhotoTest(){
		Photo photo=new Photo();
		photo.setAlbumId(16);
		photo.setPhotoName("测试");
		photo.setPublishDate(new Date());
		photo.setUrl("");
		pdao.addPhoto(photo);
	}
	
	@Test
	public void getPhotoByPageTest(){
		List<Photo> list= pdao.getPhotoByPage(1);
		for (Photo photo : list) {
			System.out.println(photo.getUrl());
		}
	}
}
