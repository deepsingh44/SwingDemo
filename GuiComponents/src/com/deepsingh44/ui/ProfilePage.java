package com.deepsingh44.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import com.deepsingh44.dao.UserDao;
import com.deepsingh44.model.User;
import com.deepsingh44.util.Utility;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class ProfilePage extends JInternalFrame {
	private JTextField tname;
	private JTextField temail;
	private JTextField tpass;
	private JTextField tmobile;
	private JTextField timagefield;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	private User user;
	private JLabel label;
	public ProfilePage(User user) {
		this.user = user;
		setTitle("Profile Page");
		setClosable(true);
		setIconifiable(true);
		setBounds(50, 15, 570, 408);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 102));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setBounds(201, 34, 128, 99);
		panel.add(label);

		tname = new JTextField();
		tname.setBounds(66, 179, 190, 30);
		panel.add(tname);
		tname.setColumns(10);

		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setForeground(new Color(255, 255, 255));
		lblFullName.setBounds(66, 161, 69, 14);
		panel.add(lblFullName);

		temail = new JTextField();
		temail.setColumns(10);
		temail.setEditable(false);
		temail.setBounds(291, 179, 190, 30);
		panel.add(temail);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(291, 161, 46, 14);
		panel.add(lblEmail);

		tpass = new JTextField();
		tpass.setColumns(10);
		tpass.setBounds(66, 238, 190, 30);
		panel.add(tpass);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(66, 220, 69, 14);
		panel.add(lblPassword);

		tmobile = new JTextField();
		tmobile.setColumns(10);
		tmobile.setBounds(291, 238, 190, 30);
		panel.add(tmobile);

		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setForeground(Color.WHITE);
		lblMobile.setBounds(291, 220, 46, 14);
		panel.add(lblMobile);

		timagefield = new JTextField();
		timagefield.setEditable(false);
		timagefield.setColumns(10);
		timagefield.setBounds(66, 294, 279, 30);
		panel.add(timagefield);

		JLabel lblProfileImage = new JLabel("Profile Image");
		lblProfileImage.setForeground(Color.WHITE);
		lblProfileImage.setBounds(66, 276, 96, 14);
		panel.add(lblProfileImage);

		JButton btnNewButton = new JButton("Browse");

		btnNewButton.setBounds(355, 294, 122, 30);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Update Profile");

		btnNewButton_1.setBounds(184, 340, 153, 30);
		panel.add(btnNewButton_1);

		// set all values here
		tname.setText(user.getName());
		temail.setText(user.getEmail());
		tpass.setText(user.getPass());
		tmobile.setText(user.getMobile());
		if (user.getImage().isEmpty()) {
			// set default picture here
			label.setIcon(Utility
					.resize(new ImageIcon(ProfilePage.class.getResource("/com/deepsingh44/images/user.png")), 128, 99));
		} else {
			// set actual image here
			label.setIcon(Utility.resize(new ImageIcon(System.getProperty("user.dir") + File.separator + "profileimages"
					+ File.separator + user.getImage()), 128, 99));
		}

		// all event here
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser();
				int i = j.showOpenDialog(ProfilePage.this);
				if (i == JFileChooser.APPROVE_OPTION) {
					File file = j.getSelectedFile();
					String path = file.getAbsolutePath();
					timagefield.setText(path);

					String dest = System.getProperty("user.dir");
					try (FileInputStream fi = new FileInputStream(path);) {
						File folder = new File(dest, "profileimages");
						folder.mkdir();
						File myimage = new File(folder, user.getEmail() + ".jpg");
						myimage.createNewFile();

						FileOutputStream fo = new FileOutputStream(myimage.getAbsolutePath());

						int k = 0;
						byte[] buffer = new byte[1024];

						while ((k = fi.read(buffer)) != -1) {
							fo.write(buffer, 0, k);
							fo.flush();
						}
						fo.close();
						// update image in database
						user.setImage(user.getEmail() + ".jpg");
						int l = UserDao.getUserDao().update(user);
						if (l > 0) {
							label.setIcon(Utility.resize(new ImageIcon(System.getProperty("user.dir") + File.separator
									+ "profileimages" + File.separator + user.getImage()), 128, 99));
							label.updateUI();
							Utility.normalMessage(ProfilePage.this, "Successfully Profile Image Uploaded");
						} else {
							Utility.errorMessage(ProfilePage.this, "Profile Image Uploaded Failed");
						}

					} catch (Exception e2) {
						Utility.errorMessage(ProfilePage.this, e2.toString());
					}

				}
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valid()) {
					//update code here
					user.setName(name);
					user.setMobile(mobile);
					user.setPass(pass);
					
					int i=UserDao.getUserDao().update(user);
					if(i>0) {
						Utility.normalMessage(ProfilePage.this, "Successfully update");
					}else {
						Utility.errorMessage(ProfilePage.this, "Updation Failed");
					}
				}
			}
		});

	}

	private String name, email, pass, mobile;

	private boolean valid() {
		name = tname.getText();
		email = temail.getText();
		pass = tpass.getText();
		mobile = tmobile.getText();

		if (name.equals("")) {
			Utility.warningMessage(ProfilePage.this, "please enter full name");
			tname.requestFocus();
			return false;
		} else if (email.equals("")) {
			Utility.warningMessage(ProfilePage.this, "please enter email id");
			temail.requestFocus();
			return false;
		} else if (!Utility.emailValidation(email)) {
			Utility.warningMessage(ProfilePage.this, "please enter valid email id");
			temail.requestFocus();
			return false;
		} else if (pass.equals("")) {
			Utility.warningMessage(ProfilePage.this, "please enter password");
			tpass.requestFocus();
			return false;
		} else if (!Utility.passwordValidation(pass)) {
			Utility.warningMessage(ProfilePage.this,
					"password must have following things: \n 1. should have upper case char \n 2. should have lower case char \n 3. length should be more than 6. \n 4. should have special char");
			tpass.requestFocus();
			return false;
		} else if (mobile.equals("")) {
			Utility.warningMessage(ProfilePage.this, "please enter mobile number");
			tmobile.requestFocus();
			return false;
		} else if (mobile.length()!=10) {
			Utility.warningMessage(ProfilePage.this, "please enter 10 digit mobile number");
			tmobile.requestFocus();
			return false;
		} else {
			return true;
		}
	}
}
