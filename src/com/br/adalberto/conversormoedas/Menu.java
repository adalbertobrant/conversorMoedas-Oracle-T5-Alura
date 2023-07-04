package com.br.adalberto.conversormoedas;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
	private JFrame frame;
    private JComboBox<String> comboBox;
    private String selectedOption;
    
    public Menu() {
    	frame = new JFrame("Menu");
        comboBox = new JComboBox<>(new String[]{"Conversor de Moedas"
        		//,// "Conversor de Temperaturas"
        		/*, "Conversor de Grandezas"*/});    
    
    // Configurando a ação do JComboBox
	    comboBox.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            selectedOption = (String) comboBox.getSelectedItem();
	            switch(selectedOption) {
	           /* case "Conversor de Grandezas":
	            	openOtherScreen();
	            	break;*/
	            case "Conversor de Moedas":
	            	openOtherScreen();
	            	break;
	            /*case "Conversor de Temperaturas":
	            	openOtherScreen();
	            	break;*/
	            }
	            /*if (selectedOption.equals("Conversor de Grandezas")) {
	                // Navegar para a outra tela
	                openOtherScreen();
	            }*/
	        }
	    });
	    frame.setLayout(new FlowLayout());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(800, 500);
	    frame.add(comboBox);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
    }
    
    private void openOtherScreen() {
    	frame.dispose();
    	switch (this.selectedOption) {
    		case "Conversor de Moedas":
    			TelaConversorMoedas telaMoedas = new TelaConversorMoedas(selectedOption);
    			telaMoedas.setLocationRelativeTo(null);
    			telaMoedas.setVisible(true);
    			break;
    	}
    	
    	
    }
    
    
    
    
    
}