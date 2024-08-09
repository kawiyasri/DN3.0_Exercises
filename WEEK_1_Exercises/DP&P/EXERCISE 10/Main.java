
public class Main {
    public static void main(String[] args) {
        // Create a Student model
        Student student = new Student("John Doe", 123, "A");

        // Create a StudentView
        StudentView view = new StudentView();

        // Create a StudentController
        StudentController controller = new StudentController(student, view);

        // Display student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Doe");
        controller.setStudentId(456);
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();
    }
}
