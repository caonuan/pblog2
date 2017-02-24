package pblog.othertest;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class HtmlParserTest {
	private static String ENCODE = "utf-8";

	public static void getPTagContent(String pageContent) {
		try {
			Parser parser = new Parser(pageContent);
			NodeFilter filter = new TagNameFilter("p");
			NodeList nodeList = parser.extractAllNodesThatMatch(filter);
			if (nodeList != null) {
				for (int i = 0; i < nodeList.size(); i++) {
					Node node = nodeList.elementAt(i);
					System.out.println("getText:" + node.toPlainTextString());
				}
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}
}
