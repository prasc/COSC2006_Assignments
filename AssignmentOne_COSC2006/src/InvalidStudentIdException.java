// This is a custom checked variable which inherits from the Exception class.

public class InvalidStudentIdException extends Exception {

    public InvalidStudentIdException(String msg) {
        super(msg);
    }
}
