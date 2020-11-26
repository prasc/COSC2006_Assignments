// Pras Cheliyan
// 209618220
// Monday, November 2, 2020
// COSC2006T
// This class is the parent class of Student and Instructor.
// It will set the name and id variable for those classes as well as allow user to getName and getID for those classes.

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        return this.id = id;
    }

    @Override
    public String toString() {
        return "Name is: " + name + " and ID is: " + id + ".";
    }
}
