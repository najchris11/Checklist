
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class GUI implements SwingConstants, ActionListener {
	// Main Method
	
	
	// GUI Setup
	JPanel panel = new JPanel();
	JFrame window = new JFrame("Checklist v1.0");
	public GUI() {
	window.setSize(500,800);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setAlwaysOnTop(true);
	window.add(panel);
	
	start(panel);
	
	window.setVisible(true);
	
	}
	public static void main(String[] args) {
		load();
		new GUI();
	}
	//Global Variables
	public static JTextField in = new JTextField();
	public static ArrayList <Task> TaskList = new ArrayList <Task>();
	public static JButton returnToMenu = new JButton("Return to Main Menu");
	public static boolean cont = true;
	
	
	private void start(JPanel panel){
		panel.setLayout(null);
		JLabel greeting = new JLabel(greet(), LEFT);
		greeting.setBounds(0, 0, 300, 100);
		panel.add(greeting);
		
		in.setBounds(0, 125, 20, 20);
		panel.add(in);
		JButton chooser = new JButton("Click to submit your choice");
		chooser.setActionCommand("CHOOSE");
		chooser.setBounds(125, 150, 250, 25);
		panel.add(chooser);
		chooser.addActionListener(this);
		panel.repaint();
	}
	
	

	private void ui(JPanel panel) {
		int choice;
		choice = Integer.parseInt(in.getText());
		while (cont) {
			switch (choice) {
			case 1:
				read(panel);
				cont = false;
				break;
			case 2:
//				add();
//				save();
				break;
			case 3:
//				remove();
//				save();
//				break;
			case 4:
				clear();
				save();
				break;
			default:
				cont = false;
				System.out.println("Be sure to stay on top of things!");
				break;
			}
			if (cont) greet();
		}
		
	}

	private void read(JPanel panel) {
		JLabel header = new JLabel("Title (String) Due Date(String) Importance(Int)", LEFT);
		header.setBounds(0, 200, 500, 20);
		panel.add(header);
		panel.repaint();
		int height = 250;
		for(Task t : TaskList) {
			JLabel tasks = new JLabel(t.toString());
			tasks.setBounds(0, height, 500, 25);
			panel.add(tasks);
			panel.repaint();
			height = height + 25;
		}
		returnToMenu.setActionCommand("RETURN");
		returnToMenu.setBounds(225, 780, 100, height);
		panel.add(returnToMenu);
		panel.repaint();
		cont = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equalsIgnoreCase("choose")) {
		ui(panel);
		} else if (cmd.equalsIgnoreCase("return")) {
			System.out.println("i got the button press");
			start(panel);
		}
	}
	
	// Methods from old code
	private String greet() {
		return "<html>What would you like to do with the list?<br />1) Display existing list<br />2) Add to existing list<br />"
				+ "3) Remove from existing list<br />4) Clear existing list<br />0) Exit Checklist</html>";
	}
	private static void clear() {
		TaskList.clear();
		System.out.println("Tasklist is empty.");
		cont = false;
	}
	private static void load() {
		Scanner fileIn = null;
		String[] task = null;
		try {
			fileIn = new Scanner(new File("list.txt"));
			while (fileIn.hasNextLine()) {
				task = fileIn.nextLine().split("\t");
				TaskList.add(new Task(task[0], task[1], Integer.parseInt(task[2])));
			}
		} catch (Exception e) {
			System.out.println("New Checklist");
		} finally {
			try {
				fileIn.close();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	private static void save() {
		PrintWriter fileOut = null;
		try {
			fileOut = new PrintWriter(new File("list.txt"));
			for (Task t : TaskList) {
				fileOut.println(t.getTitle() + "\t" + t.getDueDate() + "\t" + t.getImportance());
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				fileOut.close();
			} catch (Exception e) {
			}
		}
	}
	
}