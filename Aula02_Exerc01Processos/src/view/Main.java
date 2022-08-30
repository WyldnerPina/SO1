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
					+ " 1 - Ipv4 \n"
					+ " 2 - Ping Google (usa a média do final do teste, então demora um pouco)\n"
					+ " 9 - Sair daqui \n"
					+ ""));
			switch(opc) {
				case 1 : r.ip();
					break;
				case 2 : r.ping();
					break;
				case 9 : JOptionPane.showMessageDialog(null, "Saindo");
					break;
				default : JOptionPane.showMessageDialog(null, "Pfv, digite uma das opções");
				
			}
		}while(opc != 9);
		
	}

}
