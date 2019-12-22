package br.com.communication.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import br.com.communication.client.business.TalkServer;

public class ClientMain 
{
    public static void main( String[] args ) throws UnknownHostException, IOException
    {
    	Socket socket = new Socket("localhost", 12345);
        System.out.println("Conexão Estabelecida");
        
        TalkServer talkServer = new TalkServer(socket);
        
        talkServer.talk();
        socket.close();
        System.out.println("Conexão Fechada");
    }
}
