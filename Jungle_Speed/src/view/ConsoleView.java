package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controller;
import model.Player;

public class ConsoleView extends View {
	private Scanner scanner;

	public ConsoleView(Player model, Controller controller) {
		super(model, controller);
		scanner = new Scanner(System.in);
		new Thread(new ReadInput()).start();
	}
	
	public class ReadInput implements Runnable {

		@Override
		public void run() {
			while(true) {
				try {
					String c=scanner.next();
					
					switch(c){
						case "p": controller.pickup();
						break;
						case "me": controller.me();
						break;
						case "s": controller.stop();
						break;
					}
				}
				catch(InputMismatchException e) {
					
				}
			}
			
		}
		

	}
}
