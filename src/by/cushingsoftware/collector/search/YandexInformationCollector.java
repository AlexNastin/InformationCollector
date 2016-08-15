package by.cushingsoftware.collector.search;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YandexInformationCollector implements InformationCollector {

	public static final String YANDEX_SEARCH_URL = "https://yandex.by/search/";
	
	private static Logger LOGGER = Logger.getLogger(YandexInformationCollector.class);

	@Override
	public Map<String, String> search(String data) {
		Map<String, String> results = new HashMap<String, String>();
		StringBuilder searchURL = new StringBuilder(YANDEX_SEARCH_URL);
		searchURL.append("?text=");
		searchURL.append(data);
		try {
			Document doc = Jsoup.connect(searchURL.toString()).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
			Elements resultElements = doc.select("h2.serp-item__title > a");
			for (Element result : resultElements) {
				results.put(result.text(), result.attr("href"));
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
		return results;
	}
}
