package com.deepsingh44.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.deepsingh44.dao.ProductDao;
import com.deepsingh44.model.Product;
import com.deepsingh44.util.Utility;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchExpense extends JInternalFrame {
	private JTable table;
	private JLabel labeltotal;

	/**
	 * Create the frame.
	 */
	public SearchExpense() {
		setTitle("Search Expense");
		setClosable(true);
		setIconifiable(true);
		setBounds(50, 15, 570, 408);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(10, 11, 534, 53);
		panel.add(panel_1);
		panel_1.setLayout(null);

		UtilDateModel model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
		datePicker1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		datePicker1.setBounds(10, 20, 123, 30);
		panel_1.add(datePicker1);

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		datePicker.setBounds(148, 20, 123, 30);
		panel_1.add(datePicker);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(372, 11, 152, 31);
		comboBox.setModel(new DefaultComboBoxModel(Utility.CATEGORY));
		panel_1.add(comboBox);

		JLabel lblFrom = new JLabel("From Date");
		lblFrom.setForeground(new Color(0, 0, 0));
		lblFrom.setFont(new Font("Serif", Font.PLAIN, 11));
		lblFrom.setBounds(10, 5, 63, 14);
		panel_1.add(lblFrom);

		JLabel lblTo = new JLabel("To Date");
		lblTo.setForeground(Color.BLACK);
		lblTo.setFont(new Font("Serif", Font.PLAIN, 11));
		lblTo.setBounds(149, 6, 63, 14);
		panel_1.add(lblTo);

		String[] columns = { "ID", "NAME", "DATE", "PRICE", "QUANTITY" };
		DefaultTableModel dt = new DefaultTableModel(columns, 0);

		table = new JTable(dt);
		JScrollPane jScrollPane = new JScrollPane(table);

		jScrollPane.setBounds(10, 75, 534, 244);
		panel.add(jScrollPane);

		JLabel lblNewLabel = new JLabel("Total Expenses :");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 333, 103, 34);
		panel.add(lblNewLabel);

		JLabel lblRs = new JLabel("Rs.");
		lblRs.setBounds(123, 333, 22, 34);
		panel.add(lblRs);

		labeltotal = new JLabel("2500");
		labeltotal.setBounds(155, 333, 39, 34);
		panel.add(labeltotal);

		JButton btnMax = new JButton("Max");

		btnMax.setBounds(227, 341, 89, 23);
		panel.add(btnMax);

		JButton btnMin = new JButton("Min");

		btnMin.setBounds(337, 341, 89, 23);
		panel.add(btnMin);

		JButton btnAvg = new JButton("Avg");

		btnAvg.setBounds(455, 341, 89, 23);
		panel.add(btnAvg);

		// add products here in DESC order
		addAllProducts();

		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utility.normalMessage(SearchExpense.this, String.valueOf(max));
			}
		});

		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Utility.normalMessage(SearchExpense.this, String.valueOf(min));
			}
		});

		btnAvg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utility.normalMessage(SearchExpense.this, String.valueOf(avg));
			}
		});

	}

	float totalpriceofcurrenttabledata;
	float max;
	float min;
	float avg;
	List<Product> listProducts;

	private void addAllProducts() {
		listProducts = ProductDao.getProductDao().getAllProductsOrderByDesc();
		DefaultTableModel dt = (DefaultTableModel) table.getModel();
		for (Product p : listProducts) {
			totalpriceofcurrenttabledata += p.getQuantity() * p.getPrice();
			dt.addRow(new Object[] { p.getId(), p.getName(), p.getDate(), p.getPrice(), p.getQuantity() });
			max = Math.max(max, p.getPrice());
			min = max;
			// min=Math.min(min, p.getPrice());
			if (min < p.getPrice()) {
				min = p.getPrice();
			}
		}

		avg = totalpriceofcurrenttabledata / listProducts.size();

		labeltotal.setText(String.valueOf(totalpriceofcurrenttabledata));

	}
}
