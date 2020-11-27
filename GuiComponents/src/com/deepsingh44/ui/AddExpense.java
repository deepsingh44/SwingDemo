package com.deepsingh44.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EtchedBorder;

import com.deepsingh44.util.Utility;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddExpense extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public AddExpense() {
		setTitle("Add Expenses");
		setIconifiable(true);
		setClosable(true);
		setBounds(50, 15, 570, 408);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(30, 33, 214, 317);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 102, 102));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_2.setBounds(266, 33, 258, 317);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setForeground(Color.WHITE);
		lblProductName.setFont(new Font("Serif", Font.PLAIN, 11));
		lblProductName.setBounds(10, 31, 127, 14);
		panel_2.add(lblProductName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField.setBounds(10, 49, 236, 30);
		panel_2.add(textField);
		
		JLabel lblProductPrice = new JLabel("Product Price");
		lblProductPrice.setForeground(Color.WHITE);
		lblProductPrice.setFont(new Font("Serif", Font.PLAIN, 11));
		lblProductPrice.setBounds(10, 85, 127, 14);
		panel_2.add(lblProductPrice);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField_1.setBounds(10, 103, 236, 30);
		panel_2.add(textField_1);
		
		JLabel lblProductQuantity = new JLabel("Product Quantity");
		lblProductQuantity.setForeground(Color.WHITE);
		lblProductQuantity.setFont(new Font("Serif", Font.PLAIN, 11));
		lblProductQuantity.setBounds(10, 144, 84, 14);
		panel_2.add(lblProductQuantity);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField_2.setBounds(10, 162, 94, 30);
		panel_2.add(textField_2);
		
		JLabel lblProductDate = new JLabel("Product Date");
		lblProductDate.setForeground(Color.WHITE);
		lblProductDate.setFont(new Font("Serif", Font.PLAIN, 11));
		lblProductDate.setBounds(10, 203, 127, 14);
		panel_2.add(lblProductDate);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		datePicker.setBounds(10, 221, 236, 27);
		panel_2.add(datePicker);
		
		JLabel lblProductCategory = new JLabel("Product Category");
		lblProductCategory.setForeground(Color.WHITE);
		lblProductCategory.setFont(new Font("Serif", Font.PLAIN, 11));
		lblProductCategory.setBounds(119, 144, 127, 14);
		panel_2.add(lblProductCategory);
		
		JButton btnNewButton = new JButton("Add Expense");
		btnNewButton.setBounds(48, 272, 157, 30);
		panel_2.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Utility.CATEGORY));
		comboBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		comboBox.setBounds(116, 162, 130, 30);
		panel_2.add(comboBox);
		

	}
}
