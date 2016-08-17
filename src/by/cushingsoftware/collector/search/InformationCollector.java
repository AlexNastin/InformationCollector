package by.cushingsoftware.collector.search;

import java.util.ArrayList;
import java.util.List;

public interface InformationCollector {
	@SuppressWarnings("serial")
	final List<String> unsuccessfulList = new ArrayList<String>() {
		{
			for (int i = 0; i < 10; i++) {
				add("Ваш запрос заблокирован поисковой системой или по Вашему запросу ничего не найденно.");
			}
		}
	};
	List<String> search(String data);
}
