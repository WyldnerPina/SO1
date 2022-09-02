package controller;

public class ThreadCalc extends Thread {
	private int a, b, op;
//================================ CONSTRUTOR ===================================	
	public ThreadCalc(int a, int b, int op) {
		this.a = a;
		this.b = b;
		this.op = op;
	}
	
//================================= MÉT RUN =====================================	
		public void run() {
			calc();
		}
	
//========================= MÉT CRIADO PARA OPERAÇÕES ===========================	
	private void calc() { // classe principal chama a thread e a thread a calc, por isso private
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
		System.out.println("TID #" + getId() + ">>" + a + operacao + b + "=" + resultado);		
	}
}
