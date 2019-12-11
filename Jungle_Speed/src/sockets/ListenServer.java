package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ListenServer implements Runnable {

	private ServerSocket serverSocket;
	private ArrayList<Socket> socketClientList = new ArrayList<Socket>();
	private ArrayList<BufferedReader> in = new ArrayList<BufferedReader>();
	private PrintWriter out = null;

	public ListenServer(ServerSocket serverSocket) {

		this.serverSocket = serverSocket;
	}

	/**
	 * @return the serverSocket
	 */
	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	/**
	 * @param serverSocket the serverSocket to set
	 */
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	/**
	 * @return the socketClientList
	 */
	public ArrayList<Socket> getSocketClientList() {
		return socketClientList;
	}

	/**
	 * @param socketClientList the socketClientList to set
	 */
	public void setSocketClientList(ArrayList<Socket> socketClientList) {
		this.socketClientList = socketClientList;
	}

	/**
	 * @return the in
	 */
	public ArrayList<BufferedReader> getIn() {
		return in;
	}

	/**
	 * @param in the in to set
	 */
	public void setIn(ArrayList<BufferedReader> in) {
		this.in = in;
	}

	/**
	 * @return the out
	 */
	public PrintWriter getOut() {
		return out;
	}

	/**
	 * @param out the out to set
	 */
	public void setOut(PrintWriter out) {
		this.out = out;
	}

	@Override
	public void run() {

		try {
			while (true) {
				for (int i = 0; i < socketClientList.size(); i++) {
					out = new PrintWriter(socketClientList.get(i).getOutputStream());
					in.clear();
					for (int j = 0; j < socketClientList.size(); j++) {
						if (!socketClientList.get(i).equals(socketClientList.get(j))) {
							in.add(new BufferedReader(new InputStreamReader(socketClientList.get(j).getInputStream())));
						}
					}
					for (int k = 0; k < in.size(); k++) {
						String id = in.get(k).readLine();
						String event = in.get(k).readLine();

						System.out.println("-------------[receive]--------------");
						System.out.println("Client :" + id);
						System.out.println("Event :" + event);
						System.out.println("-------------------------------");
						out.flush();// pour clear le out avant de reecrire
					}
				}
				Thread.sleep(200); // execution tous les deux secondes
			}
		} catch (IOException e) {

		} catch (InterruptedException e) {

		}
	}

	/**
	 * send outputstream
	 * 
	 * @param id
	 * @param event
	 */
	public void send(String id, String event) {

		out.println(id);
		out.println(event);
		System.out.println("-------------[SEND]--------------");
		System.out.println("Client :" + id);
		System.out.println("Event :" + event);
		System.out.println("-------------------------------");
		out.flush();// pour clear le out avant de reecrire
	}

}
