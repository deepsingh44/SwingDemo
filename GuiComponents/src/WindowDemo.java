import javax.swing.JWindow;

public class WindowDemo {
	public static void main(String[] args) {
		JWindow w = new JWindow();
		w.setSize(300, 200);
		w.setLocationRelativeTo(null);
		w.setVisible(true);
		//it is used to clise window.
		w.dispose();
		
	}
}
