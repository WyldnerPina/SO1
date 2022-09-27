package controller;

import java.util.concurrent.Semaphore;

public class Exerc03Controller extends Thread{
	private int id;
	private Semaphore semaforo;
	public Exerc03Controller(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}
	
//=========================================================================================	
	public void run() {
		carroAndando();
//		--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
		try {
			semaforo.acquire();
			carroEstacionado();			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}finally{
			semaforo.release();
		}	
//		----------------- FIM SEÇÃO CRÍTICA ----------------
//		carroSaindo();
	}
	
	
	
	
	
//=========================================================================================		
	private void carroAndando() {
//		int distanciaTotal = (int)((Math.random()*1001) + 1000);
	}
	
	
	
	
//=========================================================================================		
	private void carroEstacionado() {
		System.out.println("Carro " + id + " estacionou");
		
		int tempo = (int)((Math.random()*2001)+1000);// do 0 até o 2000... somando 1000 = do 1000 até 3000
		try {
			sleep(tempo);// tempo parado
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

}
