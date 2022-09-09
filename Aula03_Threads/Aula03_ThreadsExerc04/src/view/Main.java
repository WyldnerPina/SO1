package view;

import controller.Exerc04;

public class Main {

	public static void main(String[] args) {
		for (int idThread = 0; idThread < 5; idThread++) {
			Thread threadId = new Exerc04(idThread); 
			threadId.start();
		}	
	}
}
