package pblog.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pblog.dao.AlbumDAO;
import pblog.entity.Album;
import pblog.entity.Photo;

public class AlbumDAOImplTest {
	private ApplicationContext context = null;
	private AlbumDAO adao = null;
	{
		context = new ClassPathXmlApplicationContext("beans.xml");
		adao = (AlbumDAO) context.getBean("albumDAO");

	}
	
	@Test
	public void deleteAlbumTest(){
		adao.deleteAlbum(16);
	}

	@Test
	public void createAlbumTest(){
		Album album=new Album();
		album.setAlbumName("测试");
		album.setAlbumUrl("");
		album.setPublishDate(new Date());
		adao.createAlbum(album);
	}
	
	
	@Test
	public void getAllPhotoTest(){
		List<Photo> list=adao.getAllPhoto(5);
		for (Photo photo : list) {
			System.out.println(photo.getPhotoName());
		}
	}
	
}
