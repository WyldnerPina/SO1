package view;

import java.io.IOException;

import controller.ArqvosController;
import controller.IArqvosController;

public class Main {

	public static void main(String[] args) {
		IArqvosController arqCont = new ArqvosController();// já criei a interface no começo do cód IArqvosController
														  // se no new eu usar o mesmo teria q implementar as assinaturas
														  // pra isso não acontecer, chamo então a classe da interface
		String dirWin = "C:\\Windows";
		String path = "D:\\A FATEC\\GitHub\\SO1\\Aula05_ManipulacaoArqvo\\Aula05_ManipulacaoArqv";
		String nome = "teste";
		
		try {
			arqCont.readDir(dirWin);// aqui faz chamada pra listar a pasta definida acima, pode listar qq pasta (Diretório) e arvos nela
			arqCont.createFile(path, nome);
			nome = "teste.txt";// se eu não colocar a extenção aqui, do jeito q está dá ruim lá ← ATENÇÃO
			arqCont.readFile(path, nome);
			arqCont.openFile(path, nome);
		} catch (IOException e) {			
			e.printStackTrace();
		}

	}

}
