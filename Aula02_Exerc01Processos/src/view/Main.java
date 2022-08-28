package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController r = new RedesController();
		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(""
					+ " ESCOLHA UMA OPÇÃO \n"
					+ " 1 - Duvida por quê? \n"
					+ " 2 - Nessa casa tem goteira \n"
					+ " 9 - Sair daqui \n"
					+ ""));
			switch(opc) {
				case 1 : r.ip();
					break;
				case 2 : r.ping();
					break;
				case 9 : JOptionPane.showMessageDialog(null, "Flwwwww");
					break;
				default : JOptionPane.showMessageDialog(null, "♪ Tente outra vezz ♫");
				
			}
		}while(opc != 9);
		
	}

}
