package by.cushingsoftware.collector.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

public class CsvFileWriter {
	
	private static final String DECLARE_SEPARATOR = "sep=,";
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_NAME = "/search_result.csv";
	private static final String FILE_HEADER = "¹,GOOGLE,YAHOO,YANDEX";

	private static Logger LOGGER = Logger.getLogger(CsvFileWriter.class);

	public static void writeCsvFile(List<List<String>> data) {
		FileWriter fileWriter = null;
		StringBuilder stringBuilder = new StringBuilder();
		try {
			fileWriter = new FileWriter(FILE_NAME, true);
			stringBuilder.append(DECLARE_SEPARATOR);
			stringBuilder.append(NEW_LINE_SEPARATOR);
			stringBuilder.append(FILE_HEADER.toString());
			stringBuilder.append(NEW_LINE_SEPARATOR);
			final int size = data.get(0).size();
			for (int i = 0; i < size ; i++) {
				stringBuilder.append(i);
				stringBuilder.append(COMMA_DELIMITER);
				for (int j = 0; j < data.size(); j++) {
					stringBuilder.append(data.get(j).get(i));
					stringBuilder.append(COMMA_DELIMITER);
				}
				stringBuilder.append(NEW_LINE_SEPARATOR);
			}
			fileWriter.write(stringBuilder.toString());
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				LOGGER.error(e);
				e.printStackTrace();
			}
		}
	}
}
