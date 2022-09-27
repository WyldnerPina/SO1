package controller;

import java.util.concurrent.Semaphore;

public class ShowController extends Thread {
	private int id;
	private Semaphore semaforo;
	private static int ingressos = 100;

	public ShowController(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}
//=========================================================================================	
	
	
	

//=========================================================================================	
	public void run() {	

		if (isLogin()) {			
			if(isBought()) {
//		--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
				try {
					semaforo.acquire();					
						ingressos();					
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
//		----------------- FIM SEÇÃO CRÍTICA ----------------
			}
		}
	}
//=========================================================================================	
	
	
	

//=========================================================================================		
	private boolean isLogin() {
		System.out.println("Pessoa " + id + " logando...");
		int tempo = (int) ((Math.random() * 1951) + 50);// de 50 até 2000		
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//==========================================================================================
		if (tempo > 1000) {
			System.err.print("Time out!! ");
			System.out.println("Pessoa " + id + ", não poderá prosseguir para compra");
			return false;
		} else {			
			return true;
		}
	}
//=========================================================================================	
	
	
	

//=========================================================================================		
	private boolean isBought() {	
		int tempo = (int) ((Math.random() * 2001) + 1000);
		
		System.out.println("Pessoa " + id + " Está esperando para efetuar compra...");
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
// ==========================================================================================
		if (tempo > 2500) {
			System.err.print("Time out!! ");
			System.out.println("Pessoa " + id + ", não poderá prosseguir para compra");
			return false;
		} else {			
			return true;
		}

	}
//=========================================================================================	
	
	
	
	
// ==========================================================================================	
	private void ingressos() {		
		int qntCompra = (int) ((Math.random() * 3) + 1);
		
		System.out.print("Pessoa " + id + " quer " + qntCompra);
		System.out.println(". Verificando qntidade de ingressos para efetuar compra");
				
		if(qntCompra <= ingressos) {
			ingressos = ingressos - qntCompra;
			System.out.println("Parabéns usuário " + id + ", você conseguiu comprar!!!" );
//			System.err.println("ingressos restantes " + ingressos);
		}else if(ingressos > 0) {
			System.err.println("Pessoa " + id + ", desistiu por não ter a qntidade que queria");
		}else {
			System.err.println("Pessoa " + id + ". Não há mais ingressos");
		}
	}

}
