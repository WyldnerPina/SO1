package view;

import controller.ThreadCalc;
import controller.ThreadCalc2;
import controller.ThreadId;

public class Main {

	public static void main(String[] args) {
//================================== THREAD ID ======================================
		for (int idThread = 0; idThread < 5; idThread++) {
//			ThreadId threadId = new ThreadId(idThread); // aqui e a de baixo estão corretas
			Thread threadId = new ThreadId(idThread); // fazemos assim pra mostrar q o mét é thread
			threadId.start();// start chama a run
		}

//================================= THREAD CALC =====================================
		int a = 10;
		int b = 2;
		for (int op = 0; op < 4; op++) {
			Thread threadCalculos = new ThreadCalc(a, b, op);
			threadCalculos.start();
		}
	

//================================= THREAD CALC =====================================
		int w = 10;
		int y = 2;
		for(int op = 0; op < 4; op++){
			Thread threadCalculos2 = new ThreadCalc2(w, y, op);
			threadCalculos2.start();
		}
	}
}
