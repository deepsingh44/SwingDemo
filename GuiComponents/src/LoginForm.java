import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblEnterEmailId;
	private JLabel lblEnterPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/images/user.png")));
		setTitle("Login Form");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel(" ");
		label.setIcon(Utility.resize(new ImageIcon(LoginForm.class.getResource("/images/user.png")), 122, 99));
		label.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		label.setBounds(181, 65, 122, 99);
		contentPane.add(label);

		JLabel lblLoginDetails = new JLabel("Login Details", JLabel.CENTER);
		lblLoginDetails.setForeground(new Color(255, 255, 255));
		lblLoginDetails.setFont(new Font("Serif", Font.BOLD, 14));
		lblLoginDetails.setBounds(171, 187, 145, 14);
		contentPane.add(lblLoginDetails);

		textField = new JTextField();
		textField.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		textField.setBounds(125, 254, 263, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		passwordField.setBounds(125, 321, 263, 30);
		contentPane.add(passwordField);

		lblEnterEmailId = new JLabel("Enter Email Id");
		lblEnterEmailId.setFont(new Font("Serif", Font.PLAIN, 11));
		lblEnterEmailId.setForeground(new Color(255, 255, 255));
		lblEnterEmailId.setBounds(125, 237, 104, 14);
		contentPane.add(lblEnterEmailId);

		lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setFont(new Font("Serif", Font.PLAIN, 11));
		lblEnterPassword.setForeground(new Color(255, 255, 255));
		lblEnterPassword.setBounds(125, 305, 104, 14);
		contentPane.add(lblEnterPassword);

		JCheckBox chckbxRememberMe = new JCheckBox("Remember Me");
		chckbxRememberMe.setFont(new Font("Serif", Font.PLAIN, 11));
		chckbxRememberMe.setForeground(new Color(255, 255, 255));
		chckbxRememberMe.setBackground(new Color(51, 102, 102));
		chckbxRememberMe.setBounds(274, 370, 114, 30);
		contentPane.add(chckbxRememberMe);

		JCheckBox chckbxShow = new JCheckBox("Show");
		chckbxShow.setFont(new Font("Serif", Font.PLAIN, 11));
		chckbxShow.setForeground(new Color(255, 255, 255));
		chckbxShow.setBackground(new Color(51, 102, 102));
		chckbxShow.setBounds(394, 321, 61, 30);
		contentPane.add(chckbxShow);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(51, 153, 204));
		btnLogin.setBounds(140, 439, 104, 30);
		contentPane.add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(102, 0, 51));
		btnReset.setBounds(274, 439, 89, 30);
		contentPane.add(btnReset);

		JLabel lblClickHereFor = new JLabel("Click Here For New User");
		lblClickHereFor.setFont(new Font("Serif", Font.PLAIN, 11));
		lblClickHereFor.setForeground(new Color(255, 255, 255));
		lblClickHereFor.setBounds(181, 497, 182, 30);
		contentPane.add(lblClickHereFor);

		lblClickHereFor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblClickHereFor.setForeground(Color.BLUE);
				lblClickHereFor.setFont(new Font("bold", Font.BOLD, 11));
				lblClickHereFor.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblClickHereFor.setForeground(Color.white);
				lblClickHereFor.setFont(new Font("Serif", Font.PLAIN, 11));
				lblClickHereFor.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

	}
}
