package view;

import java.util.concurrent.Semaphore;

import controller.Exerc03Controller;

public class Main {
	public static void main(String[] args) {		
		Semaphore semaforoPista = new Semaphore(5);
		Semaphore semaforoEquipes = new Semaphore(1);

// =============================================================================================		
		for (int id = 0; id < 2; id++) {
			Thread thread = new Exerc03Controller(id, semaforoPista, semaforoEquipes);
			thread.start();
		}
	}
}
