package by.cushingsoftware.collector.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class CsvFileWriter {

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_NAME = "/search_result.csv";
	private static final String FILE_HEADER = "TEXT LINK , LINK";

	public static void writeCsvFile(Map<String, String> data) {

		PrintWriter  fileWriter = null;
		StringBuilder stringBuilder = new StringBuilder();
		try {
			fileWriter = new PrintWriter(FILE_NAME);

			stringBuilder.append(FILE_HEADER.toString());

			stringBuilder.append(NEW_LINE_SEPARATOR);

			for (Map.Entry entry : data.entrySet()) {
				stringBuilder.append((CharSequence) entry.getKey());
				System.out.println(entry.getKey());
				stringBuilder.append(COMMA_DELIMITER);
				stringBuilder.append((CharSequence) entry.getValue());
				System.out.println(entry.getValue());
				stringBuilder.append(NEW_LINE_SEPARATOR);
			}
			System.out.println(stringBuilder);
			fileWriter.write(stringBuilder.toString());
			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			fileWriter.flush();
			fileWriter.close();

		}
	}
}
