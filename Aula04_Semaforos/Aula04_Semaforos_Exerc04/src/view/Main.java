package view;

import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);
		
// =============================================================================================		
		for(int id = 0; id<10; id++) {
			Thread thread = new Exerc04Controller(id, semaforo);
			thread.start();
		}

	}
}
