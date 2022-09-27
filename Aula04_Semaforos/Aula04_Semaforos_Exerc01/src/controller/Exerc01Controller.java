package controller;

import java.util.concurrent.Semaphore;

public class Exerc01Controller extends Thread {
	private int id;
	private Semaphore semaforo;

	public Exerc01Controller(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

//=========================================================================================	
	public void run() {
		corredor();
//		--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
		try {
			semaforo.acquire();
			cruzarPorta();
			System.out.println("O indivíduo " + id + " cruzou a porta");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
//		----------------- FIM SEÇÃO CRÍTICA ----------------
	}
//=========================================================================================
	
	
//=========================================================================================		
	private void corredor() {
		int tam = 200;
		switch (id) {
		case 0:
			int passo0 = (int) ((Math.random() * 2) + 4);
			int percorrido0 = 0;
			System.out.println(passo0);
			while (percorrido0 < tam) {
				try {
					sleep(1000);
					percorrido0 += passo0;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
			break;
		case 1:
			int passo1 = (int) ((Math.random() * 2) + 4);
			int percorrido1 = 0;
			System.out.println(passo1);
			while (percorrido1 < tam) {
				try {
					sleep(1000);
					percorrido1 += passo1;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}		
			break;
		case 2:
			int passo2 = (int) ((Math.random() * 2) + 4);
			int percorrido2 = 0;
			System.out.println(passo2);
			while (percorrido2 < tam) {
				try {
					sleep(1000);
					percorrido2 += passo2;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}		
			break;
		case 3:
			int passo3 = (int) ((Math.random() * 2) + 4);
			int percorrido3 = 0;
			System.out.println(passo3);
			while (percorrido3 < tam) {
				try {
					sleep(1000);
					percorrido3 += passo3;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}		
			break;		
		}
	}
//=========================================================================================		
	
	
	
//=========================================================================================	
	private void cruzarPorta() {
		System.out.println("O indivíduo " + id + " está entrando");

		int tempo = (int) ((Math.random() * 1001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//=========================================================================================		

}
