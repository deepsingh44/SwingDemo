import javax.swing.JFrame;

public class FrameDemo {

	public static void main(String[] args) {
		
		JFrame f=new JFrame("Title Here");
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setResizable(false);
		
		//Borderlayout is default layout of on JFrame.
		//in jframe it containe center position by default
		
		f.setVisible(true);
	}
	
}
