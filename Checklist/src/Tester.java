import java.io.File;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	public static ArrayList <Task> TaskList = new ArrayList <Task>();
	public static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {
		int choice;
		load();
		greet();
		boolean cont = true;
		while (cont) {
		choice = Integer.parseInt(kb.nextLine());
			switch (choice) {
			case 1:
				read();
				break;
			case 2:
				add();
				save();
				break;
			case 3:
				remove();
				save();
				break;
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

	private static void greet() {
		System.out.println("What would you like to do with the list?");
		System.out.println("1) Display existing list");
		System.out.println("2) Add to existing list");
		System.out.println("3) Remove from existing list");
		System.out.println("4) Clear existing list");
		System.out.println("0) Exit Checklist");
		
	}

	private static void clear() {
		TaskList.clear();
		System.out.println("Tasklist is empty.");
	}

	private static void remove() {
		int i;
		System.out.println("Enter the index of the task you'd like to remove");
		i = Integer.parseInt(kb.nextLine());
		TaskList.remove(i);
	}

	private static void add() {
		String title, dueDate, cont;
		int importance;
		System.out.println("Enter task title");
		title = kb.nextLine();
		System.out.println("Would you like to add a due date and importance level? (Y/N)");
		cont = kb.nextLine();
		if (cont.equalsIgnoreCase("y")) {
		System.out.println("Enter due date");
		dueDate = kb.nextLine();
		System.out.println("Enter importance level (0 - 3)");
		importance = Integer.parseInt(kb.nextLine());
		TaskList.add(new Task (title, dueDate, importance));
		}
		else if (cont.equalsIgnoreCase("n")) {
			TaskList.add(new Task(title));
			System.out.println("Thank you, your task has been added to the list.");
		}
		else {
			throw new InvalidParameterException("Please respond with either y or n.");
		}
	}

	private static void read() {
		System.out.printf("%-40s %-25s %-10s\n", "Title (String)", "Due Date(String)", "Importance(Int)");
		for(Task t : TaskList) {
			System.out.println(t);
		}
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
//				System.out.println("Error: " + e.getMessage());
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
