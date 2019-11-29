package model;

public class Timer implements Runnable {

	private int pointer = 0;
	private boolean started =true;

	
	public void start() {
		this.run();
	}
	public void stop() {
		this.stop();
	}
	
	@Override
	
	public void run() {

		while (started) {
			int max = Main.g.getPlayers().size();
			Main.g.getPlayers().get(pointer).playCard(Main.g);
			
			Main.controller.setModel(Main.g.getPlayers().get(pointer));
			Main.vue.setModel(Main.g.getPlayers().get(pointer));
			Main.vue.setController(Main.controller);
			
			if (pointer != max-1) {
				pointer++;
			} else {
				pointer = 0;
			}
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	/**
	 * @return the pointer
	 */
	public int getPointer() {
		return pointer;
	}
	/**
	 * @param pointer the pointer to set
	 */
	public void setPointer(int pointer) {
		this.pointer = pointer;
	}
	/**
	 * @return the started
	 */
	public boolean isStarted() {
		return started;
	}
	/**
	 * @param started the started to set
	 */
	public void setStarted(boolean started) {
		this.started = started;
	}
}
