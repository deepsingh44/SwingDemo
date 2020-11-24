import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.ImageView;

public class ComponentsDemo {
	public ComponentsDemo() {
		initComponents();
	}

	private void initComponents() {
		JFrame frame = new JFrame("Title...");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		// JLabel is used to represent text and image
		// JLabel ltext = new JLabel("Enter Text Here");
		// ltext.setBounds(50, 50, 100, 30);

		/*
		 * JLabel limage = new JLabel(new
		 * ImageIcon("C:\\Users\\deepsingh44\\Desktop\\Image Hd\\abc.jpg"));
		 * limage.setBounds(50, 50, 100, 100); frame.add(limage);
		 */

		/*
		 * JTextField tname=new JTextField(); tname.setBounds(50,50,100,30);
		 */

		/*
		 * JPasswordField tpass=new JPasswordField(); tpass.setBounds(50,50,100,30);
		 */

		/*
		 * JRadioButton r1=new JRadioButton("Male"); r1.setBounds(50,50,100,30);
		 * JRadioButton r2=new JRadioButton("Female"); r2.setBounds(160,50,100,30);
		 * 
		 * ButtonGroup bg=new ButtonGroup(); bg.add(r1); bg.add(r2);
		 */

		/*JCheckBox c1 = new JCheckBox("I accept all terms and conditions.");
		c1.setBounds(50, 50, 230, 30);
		frame.add(c1);
*/
		//JButton b1 = new JButton("Submit");
		//b1.setBounds(50, 150, 230, 30);

		//frame.add(b1);
		//b1.addActionListener((e)->System.out.println("hello"));
		
		JSlider js=new JSlider(1000,10000);
		js.setBounds(50,50,200,60);
		js.setPaintLabels(true);
		js.setMinorTickSpacing(500);
		js.setMajorTickSpacing(2500);
		js.setPaintTicks(true);
		frame.add(js);
		
		JTextField tminprice=new JTextField();
		tminprice.setBounds(50,100,100,30);
		frame.add(tminprice);
		
		
		js.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				//System.out.println(js.getValue());
				tminprice.setText(String.valueOf(js.getValue()));
			}
		});
		
		
		
		//lambda expression
		//c1.addActionListener((e)->b1.setEnabled((((JCheckBox)e.getSource()).isSelected())?true:false));
		
		
		/*c1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox ck = (JCheckBox) e.getSource();
				if (ck.isSelected()) {
					System.out.println("hi");
					b1.setEnabled(true);
					System.out.println(ck);
				} else {
					System.out.println("bye..");
					b1.setEnabled(false);
				}
				System.out.println((ck.isSelected())?"Enable":"Disable");;
			}
		});
*/
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new ComponentsDemo();
	}
}
