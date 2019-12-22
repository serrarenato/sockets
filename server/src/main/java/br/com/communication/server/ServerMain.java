package br.com.communication.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class ServerMain {
	public static void main(String[] args) throws IOException {
		System.out.println("---- Iniciando Servidor ----");
		ServerSocket servidor = new ServerSocket(12345);

		while (true) {
			Socket socket =servidor.accept();
			System.out.println("Aceitando novo cliente na porta " + socket.getPort());
		}
	}
}
