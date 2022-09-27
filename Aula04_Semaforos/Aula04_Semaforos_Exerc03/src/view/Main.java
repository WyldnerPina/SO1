package view;

import java.util.concurrent.Semaphore;

import controller.Exerc03Controller;

public class Main {
	public static void main(String[] args) {
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);

// =============================================================================================		
		for (int id = 0; id < 10; id++) {
			Thread thread = new Exerc03Controller(id, semaforo);
			thread.start();
		}
	}
}
