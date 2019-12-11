package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import model.Main;
import model.Player;

public class ListenClient implements Runnable {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out = null;
	private String id;

	public ListenClient(Socket socket) {

		this.socket = socket;
	}

	@Override
	public void run() {
		 
		while(true) {
		try {
			while(true) {
				
				out = new PrintWriter(socket.getOutputStream());
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				String id = in.readLine();
				String event = in.readLine();
				
				
				System.out.println("-------------[receive]--------------");
				System.out.println("Client :" + id);
				System.out.println("Event :" + event);
				System.out.println("-------------------------------");
				
				this.scan(id, event);
				out.flush();// pour clear le out avant de reecrire
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	}
	
	public void send(String id, String event) {
		out.println(this.getId());
		out.println(event);
			
		System.out.println("-------------[SEND]--------------");
		System.out.println("Client :" + id);
		System.out.println("Event :" + event);
		System.out.println("-------------------------------");
		out.flush();// pour clear le out avant de reecrire
	}
	
	public void scan(String id, String event) {
	//	if(id.equalsIgnoreCase(this.id)) {
	//		out.flush();
	//		return;
	//	}
		
		if(event.equalsIgnoreCase("Vous êtes assigné au joueur 1")) {
			Main.controller.setModel(Main.g.getPlayers().get(0));
			Main.vue.setModel(Main.g.getPlayers().get(0));
			Main.g.getPlayers().get(0).setIdPlayer(1);
			Main.print("Joueur assigné");
			
			this.setId(""+1);
			Main.g.getPlayers().get(0).setScanner(this);
			
		}
		else if(event.equalsIgnoreCase("Vous êtes assigné au joueur 2")) {
			Main.controller.setModel(Main.g.getPlayers().get(1));
			Main.vue.setModel(Main.g.getPlayers().get(1));
			Main.g.getPlayers().get(0).setIdPlayer(2);
			
			this.setId(""+2);
			Main.g.getPlayers().get(1).setScanner(this);
		}
		else if(event.equalsIgnoreCase("Vous êtes assigné au joueur 3")) {
			Main.controller.setModel(Main.g.getPlayers().get(2));
			Main.vue.setModel(Main.g.getPlayers().get(2));
			Main.g.getPlayers().get(2).setIdPlayer(3);
			
			this.setId(""+3);
			Main.g.getPlayers().get(2).setScanner(this);
		}
		else if(event.equalsIgnoreCase("Vous êtes assigné au joueur 4")) {
			Main.controller.setModel(Main.g.getPlayers().get(3));
			Main.vue.setModel(Main.g.getPlayers().get(3));
			Main.g.getPlayers().get(3).setIdPlayer(4);
			
			this.setId(""+4);
			Main.g.getPlayers().get(3).setScanner(this);
		
		}
		else if(event.equalsIgnoreCase("start")) {
			try {
				Main.timer.start();
				Main.print("Timer start requested by server");
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		}
		
		if(event.equalsIgnoreCase("pickTotem")) {
			out.flush();
			this.idToPlayer(id).pickTotem(Main.g);
		}
		if(event.equalsIgnoreCase("playCard")) {
			out.flush();
			this.idToPlayer(id).playCard(Main.g);
			
		}
	}
	
	public Player idToPlayer(String id) {
		return Main.g.getPlayers().get(Integer.parseInt("id"));
	}

	/**
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * @param socket the socket to set
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * @return the in
	 */
	public BufferedReader getIn() {
		return in;
	}

	/**
	 * @param in the in to set
	 */
	public void setIn(BufferedReader in) {
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

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
