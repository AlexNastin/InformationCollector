package by.cushingsoftware.collector.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YahooInformationCollector implements InformationCollector {

	public static final String YAHOO_SEARCH_URL = "https://search.yahoo.com/search";

	private static Logger LOGGER = Logger.getLogger(YahooInformationCollector.class);

	@Override
	public List<String> search(String data) {
		List<String> results = new ArrayList<String>();
		StringBuilder searchURL = new StringBuilder(YAHOO_SEARCH_URL);
		searchURL.append("?q=");
		searchURL.append(data);
		try {
			Document doc = Jsoup.connect(searchURL.toString()).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
			Elements resultElements = doc.select("h3.title > a");
			for (Element result : resultElements) {
				results.add(result.attr("href"));
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
		return results;
	}
}
