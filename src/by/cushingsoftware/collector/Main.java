package by.cushingsoftware.collector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

import by.cushingsoftware.collector.parser.InputDataParser;
import by.cushingsoftware.collector.search.InformationCollector;
import by.cushingsoftware.collector.search.InformationCollectorFactory;
import by.cushingsoftware.collector.search.SearchSystem;
import by.cushingsoftware.collector.writer.CsvFileWriter;

public class Main {

	static {
		new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
	}

	public static void main(String[] args) throws IOException {
		String data = InputDataParser.parse(args);
		System.out.println(data);
		System.out.println();
		System.out.println("GOOGLE");
		InformationCollectorFactory factory = InformationCollectorFactory.getInstance();
		InformationCollector informationCollector = factory.getInformationCollector(SearchSystem.GOOGLE);
		List<String> map = informationCollector.search(data);
		for (String string : map) {
			System.out.println(string);
		}
		System.out.println();
		System.out.println("YAHOO");
		InformationCollector informationCollector2 = factory.getInformationCollector(SearchSystem.YAHOO);
		List<String> map2 = informationCollector2.search(data);
		for (String string : map2) {
			System.out.println(string);
		}
		System.out.println();
		System.out.println("YANDEX");
		InformationCollector informationCollector3 = factory.getInformationCollector(SearchSystem.YANDEX);
		List<String> map3 = informationCollector3.search(data);
		for (String string : map3) {
			System.out.println(string);
		}
		List<List<String>> maps = new ArrayList<List<String>>();
		maps.add(map);
		maps.add(map2);
//		maps.add(map3);
		CsvFileWriter.writeCsvFile(maps);
	}
}
