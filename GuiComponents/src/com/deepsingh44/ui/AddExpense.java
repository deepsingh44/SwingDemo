package com.deepsingh44.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EtchedBorder;

import com.deepsingh44.dao.ProductDao;
import com.deepsingh44.model.Product;
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
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AddExpense extends JInternalFrame {
	private JTextField tname;
	private JTextField tprice;
	private JTextField tquantity;
	private JTextField textField_3;
	private JComboBox tcombobox;
	private JDatePickerImpl datePicker;

	public AddExpense() {
		setTitle("Add Expenses");
		setIconifiable(true);
		setClosable(true);
		setBounds(50, 15, 570, 408);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 0, 51));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(30, 33, 214, 317);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 0, 51));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_2.setBounds(266, 33, 258, 317);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setForeground(Color.WHITE);
		lblProductName.setFont(new Font("Serif", Font.PLAIN, 11));
		lblProductName.setBounds(10, 31, 127, 14);
		panel_2.add(lblProductName);

		tname = new JTextField();
		tname.setColumns(10);
		tname.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tname.setBounds(10, 49, 236, 30);
		panel_2.add(tname);

		JLabel lblProductPrice = new JLabel("Product Price");
		lblProductPrice.setForeground(Color.WHITE);
		lblProductPrice.setFont(new Font("Serif", Font.PLAIN, 11));
		lblProductPrice.setBounds(10, 85, 127, 14);
		panel_2.add(lblProductPrice);

		tprice = new JTextField();
		tprice.setColumns(10);
		tprice.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tprice.setBounds(10, 103, 236, 30);
		panel_2.add(tprice);

		JLabel lblProductQuantity = new JLabel("Product Quantity");
		lblProductQuantity.setForeground(Color.WHITE);
		lblProductQuantity.setFont(new Font("Serif", Font.PLAIN, 11));
		lblProductQuantity.setBounds(10, 144, 84, 14);
		panel_2.add(lblProductQuantity);

		tquantity = new JTextField();
		tquantity.setColumns(10);
		tquantity.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tquantity.setBounds(10, 162, 94, 30);
		panel_2.add(tquantity);

		JLabel lblProductDate = new JLabel("Product Date");
		lblProductDate.setForeground(Color.WHITE);
		lblProductDate.setFont(new Font("Serif", Font.PLAIN, 11));
		lblProductDate.setBounds(10, 203, 127, 14);
		panel_2.add(lblProductDate);

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		datePicker.setBounds(10, 221, 236, 28);
		panel_2.add(datePicker);

		JLabel lblProductCategory = new JLabel("Product Category");
		lblProductCategory.setForeground(Color.WHITE);
		lblProductCategory.setFont(new Font("Serif", Font.PLAIN, 11));
		lblProductCategory.setBounds(119, 144, 127, 14);
		panel_2.add(lblProductCategory);

		JButton btnNewButton = new JButton("Add Expense");

		btnNewButton.setBounds(48, 272, 157, 30);
		panel_2.add(btnNewButton);

		tcombobox = new JComboBox();
		tcombobox.setModel(new DefaultComboBoxModel(Utility.CATEGORY));
		tcombobox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tcombobox.setBounds(116, 162, 130, 30);
		panel_2.add(tcombobox);

		// add all event code here
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {
					
					Product product=new Product();
					product.setName(name);
					product.setPrice(Float.parseFloat(price));
					product.setCategory(category);
					product.setQuantity(Integer.parseInt(quantity));
					product.setDate(date);
					
					int i=ProductDao.getProductDao().insert(product);
				if(i>0) {
					reset();
					Utility.normalMessage(AddExpense.this, "Product added successfully");
				}else {
					Utility.errorMessage(AddExpense.this, "Product added failed");
					reset();
				}
				}
			}
		});

	}
	
	private void reset() {
		tname.setText("");
		tprice.setText("");
		tquantity.setText("");
		tcombobox.setModel(new DefaultComboBoxModel(Utility.CATEGORY));
		datePicker.getModel().setValue(null);
		
	}

	private String name, price, quantity, date, category;

	private boolean valid() {
		name = tname.getText();
		price = tprice.getText();
		quantity = tquantity.getText();
		category = tcombobox.getSelectedItem().toString();
		Date selectedDate = (Date) datePicker.getModel().getValue();

		if (name.equals("")) {
			Utility.warningMessage(AddExpense.this, "please enter product name");
			tname.requestFocus();
			return false;
		} else if (price.equals("")) {
			Utility.warningMessage(AddExpense.this, "please enter price");
			tprice.requestFocus();
			return false;
		} else if (quantity.equals("")) {
			Utility.warningMessage(AddExpense.this, "please enter quantity");
			tquantity.requestFocus();
			return false;
		} else if (category.equalsIgnoreCase("category")) {
			Utility.warningMessage(AddExpense.this, "please select category");
			tcombobox.requestFocus();
			return false;
		} else if (selectedDate == null) {
			Utility.warningMessage(AddExpense.this, "please select date");
			datePicker.requestFocus();
			return false;
		} else {
			java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
			date = sqlDate.toString();
			return true;
		}
	}
}
