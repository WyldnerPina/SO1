package view;
//import java.util.Scanner; // 1. importando a classe Scanner


//=========================================== PARA INSTANCIAR CLASSE ==============================================
import controller.OperacoesController;
import controller.Tarefa01;
//import controller.*; até posso por asterístico, mas importa todas as classes q houverem lá (q podem ser várias)
// isso deixa o cód lento. então o certo é saber qual vc quer importar


//=================================================== MAIN  ======================================================
public class Principal {

	public static void main(String[] args) {// se esquecer o principal só digitar "main" + ctrl+space
		
		//agora preciso chamar as classes criadas - instanciar
		OperacoesController op = new OperacoesController();// essa var não está sendo usada, só será qndo eu 
		// chamar as operações abaixo:
		
		//CHAMANDO OPERAÇOES DA CLASSE
		op.concatenaString();
		op.concatenaBuffer();
		//agora ele vai seguir um após o outro
		
		String frase = "nessa longa estrada da vida";
		op.divideFrase(frase);
		
		
//===========================================================================================================		
//		int valorDigitado;
		Tarefa01 tarefa = new Tarefa01();// instanciando tarefa
		
//		Scanner ler = new Scanner(System.in); // 2. instanciando e criando um objeto Scanner (pra ler sem JOptionPane)
		

//		System.out.printf("Informe o tamanho: ");
//		valorDigitado = ler.nextInt(); // 3. entrada de dados (lendo um valor inteiro)		
		//ler.nextLine();  
//		ler.close();// ler sempre precisa fechar
		
		System.out.println("==================== TAREFA =========================\n");	
		tarefa.Tarefa();//aqui chama a classe e a função		
	}

}

/*
//=========================================================================================================== 
============================================== ATALHOS ECLIPSE ==============================================
vc pode escrever parte "OperacoesCon" + Ctrl+1 → isso vai iportar a classe certae já fazer o new, 
após Ctrl+1 e ele cria a var pra vc dar o nome (nesse caso op) 

F11 → depura
ctrl+F11 →
*/