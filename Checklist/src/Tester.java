import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	public static ArrayList <Task> TaskList = new ArrayList <Task>();
	public static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {
		int choice;
		load();
		System.out.println("What would you like to do with the list?");
		System.out.println("1) Display existing list");
		System.out.println("2) Add to existing list");
		System.out.println("3) Remove from existing list");
		System.out.println("4) Clear existing list");
		System.out.println("0) Exit Checklist");
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
				save();
				break;
			case 4:
				save();
				break;
			default:
				System.out.println("Be sure to stay on top of things!");
				break;
			}
		kb.close();
	}

	private static void add() {
		System.out.println("Enter task title");
		System.out.println("Would you like to add a due date and importance level?");
	}

	private static void read() {
		System.out.printf("%-40s %10s %-15s", "Title", "Due Date", "Importance");
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
				task = kb.nextLine().split("/t");
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
				fileOut.println(t.getTitle() + "/t" + t.getDueDate() + "/t" + t.getImportance());
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
