package view;

import java.util.concurrent.Semaphore;

import controller.AeroController;

public class Main {
	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		Semaphore semaforo2 = new Semaphore(permissoes);
		
// =============================================================================================		
		for(int id = 0; id < 12; id++) {
			Thread thread = new AeroController(id, semaforo, semaforo2);
			thread.start();
		}

	}
}
