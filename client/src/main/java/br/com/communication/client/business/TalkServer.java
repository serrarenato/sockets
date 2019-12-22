package br.com.communication.client.business;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TalkServer {

	Socket socket;
	
	public TalkServer(Socket socket) {
		this.socket = socket;
	}
	public void talk() throws IOException {
		PrintStream outputServer = new PrintStream(socket.getOutputStream());
		   
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
        
	}

}
