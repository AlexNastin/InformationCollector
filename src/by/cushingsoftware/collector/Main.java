package by.cushingsoftware.collector;

import java.io.IOException;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import by.cushingsoftware.collector.parser.InputDataParser;
import by.cushingsoftware.collector.search.GoogleInformationCollector;

public class Main {
	
	public static void main(String[] args) throws IOException {
		String data = InputDataParser.parse(args);
		System.out.println(data);
		GoogleInformationCollector googleInformationCollector = new GoogleInformationCollector();
		Elements results = googleInformationCollector.search(data);
		for (Element element : results) {
			System.out.println(element);
		}
	}
}
