package view;

import controller.Exerc02;

public class Main {

	public static void main(String[] args) {
		for (int idThread = 0; idThread < 5; idThread++) {
			Thread threadId = new Exerc02(idThread); 
			threadId.start();
		}		
	}

}
