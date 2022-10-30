package view;

import java.io.IOException;

//import java.io.IOException;

import controller.FruitsController;

public class Main {

	public static void main(String[] args) {
		FruitsController fruits = new FruitsController();
		
		String caminho = "C:\\TEMP";
		String nome = "generic_food.csv";
		
		try {
			fruits.exibeFrutas(caminho, nome);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}
