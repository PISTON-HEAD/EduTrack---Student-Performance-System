# EduTrack---Student-Performance-System
EduTrack is a simple yet robust **Object-Oriented Programming (OOP)** project written in **Java**.   It simulates a mini **academic performance management system** for students and courses — allowing user-friendly management of enrollments, grades, and GPA calculations.

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
