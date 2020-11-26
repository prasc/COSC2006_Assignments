// Pras Cheliyan
// 209618220
// Monday, November 2, 2020
// COSC2006T
// Assignment#1
// This course demonstrates methods  in the course class including setInstructor, addStudent. As well as a few of the methods in the Student class.

import java.io.IOException;

public class TestClass {

    public static void main(String[] args) throws InvalidStudentIdException {
        Student dude = new Student("Dude", 469912);
        Student dudette = new Student("Dudette", 929912);
        Instructor mrChurch = new Instructor("Jason", 15151);
        Course course = new Course("DS", 2006, 35);

        course.setInstructor(mrChurch);
        course.addStudent(dude);
        course.addStudent(dudette);

        System.out.println("Is Dude in the course? " + course.findStudent(469912));

        dude.setTotalGradePointEarned(66);
        dude.setTotalCredits(16);
        System.out.println("Dude's gpa is " + dude.getGPA());

        System.out.println("Are Dude and Dudette the same student? " + dude.equals(dudette));

        System.out.print(dude.toString() + " ");
        System.out.println(mrChurch.toString());

    }
}
