package net.ukr.andy777;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 Lesson11
 2. Написать сервер, который будет отправлять пользователю информацию о системе и номер запроса.
 */

public class Main {
	public static void main(String[] args) {
		int inquiryNo = 0;
		try {
			ServerSocket serverSocket = new ServerSocket(8080);
			for (;;) {
				Socket clientSocket = serverSocket.accept();
				Client client = new Client(clientSocket, sysInfo(++inquiryNo));
			}
		} catch (IOException e) {
			System.out.println("Error to server Socket Open!!!");
		}
	}

	public static String sysInfo(int inquiryNo) {
		String answer = "";
		answer += "<html><head><title>SystemInfo</title> <meta charset='utf-8'></head><body>" + "<p>ЗАПИТ № "
				+ inquiryNo + "</p><p>Інформація про систему:</p>"
				+ "<br><table border='1' cellpadding='5' ><tr><th>Інформація</th><th>Значення</th></tr>";

		answer += "<tr><td>Operating system (name)</td>";
		answer += "<td>" + System.getProperty("os.name") + "</td></tr>";

		answer += "<tr><td>Operating system (version)</td>";
		answer += "<td>" + System.getProperty("os.version") + "</td></tr>";

		answer += "<tr><td>Operating system architecture</td>";
		answer += "<td>" + System.getProperty("os.arch") + "</td></tr>";

		answer += "<tr><td>User account name</td>";
		answer += "<td>" + System.getProperty("user.name") + "</td></tr>";

		answer += "<tr><td>JRE version number</td>";
		answer += "<td>" + System.getProperty("java.version") + "</td></tr>";

		answer += "<tr><td>Installation directory for Java Runtime Environment (JRE))</td>";
		answer += "<td>" + System.getProperty("java.home") + "</td></tr>";

		answer += "<tr><td>Available processors (cores)</td>";
		answer += "<td>" + Runtime.getRuntime().availableProcessors() + "</td></tr>";

		answer += "<tr><td>Maximum memory (bytes)</td>";
		answer += "<td>" + Runtime.getRuntime().maxMemory() + "</td></tr>";

		answer += "<tr><td>Total memory available to JVM (bytes)</td>";
		answer += "<td>" + Runtime.getRuntime().totalMemory() + "</td></tr>";

		answer += "<tr><td>Free memory (bytes)</td>";
		answer += "<td>" + Runtime.getRuntime().freeMemory() + "</td></tr>";

		answer += "</table></body></html>";
		return answer;
	}

}
