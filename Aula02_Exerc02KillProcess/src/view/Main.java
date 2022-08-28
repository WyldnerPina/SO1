package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController killer = new KillController();		
		
		killer.listaProcessos();
		
		String parametro = JOptionPane.showInputDialog("Digite seu alvo");
		killer.killProcess(parametro);
	}

}
