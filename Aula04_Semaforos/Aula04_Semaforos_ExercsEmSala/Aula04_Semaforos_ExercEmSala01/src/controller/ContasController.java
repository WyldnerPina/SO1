package controller;

import java.util.concurrent.Semaphore;

public class ContasController extends Thread {
	private int IdCalc;
	
	private Semaphore semaforo;

	public ContasController(int threadID, Semaphore semaforo) {
		this.IdCalc = threadID;
		this.semaforo = semaforo;
	}

//==============================================================================================	
	public void run() {
		dividindo();
	}

//==============================================================================================	
	private void dividindo() {
		switch (IdCalc%3) {
		case 0:
			int tempoCalc0 = (int)((Math.random()*801)+200);
			int tempoBD0 = 1000;
			for(int i = 0; i<2; i++) {
				calculos(tempoCalc0);
//				--------------- INÍCIO SEÇÃO CRÍTICA ---------------
				try {
					semaforo.acquire();
					transacao(tempoBD0);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}finally{
					semaforo.release();
				}
//				----------------- FIM SEÇÃO CRÍTICA ----------------				
			}
			break;
			
		case 1:
			int tempoCalc1 = (int)((Math.random()*1001)+500);			
			int tempoBD1 = 1500;
			for(int i = 0; i<3; i++) {
				calculos(tempoCalc1);
//				--------------- INÍCIO SEÇÃO CRÍTICA ---------------
				try {
					semaforo.acquire();
					transacao(tempoBD1);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}finally{
					semaforo.release();
				}
//				----------------- FIM SEÇÃO CRÍTICA ----------------				
			}
			break;
			
		case 2:
			int tempoCalc2 = (int)((Math.random()*1001)+1000);
			int tempoBD2 = 1500;
			for(int i = 0; i<3; i++) {
				calculos(tempoCalc2);
//				--------------- INÍCIO SEÇÃO CRÍTICA ---------------
				try {
					semaforo.acquire();
					transacao(tempoBD2);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}finally{
					semaforo.release();
				}
//				----------------- FIM SEÇÃO CRÍTICA ----------------				
			}
			break;
		}
//		System.out.println("Calc " + calc);
	}

//==============================================================================================
	private void calculos(int tempo) {
		System.out.println("Id: " + IdCalc + " calculando");		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

//==============================================================================================	
	private void transacao(int tempo) {
		System.out.println("Id: " + IdCalc + " no BD");				
		try {
			sleep(tempo);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}
