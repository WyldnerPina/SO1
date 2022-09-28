package view;

import java.util.concurrent.Semaphore;

import controller.Exerc03Controller;

public class Main {
	public static void main(String[] args) {		
		Semaphore sPista = new Semaphore(5);
		Semaphore sF = new Semaphore(1);
		Semaphore sML = new Semaphore(1);
		Semaphore sM = new Semaphore(1);
		Semaphore sW = new Semaphore(1);
		Semaphore sL = new Semaphore(1);
		Semaphore sRB = new Semaphore(1);
		Semaphore sS = new Semaphore(1);

// =============================================================================================		
		for (int id = 0; id < 14; id++) {
			Thread thread = new Exerc03Controller(id, sPista, sF, sML, sM, sW, sL, sRB, sS);
			thread.start();
		}
	}
}
