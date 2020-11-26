package com.deepsingh44.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import com.deepsingh44.util.Utility;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SplashFile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SplashFile frame = new SplashFile();
	}

	/**
	 * Create the frame.
	 */
	public SplashFile() {
		LookAndFeelInfo lf[] = UIManager.getInstalledLookAndFeels();
		try {
			UIManager.setLookAndFeel(lf[1].getClassName());
		} catch (Exception e) {
			System.out.println(e);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(465, 261);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(Utility
				.resize(new ImageIcon(SplashFile.class.getResource("/com/deepsingh44/images/logo.jpg")), 465, 261));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);

		JProgressBar pb = new JProgressBar();
		pb.setStringPainted(true);
		pb.setIndeterminate(true);
		contentPane.add(pb, BorderLayout.SOUTH);

		setVisible(true);

		for (int i = 0; i <= 100; i++) {
			pb.setValue(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

		if (pb.getValue() == 100) {
			new LoginFile().setVisible(true);
			dispose();
		}

	}

}
