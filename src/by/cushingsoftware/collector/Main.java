package by.cushingsoftware.collector;

import java.io.IOException;
import java.util.Map;

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
		Map<String, String> map = informationCollector.search(data);
//		for (Map.Entry entry : map.entrySet()) {
//			System.out.println(entry.getKey() + ", " + entry.getValue());
//		}
		CsvFileWriter.writeCsvFile(map);
//		 System.out.println();
//		 System.out.println("YAHOO");
//		 InformationCollector informationCollector2 =
//		 factory.getInformationCollector(SearchSystem.YAHOO);
//		 Map<String, String> map2 = informationCollector2.search(data);
//		 for (Map.Entry entry : map2.entrySet()) {
//		 System.out.println(entry.getKey() + ", " + entry.getValue());
//		 }
//		 CsvFileWriter.writeCsvFile(map2);
		// System.out.println();
		// System.out.println("YANDEX");
		// InformationCollector informationCollector3 =
		// factory.getInformationCollector(SearchSystem.YANDEX);
		// Map<String, String> map3 = informationCollector3.search(data);
		// for (Map.Entry entry : map3.entrySet()) {
		// System.out.println(entry.getKey() + ", " + entry.getValue());
		// }
	}
}
