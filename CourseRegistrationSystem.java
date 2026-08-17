import java.util.*;

class Course {
    String code;
    String title;
    int credits;

    Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return code + " - " + title + " (" + credits + " credits)";
    }
}

class Student {
    String id;
    String name;
    List<Course> registeredCourses = new ArrayList<>();

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    void registerCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
            System.out.println(name + " registered for " + course.title);
        } else {
            System.out.println("Already registered for " + course.title);
        }
    }

    void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            System.out.println(name + " dropped " + course.title);
        } else {
            System.out.println("Course not found in registration.");
        }
    }

    void showCourses() {
        System.out.println("\nCourses registered by " + name + ":");
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            for (Course c : registeredCourses) {
                System.out.println(c);
            }
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample courses
        Course c1 = new Course("CS101", "Introduction to Programming", 3);
        Course c2 = new Course("CS102", "Data Structures", 4);
        Course c3 = new Course("CS103", "Database Systems", 3);

        List<Course> courseList = Arrays.asList(c1, c2, c3);

        // Student
        Student s1 = new Student("S001", "Pavani");

        while (true) {
            System.out.println("\n--- Course Registration Menu ---");
            System.out.println("1. View available courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. Show registered courses");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable courses:");
                    for (Course c : courseList) {
                        System.out.println(c);
                    }
                    break;

                case 2:
                    System.out.print("Enter course code to register: ");
                    String regCode = sc.next();
                    Course regCourse = findCourse(courseList, regCode);
                    if (regCourse != null) {
                        s1.registerCourse(regCourse);
                    } else {
                        System.out.println("Course not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter course code to drop: ");
                    String dropCode = sc.next();
                    Course dropCourse = findCourse(courseList, dropCode);
                    if (dropCourse != null) {
                        s1.dropCourse(dropCourse);
                    } else {
                        System.out.println("Course not found!");
                    }
                    break;

                case 4:
                    s1.showCourses();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static Course findCourse(List<Course> courseList, String code) {
        for (Course c : courseList) {
            if (c.code.equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }
}

