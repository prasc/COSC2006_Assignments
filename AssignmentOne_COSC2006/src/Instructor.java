// Pras Cheliyan
// 209618220
// Monday, November 2, 2020
// COSC2006T
// This class is a base class of the Person class and uses the superclass to set both its name and id. It also has getters and setters for the department variable.

import java.io.Serializable;

public class Instructor extends Person implements Serializable {
    private String department;

    public Instructor(String name, int facultyID) {
        super(name, facultyID);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
