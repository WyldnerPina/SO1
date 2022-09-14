package controller;

import java.util.concurrent.Semaphore;

public class CozimentoController extends Thread {

	private int idPratos;

	private Semaphore semaforo;

	public CozimentoController(int idPratos, Semaphore semaforo) {
		this.idPratos = idPratos;
		this.semaforo = semaforo;
	}

// ==============================================================================================
	public void run() {
		praCozinha();
	}

// ==============================================================================================
	private void praCozinha() {
		String nomePrato ="";
		switch (idPratos % 2) {
		case 0:
			nomePrato = "Lasanha a Bolonhesa";
			System.out.println(nomePrato + idPratos + " Iniciou");
			
			
			int t0 = (int)((Math.random()*301)+500);
			int temp = 10;
			int percentual = 0;			
			while (temp < t0 ) {
				try {					
					sleep(temp);
					if(temp%100 == 0) {						
						percentual = (temp*100)/t0;
						System.out.println(nomePrato + " " +  idPratos + "está " + percentual + "% em preparação");
					}
					temp += 10;
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			}
			
			
			try {
				sleep(t0);
			} catch (InterruptedException e1) {				
				e1.printStackTrace();
			}
						
			System.out.println(nomePrato + idPratos + " Pronto!!");
			break;
		case 1:
			nomePrato = "Sopa de Cebola";
			System.out.println(nomePrato + idPratos + " Iniciou");
			
			int t1 = (int)((Math.random()*601)+600);
			
			int temp1 = 10;
			int percentual1 = 0;			
			while (temp1 < t1 ) {
				try {					
					sleep(temp1);
					if(temp1%100 == 0) {						
						percentual1 = (temp1*100)/t1;
						System.out.println(nomePrato + " " +  idPratos + "está " + percentual1 + "% em preparação");
					}
					temp1 += 10;
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			}
			
			try {
				sleep(t1);
			} catch (InterruptedException e1) {				
				e1.printStackTrace();
			}
				
			System.out.println(nomePrato + idPratos + " Pronto!!");
			break;
		}
		
		int tempo = 500;
//		--------------- INÍCIO SEÇÃO CRÍTICA ---------------
		try {
			semaforo.acquire();
			sleep(tempo);
			System.out.println(nomePrato + idPratos + " ENTREGUE!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
//		----------------- FIM SEÇÃO CRÍTICA ----------------		
	}
}
