package by.cushingsoftware.collector.search;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GoogleInformationCollector implements InformationCollector {

	public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";


	@Override
	public Elements search(String data) {
		String searchURL = GOOGLE_SEARCH_URL + "?q=" + data + "&num=10";
		Elements results = null;
		try {
			Document doc = Jsoup.connect(searchURL) .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
			results = doc.select("h3.r > a");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(searchURL);
		return results;
	}

}
