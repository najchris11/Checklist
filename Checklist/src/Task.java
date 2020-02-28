import java.security.InvalidParameterException;

public class Task {
	
	//===================== Properties
	private String title, dueDate;
	private int importance;
	
	//===================== Constructors
	public Task(String title, String dueDate, int importance) {
		setTitle(title);
		setDueDate(dueDate);
		setImportance(importance);
	}
	public Task(String title) {
		setTitle(title);
		setDueDate("Not Supplied");
		setImportance(0);
	}
	public Task(Task task) {
		this(task.getTitle(), task.getDueDate(), task.getImportance());
	}
	
	//===================== Methods
	public Task clone (Task task) {
		if (!(task instanceof Task)) return null;
		else return new Task(task);
	}
	@Override
	public String toString() {
		return String.format("%-40s %-25s %-10d", getTitle(), getDueDate(), getImportance());
	}
	
	//===================== Getters/Settters
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getDueDate() {
		return this.dueDate;
	}
	public void setImportance(int importance) {
		if (importance >= 0 && importance <= 3)
		this.importance = importance;
		else throw new InvalidParameterException("Value must be between 0 and 3");
	}
	public int getImportance() {
		return this.importance;
	}
}
