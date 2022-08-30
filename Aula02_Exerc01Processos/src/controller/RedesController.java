package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
//import javax.swing.JOptionPane;

public class RedesController {
	public RedesController() {
		super();
	}

//===============================================================================================
//========================================== S.O. ===============================================
//===============================================================================================
	private String os() {
		String os = System.getProperty("os.name");
		String arquitetura = System.getProperty("os.arch");
		String versao = System.getProperty("os.version");

		return os + " - v. " + versao + " - arq " + arquitetura;// retorna tudo concatenado
	}

//===============================================================================================
//============================================ IP ===============================================
//===============================================================================================
	public void ip() {
		String os = os();
		String comando, wordSeek;
		if (os.contains("Win")) {
			wordSeek = "IPv4";
			comando = "IPCONFIG";
		} else {
			wordSeek = "inet ";
			comando = "ifconfig";
		}
//===============================================================================================		

		try {
			Process p = Runtime.getRuntime().exec(comando);

			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);

			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains(wordSeek)) {
					System.out.println(linha);
//					JOptionPane.showMessageDialog(null, linha);
				}
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//===============================================================================================
//=========================================== PING ==============================================
//===============================================================================================
	public void ping() {
		String os = os();
		String comando;
		if (os.contains("Win")) {
			comando = "PING -4 -n 10 www.google.com.br";
		} else {
			comando = "PING -4 -c 10 www.google.com.br";
		}
//===============================================================================================

		try {
			Process p = Runtime.getRuntime().exec(comando);

			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);

			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			while (linha != null) {
				if (linha.contains("dia =")) {
					String[] partes = linha.split(" ");

					for (String parts : partes) {
						if (!parts.contains("ms,") && parts.contains("ms")) {
							System.out.println("Media = " + parts);
//							JOptionPane.showMessageDialog(null, "Media = " + parts);
						}
					}
				}
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
