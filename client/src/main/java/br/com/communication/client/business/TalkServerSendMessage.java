package br.com.communication.client.business;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TalkServerSendMessage implements Runnable {

	private Socket socket;

	public TalkServerSendMessage(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		PrintStream outputServer;
		try {
			outputServer = new PrintStream(socket.getOutputStream());
			Scanner keyboard = new Scanner(System.in);
			while (keyboard.hasNextLine()) {
				String command = keyboard.nextLine();
				outputServer.println(command);
				if (command.trim().equals("")) {
					break;
				}
			}

			outputServer.close();
			keyboard.close();
	        socket.close();
	        System.out.println("Conexão Fechada");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
