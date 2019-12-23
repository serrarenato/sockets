package br.com.communication.client.business;

import java.io.IOException;
import java.net.Socket;

public class TalkServer {

	Socket socket;
	TalkServerSendMessage talkServerSendMessage;
	TalkServerReceiveMessage talkServerReceiveMessage;
	
	public TalkServer(Socket socket) {
		this.socket = socket;
	}
	public void talk() throws IOException {
		talkServerSendMessage = new TalkServerSendMessage(socket);
		talkServerReceiveMessage = new TalkServerReceiveMessage(socket);
		new Thread(talkServerSendMessage).start();  
		new Thread(talkServerReceiveMessage).start();        
	}

}
