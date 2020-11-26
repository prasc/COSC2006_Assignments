// Pras Cheliyan
// 209618220
// Monday, November 2, 2020
// COSC2006T
// This class allows users to initialize a Course object in two different ways, it also a setter instructor.
// It allows users to find a student based on studentID, remove a student, and add students.
// It also contains the logic behind object serialization.

import java.io.*;

public class Course implements Serializable{
    private String name;
    private int courseCode;
    private int maxStudents;
    private Instructor instructor;
    private int numOfStudents = 0;
    private Student[] students;

    public Course(String name, int courseCode) {
        this(name, courseCode, 35);
    }

    public Course(String name, int courseCode, int maxStudents) {
        this.name = name;
        this.courseCode = courseCode;
        this.maxStudents = maxStudents;
        students = new Student[maxStudents];
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public boolean findStudent(int studentID){
        for (int i = 0; i < numOfStudents; i++) {
           if (students[i].getId() == studentID) {
               return true;
           }
       }
        return false;
    }

    public void addStudent(Student newStudent)  throws InvalidStudentIdException, ArrayIndexOutOfBoundsException {
        if (numOfStudents == maxStudents) {
            throw new ArrayIndexOutOfBoundsException("The courses has the max number of students allowed");
        }

        for (int i = 0; i < numOfStudents; i++) {
            if (students[i].equals(newStudent)) {
                throw new InvalidStudentIdException("This student is already registered");
            }
        }

        students[numOfStudents++] = newStudent;
    }

    public void removeStudent(Student studentToRemove) throws InvalidStudentIdException {
        int indexOfStudent = -1;

        for (int i = 0; i < numOfStudents; i++) {
            if (students[i].equals(studentToRemove)) {
                indexOfStudent = i;
            }
        }

        if (indexOfStudent == -1) throw new InvalidStudentIdException("This student is not registered in this course");

        for (int i = indexOfStudent; i < numOfStudents-1; i++) {
           students[i] = students[i + 1];
        }

        numOfStudents--;
    }

    public static void writeObjectToDisk(Course course[]) throws IOException, ClassNotFoundException {
        try (
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat", true));
        ) {
            output.writeObject(course);
        }
    }

    public static void readObjectFromDisk() throws IOException, ClassNotFoundException {
        try (
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat"));
        ) {
            Course course = (Course)(input.readObject());
            System.out.println("The course is: " + course);
        }
    }

    public Student[] getStudents() {
        return students;
    }
}
