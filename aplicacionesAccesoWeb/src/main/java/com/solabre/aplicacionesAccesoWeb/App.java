package com.solabre.aplicacionesAccesoWeb;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import org.apache.commons.codec.binary.Base64;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.geocaching.com/account/join");
			byte[] encodedBytes = Base64.encodeBase64("username:password".getBytes());
			System.out.println("encodedBytes " + new String(encodedBytes));
			String encoding = new String(encodedBytes);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Basic " + encoding);
			InputStream content = (InputStream) connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(content));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
	}
}
