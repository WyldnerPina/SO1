package controller;

public class Exerc02 extends Thread {
	private int idThread;
	
	public Exerc02(int threadID) {
		this.idThread = threadID;
	}
	
	public void run() {		
		System.out.print(idThread + " ");		
	}
}
