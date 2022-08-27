package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
//import javax.swing.JOptionPane;

public class RedesController {
	public RedesController() {
		super();
	}

	private String os() {
		String os = System.getProperty("os.name");
		String arquitetura = System.getProperty("os.arch");
		String versao = System.getProperty("os.version");

		return os + " - v. " + versao + " - arq " + arquitetura;// retorna tudo concatenado
	}

	public void ip(String process) {
		String so = os();

		if (so.contains("Win")) {// ================= WINDOWS =======================
			try {
				Process p = Runtime.getRuntime().exec(process);

				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);

				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("IPv4")) {
						System.out.println(linha);
//						JOptionPane.showMessageDialog(null, linha);
					}
					linha = buffer.readLine();
				}

				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {// ================================ LINUX ==========================

		}
	}

	public void ping(String processo) {
		String so = os();

		if (so.contains("Win")) {// ================= WINDOWS =======================
			try {
				Process p = Runtime.getRuntime().exec(processo);

				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);

				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {			
					if(linha.contains("dia =")) {
						String[] partes = linha.split(" ");
						
						for(String parts : partes) {
							if (!parts.contains("ms,") && parts.contains("ms")) {
								System.out.println("Media = " + parts);
//								JOptionPane.showMessageDialog(null, "Media = " + parts);
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
		} else {// ================================ LINUX ==========================

		}
	}

}
