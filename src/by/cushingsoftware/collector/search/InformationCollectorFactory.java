package by.cushingsoftware.collector.search;

public class InformationCollectorFactory {

	private InformationCollectorFactory() {
	}

	private static class InformationCollectorFactoryHolder {
		public static final InformationCollectorFactory INSTANCE = new InformationCollectorFactory();
	}

	public static InformationCollectorFactory getInstance() {
		return InformationCollectorFactoryHolder.INSTANCE;
	}

	public InformationCollector getInformationCollector(SearchSystem searchSystem) {
		switch (searchSystem) {
		case GOOGLE:
			return new GoogleInformationCollector();
		case YAHOO:
			return new YahooInformationCollector();
		case YANDEX:
			return new YandexInformationCollector();
		default:
			return null;
		}
	}
}
