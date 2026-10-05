import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {

    // Course class
    static class Course {
        String code;
        String title;
        String description;
        int capacity;
        String schedule;
        int registeredStudents;

        Course(String code, String title, String description,
               int capacity, String schedule) {

            this.code = code;
            this.title = title;
            this.description = description;
            this.capacity = capacity;
            this.schedule = schedule;
            this.registeredStudents = 0;
        }

        int availableSlots() {
            return capacity - registeredStudents;
        }

        void displayCourse() {
            System.out.println("----------------------------------------");
            System.out.println("Course Code  : " + code);
            System.out.println("Title        : " + title);
            System.out.println("Description  : " + description);
            System.out.println("Capacity     : " + capacity);
            System.out.println("Schedule     : " + schedule);
            System.out.println("Available    : " + availableSlots());
            System.out.println("----------------------------------------");
        }
    }

    // Student class
    static class Student {
        String studentId;
        String name;
        ArrayList<String> registeredCourses;

        Student(String studentId, String name) {
            this.studentId = studentId;
            this.name = name;
            registeredCourses = new ArrayList<>();
        }

        void displayStudent() {
            System.out.println("\n===== STUDENT DETAILS =====");
            System.out.println("Student ID: " + studentId);
            System.out.println("Name      : " + name);

            if (registeredCourses.isEmpty()) {
                System.out.println("Registered Courses: None");
            } else {
                System.out.println("Registered Courses:");

                for (String course : registeredCourses) {
                    System.out.println("- " + course);
                }
            }
        }
    }

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Course> courses = new ArrayList<>();

    static Student student;

    public static void main(String[] args) {

        // Create sample courses
        courses.add(new Course(
                "CSE101",
                "Java Programming",
                "Introduction to Java programming",
                5,
                "Monday & Wednesday - 10:00 AM"
        ));

        courses.add(new Course(
                "CSE102",
                "Database Management",
                "Introduction to databases and SQL",
                4,
                "Tuesday & Thursday - 11:00 AM"
        ));

        courses.add(new Course(
                "CSE103",
                "Operating System",
                "Fundamentals of operating systems",
                5,
                "Monday & Friday - 2:00 PM"
        ));

        courses.add(new Course(
                "CSE104",
                "Software Engineering",
                "Software development principles and methods",
                3,
                "Wednesday & Friday - 12:00 PM"
        ));

        // Student information
        System.out.println("========================================");
        System.out.println("   STUDENT COURSE REGISTRATION SYSTEM");
        System.out.println("========================================");

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        student = new Student(studentId, studentName);

        int choice;

        do {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Display Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Student Details");
            System.out.println("5. Exit");
            System.out.println("===============================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    displayCourses();
                    break;

                case 2:
                    registerCourse();
                    break;

                case 3:
                    dropCourse();
                    break;

                case 4:
                    student.displayStudent();
                    break;

                case 5:
                    System.out.println("\nThank you for using the system!");
                    break;

                default:
                    System.out.println("\nInvalid choice!");
                    System.out.println("Please select 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }

    // Display all courses
    static void displayCourses() {

        System.out.println("\n========== AVAILABLE COURSES ==========");

        for (Course course : courses) {
            course.displayCourse();
        }
    }

    // Register for a course
    static void registerCourse() {

        System.out.println("\n========== COURSE REGISTRATION ==========");

        System.out.print("Enter Course Code: ");
        String code = sc.nextLine().toUpperCase();

        Course selectedCourse = findCourse(code);

        if (selectedCourse == null) {
            System.out.println("Course not found!");
            return;
        }

        // Check if already registered
        if (student.registeredCourses.contains(code)) {
            System.out.println("You are already registered for this course.");
            return;
        }

        // Check available slots
        if (selectedCourse.availableSlots() <= 0) {
            System.out.println("Registration failed!");
            System.out.println("No available slots for this course.");
            return;
        }

        student.registeredCourses.add(code);
        selectedCourse.registeredStudents++;

        System.out.println("Registration successful!");
        System.out.println("Course: " + selectedCourse.title);
        System.out.println("Available slots remaining: "
                + selectedCourse.availableSlots());
    }

    // Drop a course
    static void dropCourse() {

        System.out.println("\n========== DROP COURSE ==========");

        System.out.print("Enter Course Code to drop: ");
        String code = sc.nextLine().toUpperCase();

        if (!student.registeredCourses.contains(code)) {
            System.out.println("You are not registered for this course.");
            return;
        }

        Course selectedCourse = findCourse(code);

        student.registeredCourses.remove(code);
        selectedCourse.registeredStudents--;

        System.out.println("Course dropped successfully!");
        System.out.println("Course: " + selectedCourse.title);
    }

    // Find course by code
    static Course findCourse(String code) {

        for (Course course : courses) {

            if (course.code.equals(code)) {
                return course;
            }
        }

        return null;
    }
}
