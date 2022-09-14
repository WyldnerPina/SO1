package view;

import java.util.concurrent.Semaphore;

import controller.CozimentoController;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int idPratos = 1; idPratos <= 5; idPratos++) {
			Thread threadId = new CozimentoController(idPratos, semaforo); 
			threadId.start();
		}

	}

}
