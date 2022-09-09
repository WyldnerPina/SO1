package view;

import controller.Exerc03;

public class Main {

	public static void main(String[] args) {
		int matx[][] = new int[3][5];
//===================================================================================================
//================================== CRIANDO MATRIX ALEATÓRIA 3X5 ===================================
//===================================================================================================
		for(int L = 0; L < 3; L++) {
			for(int C = 0; C < 5; C++) { // no enunciado fala números aleatórios, sem range, fiz 0 a 9
				matx[L][C] = (int)(Math.random()*10);
			}
		}
		
//===================================================================================================		
//========================= ENVIANDO LINHAS DA MATRIX COMO VETOR PARA SOMA ==========================
//===================================================================================================
		int tam = matx[0].length;// só colocar o zero e pego colunas, matx.length = número de linhas
			
		for(int L = 0; L < 3; L++) {
			int[] vetAux = new int[tam];// se vai usar vários diferentes CRIE DENTRO!!!
			for(int C = 0; C < 5; C++) {				
				vetAux[C] = matx[L][C];				
			}			
			Thread contando = new Exerc03(vetAux, tam, L); 
			contando.start();
		}
		
//===================================================================================================		
//======================================= IMPRIMINDO MATRIX =========================================
//===================================================================================================
		for(int L = 0; L < 3; L++) {
			for(int C = 0; C < 5; C++) {				
				System.out.print(matx[L][C] + "  ");
			}
			System.out.println();
		}	
		
	}

}
