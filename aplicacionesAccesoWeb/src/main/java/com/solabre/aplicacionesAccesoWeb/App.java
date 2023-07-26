package com.solabre.aplicacionesAccesoWeb;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		String url = "https://www.geocaching.com/my/statistics.aspx";

		try {
			Connection.Response loginForm = Jsoup.connect(url).method(Connection.Method.GET).execute();

			// POST login data
			Document doc = Jsoup.connect(url).cookies(loginForm.cookies()).timeout(100000).post();
			System.out.println(doc.baseUri());
			Element e = doc.getElementById("CybotCookiebotDialogBodyUnderlay");
			System.out.println(e.toString());
		} catch (IOException ex) {
			System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
		}
	}
}
