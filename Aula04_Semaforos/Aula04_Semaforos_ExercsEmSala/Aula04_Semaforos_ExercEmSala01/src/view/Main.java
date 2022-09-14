package view;

import java.util.concurrent.Semaphore;

import controller.ContasController;

public class Main {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int idThread = 1; idThread <= 21; idThread++) {
			Thread threadId = new ContasController(idThread, semaforo);
			threadId.start();
		}
	}
}
