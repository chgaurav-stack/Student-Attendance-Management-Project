# Student Attendance Management System

## Project Information

- **Project No.:** 22
- **Project Title:** Student Attendance Management
- **Language:** Java
- **Concepts:** ArrayList, Searching, Sorting, Methods, File Handling, OOP

## 1. Project Description

Student Attendance Management is a console-based Java application used to maintain student attendance records.

The application allows users to add students, mark attendance, search for students, display defaulters (students having attendance below 75%), and sort students according to their attendance percentage.

Student records are stored in a text file (`students.txt`) so that the data can be loaded whenever the program starts again.

## 2. Features

1. **Add Student:** Add a student using roll number and name.
2. **Mark Attendance:** Mark a student as Present or Absent.
3. **Search Student:** Find a student using their roll number.
4. **Display Defaulters:** Display students having attendance below 75%.
5. **Sort Attendance:** Sort students by attendance percentage from highest to lowest.
6. **Display All Students:** View all registered student records.
7. **File Handling:** Automatically load and save student records.

## 3. DSA Concepts Used

| Concept | Application |
|---|---|
| ArrayList | Store student objects |
| Linear Search | Search students by roll number |
| Bubble Sort | Sort attendance percentages |
| Methods | Divide the program into functions |
| File Handling | Read and write student records |
| OOP | Student class and objects |

## 4. Project Structure

```text
Student-Attendance-Management/
│
├── Main.java
├── students.txt
└── README.md
```

- `Main.java` – Contains the complete Java program.
- `students.txt` – Stores student attendance records.
- `README.md` – Project documentation.

## 5. How to Run the Project

### Requirements
- Java JDK installed.
- Any Java IDE or terminal.

### Steps

1. Download or clone the repository.
2. Open the project folder.
3. Open the terminal in that folder.
4. Compile the Java program:

```bash
javac Main.java
```

5. Run the program:

```bash
java Main
```

## 6. Sample Input and Output

### Sample Input

```text
===== STUDENT ATTENDANCE MANAGEMENT =====

1. Add Student
2. Mark Attendance
3. Search Student
4. Display Defaulters
5. Sort by Attendance (High to Low)
6. Display All Students
7. Exit

Enter your choice: 1

Enter Roll Number: 101
Enter Name: Riya

Student added. 101 | Riya

Enter your choice: 1

Enter Roll Number: 102
Enter Name: Aman

Student added. 102 | Aman

Enter your choice: 2

Enter Roll Number: 101
Enter P for Present or A for Absent: P

Attendance marked successfully.
101 | Riya | Attendance: 1/1 | 100.0%

Enter your choice: 2

Enter Roll Number: 102
Enter P for Present or A for Absent: A

Attendance marked successfully.
102 | Aman | Attendance: 0/2 | 0.0%
```

### Sample Output: Search Student

```text
Enter your choice: 3

Enter Roll Number: 101

101 | Riya | Attendance: 1/2 | 50.0%
```

### Sample Output: Display Defaulters

```text
Enter your choice: 4

--- Defaulter Students ---

101 | Riya | 50.0%
102 | Aman | 0.0%
```

### Sample Output: Sort by Attendance

```text
Enter your choice: 5

--- Sorted Students ---

1. 101 | Riya | 50.0%
2. 102 | Aman | 0.0%
```

### Sample Output: Exit

```text
Enter your choice: 7

Data saved successfully.
Exiting program...
```

## 7. File Handling

The application uses `BufferedReader` and `BufferedWriter` to manage student records.

Student information is stored in the following format:

```text
101,Riya,1,2
102,Aman,0,2
```

The data contains:

- Roll Number
- Student Name
- Classes Attended
- Total Classes

When the application starts, existing records are loaded from the file. When the user exits, updated records are saved.

## 8. Conclusion

The Student Attendance Management System demonstrates the practical implementation of Java programming, Data Structures and Algorithms, Object-Oriented Programming, searching, sorting and file handling.

It provides a simple way to maintain student attendance records through a menu-driven console application.

---

**Developed as a Semester Project**

**Project No. 22 – Student Attendance Management**