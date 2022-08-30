package view;

import javax.swing.JOptionPane;
import controller.KillController;

public class Main {
	public static void main(String[] args) {
		KillController killer = new KillController();
		String parametro;
		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(""
					+ " ESCOLHA UMA OPÇÃO \n"
					+ " 1 - Lista Processos \n"
					+ " 2 - Mata por PID \n"
					+ " 3 - Mata por Nome \n"
					+ " 9 - Sair \n"
					+ ""));
			switch(opc) {
				case 1 : killer.listaProcessos();
					break;
				case 2 : parametro = JOptionPane.showInputDialog("Digite seu alvo");
						 killer.mataPid(parametro);
					break;
				case 3 : parametro = JOptionPane.showInputDialog("Digite seu alvo"); 
						 killer.mataNome(parametro);
				break;
				case 9 : JOptionPane.showMessageDialog(null, "Saindo");
					break;
				default : JOptionPane.showMessageDialog(null, "Pfv, digite uma das opções");				
			}
		}while(opc != 9);
	}

}
