package com.deepsingh44.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public HomePage() {
		LookAndFeelInfo lf[] = UIManager.getInstalledLookAndFeels();
		try {
			UIManager.setLookAndFeel(lf[1].getClassName());
		} catch (Exception e) {
			System.out.println(e);
		}
		setTitle("Expense Manager");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmAddExpense = new JMenuItem("Add Expense");

		mntmAddExpense.setIcon(new ImageIcon(HomePage.class.getResource("/com/deepsingh44/images/expenses_add.png")));
		mntmAddExpense.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnFile.add(mntmAddExpense);

		JMenuItem mntmUpdateExpense = new JMenuItem("Update Expense");
		mntmUpdateExpense.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
		mnFile.add(mntmUpdateExpense);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		JMenuItem mntmProfile = new JMenuItem("Profile");

		mntmProfile.setIcon(new ImageIcon(HomePage.class.getResource("/com/deepsingh44/images/profile-user.png")));
		mntmProfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnView.add(mntmProfile);

		JMenuItem mntmLiastOfExpense = new JMenuItem("List of Expense");
		mntmLiastOfExpense.setIcon(new ImageIcon(HomePage.class.getResource("/com/deepsingh44/images/expenses.png")));
		mntmLiastOfExpense.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnView.add(mntmLiastOfExpense);
		
		JMenuItem mntmSearchExpense = new JMenuItem("Search Expense");
		
		mntmSearchExpense.setIcon(new ImageIcon(HomePage.class.getResource("/com/deepsingh44/images/expenses_add.png")));
		mntmSearchExpense.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnView.add(mntmSearchExpense);
		
		JMenu menu = new JMenu("");
		menuBar.add(menu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		// all events here
		mntmAddExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddExpense addExpense = new AddExpense();
				desktopPane.add(addExpense);
				addExpense.setVisible(true);
			}
		});

		mntmProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		mntmSearchExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchExpense searchExpense = new SearchExpense();
				desktopPane.add(searchExpense);
				searchExpense.setVisible(true);
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// JOptionPane.showMessageDialog(HomePage.this, "Hey dont do this.");
				// JOptionPane.showMessageDialog(HomePage.this, "Hey dont do
				// this.","Error-Message",JOptionPane.ERROR_MESSAGE);
				// JOptionPane.showMessageDialog(HomePage.this, "Hey dont do
				// this.","Warning-Message",JOptionPane.WARNING_MESSAGE);
				int i = JOptionPane.showConfirmDialog(HomePage.this, "Are you sure to close this window ?");
				if (i == 0) {
					if (desktopPane.getAllFrames().length == 0) {
						dispose();
						System.exit(0);
					} else {
						JOptionPane.showMessageDialog(HomePage.this, "Please close all internal frames.",
								"Warning-Message", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
	}
}
