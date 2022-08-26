package controller;

public class Tarefa01 {
	public Tarefa01() {
		super();
	}

	public void Tarefa() {
		String a = "a";
		long soma = 0;
		int tam = 100000;
		String vet[] = new String[tam];

		while (tam >= 1000) {
			long tempInicialS = System.nanoTime();
			soma = 0;
			for (int i = 0; i < tam; i++) {				
				vet[i] = a;
				soma++;
			}
			long tempFinalS = System.nanoTime();

			double tempoS = (tempFinalS - tempInicialS) / Math.pow(10, 9);// para segundos
			System.out.println("tempo de " + tam + " execucoes= " + tempoS + "s");

			System.out.println("\nSoma = " + soma);
			System.out.println("=====================================================\n");
			tam = tam / 10;			
		}
		
	}
}
