package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public KillController() {
		super();
	}
//===============================================================================================
//========================================== S.O. ===============================================
//===============================================================================================
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
//===============================================================================================
//==================================== LISTA PROCESSOS ==========================================
//===============================================================================================
	public void listaProcessos() {
		String os = os();
		String comando;
		if(os.contains("Win")) {
			comando = "TASKLIST /FO TABLE";
		} else {
			comando = "ps -ef";
		}
		
//===============================================================================================		
		
		try {
			Process p = Runtime.getRuntime().exec(comando);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);

			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//===============================================================================================	
//=================================== KILLING PROCESS PID =======================================
//===============================================================================================	
	public void mataPid(String parametro) {
		String os = os();		
		String cmdPid;
		if(os.contains("Win")) {
			cmdPid = "TASKKILL /PID";			
		} else {
			cmdPid = "kill -9";			
		}		
//===============================================================================================
		
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		try {// PID
			pid = Integer.parseInt(parametro);			
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
			executaComando(buffer.toString());
		} catch (NumberFormatException e) {//NOME	
			System.err.println("Insira apenas números");
		}
		
	}

	
//===============================================================================================	
//================================== KILLING PROCESS NAME =======================================
//===============================================================================================	
	public void mataNome(String parametro) {
		String os = os();	
		String cmdNome;
		if(os.contains("Win")) {			
			cmdNome = "TASKKILL /IM";	
		} else {			
			cmdNome = " pkill -f";
		}		
//===============================================================================================
		
		StringBuffer buffer = new StringBuffer();
		
		try {// PID
			Integer.parseInt(parametro);			
			System.err.println("digite um nome");
		} catch (NumberFormatException e) {//NOME
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(parametro);
			executaComando(buffer.toString());
		}
	}
	

//===============================================================================================
//===================================== EXECUTA COMANDO =========================================
//===============================================================================================
	public void executaComando(String comando) {

		try {
			Runtime.getRuntime().exec(comando);
		} catch (Exception e) {
			String msgErro = e.getMessage();
			System.err.println(msgErro);
		}

	}	
}
