package controller;

public class OperacoesController {
//===========================================================================================================	
	// sempre q criamos a classe temos q criar construtor:
	public OperacoesController() {// se digitar só o nome e ctrl+space vc agiliza o processo
		super(); // significa q a classe vai seguir as operações da super classe o OBjet (toda classe Java tem)
		// mas posso deixar sem
	}	
	
	
//===========================================================================================================		
//========================================== CONCATENA VAR STRINGS ==========================================
	public void concatenaString() {
		String cadeia = "";
		
		long tempInicial = System.nanoTime(); // retorno em nanosegundos
		//long tempInicial = System.currentTimeMillis(); // retorno em milessegundos
		
		for (int i = 0; i < 1000; i++) {
			cadeia = cadeia + "a";// como tô somando string tenho q por entre aspas		
		}	
		
		long tempFinal = System.nanoTime(); // retorno em nanosegundos
		//long tempFinal = System.currentTimeMillis(); // retorno em milessegundos
		
		double tempo = (tempFinal - tempInicial)/Math.pow(10, 9);// é double pq tem divisão. 
		//A divisão por 10^9 é pra voltar para segundos. 
		System.out.println("String → " + tempo + "s");
	}
	

	
//===========================================================================================================		
//========================================== CONCATENA VAR STRINGS ==========================================
	public void concatenaBuffer() {
		StringBuffer bufado = new StringBuffer();// só instanciar e já pode usar 
		
		long tempInicial = System.nanoTime(); // retorno em nanosegundos
		//long tempInicial = System.currentTimeMillis(); // retorno em milesegundos
		
		for (int i = 0; i < 1000; i++) {
				bufado.append("a");// só coloca no final do buffer a letra
		}	
		
		long tempFinal = System.nanoTime(); // retorno em nanosegundos
		//long tempFinal = System.currentTimeMillis(); // retorno em milessegundos
		
		double tempo = (tempFinal - tempInicial)/Math.pow(10, 9);// é double pq tem divisão. 
		//A divisão por 10^9 é pra voltar para segundos. 
		System.out.println("Buffer → " + tempo + "s");
	}
	
	

	
//===========================================================================================================		
//=============================== RECEBE FRASE, DIVIDE PALAVRAS E AS IMPRIME ================================
		public void divideFrase(String frase) {
			String[] vetorPalavras = frase.split(" "); //cada vez q ele encontrar "espaço", ele vai dar um split
			// para uma nova posição no vetor. Meu vetor muda então dependendo da frase.
			
			// NÃO RECOMENDADO → pq toda vez ele percorre o vetor pra saber qntas posições e se for menor, então
			// entra no for. isso é lento
			for (int i = 0; i < vetorPalavras.length; i++) {
					
			}
			
			// RECOMENDADO → aqui ele só lê o tamanho uma vez e atribui à var q fica com aquele valor
			int tam = vetorPalavras.length;
			for (int i = 0; i < tam; i++) {
				
			}
			
			// FORMA MAIS RECOMENDADA → FOREACH ← sintaxe:
			// for(tipoDado var: vetor) → cada posição do vetor vai ser colocado em uma var daquele tipo
			for(String palavra: vetorPalavras) {
				System.out.println(palavra);				
			}
	
		}	
//===========================================================================================================	
}




/*
//=========================================================================================================== 
============================================== ATALHOS ECLIPSE ==============================================
Ctrl+D = apaga a linha toda
Ctrl+1 = cria uma var pra receber algo (se não tiver nada não dá sugestão)
sysout+Space = System.out.print
Ctrl+barra = comenta a linha toda
*/