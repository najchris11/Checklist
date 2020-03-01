
import javax.swing.*;

public class GUI extends Tester implements SwingConstants {
	JPanel panel = new JPanel();
	JFrame window = new JFrame("Checklist v1.0");
	public GUI() {
	window.setSize(500,800);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setAlwaysOnTop(true);
	window.add(panel);
	
	visual(panel);
	
	window.setVisible(true);
	}
	private void visual(JPanel panel) {
		panel.setLayout(null);
		JTextField greeting = new JTextField(greet(), LEFT);
		greeting.setBounds(10, 20, 300, 300);
		panel.add(greeting);
	}
}