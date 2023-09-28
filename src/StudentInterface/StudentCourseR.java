package StudentInterface;
import java.util.ArrayList;
import java.util.*;

import java.util.ArrayList;

class Course {

private String code;
private String title;
private String description;
private int capacity;
private String schedule;

public Course(String code, String title, String description, int capacity, String schedule) {
 this.code = code;
 this.title = title;
 this.description = description;
 this.capacity = capacity;
 this.schedule = schedule;
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

public int getCapacity() {
 return capacity;
}

public String getSchedule() {
 return schedule;
}

public boolean hasSlot() {
 return capacity > 0;
}
public void register() {
 capacity--;
}
public void drop() {
 capacity++;
}
}
class Student {
private int id;
private String name;
private ArrayList<Course> courses;
public Student(int id, String name) {
 this.id = id;
 this.name = name;
 courses = new ArrayList<Course>();
}

public int getId() {
 return id;
}

public String getName() {
 return name;
}

public ArrayList<Course> getCourses() {
 return courses;
}
public void register(Course course) {
 if (course.hasSlot()) {
   courses.add(course);

   course.register();
   System.out.println("You have successfully registered for " + course.getTitle());
 } else {
   System.out.println("Sorry, the course " + course.getTitle() + " is full.");
 }
 
}
public void drop(Course course) {
 if (courses.contains(course)) {
    courses.remove(course);

   course.drop();
   System.out.println("You have successfully dropped " + course.getTitle());
 } else {
   System.out.println("You are not registered for " + course.getTitle());
 }
 
}
}

public class StudentCourseR {

public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 ArrayList<Course> courses = new ArrayList<Course>();
 courses.add(new Course("CS101", "Introduction to Computer Science", "This course covers the basics of programming, data structures, algorithms, and software engineering.", 
                        30, "Monday and Wednesday, 10:00 AM -11:30 AM"));
 
 courses.add(new Course("CS102", "Object-Oriented Programming", "This course teaches the concepts and applications of object-oriented programming using Java.", 
                        25, "Tuesday and Thursday, 2:00 PM -3:30 PM"));
 
 courses.add(new Course("CS103", "Data Structures and Algorithms", "This course introduces various data structures and algorithms for efficient problem solving.", 
                        20, "Monday and Wednesday, 2:00 PM -3:30 PM"));

 
 courses.add(new Course("CS104", "Database Systems", "This course covers the design and implementation of relational database systems using SQL.", 
                        15, "Tuesday and Thursday,10:00 AM -11:30 AM"));

 
 courses.add(new Course("CS105", "Artificial Intelligence", "This course explores the principles and techniques of artificial intelligence, such as search, knowledge representation, reasoning, planning, and machine learning.", 
                        10, "Friday, 10:00 AM -12:00 PM"));

 Student student = new Student(123456, "Alice");
 System.out.println("Welcome to the Course Registration System!");
 System.out.println("Your student ID is " + student.getId());
 System.out.println("Your name is " + student.getName());
 while (true) {
   System.out.println("Please choose an option from the following:");
   System.out.println("1. View available courses");
   System.out.println("2. Register for a course");
   System.out.println("3. Drop a course");
   System.out.println("4. View registered courses");
   System.out.println("5. Exit");
   int choice = sc.nextInt();
   switch (choice) {
     case 1:
       System.out.println("The available courses are:");
       for (Course course : courses) {
         System.out.println(course.getCode() + ": " + course.getTitle());
         System.out.println(course.getDescription());
         System.out.println(course.getSchedule());
         System.out.println("Available slots: " + course.getCapacity());
         System.out.println();
       }
       break;
     case 2:
    System.out.println("Enter the course code of the course you want to register for:");
       String code = sc.next();
       Course course = null;
       for (Course c : courses) {
         if (c.getCode().equals(code)) {
           course = c;
           break;
         }
       }
       if (course != null) {
         student.register(course);
       } else {
         System.out.println("Invalid course code.");
       }
       
       break;
     case 3:
       System.out.println("Enter the course code of the course you want to drop:");
       code = sc.next();
       course = null;
       for (Course c : student.getCourses()) {
         if (c.getCode().equals(code)) {
           course = c;
           break;
         }
       }
       if (course != null) {
         student.drop(course);
       } else {
         System.out.println("You are not registered for this course.");
       }
       
       break;
     case 4:
 
       System.out.println("Your registered courses are:");
       for (Course c : student.getCourses()) {
         System.out.println(c.getCode() + ": " + c.getTitle());
         System.out.println(c.getSchedule());
         System.out.println();
       }
       
       break;
     case 5:
       System.out.println("Thank you for using the Course Registration System!");
       return;
     default:
       System.out.println("Invalid input. Please enter a number between 1 and 5.");
   }
 }
}
}
