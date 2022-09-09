package view;

import javax.swing.JOptionPane;

import controller.ThreadVetor;

public class Main {

	public static void main(String[] args) {
		int tam = 1000;
		int vet[] = new int[tam];
//===================================================================================================
//========================================= CRIANDO VETOR ===========================================
//===================================================================================================
		for (int i = 0; i < tam; i++) { 
			vet[i] = (int) ((Math.random() * 100) + 1);
		}
		
		
//===================================================================================================
//====================================== PASSANDO P/ THREAD =========================================
//===================================================================================================		
		for(int num = 0; num < tam; num++) {
			// no exercício não ficou claro se num ou vet[num] seria o número pra testar se par ou ímpar
			Thread difFor = new ThreadVetor(vet, tam, num); 
			difFor.start();
		}		

	}

}
