package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;

public class ProcessosController {
	public ProcessosController() {
		super();
	}

//=================================== DESCOBRINDO S.O. ==========================================
//===============================================================================================
	// Retorna o S.O. q está em execução
	public String so() {
		// todos os códs abaixo são do tipo STRING
		String os = System.getProperty("os.name");// pega o nome do sistema operacional
		String arquitetura = System.getProperty("os.arch");// pega a arquitetura
		String versao = System.getProperty("os.version");// pega a versão

		return os + " - v. " + versao + " - arq " + arquitetura;// retorna tudo concatenado
	}
	

//================================= CHAMANDO UM PROCESSO ========================================
//===============================================================================================
	public void callProcess(String process) {
		try {
			// ESSA É A LINHA Q ELE TENTA EXECUTAR, SE ERRADO VAI PRO CATCH
			Runtime.getRuntime().exec(process);// precisa de tratamento pq qq erro ao digitar buga
			// só esse erro comprometeria toda a aplicacao, por isso o tratamento
		} catch (Exception e) {// o erro/excessão vai ser inserido na var "e", e pode recupera-lo
			// LINHAS DE TRATAMENTO DO ERRO
			// ou faço um tratamento ou retorno um erro
			// a classe "Exception" é a genérica, há várias outras mais específicas
			// EX: NullPointerException; IOException;
			// qndo vc gera o runtime se passar o mouse é possível ver o erro q é
			// IOException aqui
			// mas usaremos o genérico

			e.printStackTrace();// vai printar no console o erro
		}

	}

	
//=================================== CHAMANDO COMO ADM =========================================
//===============================================================================================
	public void callProcess2(String process) {
		try {
			Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			String msgErro = e.getMessage();// pega somente a msg de erro (1ª linha)
			System.err.println(msgErro);// imprime a msg só q em vermelho

			if (msgErro.contains("740")) {// diferente do eguals q compara o valor exato,
				// contains só verifica se contém ali no meio. e nesse caso usamos o nº do erro
				// já q dependendo o computador a msg pode aparecer em outro idioma
				// COMO AQUI É ERRO DE ELEVAÇÃO DO USUÁRIO, ENTÃO:

				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");// uso o cód do win para elevar aplicação como adm
				buffer.append(" ");// se esquecer o espaço dá erro, por isso feito separado, só pra lembrar
				buffer.append(process);// e o processo pra elevar

				// PARA EXECUTAR PROCESSO NOVAMENTE
				try {
					Runtime.getRuntime().exec(buffer.toString());// o buffer tem q ser convertido pra string
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}else { // CASO A MSG NÃO SEJA 740
				System.err.println(msgErro);
			}
		}

	}
	
	
//===================================== LENDO UM PROCESSO =======================================
//===============================================================================================
	public void readProcess(String process){
		try {
			Process p = Runtime.getRuntime().exec(process);// enqnto processo em execucao var
			//tipo precesso recebe os dados do mesmo
			
			// só q não dá pra saber q dados estão entrando 
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);  
			
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null){
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
	
	
//====================================== KILLING PROCESS ========================================
//===============================================================================================
	public void killProcess(String parametro) {
		String cmdPid = "TASKKILL /PID";// Matar processo pelo id no win
		String cmdNome = "TASKKILL /IM";// matar pelo nome win
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		// o parâmetro pode ser número ou escrito, uso Try..catch
		try {
			pid = Integer.parseInt(parametro);// se der certo a conversão mato ele aqui
			
			// TASK KILL /PID num
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);			
		} catch(NumberFormatException e) {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(parametro);
		}
		
		callProcess2(buffer.toString());		 
	}
}
