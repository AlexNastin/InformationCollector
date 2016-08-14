package by.cushingsoftware.collector.parser;

public class InputDataParser {

	public  static String parse(String[] args) {
		StringBuilder outputData = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			outputData.append(args[i]);
			if (i != args.length - 1) {
				outputData.append("+");
			}
		}
		return outputData.toString();
	}
}
