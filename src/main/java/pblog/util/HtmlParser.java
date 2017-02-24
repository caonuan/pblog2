package pblog.util;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class HtmlParser {

	public static String getPTagContent(String pageContent) {
		try {
			String result = "";
			Parser parser = new Parser(pageContent);
			NodeFilter filter = new TagNameFilter("p");
			NodeList nodeList = parser.extractAllNodesThatMatch(filter);
			if (nodeList != null) {
				if (nodeList.elementAt(0) != null)
					result += nodeList.elementAt(0).toPlainTextString() + "...";
			}
			return result;
		} catch (ParserException e) {
			e.printStackTrace();
			return null;
		}
	}
}
