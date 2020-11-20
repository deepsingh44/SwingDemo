import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelDemo {
	public static void main(String[] args) {
		// that panel must be added in root container like JFrame or JWindow
		//by default panel support FlowLayout
		JPanel p = new JPanel();
		//p.setLayout(null);
		p.setBounds(0,0,500,100);
		p.setBackground(Color.CYAN);
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.add(p);
		
		JButton b1=new JButton("Add Me");
		JButton b2=new JButton("Sub Me");
		
		p.add(b1);
		p.add(b2);
		
		f.setVisible(true);

	}
}
