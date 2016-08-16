package by.cushingsoftware.collector.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleInformationCollector implements InformationCollector {

	private final String GOOGLE_SEARCH_URL = "https://www.google.com/search";

	private static Logger LOGGER = Logger.getLogger(GoogleInformationCollector.class);
	
	@Override
	public List<String> search(String data) {
		List<String> results = new ArrayList<String>();
		StringBuilder searchURL = new StringBuilder(GOOGLE_SEARCH_URL);
		searchURL.append("?q=");
		searchURL.append(data);
		searchURL.append("&num=10");
		try {
			Document doc = Jsoup.connect(searchURL.toString()).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
			Elements resultElements = doc.select("h3.r > a");
			if (resultElements.size() != 0) {
				for (Element result : resultElements) {
					results.add(result.attr("href"));
				}	
			} else {
				results = InformationCollector.unsuccessfulList;
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
		return results;
	}
}
