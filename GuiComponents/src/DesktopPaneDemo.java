import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class DesktopPaneDemo {
	public static void main(String[] args) {
		JFrame f = new JFrame("Title Here");
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		//f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add menu bar here
		JMenuBar mb = new JMenuBar();
		// add menu here
		JMenu m1 = new JMenu("File");
		mb.add(m1);
		JMenuItem mi1 = new JMenuItem("New");
		mi1.setBackground(Color.green);
		mi1.setForeground(Color.WHITE);
		mi1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mi1.setBackground(Color.yellow);
				mi1.setForeground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mi1.setBackground(Color.green);
				mi1.setForeground(Color.WHITE);
			}
		});

		mi1.setAccelerator(KeyStroke.getKeyStroke('N', KeyEvent.CTRL_DOWN_MASK));
		mi1.setIcon(new ImageIcon("src\\new.png"));
		JMenuItem mi2 = new JMenuItem("Open");
		JMenuItem mi3 = new JMenuItem("Save");
		JMenuItem mi4 = new JMenuItem("Exit");

		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m1.add(mi4);

		JMenu m2 = new JMenu("View");
		mb.add(m2);

		JDesktopPane desktopPane = new JDesktopPane();

		f.add(desktopPane);
		f.add(mb, BorderLayout.NORTH);
		f.setVisible(true);

		// all the events here
		mi1.addActionListener((e) -> {
			InternalframeDemo inf = new InternalframeDemo();
			desktopPane.add(inf);
			inf.setVisible(true);
		});

		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Hey its close2");
			}

		});

	}
}
