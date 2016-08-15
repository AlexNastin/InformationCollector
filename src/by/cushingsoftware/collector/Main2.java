package by.cushingsoftware.collector;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main2 {

	public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";
	public static final String YAHOO_SEARCH_URL = "https://search.yahoo.com/search";
	public static final String MAIL_SEARCH_URL = "http://go.mail.ru/search?q=Java";

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(new File("/test.csv"));
		StringBuilder sb = new StringBuilder();
		sb.append("id");
		sb.append(',');
		sb.append("Name");
		sb.append('\n');

		sb.append("1");
		sb.append(',');
		sb.append("Prashant Ghimire");
		sb.append('\n');

		pw.write(sb.toString());
		pw.close();
		System.out.println("done!");
		// for (String string : args) {
		// System.out.println(string + "!");
		// }
		//
		// StringBuilder outputData = new StringBuilder();
		// for (String string : args) {
		// outputData.append(string);
		// outputData.append("+");
		// }
		// System.out.println(outputData.toString());
		// StringBuilder outputData2 = new StringBuilder();
		// System.out.println(args.length);
		// for (int i = 0; i < args.length; i++) {
		// outputData2.append(args[i]);
		// if (i != args.length - 1) {
		// outputData2.append("+");
		// }
		// }
		// System.out.println(outputData2.toString());
		// // Taking search term input from console
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Please enter the search term.");
		// String searchTerm = scanner.nextLine();
		// System.out.println("Please enter the number of results. Example: 5 10
		// 20");
		// int num = scanner.nextInt();
		// scanner.close();

		// String searchURL = GOOGLE_SEARCH_URL + "?q=" + searchTerm + "&num=" +
		// num;
		// String searchURL = MAIL_SEARCH_URL;
		// without proper User-Agent, we will get 403 error
		// Document doc =
		// Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
		// Document doc =
		// Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();

		// System.out.println(searchURL);
		// System.out.println(doc);
		// below will print HTML data, save it to a file and open in browser
		// to
		// compare
		// System.out.println(doc.html());

		// If google search results HTML change the <h3 class="r" to <h3
		// class="r1"
		// we need to change below accordingly
		// Elements results = doc.select("a[href]");
		//
		// for (Element result : results) {
		// System.out.println(result);
		// String temp = result.attr("href");
		// String linkText = result.text();
		// System.out.println("! " +temp );
		// System.out.println("! " +linkText );
		// String linkHref = result.attr("href");
		// String linkText = result.text();
		// System.out.println("Text::" + linkText + ", URL::" +
		// linkHref.substring(6, linkHref.indexOf("&")));
		// }
	}

}
