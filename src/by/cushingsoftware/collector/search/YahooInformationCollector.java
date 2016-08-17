package by.cushingsoftware.collector.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YahooInformationCollector implements InformationCollector {

	public static final String YAHOO_SEARCH_URL = "https://search.yahoo.com/search";

	@Override
	public List<String> search(String data) {
		List<String> results = new ArrayList<String>();
		StringBuilder searchURL = new StringBuilder(YAHOO_SEARCH_URL);
		searchURL.append("?q=");
		searchURL.append(data);
		try {
			Document doc = Jsoup.connect(searchURL.toString()).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
			Elements resultElements = doc.select("h3.title > a");
			
			if (resultElements.size() != 0) {
				for (Element result : resultElements) {
					results.add(result.attr("href"));
				}	
			} else {
				results = InformationCollector.unsuccessfulList;
			}
		} catch (IOException e) {
			StringBuilder error = new StringBuilder(YahooInformationCollector.class.toString());
			error.append(" Непредвиденная ошибка при поиске: ");
			error.append(e);
			System.err.println(error);
		}
		return results;
	}
}
