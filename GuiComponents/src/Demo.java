import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Demo {
public static void main(String[] args) {
	
	JFrame frame=new JFrame();
	frame.setSize(300, 300);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(null);
	UtilDateModel model = new UtilDateModel();
	JDatePanelImpl datePanel = new JDatePanelImpl(model);
	JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
	datePicker.setBounds(10,10,200,30);
	
	JButton b1=new JButton("Get Date");
	b1.setBounds(10,100,100,30);

	b1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Date selectedDate = (Date) datePicker.getModel().getValue();
			//System.out.println(selectedDate);
			java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
			System.out.println(sqlDate);
			
		}
	});
	
	frame.add(datePicker);
	frame.add(b1);
	frame.setVisible(true);
}
}
