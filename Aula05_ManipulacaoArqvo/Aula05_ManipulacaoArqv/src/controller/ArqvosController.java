package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;// sempre java io para diretórios ou arqvos
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArqvosController implements IArqvosController {
	// se tivesse algo para passar para contrutor ctrl+3 > digira contructor e seleciona pra criar
	public ArqvosController() {
		super();
	}
	
	
//======================================= Ler Diretorio =======================================
//=============================================================================================
	public void readDir(String path) throws IOException {
		File dir = new File(path);// colocando o caminho do diretório; poderia ser "C:\\Windows\\ ....", como vai recerber de outro lugar
		// foi feito assim, mas e se a pessoa digitou um arqv "C:\\Windows\\write.exe", preciso então fazer uma validação
		
		// se existir e for diretório é o q queremos
		if(dir.exists() && dir.isDirectory()) {// exists retorna boolean, mas aqui tbm tem q ser diretório
			File[] files = dir.listFiles();//retorna um vetor de Files, todos os diretórios e arqvos no primeiro nível vão aparecer
			// o tipo file tem várias operações → pegar nome do arqv ou diretorio, pasta o caminho, caminho absoluto, propriedades do arqvo
			// qndo modificado, se oculto, tam do arqv, criar, listar, excluir etc.
			
			// VOU LISTAR TODO O VETOR CRIADO E SE FOR DIRETÓRIO VAI APARECER COM <DIR> 
			for(File f : files) {
				if(f.isFile()) {
					System.out.println("     \t" + f.getName());
				}else {
					System.out.println("<DIR> \t" + f.getName());
				}
			}
			
			
		}else {
			throw new IOException("Diretório inválido");
		}
	}
	
	
//======================================== Criar Arqvo ========================================
//=============================================================================================
	public void createFile(String path, String name) throws IOException {
		File dir = new File(path);// caminho
		File arq = new File(path, name + ".txt");// nome arqv => poderia ter colocado o caminho "C:\\Windows\\"
												// ou ("C:\\Windows", "write.exe"); onde um argumento é o caminho do dir e outro nome do arqv
												// formato poderia ser .csv → o de planilha, usa-se o ";" para separar em colunas
		// pra criar arqv não precisa existir, mas dir sim!
		if(dir.exists() && dir.isDirectory()) {
			 boolean existe = false; // se arqv existir, não exite oO; pra criar partimos de q ele não existe se existir mudo a condição dele
			 						// se existir vai fazer um append, se não write
			 
			 if(arq.exists()) {//condição de existência
				 existe = true;
			 }
			 String conteudo = geraTXT();
			 FileWriter fileWriter = new FileWriter(arq, existe);//responsável por abrir arqv e definir operação write ou append
			 // se eu não passar o boolean existe ele sempre vai gravar por cima usando o write
			 PrintWriter print = new PrintWriter(fileWriter);// quem escreve/print o conteúdo no arqv
			 print.write(conteudo);// escreve o conteúdo
			 print.flush();// finaliza a escrita
			 print.close();
			 fileWriter.close();
			 
		}else {// caso o diretório não exista
			throw new IOException("Diretório inválido");
		}
		
		
	}

//--------------------------------------------------------------------------------------------------------------------	
	private String geraTXT() {// sendo privado não precisa estar na interface// AQUI VAI GERAR O CONTEÚDO DO TXT
		StringBuffer buffer = new StringBuffer();
		String linha = " ";
		while(!linha.equalsIgnoreCase("fim")) {//enqnto a linha não for fim faça
			linha = JOptionPane.showInputDialog(null, "Digite uma frase",
					"Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
			if(!linha.equalsIgnoreCase("fim")) {// se a linha não for fim.. pra tirar a palavra fim
				buffer.append(linha + "\r\n");// \n é pra quebra de linha, pra não ficar tudo junto
				// \n não funciona em sempre, só a partir do win 10. O certo é os dois e fica o certo
			}			
		}
		return buffer.toString();
	}


//========================================= Ler Arqvo =========================================
//=============================================================================================
	public void readFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {//aqui é parecido com processos, com algumas diferenças
			FileInputStream fluxo = new FileInputStream(arq);// ABRE ARQV
			InputStreamReader leitor = new InputStreamReader(fluxo);// converte inputSteam em Stream  LÊ ARQV
			BufferedReader buffer = new BufferedReader(leitor);	// COLOCA ARQV NO BUFFER
			// agora já posso usar o buffer pra fazer qq coisa // FAZ OPERAÇÕES
			String linha = buffer.readLine(); 
			while(linha != null) {// procurando EOF
				System.out.println(linha);
				linha = buffer.readLine();// printo em cima e aqui leio próx linha
			}
			buffer.close();
			leitor.close();
			fluxo.close();// FECHA TUDO
			
		}else {
			throw new IOException ("Arquivo Inválido");
		}		
	}

	
//======================================== Abrir Arqvo ========================================
//=============================================================================================
	public void openFile(String path, String nome) throws IOException {//fazer programa abrir uma exten
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			Desktop dt = Desktop.getDesktop(); // tipo desktop inicializa aplicações associadas de um arqv
			dt.open(arq);
		}else {
			throw new IOException ("Arquivo Inválido");
		}	
		
	}
}
