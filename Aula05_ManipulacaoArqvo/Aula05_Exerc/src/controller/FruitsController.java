package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FruitsController {

	public FruitsController() {
		super();
	}
			
	public void exibeFrutas(String caminho, String nome) throws IOException {		
		File arq = new File(caminho, nome);		
		if(arq.exists() && arq.isFile()) {			
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);			
			String linha = buffer.readLine();
			
			
			while(linha != null) {			
				String[] partes = linha.split(",");
				boolean nulo = false;				
				for (String parts : partes) {
					if (parts.contains("NULL")) {	
						nulo = true;
					}
				}
				
				for (String parts : partes) {
					if (parts.contains("Fruits") && !nulo) {						
						System.out.println(partes[0] + "\t" + partes[1] + "\t" + partes[3]);
						System.err.println("===============================================");						
					}
				}
				linha = buffer.readLine();
			}			
			buffer.close();
			leitor.close();
			fluxo.close();
			
		}else {
			throw new IOException ("Arquivo Inválido");
		}		
	}
}
