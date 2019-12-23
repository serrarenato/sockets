package br.com.communication.server.business;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread implements Runnable {

	Socket socket;

	public ClientThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		System.out.println("Cliente: " +  socket);
		Scanner inputClient;
		try {
			
			inputClient = new Scanner(socket.getInputStream());
			PrintStream outputClient = new PrintStream(socket.getOutputStream());
			
			while (inputClient.hasNextLine()) {
	            String comando = inputClient.nextLine();
	            System.out.println("Cliente: " +socket.getPort());
	            System.out.println(comando);
	            outputClient.println("Mensagem recebida: " + comando);
	        }
	        inputClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
