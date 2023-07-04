package com.br.adalberto.conversormoedas;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TelaConversorMoedas extends JFrame {
	
	private String selectedOption;
	
	public TelaConversorMoedas(String selectedOption) {
		this.selectedOption = selectedOption;
		
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
		
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu();
            }
        });
        
        add(backButton);
	}
		
}
	
	
	


