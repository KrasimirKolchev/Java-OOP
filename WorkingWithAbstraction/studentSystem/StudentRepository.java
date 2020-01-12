package WorkingWithAbstraction.studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> students;

    public StudentRepository() {
        this.students = new HashMap<>();
    }

    public boolean containStudentName(String name) {
        return this.students.containsKey(name);
    }

    public void addStudent(String name, Student student) {
        this.students.put(name, student);
    }

    public Student findStudentByName(String name) {
        return this.students.get(name);
    }
}
