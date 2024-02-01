package package123;
import java.util.ArrayList;
import java.util.List;
class Student{
	private String code;
	private String title;
	private String description;
	private int capacity;
	private int availableSlots;
	private String schedule;
	public Student(String code,String title,String description,int capacity,String schedule) {
		this.code=code;
		this.title=title;
		this.description=description;
		this.capacity=capacity;
		this.availableSlots=capacity;
		this.schedule=schedule;
	}
	public String getCode() {
		return code;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public int getAvailableSlots() {
		return availableSlots;
	}
	public String getSchedule() {
		return schedule;
	}
	public void decrementAvailableSlots() {
		if (availableSlots>0) {
			availableSlots--;
		}
	}
	public void incrementAvailableSlots() {
		if (availableSlots<capacity) {
			availableSlots++;
		}
	}
}
class Course{
	private List<Student> courses;
	public Course() {
		this.courses=new ArrayList<>();
	}
	public void addStudent(Student course) {
		courses.add(course);
	}
	public void removeStudent(Student course) {
		courses.remove(course);
	}
	public List<Student> getAllCourses(){
		return courses;
	}
}
class Student1 {
	private String ID;
	private String Name;
	private List<Student> registeredCourses;
	public Student1(String ID,String Name) {
		this.ID=ID;
		this.Name=Name;
		this.registeredCourses=new ArrayList<>();
		
	}
	public String getID() {
		return ID;
	}
	public String getName() {
		return Name;
	}
	public List<Student> getRegisteredCourses(){
		return registeredCourses;
	}
	public void registerStudent(Student course) {
		if(course.getAvailableSlots()>0) {
			registeredCourses.add(course);
			course.decrementAvailableSlots();
		} else {
			System.out.println("Course" +course.getCode()+"is full.Registration failed.");
		}
	}
	public void dropCourse(Student course) {
		if(registeredCourses.contains(course)) {
			registeredCourses.remove(course);
			course.incrementAvailableSlots();
			System.out.println("Course "+course.getCode()+"dropped successfully");
		}
		else {
			System.out.println("Course "+course.getCode()+"not found in registered courses");
		}
	}
	
}
public class Task5{
	public static void main(String args[]) {
		Course c=new Course();
		c.addStudent(new Student("C01","Java Programming","Introduction",30,"Mon,Wed 10:00"));
		c.addStudent(new Student("C02","English","Grammer",24,"Tue,Thurs 12:00"));
		System.out.println("Available Courses: ");
		List<Student> allCourses=c.getAllCourses();
		for (Student course:allCourses) {
			System.out.println("Course Code: " +course.getCode());
			System.out.println("Title: "+course.getTitle());
			System.out.println("Description: "+course.getDescription());
			System.out.println("Available slots: "+course.getAvailableSlots());
			System.out.println("Schedule: "+course.getSchedule());
			System.out.println("----------------------------------");
		}
		Student1 a=new Student1("01","Ajay");
		Student1 b=new Student1("02","Atul");
		a.registerStudent(allCourses.get(0));
		a.registerStudent(allCourses.get(1));
		b.registerStudent(allCourses.get(0));
		System.out.println("\nRegistered Courses for Ajay: ");
		for (Student course: a.getRegisteredCourses()) {
			System.out.println("Course Code: "+course.getCode());
			System.out.println("Title: "+course.getTitle());
			System.out.println("-----------------------");
		}
		a.dropCourse(allCourses.get(0));
		System.out.println("\nRegistered Courses for Ajay after dropping a course: ");
		for(Student course:a.getRegisteredCourses()) {
			System.out.println("Course Code: "+course.getCode());
			System.out.println("Title: "+course.getTitle());
			System.out.println("---------------------");
		}
	}
}
