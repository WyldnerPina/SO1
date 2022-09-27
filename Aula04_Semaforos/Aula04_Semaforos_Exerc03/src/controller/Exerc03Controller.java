package controller;

import java.util.concurrent.Semaphore;

public class Exerc03Controller extends Thread {
	private int id;
	private static int grid[] = new int[2];
	private Semaphore semaforo;
	private Semaphore semaforoF;
	private Semaphore semaforoML;
	private Semaphore semaforoM;
	private Semaphore semaforoW;
	private Semaphore semaforoL;
	private Semaphore semaforoRB;
	private Semaphore semaforoS;

	public Exerc03Controller(int id, Semaphore semaforoPista, Semaphore semaforoEquipes) {
		this.id = id;
		this.semaforo = semaforoPista;
		this.semaforoF = semaforoEquipes;
		this.semaforoML = semaforoEquipes;
		this.semaforoM = semaforoEquipes;
		this.semaforoW = semaforoEquipes;
		this.semaforoL = semaforoEquipes;
		this.semaforoRB = semaforoEquipes;
		this.semaforoS = semaforoEquipes;
	}
// =========================================================================================

	
	
	
// =========================================================================================
	public void run() {
		equipes();
	}
// =========================================================================================

	
	
	
// =========================================================================================

	private void equipes() {
		String escuderia = "";
		int voltas = 3;

		if (id < 2) {
			escuderia = "Ferrari";
			for (int i = 0; i < voltas; i++) {
				System.out.println("Carro  " + (id + 1) + " == " + escuderia + " esperando liberação");
				int tempo = 0;
//			--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
				try {
					semaforoF.acquire();
					tempo = naPista(escuderia, tempo, i);

					if (grid[id] == 0) {
						grid[id] = tempo;
					} else {
						if (tempo < grid[id]) {
							grid[id] = tempo;
						}
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforoF.release();
				}
//			----------------- FIM SEÇÃO CRÍTICA ----------------
			}

//		} else if (id >= 2 && id < 4) {
//			escuderia = "MacLaren";
//			System.out.println("Carro  " + (id+1) + " == " + escuderia);
//		} else if (id >= 4 && id < 6) {
//			escuderia = "Mercedes";
//			System.out.println("Carro  " + (id+1) + " == " + escuderia);
//		} else if (id >= 6 && id < 8) {
//			escuderia = "Willians";
//			System.out.println("Carro  " + (id+1) + " == " + escuderia);
//		} else if (id >= 8 && id < 10) {
//			escuderia = "Lotus";
//			System.out.println("Carro  " + (id+1) + " == " + escuderia);
//		} else if (id >= 10 && id < 12) {
//			escuderia = "RedBull Racing";
//			System.out.println("Carro  " + (id+1) + " == " + escuderia);
//		} else {
//			escuderia = "Sauber";
		}

		grid(grid, escuderia);
	}
// =========================================================================================

	
	
	
// =========================================================================================
	private int naPista(String escuderia, int tempo, int i) {
//		--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
		try {
			semaforo.acquire();
			System.out.println("Carro  " + (id + 1) + " da " + escuderia + " entrando na pista");

			tempo = (int) ((Math.random() * 1001) + 1000);

			try {
				sleep(tempo);
				System.err.println("===============" + escuderia + "===============\n" + "Carro  " + (id + 1) + " da "
						+ escuderia + "\n" + "Volta  " + (i + 1) + " = " + tempo + "\n"
						+ "======================================");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
//		----------------- FIM SEÇÃO CRÍTICA ----------------
		return tempo;
	}
// =========================================================================================

	
	
	
// =========================================================================================
	private void grid(int grid[], String escuderia) {
		int cont = 0;
		do {
			for (int i = 0; i < grid.length; i++) {
				if(grid[i] == 0) {
				   cont += 1;	
				}
				System.out.println("Volta do piloto " + (i + 1) + " da " + escuderia + " = " + grid[i]);
			}
		}while(cont != 0);

		
//		ajustarGrid();
		
	}
	
	
	private void ajustarGrid() {
		
		
	}
}