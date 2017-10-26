package pblog.othertest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pblog.service.ArticleService;
import pblog.util.SingleApplicationContext;
import pblog.util.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

	@Test
	// 读取配置时时多例模式
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println(ac == ac1);
	}

	@Test
	// string 类 indexof()测试
	public void stringindexoftest() {
		String content = "src1  src2  src3";
		int lastSrc = content.lastIndexOf("src");
		int firstSrc = content.indexOf("src");
		System.out.println(lastSrc);
		int afterlast = content.indexOf("src", lastSrc + 1);
		int afterfirst = content.indexOf("src", firstSrc + 1);
		System.out.println(afterlast);
		System.out.println(afterfirst);
	}

	@Test
	public void getSrcTest() {
		ArticleService as = (ArticleService) (SingleApplicationContext
				.getApplicationContext().getBean("articleService"));
		String tar = as.getOneArticle(20).getContent();
		List<String> imgList = getImg(tar);
		for (String string : imgList) {
			int begin = string.indexOf("\"") + 1;
			int end = string.lastIndexOf("\"");
			System.out.println(string.substring(begin, end));
			System.out.println(string);
		}
	}

	public static List<String> getImg(String s) {
		String regex;
		List<String> list = new ArrayList<String>();
		regex = "src=\"(.*?)\"";
		Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
		Matcher ma = pa.matcher(s);
		while (ma.find()) {
			list.add(ma.group());
		}
		return list;
	}

	@Test
	public void test2() {
		File f = new File("");
		try {
			System.out.println(f.getCanonicalPath());// 获取标准的路径
			System.out.println(f.getAbsolutePath());// 获取绝对路径
		} catch (Exception e) {
		}
	}

	@Test
	public void deletePhtotTest() {
		Util.deleteFileBySrc("/pblog/userfiles/images/chuanpang.png");
		Util.getPath();
	}

	@Test
	public void test3() {
		File file = new File("");
		String s = file.getAbsolutePath()
				+ "/src/main/webapp/pblog/userfiles/images/chuanpang.png";
		System.out.println(s);
		File file2 = new File(s);
		System.out.println(file2.exists());
	}

	@Test
	public void test4() {
		Test1.class.getClassLoader();
		System.err.println(ClassLoader.getSystemResource(""));
	}

	@Test
	public void regularTest() {
		String url = "c:/a./sd.v/asd.jpg";
		String ruglar = "\\S*\\.";
		Pattern p = Pattern.compile(ruglar);
		Matcher m = p.matcher(url);
		if (m.find())
			System.out.println(m.group());
		ruglar = "\\..*";
		p = Pattern.compile(ruglar);
		m = p.matcher(url);
		if (m.find())
			System.out.println(m.group(m.groupCount()));
		url=url.substring(0,url.lastIndexOf('.'))+"_t"+url.substring(url.lastIndexOf('.'),url.length());
		System.out.println(url);
	}
	
	@Test
	public void dateTest(){
		Date date = new Date();
		System.out.println(date);
	}


	@Test
	public void equalTest(){
//        System.out.println(true=="true");
	}

	@Test
	public void springTest(){
		ApplicationContext ac=SingleApplicationContext.getApplicationContext();
		SpringTest2 st2= (SpringTest2) ac.getBean("springTest2");
		st2.test();
	}

	@Test
	public void stringTest(){
		String content="123"+":\n\t您好，您收到了来自\t"+"312"+"\t的新回复。\n\t请访问：\t"+"http:1234"+"\t查看详情。";
		System.out.println(content);
	}

	public static void main(String[] args) {
		overflow1();
	}

	public static void overflow1(){
		overflow2();
	}
	public static void overflow2(){
		overflow1();
	}
}
