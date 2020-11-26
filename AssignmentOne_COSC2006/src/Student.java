// Pras Cheliyan
// 209618220
// Monday, November 2, 2020
// COSC2006T
// This class is a base class of the Person class and uses the superclass to set both its name and id.
// It has a setID method that will make sure the id a user submits fulfills the requirements based on multiple checks
// it also implements a custom equals method

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private int totalCredits;
    private int totalGradePointEarned;

    public Student(String name, int studentID) throws InvalidStudentIdException {
        super(name, studentID);
        setID(studentID);
    }

    public void setID(int id) throws InvalidStudentIdException {
        String num =  id + "";
        if (num.length() != 6) throw new InvalidStudentIdException("Please enter a 6 digit number");
        if (num.charAt(0) == 0) throw new InvalidStudentIdException("First digit cannot be a 0");

        String stringID = Integer.toString(id);

        int sum = 0;
        int lastDigit = Integer.parseInt(String.valueOf(stringID.charAt(5)));

        for (int i = 0; i < 5; i++) {
            sum += Integer.parseInt(num.charAt(i) + "");
        }


        if (sum % 9 != lastDigit) {
            throw new InvalidStudentIdException("Invalid ID");
        }

        setId(id);
    }

    public boolean equals(Student student) {
       if (student.getId() == this.getId()) {
           return true;
       } else
           return false;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int credits) {
        this.totalCredits = credits;
    }

    public int getTotalGradePointEarned() {
        return totalGradePointEarned;
    }

    public void setTotalGradePointEarned(int gradePoints) {
        this.totalGradePointEarned = gradePoints;

    }

    public double getGPA() {
        return (getTotalGradePointEarned()/getTotalCredits());
    }
}
