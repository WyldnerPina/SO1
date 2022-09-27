package view;

import java.util.concurrent.Semaphore;

import controller.Exerc01Controller;


public class Main {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		// =============================================================================================
		for (int id = 0; id < 4; id++) {
			Thread thread = new Exerc01Controller(id, semaforo);
			thread.start();
		}
	}
}
