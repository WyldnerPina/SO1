package controller;

public class ThreadVetor extends Thread{
	private int num;
	private int tam;
	private int[] vet = new int[tam];
	
//===================================================================================================	
	public ThreadVetor(int[] vet, int tam, int num) {
		this.num = num;
		this.tam = tam;
		this.vet = vet;				
	}
	
//===================================================================================================	
	public void run() {		
		passarVet();		
	}
	
//===================================================================================================	
	private void passarVet() {
		int soma = 0;
		double tempo = 0;
		long tempInicial, tempFinal;
		String parImpar = "";
		
		switch(num%2) {
		case 0 ://===================================================== PAR
			parImpar = "Par";
			tempInicial = System.nanoTime();
			for(int i = 0; i < tam; i++) {
				soma = soma + vet[i];// como não fazer nada
			}
			tempFinal = System.nanoTime();
			tempo = (tempFinal - tempInicial)/Math.pow(10, 9);
			break;
		case 1 ://=================================================== ÍMPAR
			parImpar = "Ímpar";
			tempInicial = System.nanoTime();
			for(int cada : vet) {
				soma = soma + cada;
			}
			tempFinal = System.nanoTime();
			tempo = (tempFinal - tempInicial)/Math.pow(10, 9);
			break;
		}
		System.out.println(num + " → Velocidade do " + parImpar + " é: " + tempo + ".s");
	}
}
