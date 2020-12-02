import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.ActionEvent;

public class LiveDataRead extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LiveDataRead frame = new LiveDataRead();
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
	JLabel lblNewLabel, label_1, label_3;

	public LiveDataRead() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnGetCovidOf = new JButton("Get Covid Of India");

		btnGetCovidOf.setBounds(224, 433, 199, 23);
		contentPane.add(btnGetCovidOf);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(89, 91, 130, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cases");
		lblNewLabel_1.setBounds(89, 73, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblTodaycases = new JLabel("todayCases");
		lblTodaycases.setBounds(293, 73, 91, 14);
		contentPane.add(lblTodaycases);

		label_1 = new JLabel("");
		label_1.setBounds(293, 91, 130, 29);
		contentPane.add(label_1);

		JLabel lblDeaths = new JLabel("deaths");
		lblDeaths.setBounds(498, 73, 67, 14);
		contentPane.add(lblDeaths);

		label_3 = new JLabel("");
		label_3.setBounds(498, 91, 130, 29);
		contentPane.add(label_3);

		btnGetCovidOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getDataFromLiveUrl();

				Timer timer = new Timer(10000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						getDataFromLiveUrl();
					}
				});
				timer.start();

			}
		});
	}

	private void getDataFromLiveUrl() {

		try {
			URL url = new URL("https://coronavirus-19-api.herokuapp.com/countries/india");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			InputStream inputStream = httpURLConnection.getInputStream();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line = bufferedReader.readLine();

			StringBuffer stringBuffer = new StringBuffer();

			while (line != null) {
				// System.out.println(line);
				stringBuffer.append(line).append("\n");
				line = bufferedReader.readLine();
			}

			System.out.println(stringBuffer);
			// now we need to convert Json data into Java Object.
			Country country = new Gson().fromJson(stringBuffer.toString(), Country.class);
			lblNewLabel.setText(String.valueOf(country.getCases()));
			label_1.setText(String.valueOf(country.getTodayCases()));
			label_3.setText(String.valueOf(country.getDeaths()));

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
