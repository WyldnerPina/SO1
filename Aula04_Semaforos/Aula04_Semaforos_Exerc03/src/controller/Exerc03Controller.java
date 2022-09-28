package controller;

import java.util.concurrent.Semaphore;

public class Exerc03Controller extends Thread {
	private int id;
	private static int tamanhoGrid = 14;
	private static int grid[] = new int[tamanhoGrid];
	private static int aux[] = new int[tamanhoGrid];
	private static int carro[] = new int[tamanhoGrid];
	
	private static String[] escuderia  = new String[tamanhoGrid];
	
	private Semaphore semaforo;
	private Semaphore semaforoF;
	private Semaphore semaforoML;
	private Semaphore semaforoM;
	private Semaphore semaforoW;
	private Semaphore semaforoL;
	private Semaphore semaforoRB;
	private Semaphore semaforoS;

	public Exerc03Controller(int id, Semaphore sPista, Semaphore sF, Semaphore sML, Semaphore sM, Semaphore sW, Semaphore sL, Semaphore sRB, Semaphore sS) {
		this.id = id;
		this.semaforo = sPista;
		this.semaforoF = sF;
		this.semaforoML = sML;
		this.semaforoM = sM;
		this.semaforoW = sW;
		this.semaforoL = sL;
		this.semaforoRB = sRB;
		this.semaforoS = sS;
	}
// =========================================================================================

	
	
// =========================================================================================
	public void run() {
		equipes();
	}
// =========================================================================================
	
	
	
// =========================================================================================

	private void equipes() {
		int voltas = 3;
		
		
		if (id < 2) {
			escuderia[id] = "Ferrari";
			carro[id] = id + 1;
			
			for (int i = 0; i < voltas; i++) {
				System.out.println("Carro  " + (id + 1) + " == " + escuderia[id] + " esperando liberação");
				int tempo = 0;
//			--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
				try {
					semaforoF.acquire();
					tempo = naPista(escuderia, tempo);

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
				aux[id] = i;
			}
// ------------------------------------------------------------------------------------	
// ------------------------------------------------------------------------------------
		} else if (id >= 2 && id < 4) {
			escuderia[id] = "MacLaren";
			carro[id] = id + 1;
			
			for (int i = 0; i < voltas; i++) {
				System.out.println("Carro  " + (id + 1) + " == " + escuderia[id] + " esperando liberação");
				int tempo = 0;
//			--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
				try {
					semaforoML.acquire();
					tempo = naPista(escuderia, tempo);

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
					semaforoML.release();
				}
//			----------------- FIM SEÇÃO CRÍTICA ----------------
				aux[id] = i;
			}
// ------------------------------------------------------------------------------------	
// ------------------------------------------------------------------------------------			
		} else if (id >= 4 && id < 6) {
			escuderia[id] = "Mercedes";
			carro[id] = id + 1;
			
			for (int i = 0; i < voltas; i++) {
				System.out.println("Carro  " + (id + 1) + " == " + escuderia[id] + " esperando liberação");
				int tempo = 0;
//			--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
				try {
					semaforoM.acquire();
					tempo = naPista(escuderia, tempo);

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
					semaforoM.release();
				}
//			----------------- FIM SEÇÃO CRÍTICA ----------------
				aux[id] = i;
			}
// ------------------------------------------------------------------------------------	
// ------------------------------------------------------------------------------------
		} else if (id >= 6 && id < 8) {
			escuderia[id] = "Willians";
			carro[id] = id + 1;
			
			for (int i = 0; i < voltas; i++) {
				System.out.println("Carro  " + (id + 1) + " == " + escuderia[id] + " esperando liberação");
				int tempo = 0;
//			--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
				try {
					semaforoW.acquire();
					tempo = naPista(escuderia, tempo);

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
					semaforoW.release();
				}
//			----------------- FIM SEÇÃO CRÍTICA ----------------
				aux[id] = i;
			}
// ------------------------------------------------------------------------------------	
// ------------------------------------------------------------------------------------			
		} else if (id >= 8 && id < 10) {
			escuderia[id] = "Lotus";
			carro[id] = id + 1;
			
			for (int i = 0; i < voltas; i++) {
				System.out.println("Carro  " + (id + 1) + " == " + escuderia[id] + " esperando liberação");
				int tempo = 0;
//			--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
				try {
					semaforoL.acquire();
					tempo = naPista(escuderia, tempo);

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
					semaforoL.release();
				}
//			----------------- FIM SEÇÃO CRÍTICA ----------------
				aux[id] = i;
			}
// ------------------------------------------------------------------------------------	
// ------------------------------------------------------------------------------------	
		} else if (id >= 10 && id < 12) {
			escuderia[id] = "RedBull Racing";
			carro[id] = id + 1;
			
			for (int i = 0; i < voltas; i++) {
				System.out.println("Carro  " + (id + 1) + " == " + escuderia[id] + " esperando liberação");
				int tempo = 0;
//			--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
				try {
					semaforoRB.acquire();
					tempo = naPista(escuderia, tempo);

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
					semaforoRB.release();
				}
//			----------------- FIM SEÇÃO CRÍTICA ----------------
				aux[id] = i;				
			}
// ------------------------------------------------------------------------------------	
// ------------------------------------------------------------------------------------	
		} else {
			escuderia[id] = "Sauber";
			carro[id] = id + 1;
			
			for (int i = 0; i < voltas; i++) {
				System.out.println("Carro  " + (id + 1) + " == " + escuderia[id] + " esperando liberação");
				int tempo = 0;
//			--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
				try {
					semaforoS.acquire();
					tempo = naPista(escuderia, tempo);

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
					semaforoS.release();
				}
//			----------------- FIM SEÇÃO CRÍTICA ----------------
				aux[id] = i;				
			}
		}

		grid();
	}
// =========================================================================================

	
	
	
// =========================================================================================
	private int naPista(String[] escuderia, int tempo) {
//		--------------- INÍCIO SEÇÃO CRÍTICA ---------------		
		try {
			semaforo.acquire();
			System.out.println("Carro  " + (id + 1) + " da " + escuderia[id] + " entrando na pista");

			tempo = (int) ((Math.random() * 2001) + 4000);// tempo na pista

			try {
				sleep(tempo);
				System.err.println("===============" + escuderia[id] + "===============\n"
						+ "Carro  " + (id + 1) + " da "
						+ escuderia[id] + "\n"
						+ "Volta  " + (id + 1) + " = " + tempo + "\n"
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
	private void grid() {
		int cont = 0;
		int contAux = 0;
		
		while(cont < tamanhoGrid) {
			if(aux[cont] == 2) {
				contAux += 1;
			}
			cont++;
		}
		
		
		if(contAux == tamanhoGrid) {
			for (int i = 0; i < tamanhoGrid; i++) {				
				System.out.println("Melhor volta do piloto " + (i + 1) + " da " + escuderia[i] + " = " + grid[i]);
			}
			gridOficial();
		}		
	}
	// =========================================================================================

	
	
	
	// =========================================================================================	
	private void gridOficial() {
		try {
			sleep(500); // só um tempo pra não misturar com o anterior
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		
		for (int i = 0; i < tamanhoGrid; i++) {		
			for (int j = 0; j < tamanhoGrid; j++) {
				if(grid[i] < grid[j]) {
					int car = carro[i];
					int aux = grid[i];
					String auxi = escuderia[i];
					carro[i] = carro[j];
					grid[i] = grid[j];
					escuderia[i] = escuderia[j];
					carro[j] = car;
					grid[j] = aux;
					escuderia[j] = auxi;					
				}				
			}
		}
		
		
		for (int i = 0; i < tamanhoGrid; i++) {
			if(i == 0) {
				System.err.println("\n==================== Grid official F1 2022 ====================");
			}
			System.out.println((i + 1) + " colocado " + carro[i] + " " + escuderia[i] + " tempo: " + grid[i]);
			if(i == (tamanhoGrid - 1)) {
				try {
					sleep(500); // só um tempo pra não misturar com o anterior
					System.err.println("===============================================================");
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
				
			}
		}	
	}
}