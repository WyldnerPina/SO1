package view;

import java.util.concurrent.Semaphore;

import controller.ShowController;

public class Main {
	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
// =============================================================================================		
		for(int id = 0; id < 300; id++) {
			Thread thread = new ShowController(id, semaforo);
			thread.start();
		}

	}
}
