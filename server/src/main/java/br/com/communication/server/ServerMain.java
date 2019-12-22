package br.com.communication.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.communication.server.business.ClientThread;

public class ServerMain {
	public static void main(String[] args) throws IOException {
		System.out.println("---- Iniciando Servidor ----");
		ServerSocket servidor = new ServerSocket(12345);

		while (true) {
			Socket socket = servidor.accept();
            ClientThread clientThread = new ClientThread(socket);
            new Thread(clientThread).start();
			System.out.println("Aceitando novo cliente na porta " + socket.getPort());
		}
	}
}
