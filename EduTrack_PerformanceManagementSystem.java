
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student
{
  private String studentId;
  private String name;
  private String email;
  private int year;
  private ArrayList<Course> courseList;
  HashMap<Course, Double> grades;

  public Student(String studentId, String name, String email, int year) {
      this.studentId = studentId;
      this.name = name;
      this.email = email;
      this.year = year;
      this.courseList = new ArrayList<>();
      grades = new HashMap<>();
  }

  public String getStudentId() {
      return studentId;
  }

  public String getName() {
      return name;
  }

  public int getYear() {
      return year;
  }

  public HashMap<Course, Double> getGrades() {
      return grades;
  }



  public void enrollInCourse(Course c)
  {
    if(!courseList.stream().anyMatch(i -> i.getCourseCode().equals(c.getCourseCode())))
    {
      courseList.add(c);
      //c.addStudent(this);
    }
  }


  public void viewGrades(){
    System.out.println("\nGrades for " + name + ":");
    if (grades.isEmpty()) {
        System.out.println("No grades available.");
        return;
      }
    for (Map.Entry<Course, Double> entry : grades.entrySet()) {
        Course course = entry.getKey();
        double grade = entry.getValue();
        System.out.println(course.getCourseCode() + " - " + course.getCourseName() + ": " + grade);
    }
    
  }

  public double calculateGPA() {
    if (grades.isEmpty()) return 0.0;

    double totalPoints = 0;
    int totalCredits = 0;

    for (Map.Entry<Course, Double> entry : grades.entrySet()) {
      Course course = entry.getKey();
      double grade = entry.getValue();
      totalPoints += grade * course.getCredits();
      totalCredits += course.getCredits();
    }

    return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
  }

  public void showStudentInfo() {
    System.out.println("==========================================");
    System.out.println("📘 Student Information");
    System.out.println("==========================================");
    System.out.println("ID        : " + studentId);
    System.out.println("Name      : " + name);
    System.out.println("Email     : " + email);
    System.out.println("Year      : " + year);
    System.out.println("------------------------------------------");

    // Show enrolled courses
    if (courseList.isEmpty()) {
        System.out.println("Enrolled Courses: None");
    } else {
        System.out.println("Enrolled Courses:");
        for (Course c : courseList) {
            System.out.println(" - " + c.getCourseCode() + " | " + c.getCourseName() + " (" + c.getCredits() + " credits)");
        }
    }

    System.out.println("------------------------------------------");

    // Show grades (if available)
    if (grades.isEmpty()) {
        System.out.println("Grades: No grades available yet.");
    } else {
        System.out.println("Grades:");
        for (Map.Entry<Course, Double> entry : grades.entrySet()) {
            Course course = entry.getKey();
            double grade = entry.getValue();
            System.out.printf(" - %s: %.2f%n", course.getCourseCode()+" -> "+course.getCourseName(), grade);
        }
        System.out.printf("Overall GPA: %.2f%n", calculateGPA());
    }

    System.out.println("==========================================\n");
}


}

class GradeRecord {
  private String studentId;
  private String courseCode;
  private double assignmentMarks;
  private double examMarks;
  private double finalGrade;

  public GradeRecord(String studentId, String courseCode, double assignmentMarks, double examMarks) {
      this.studentId = studentId;
      this.courseCode = courseCode;
      this.assignmentMarks = assignmentMarks;
      this.examMarks = examMarks;
      calculateFinalGrade();
  }

  private void calculateFinalGrade() {
      this.finalGrade = (0.4 * assignmentMarks) + (0.6 * examMarks);
  }

  public double getAssignmentMarks() { return assignmentMarks; }
  public double getExamMarks() { return examMarks; }
  public double getFinalGrade() { return finalGrade; }

  @Override
  public String toString() {
      return String.format("Assignment: %.2f, Exam: %.2f, Final: %.2f", assignmentMarks, examMarks, finalGrade);
  }
}






class Course{
  private ArrayList<Student> studentList;
  private String courseCode;
  private String courseName;
  private double credits;
  private String instructor;

  public Course(String courseCode, String courseName, double credits, String instructor) {
      this.studentList = new ArrayList<>();
      this.courseCode = courseCode;
      this.courseName = courseName;
      this.credits = credits;
      this.instructor = instructor;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  public void setCourseName(String courseName) {
      this.courseName = courseName;
  }

  public void setCredits(double credits) {
      this.credits = credits;
  }

  public void setInstructor(String instructor) {
      this.instructor = instructor;
  }

  public String getCourseCode() {
      return courseCode;
  }

  public String getCourseName() {
      return courseName;
  }

  public String getInstructor() {
      return instructor;
  }

  public double getCredits() {
      return credits;
  }

  public void addStudent(Student student)
  {
    if(!studentList.contains(student))
    {
      studentList.add(student);
      System.out.print("\nStudent has been enrolled to the new course");
    }
  }

  public void removeStudent(Student student){
    studentList.remove(student);
    System.out.print("\n Student has been removed from "+courseName);
  }

  public void listEnrolledStudents() {
    System.out.println("==========================================");
    System.out.println("👨‍🏫 Course: " + courseCode + " - " + courseName);
    System.out.println("Instructor: " + instructor);
    System.out.println("Credits   : " + credits);
    System.out.println("==========================================");

    if (studentList.isEmpty()) {
        System.out.println("No students are currently enrolled in this course.");
    } else {
        System.out.println("📋 Enrolled Students:");
        int count = 1;
        for (Student s : studentList) {
            System.out.println(" " + count + ". " + s.getName() + " (ID: " + s.getStudentId() + ")");
            count++;
        }
        System.out.println("------------------------------------------");
        System.out.println("Total Enrolled: " + studentList.size());
    }

    System.out.println("==========================================\n");
  }
}



class ManagementSystem
{
  private ArrayList<Student> studentList;
  private ArrayList<Course> courseList;
  Scanner sc = new Scanner(System.in);

  public ManagementSystem() {
      this.studentList = new ArrayList<>();
      this.courseList = new ArrayList<>();
  }

  private Student getStudentById(String studentId) {
    for (Student s : studentList) {
        if (s.getStudentId().equals(studentId)) {
            return s;
        }
    }
    return null;
  }

  private Course getCourseByCode(String courseCode) {
    for (Course c : courseList) {
        if (c.getCourseCode().equals(courseCode)) {
            return c;
        }
    }
    return null;
  }

  public void addStudentToManagementSystem()
  {
    System.out.print("Create Student ID: ");
    String studentId = sc.nextLine();
    
    System.out.print("Enter Student Name: ");
    String name = sc.nextLine();
    
    System.out.print("Enter Student email: ");
    String email = sc.nextLine();
    
    System.out.print("Enter Year: ");
    int year = sc.nextInt();
    sc.nextLine();
            
    Student student = new Student(studentId, name, email, year);
    studentList.add(student);
  }
  
  public void addCourseToManagementSystem() {
    System.out.print("\nEnter Course code: ");
    String courseCode = sc.nextLine();
    
    System.out.print("Enter Course Name: ");
    String courseName = sc.nextLine();
    
    System.out.print("Enter Course credits: ");
    Double courseCredits = sc.nextDouble();
    
    
    System.out.print("Enter Instructor: ");
    String courseInstructor = sc.nextLine();
    sc.nextLine();

    Course course = new Course(courseCode, courseName, courseCredits, courseInstructor);
    if(!courseList.stream().anyMatch(i -> i.getCourseCode().equals(courseCode)))
    {
      courseList.add(course);
      
      System.out.print("\nCourse "+courseCode+" added successfully");
    }else{
      System.out.print("\nX Course "+courseCode+" ALREADY present");
    }
  }

  public void enrollInCourse()
  {

    System.out.print("\nEnter Student ID: ");
    String studentId = sc.nextLine();

    System.out.print("\nEnter Course code: ");
    String courseCode = sc.nextLine();

    Student student = getStudentById(studentId);
    Course course = getCourseByCode(courseCode);

    if (student == null) {
        System.out.println("❌ Student ID not found.");
        return;
    }
    if (course == null) {
        System.out.println("❌ Course code not found.");
        return;
    }

    if (student.getGrades().containsKey(course)) {
        System.out.println("⚠️ Student is already enrolled in this course.");
        return;
    }

    student.enrollInCourse(course);
    course.addStudent(student);
    student.getGrades().put(course, 0.0);

    System.out.println("\n✅ Student " + student.getName() + " enrolled in " + course.getCourseName() + " successfully!");
    
  }

  public void addGradesToStudent()
  {
    System.out.print("\nEnter Student ID: ");
    String studentId = sc.nextLine();

    System.out.print("\nEnter Course code: ");
    String courseCode = sc.nextLine();
    sc.nextLine();

    System.out.println();
    Student student = getStudentById(studentId);
    Course course = getCourseByCode(courseCode);

    if (student == null) {
      System.out.println("❌ Student ID not found.");
      return;
    }
    if (course == null) {
      System.out.println("❌ Course code not found.");
      return;
    }

    System.out.print("Enter Assignment Marks of "+student.getName()+":\n");
    double assingmentMarks = sc.nextDouble();

    System.out.print("Enter Exam Marks of "+student.getName()+":\n");
    double examMarks = sc.nextDouble();
    sc.nextLine();

    GradeRecord gradeRecord = new GradeRecord(studentId, courseCode, assingmentMarks, examMarks);
    
    student.getGrades().put(course, gradeRecord.getFinalGrade());    


  }


  public void viewStudentReport()
  {
    System.out.print("\nEnter Student ID: ");
    String studentId = sc.nextLine();
    sc.nextLine();

    Student student = getStudentById(studentId);
    student.showStudentInfo();
  }

  public void viewcourseReport()
  {
    System.out.print("\nEnter Course ID: ");
    String courseId = sc.nextLine();
    sc.nextLine();

    Course course = getCourseByCode(courseId);
    course.listEnrolledStudents();
  }
  
}
    
  
  
  
  public class EduTrack_PerformanceManagementSystem {
    public static void main(String[] args) {
      ManagementSystem system = new ManagementSystem();
  
      System.out.println("\n====== EduTrack Menu ======");
      System.out.println("""
            1. Add Student
            2. Add Course
            3. Enroll Student in Course
            4. Record Grades
            5. View Student Report
            6. View Course Report
            7. View GPA Rankings
            8. Exit
            Enter choice: """);
      Scanner sc = new Scanner(System.in);
      int choice = sc.nextInt();
      sc.nextLine();
      while (choice<7){
        switch (choice) {
          case 1 -> {
              system.addStudentToManagementSystem();
            }
  
          case 2 -> {
              system.addCourseToManagementSystem();
          }

          case 3 -> {
            system.enrollInCourse();
          }
          
          case 4 ->{
            system.addGradesToStudent();
          }

          case 5 ->{
            system.viewStudentReport();
          }
          case 6 ->
          {
            //ranking
          }
        default -> throw new AssertionError();
      }
      System.out.print("\n Enter Choice: ");
      choice = sc.nextInt();
      sc.nextLine();
    }
    sc.close();
  }
}
