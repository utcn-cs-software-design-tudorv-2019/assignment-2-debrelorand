package com.csdepartment.mvc.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class InfoCurs extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JPanel panel_center = new JPanel();
	public JPanel panel_north = new JPanel();
	public JPanel panel_south = new JPanel();
	public JTable table2;
	
	private JLabel lblBineAiVenit;
	private JTextField textField_nota = new JTextField();
	
	private JButton button_addNota = new JButton("Adaugare nota");
	private JButton button_inapoi = new JButton("Inapoi");
	/**
	 * Create the frame.
	 */
	public InfoCurs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CursInfo");
		setBounds(200, 100, 600, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new MigLayout("", "[][][][][][]", "[][][][][][]"));
				
		panel_north = new JPanel();
		contentPane.add(panel_north, BorderLayout.NORTH);
		panel_north.setLayout(new MigLayout("", "[][][][][]", "[][][][]")); 
		
		contentPane.add(panel_south,BorderLayout.SOUTH);
		
		lblBineAiVenit = new JLabel("");
		lblBineAiVenit.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_north.add(lblBineAiVenit, "flowx,cell 0 0");
	}
	
	public void setBineAiVenitText(String string)
	{
		lblBineAiVenit.setText(string);
	}
	
	public void addButtonAddNotaListener(ActionListener a1)
	{
		button_addNota.addActionListener(a1);
	}
	
	public void addButtonInapoiListener(ActionListener a1)
	{
		button_inapoi.addActionListener(a1);
	}
	
	public int getNota()
	{
		return Integer.parseInt(textField_nota.getText());
	}

	public void addButtoanele()
	{
		JLabel nota = new JLabel("nota");
		panel_center.add(nota,"cell 0 1");
		panel_center.add(textField_nota, "cell 0 1,growx");
		textField_nota.setColumns(20);
		panel_center.add(button_addNota,"cell 0 2");
		panel_center.add(button_inapoi,"cell 0 2,growx");
	}
}
