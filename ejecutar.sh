#!/bin/bash

# Se comprueba el correcto funcionamiento de java en la PC
if ! command -v java --version 2>&1 > /dev/null; 
	then
		echo -e "\033[31mNo se encuentra java en su PC"
	else 
		clear
		dir=$(pwd)/src/com/dfont/App

		# Se lanza el servidor
		java "$dir"/Servidor.java &

		# Se almacena el PID del servidor dado que tiene un bucle while(true)
		# y sera necesario terminar su ejecucion.
		pidServidor=$!
		
		# Se lanza el cliente
		java "$dir"/Cliente.java &
		
		# Tiempo prudencial para la ejecucion del programa
		sleep 4
		
		# Se mata el proceso del servidor
		kill $pidServidor
fi
