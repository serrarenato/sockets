package br.com.communication.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class ClientMain 
{
    public static void main( String[] args ) throws UnknownHostException, IOException
    {
    	Socket socket = new Socket("localhost", 12345);
        System.out.println("Conexão Estabelecida");

        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();

        socket.close();
        System.out.println("Conexão Fechada");
    }
}
