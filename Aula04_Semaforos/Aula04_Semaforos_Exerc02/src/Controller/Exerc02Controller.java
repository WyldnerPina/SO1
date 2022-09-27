package Controller;

import java.util.concurrent.Semaphore;

public class Exerc02Controller extends Thread{
	private int id;
	private Semaphore semaforo;
	
	public Exerc02Controller(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}
//=========================================================================================	

	
//=========================================================================================	
	public void run() {
		cruzamento();
//		--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
		try {
			semaforo.acquire();
			cruzando();			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}finally{
			semaforo.release();
		}	
//		----------------- FIM SEÇÃO CRÍTICA ----------------		
	}
//=========================================================================================		

	
//=========================================================================================		
	
	private void cruzamento() {		
		switch (id) {
		case 0:
			String sentidoN = "Norte";
			System.out.println("Carro  " + id + " chegou no cruzamento pelo " + sentidoN);	
			break;
		case 1:
			String sentidoS = "Sul";
			System.out.println("Carro  " + id + " chegou no cruzamento pelo " + sentidoS);
			break;
		case 2:
			String sentidoL = "Leste";
			System.out.println("Carro  " + id + " chegou no cruzamento pelo " + sentidoL);
			break;
		case 3:
			String sentidoO = "Oeste";
			System.out.println("Carro  " + id + " chegou no cruzamento pelo " + sentidoO);
			break;		
		}
	}	
//=========================================================================================		

	
//=========================================================================================	
		private void cruzando() {
			System.out.println("O Carro " + id + " está cruzando");

			int tempo = (int) (Math.random() * 1001);
			try {
				sleep(tempo);
				System.out.println("Carro  " + id + " cruzou");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
//=========================================================================================
}

