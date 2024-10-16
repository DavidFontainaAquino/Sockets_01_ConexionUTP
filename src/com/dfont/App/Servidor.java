package com.dfont.App;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static void main(String[] args) {
		
		final int PUERTO = 5000;
		
		ServerSocket server = null;
		Socket socket = null;
		DataInputStream in;
		DataOutputStream out;
		Logger logger = Logger.getLogger(Servidor.class.getName());
		
		try {
			server = new ServerSocket(PUERTO);
			logger.log(Level.INFO, "Servidor Iniciado");
			
			while(true) {
				// Client's socket
				socket = server.accept();
				logger.log(Level.INFO, "Cliente conectado");
				
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				
				String message = in.readUTF();
				logger.log(Level.INFO, "Recibido: " + message);
				out.writeUTF("Hola mundo desde el servidor");
				socket.close();
				logger.log(Level.INFO, "Cliente desconectado");
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, null, e);
		}

	}

}
