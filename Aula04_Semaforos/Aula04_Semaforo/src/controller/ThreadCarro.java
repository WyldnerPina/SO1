package controller;

import java.util.concurrent.Semaphore;// importando semaforo

public class ThreadCarro extends Thread {
	private int idCarro;
	private static int posChegada;
	private static int posSaida;
	
	private Semaphore semaforo;// criando semaforo
	

	public ThreadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

//=========================================================================================	
	public void run() {
		carroAndando();
//		--------------- INÍCIO SEÇÃO CRÍTICA ---------------
		// vai tentar pegar o semaforo, se conseguir roda carro estacionado 
		// se não conseguir espera em fila
		try {
			semaforo.acquire();//cód q chama semaforo
			carroEstacionado();			
			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}finally{// se der erro vai para o catch, mas se não der release dá erro (semaforo preso)
			// e nenhuma outra thread vai conseguir rodar → DEADLOCK
			// então usamos finally, onde roda try ou catch e depois o finally.
			// e finalizamos a seção crítica
			semaforo.release();// para finalisar seção crítica.
		}
		
		
//		----------------- FIM SEÇÃO CRÍTICA ----------------
		carroSaindo();

	}

//=========================================================================================	
/* Math.random() = 0 até 0,99999999...	
 de 0 até 1000 => multiplico por 1001 e vou ter de 0 até 1000,9999... então converto e só 
 pego parte inteira. 
*/	
	private void carroAndando() {
		int distanciaTotal = (int)((Math.random()*1001) + 1000);// de 1000 até 2000		
		int distanciaPercorrida = 0;
		int deslocamento = 100;
		int tempo = 1000;
		
		while(distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento; // distanciaPercorrida = distanciaPercorrida + deslocamento
			// estou somando o deslocamento a cada segundo (tempo = 1000)... 100"m"/s
			// após somar preciso simular o tempo			
			try {
				sleep(tempo);// tempo sempre com try catch
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			// a cada volta vou printar qnto ele andou
			System.out.println("Carro " + idCarro + " já andou " + distanciaPercorrida + "m");
		}
		// AQUI TODOS ACESSAM, NÃO É CRÍTICO
		posChegada++;// aqui qndo o carro chegar eu insiro ele na posChegada
		System.out.println("O Carro " + idCarro + " foi o " + posChegada + " º a chegar");// printo quem chegou
	}


//=========================================================================================	
	//ESSE É CRÍTICO PQ SÓ PODE ACONTECER PRA 3 CARROS. SEÇÃO CRÍTICA É UMA FUNÇÃO
	private void carroEstacionado() {
		System.out.println("Carro " + idCarro + " estacionou");
		// vou inserir o tempo q o carro vai ficar estacionado
		int tempo = (int)((Math.random()*2001)+1000);// do 0 até o 2000... somando 1000 = do 1000 até 3000
		try {
			sleep(tempo);// tempo parado
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

// =========================================================================================
	private void carroSaindo() {
		posSaida++;
		System.out.println("Carro " + idCarro + " foi o " + posSaida + " º a sair");
	}
}
