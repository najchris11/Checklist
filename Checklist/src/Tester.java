import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int choice;
		ArrayList <Task> TaskLIst = new ArrayList <Task>();
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
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				save();
				break;
			}
		}
	}

	private static void save() {
	}

}
