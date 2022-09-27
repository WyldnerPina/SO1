package controller;

import java.util.concurrent.Semaphore;

public class AeroController extends Thread {
	private int id;
	private Semaphore semaforoN;
	private Semaphore semaforoS;

	public AeroController(int id, Semaphore semaforo,Semaphore semaforo2) {
		this.id = id;
		this.semaforoN = semaforo;
		this.semaforoS = semaforo2;
	}
//=========================================================================================
	

//=========================================================================================	
	public void run() {
		String pista = "Sul";
		int aux = (int) (Math.random() * 2);
		if(aux == 0) {
			pista = "Norte";
			System.out.println("Avião " + id + " vai para a pista " + pista);
			controleTrafegoNorte();
		}else {			
			System.out.println("Avião " + id + " vai para a pista " + pista);
			controleTrafegoSul();
		}
	}
//=========================================================================================
	
	
//=========================================================================================	
	private void controleTrafegoNorte() {
//		--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
		try {
			semaforoN.acquire();
			procedimento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoN.release();
		}
//		----------------- FIM SEÇÃO CRÍTICA ----------------
	}	
//=========================================================================================
	
	
//=========================================================================================	
	private void controleTrafegoSul() {
//		--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
		try {
			semaforoS.acquire();
			procedimento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoS.release();
		}
//		----------------- FIM SEÇÃO CRÍTICA ----------------
	}	
//=========================================================================================

	
//=========================================================================================	
	private void procedimento() {
		manobra();
		taxiar();
		decolagem();
		afastamento();
	}
//=========================================================================================

	
//=========================================================================================	
	private void manobra() {
		System.out.println("Avião " + id + ", em manobra ");
		int tempo = (int) ((Math.random() * 4001) + 3000);

		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//=========================================================================================

	
//=========================================================================================	
	private void taxiar() {
		System.out.println("Avião " + id + ", na fase de taxiar");
		int tempo = (int) ((Math.random() * 5001) + 5000);

		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//=========================================================================================

	
//=========================================================================================
	private void decolagem() {
		System.out.println("Avião " + id + ", decolando");
		int tempo = (int) ((Math.random() * 3001) + 1000);

		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//=========================================================================================

	
//=========================================================================================	
	private void afastamento() {
		System.out.println("Avião " + id + ", se afastando");
		int tempo = (int) ((Math.random() * 5001) + 3000);

		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Avião " + id + " decolou");
	}
//=========================================================================================
}
