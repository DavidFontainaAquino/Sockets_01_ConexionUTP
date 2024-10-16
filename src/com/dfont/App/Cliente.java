package com.dfont.App;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {
		
		final String HOST = "127.0.0.1";
		final int PUERTO = 5000;
		Socket socket = null;
		DataInputStream in;
		DataOutputStream out;
		Logger logger = Logger.getLogger(Cliente.class.getName());
		
		try {
			socket = new Socket(HOST, PUERTO);
			
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			out.writeUTF("Hola servidor desde el cliente!");
			String message = in.readUTF();
			logger.log(Level.INFO, "Recibido: " + message);
			
			socket.close();
			
		} catch (Exception e) {
			
		}
		
	}

}
