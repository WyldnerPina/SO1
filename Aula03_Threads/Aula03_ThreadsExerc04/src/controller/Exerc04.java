package controller;

public class Exerc04 extends Thread {
	private int sapo;
	int distMx = 100;
//	int maxPulo = (int)(Math.random()*11);
	private static int colocacao = 0;
	
	
	public Exerc04(int threadID) {
		this.sapo = threadID;
	}
	
	public void run() {	
		pulo();
	}
	
	private void pulo() {	
		switch(sapo) {
		case 0 :
			int posicao0 = 0;
			while(posicao0 <= distMx) {
				posicao0 = posicao0 + (int)(Math.random()*11);
				try {
					sleep(100);// 0,1 seg de espera até próxima soma
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			colocacao++;			
			break;
		case 1 :
			int posicao1 = 0;
			while(posicao1 <= distMx) {
				posicao1 = posicao1 + (int)(Math.random()*11);
				try {
					sleep(100);// 0,1 seg de espera até próxima soma
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			colocacao++;				
			break;
		case 2 :
			int posicao2 = 0;
			while(posicao2 <= distMx) {
				posicao2 = posicao2 + (int)(Math.random()*11);
				try {
					sleep(100);// 0,1 seg de espera até próxima soma
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			colocacao++;			
			break;
		case 3 :
			int posicao3 = 0;
			while(posicao3 <= distMx) {
				posicao3 = posicao3 + (int)(Math.random()*11);
				try {
					sleep(100);// 0,1 seg de espera até próxima soma
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			colocacao++;		
			break;	
		case 4 :
			int posicao4 = 0;
			while(posicao4 <= distMx) {
				posicao4 = posicao4 + (int)(Math.random()*11);
				try {
					sleep(100);// 0,1 seg de espera até próxima soma
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			colocacao++;			
			break;	
		}
		System.out.println("\nSapo " + sapo + " terminou em " + colocacao + " lugar");
//**************************************************************************//
		// como todos acessam colocação sem semaforo é possível que eles empatem
	}
	
	//semaforo
}
