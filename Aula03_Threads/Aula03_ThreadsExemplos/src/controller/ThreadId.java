package controller;

// CARACTERÍSTICAS
// → extends Thread: qndo coloco ele passa a ser uma classe do tipo thread, mas é preciso herdar thread
// para ver dir(aqui no cód)>Source>Override/implement Methods (alt+shift+s > overrid...)
// com isso é possível ver os métodos herdados

// → Parâmetros por construtor
// → só executado o q está no método run
 
public class ThreadId extends Thread{
	private int idThread;
	
	// construtor por onde os parâmetro vêm
	public ThreadId(int iDthread) {
		this.idThread = iDthread; // o parâmetro passado para esse método vão para a var definida
		// nessa classe inteira
	}
	
	// e o método run	
	public void run() {
		System.out.println(idThread);// aqui eu printo a var		
	}
}
