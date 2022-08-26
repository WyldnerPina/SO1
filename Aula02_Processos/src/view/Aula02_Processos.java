package view;

import controller.ProcessosController;

public class Aula02_Processos {

	public static void main(String[] args) {
		ProcessosController processos = new ProcessosController();
//=================================== DESCOBRINDO S.O. ==========================================
//===============================================================================================		
		//Se eu precisar usar processos em uma aplicacao, será diferente os comandos dependendo
		// do SO utilizado.			
		String so = processos.so();		
		System.out.println("S.O.: " + so);

		
//================================= CHAMANDO UM PROCESSO ========================================
//===============================================================================================
		// duas barras no lugar da normal por limitações em comandos ex \n 
		String process = "C:\\Windows\\write.exe";// SÓ COLOCAR O CAMINHO, do win pode ser o cód cmd
		// se errar o erro vai aparece no console "ERRO 2"
		processos.callProcess(process);

//=================================== CHAMANDO COMO ADM =========================================
//===============================================================================================
		// se não tiver como adm "ERRO 720"; somente no win é capaz de elevar usuário
		String process2 = "C:\\Windows\\regedit.exe";
		// roda normal, como adm, e se digita erradomostra erro
		processos.callProcess2(process2);
		
//===================================== LENDO UM PROCESSO =======================================
//===============================================================================================
		String process3 = "TASKLIST /FO TABLE";// comando cmd para chamar os processos em tabela
		processos.readProcess(process3);
		
		process3 = "PING -t10 www.google.com.br";// pingando google, com -t10 ele fica um tempo
		// se eu usar pra fazer média tenho o ping
		processos.readProcess(process3);
		
		process3 = "TRACERT -t10 www.google.com.br";// caminho do pacote
		// se eu usar pra fazer média tenho o ping
		processos.readProcess(process3);
		
//====================================== KILLING PROCESS ========================================
//===============================================================================================
		String parametro = "cmd.exe";// comando cmd para chamar os processos em tabela
		processos.killProcess(parametro);
	}

}
