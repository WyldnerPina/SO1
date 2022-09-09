package controller;

public class Exerc03 extends Thread {
	private int iD;
	private int tam;
	private int[] vet = new int[tam];
	
	public Exerc03(int[] vet, int tam, int L) {
		this.iD = L;
		this.tam = tam;
		this.vet = vet;
	}
	
	
	public void run() {		
		soma();		
	}
	
	private void soma() {		
		int soma = 0;
		
		switch(iD) {
		case 0 :			
			for(int cada : vet) {
				soma = soma + cada;
			}
			break;
		case 1 :
			for(int cada : vet) {
				soma = soma + cada;
			}			
			break;
		case 2 :
			for(int cada : vet) {				
				soma = soma + cada;
			}			
			break;			
		}
		System.out.print(iD + "==> (" + soma + ") ");
	}
}
