import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	public static ArrayList <Task> TaskList = new ArrayList <Task>();
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int choice;
		System.out.println("What would you like to add to the list?");
		System.out.println("1) Display existing list");
		System.out.println("2) Add to existing list");
		System.out.println("3) Remove from existing list");
		System.out.println("4) Clear existing list");
		System.out.println("0) Exit Checklist");
		choice = Integer.parseInt(kb.nextLine());
		while (choice != 0) {
			switch (choice) {
			case 1:
				save();
				break;
			case 2:
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
		}
		kb.close();
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
