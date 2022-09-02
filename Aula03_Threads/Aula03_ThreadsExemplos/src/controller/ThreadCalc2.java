package controller;

public class ThreadCalc2 extends Thread{	
		private int a, b, op;
	//================================ CONSTRUTOR ===================================	
		public ThreadCalc2(int w, int y, int op) {
			this.a = w;
			this.b = y;
			this.op = op;
		}
		
	//================================= MÉT RUN =====================================	
			public void run() {
				calc();
			}
		
	//========================= MÉT CRIADO PARA OPERAÇÕES ===========================	
		private void calc()  { 
			// há métodos para controlar a entrada das threads
			// o mais grosseiro e não usual, é por tempo (NÃO USAR)
			int tempo = 1000;// sleep é em miliseg então 1000 = 1s
			// é ruim pq o tempo varia de processador para processador então pra acertar vc 
			// acaba tendo q deixar o programa lento (o normal é muito mais rápido q segs)
			try {
				sleep(op * tempo);// sleep pede try catch
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			
			
			int resultado = 0;
			String operacao = "";
			
			switch (op) {
			case 0 :
				resultado = a + b;
				operacao ="+";
				break;
			case 1 :
				resultado = a - b;
				operacao ="-";
				break;
			case 2 :
				resultado = a * b;
				operacao ="*";
				break;
			case 3 :
				resultado = a / b;
				operacao ="/";
				break;
			}
			System.out.println("Com 1s: " + a + operacao + b + "=" + resultado);		
		}
}
