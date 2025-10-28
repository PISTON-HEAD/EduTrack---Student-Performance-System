# 🎓 EduTrack - Student Performance Management System (Java OOP Project)

EduTrack is a simple yet robust **Object-Oriented Programming (OOP)** project written in **Java**.  
It simulates a mini **academic performance management system** for students and courses — allowing user-friendly management of enrollments, grades, and GPA calculations.

---

## 🧩 Project Overview

This system allows administrators to:
- Add students and courses
- Enroll students into courses
- Record assignment and exam marks
- Automatically calculate final grades and GPA
- View detailed reports for students and courses

It demonstrates key OOP principles such as:
- **Encapsulation**
- **Composition**
- **Abstraction**
- **Data management using Collections (ArrayList, HashMap)**

---

## 🏗️ Class Structure

### 🧍 `Student`
Represents a student with:
- Student ID, name, email, and academic year
- List of enrolled courses
- Grades stored per course  
- Methods to enroll in courses, view grades, and calculate GPA.

### 📚 `Course`
Represents a university course with:
- Course code, name, instructor, and credits
- List of enrolled students
- Methods to manage student enrollment and display enrolled students.

### 🧾 `GradeRecord`
Represents a student’s performance in a specific course:
- Stores assignment marks, exam marks, and auto-calculates the **final grade**  


finalGrade = (0.4 * assignmentMarks) + (0.6 * examMarks)



### ⚙️ `ManagementSystem`
Handles user interaction and controls the flow of the system:
- Manages lists of all students and courses
- Provides menu-driven options to:
- Add students/courses
- Enroll students
- Record grades
- View reports

### 🚀 `EduTrack_PerformanceManagementSystem` (Main Class)
Contains the main menu and handles user input to interact with the system.

---

## 📋 Features Implemented

| Feature | Description |
|----------|--------------|
| ➕ Add Student | Add new students to the management system |
| ➕ Add Course | Create new courses with instructor and credits |
| 🧑‍🏫 Enroll Student | Enroll a student in a selected course |
| 🧮 Record Grades | Input assignment and exam marks; system calculates final grade automatically |
| 📖 View Student Report | Display student details, enrolled courses, grades, and GPA |
| 📚 View Course Report | Show all students enrolled in a course |
| 🎓 GPA Calculation | Weighted average of final grades across all enrolled courses |

---

## 🧠 Example Formula

**Final Grade:**


finalGrade = (0.4 × assignmentMarks) + (0.6 × examMarks)



**GPA:**


GPA = (Σ (finalGrade × courseCredits)) / Σ (courseCredits)



---

## 🖥️ Example Program Flow



====== EduTrack Menu ======

1. Add Student
2. Add Course
3. Enroll Student in Course
4. Record Grades
5. View Student Report
6. View Course Report
7. Exit
   Enter choice: 1

Create Student ID: S101
Enter Student Name: Alice Johnson
Enter Student Email: [alice@university.com](mailto:alice@university.com)
Enter Year: 2

✅ Student added successfully!



---

## 🧰 How to Run

1. Clone or download the repository:

   git clone https://github.com/PISTON-HEAD>/EduTrack-PerformanceManagementSystem.git
   cd EduTrack-PerformanceManagementSystem


2. Compile all Java files:

  
   javac EduTrack_PerformanceManagementSystem.java


3. Run the program:

  
   java EduTrack_PerformanceManagementSystem
  

---

## 🧑‍💻 Assignment-Style Question (for Students)

### 🎯 **Problem Statement**

Design and implement a **Student Performance Management System** using **Java OOP concepts** that allows users to:

1. Add and manage students and courses.
2. Enroll students into multiple courses.
3. Record student grades per course (assignment + exam).
4. Automatically calculate the **final grade** and **GPA**.
5. Display detailed student and course reports.

### 🔍 **System Requirements**

* Use **classes and objects** to represent students, courses, and grade records.
* Use **ArrayList** and **HashMap** for managing relationships.
* Implement encapsulation through getters/setters.
* Display a **menu-driven console interface**.
* Follow the grading formula:

  
  finalGrade = (0.4 * assignmentMarks) + (0.6 * examMarks)
  

### 💡 **Bonus Challenge**

* Implement GPA ranking to list students from highest to lowest GPA.
* Allow data persistence (optional) using file storage.

---

## 🧱 Concepts Demonstrated

* Object-Oriented Design (Classes, Methods, Constructors)
* Data encapsulation and association
* Collections Framework (ArrayList, HashMap)
* Modular code organization
* Console-based input/output

---

## 🧑‍🏫 Author
Gokul Krishna
