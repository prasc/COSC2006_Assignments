// Pras Cheliyan
// 209618220
// Monday, November 2, 2020
// COSC2006T
// Assignment#1
// This class has a console based menu that allows user to add students, add courses, add instructors, edit courses, and exit.
// However the edit student function isn't functional yet. The class also attempts to read from an object and write to the object. It is a work in progress but I tried my best.
// It also has a function called validateCourseCode which does a great job at making sure the course code is valid input only

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidStudentIdException {
        Scanner input = new Scanner(System.in);
        Student[] students = new Student[100];
        Course[] courses = new Course[100];
        Instructor[] instructors = new Instructor[100];
        String name, courseName;
        int userSelection, id, courseCode, currentAmountOfStudents = 0, currentAmountOfInstructors = 0;


        File obj = new File("object.dat");

        if (obj.exists()) {
            try {
                Course.readObjectFromDisk();
            } catch (IOException ex) {
                System.out.println(ex);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }

        do {
            do {
                System.out.println("Press 1 to add students, 2 to add courses, 3 to add instructors");
                System.out.println("Press 4 to edit courses");
                System.out.println("Press 0 to exit\n");

                System.out.println("Please enter a selection");
                userSelection = input.nextInt();

                switch (userSelection) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 0:
                        break;
                    default:
                        System.out.println("Please enter valid input");
                        continue;
                }
                break;

            } while (userSelection != 0);

            switch (userSelection) {
                case 1:
                    System.out.println("Please enter the students name");
                    name = input.next();
                    System.out.println("Please enter 6 digit student number");
                    id = input.nextInt();

                    try {
                        students[currentAmountOfStudents++] = (new Student(name, id));
                    } catch (InvalidStudentIdException ex) {
                        System.out.println(ex + "\n");
                        break;
                    }
                    System.out.println("Student successfully added\n");
                    break;
                case 2:
                    System.out.println("Please enter a course name");
                    courseName = input.next();
                    System.out.println("Please enter a course code, containing 6 digits");
                    String temp = "";

                    while (true) {
                        temp = input.next();

                        if (validateCourseCode(temp)) break;
                        System.out.println("Please 6 digits only");
                    }

                    courseCode = Integer.parseInt(temp);
                    System.out.println("Course successfully added\n");

                    break;
                case 3:
                    System.out.println("Please enter the instructors name");
                    name = input.next();
                    System.out.println("Please enter 6 digit faculty number");
                    id = input.nextInt();

                    instructors[currentAmountOfInstructors++] = (new Instructor(name, id));
                    System.out.println("Instructor successfully added\n");
                    break;
                case 4:
                    System.out.println("Select the course you would like to edit");

                    for (int i = 0; i < courses.length; i++) {
                        System.out.println((courses.toString()));
                    }

                case 0:
                    System.out.println("Exiting menu\n");
                    break;
                default:
                    System.out.println("Please enter valid input!");
            }
        } while (userSelection != 0);



        try {
            Course.writeObjectToDisk(courses);
            Course.readObjectFromDisk();
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public static boolean validateCourseCode(String temp) {

            if (temp.length() == 6) {
                for (int i = 0; i < temp.length(); i++) {
                    if (!Character.isDigit(temp.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
    }
}


