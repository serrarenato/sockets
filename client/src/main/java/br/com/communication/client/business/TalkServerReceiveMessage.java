package br.com.communication.client.business;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TalkServerReceiveMessage implements Runnable {

	private Socket socket;

	public TalkServerReceiveMessage(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		Scanner inputServer;
		try {
			inputServer = new Scanner(socket.getInputStream());
			
			while (inputServer.hasNextLine()) {
				String command = inputServer.nextLine();
                System.out.println("Servidor enviou: " + command);
			}

			inputServer.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
