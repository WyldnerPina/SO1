package controller;

import java.io.IOException;

// INTERFACE COM 4 ASSINATURAS DE MÉTS
public interface IArqvosController {
	public void readDir(String path) throws IOException;// mostrar quais arqvos estão no diretôrio. poderia retornar vet de arqvos => File[], mas só pring agora 
	// tipo file engloba tanto arqvos qnto diretórios // normal é ir passando os erros (com throws) até classe view e então fazer tratamento
	
	public void createFile(String path, String nome)throws IOException;
	public void readFile(String path, String nome)throws IOException;
	public void openFile(String path, String nome)throws IOException;
	
}
